package tests;
import java.util.List;

import models.Categoria;
import models.Sucursal;
import controllers.*;

public class DAOPersistenceTester {
private static ServicioAlquilerVehiculos sav;

	public static void main(String[] args){
		sav = ServicioAlquilerVehiculos.getAlquilerVehiculos();
		List<Sucursal> sucursales = sav.obtenerSucursales();
		for(Sucursal s: sucursales){
			System.out.println(sav.listarReservasSucursal(s));
			System.out.println(s.getDireccion());
		}
		List<Categoria> cat = sav.obtenerCategorias();
		for(Categoria c: cat){
			System.out.println(c.getNombre());
		}
	}
}
