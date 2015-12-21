package controllers;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class AlquilerVehiculosApp extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("ALQUILER DE VEHICULOS");
		initRootLayout();
	}
 
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(AlquilerVehiculosApp.class.getResource("/vistas/principal.fxml"));
			rootLayout = (AnchorPane) loader.load();
			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			ControladorPrincipal controlador = loader.getController();
			controlador.setPrimaryStage(primaryStage);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}