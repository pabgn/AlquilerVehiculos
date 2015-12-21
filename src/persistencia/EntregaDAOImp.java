package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ClienteDTO;
import persistencia.dto.EntregaDTO;
import excepciones.DAOExcepcion;

public class EntregaDAOImp implements IEntregaDAO{
	protected ConnectionManager connManager;

	public EntregaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	public boolean existeEntragaConReseva(int id) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Entrega WHERE ID = "+id);						
			connManager.close();
			int size=0;
			while (rs.next()) {
			    size++;
			}
			return size>0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;	

	}
	
	@Override
	public void crearEntrega(EntregaDTO entrega) throws DAOExcepcion {
		try {
			connManager.connect();
			int id =entrega.getId();
			LocalDate fecha = entrega.getFecha();
			String tipoSeguro = entrega.getTipoSeguro();
			float kms = entrega.getKms();
			float combustible = entrega.getCombustible();
			String cocheAsignado = entrega.getCocheAsignado();
			String empleadoRealiza = entrega.getEmpleadoRealiza();
			connManager.queryDB("INSERT INTO Entrega (ID,FECHA,TIPOSEGURO,KMS,COMBUSTIBLE,COCHEASIGNADO,EMPLEADOREALIZA)"
					+ "VALUES ("+id+",'"+fecha.toString()+" 00:00:00','"+tipoSeguro+"','"+kms+"','"+combustible+"','"+cocheAsignado+"','"+empleadoRealiza+"')");
			connManager.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
