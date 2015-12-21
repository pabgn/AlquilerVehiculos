package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Categoria;
import persistencia.dto.CocheDTO;
import excepciones.DAOExcepcion;

public class CochesDAOImp {
	protected ConnectionManager connManager;

	public CochesDAOImp() throws DAOExcepcion {
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public CocheDTO buscarCoche(String nombre) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Coche where NOMBRE= '"+nombre+"'");
			connManager.close();
		
			if (rs.next()){
				return new CocheDTO(rs.getString("MATRICULA"), rs.getFloat("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"));
			}
			else{
				return null;	
			}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	
	public List<CocheDTO> obtenerCoches() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Coche");						
			connManager.close();
	  	  
			List<CocheDTO> listaCocheDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){
					CocheDTO cliDTO = new CocheDTO(
							rs.getString("MATRICULA"),	
							rs.getFloat("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"));
					listaCocheDTO.add(cliDTO);
				}
				return listaCocheDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
	
	public List<CocheDTO> obtenerCochesPorSucursal(int idSucursal) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Coche  where SUCURSAL= '"+idSucursal+"'");						
			connManager.close();
	  	  
			List<CocheDTO> listaCocheDTO = new ArrayList<CocheDTO>();
				
			try{				
				while (rs.next()){
					CocheDTO cliDTO = new CocheDTO(
							rs.getString("MATRICULA"),	
							rs.getFloat("KMSACTUALES"),
							rs.getInt("SUCURSAL"),
							rs.getString("CATEGORIA"));
					listaCocheDTO.add(cliDTO);
				}
				return listaCocheDTO;
			}
			catch (Exception e){	
				throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}
/*
	@Override
	public void crearCoche(CocheDTO Coche) throws DAOExcepcion {
		try {
			connManager.connect();
			String dni = Coche.getDni();
			String nombre = Coche.getNombreyApellidos();
			String direccion = Coche.getDireccion();
			String poblacion = Coche.getPoblacion();
			String codpostal = Coche.getCodPostal();
			LocalDate fechaCarnetConducir = Coche.getFechaCanetConducir();
			String digitosTC = Coche.getDigitosTC();
			int mesTC = Coche.getMesTC();
			int añoTC = Coche.getAñoTC();
			int cvcTC = Coche.getCvcTC();
			String tipoTC = Coche.getTipoTC();
			connManager.queryDB("INSERT INTO Coche (DNI,NOMBREAPELLIDOS,DIRECCION,POBLACION,CODPOSTAL,FECHACARNETCONDUCIR,DIGITOSTC,MESTC,a\u00f1oTC,CVCTC,TIPOTC)"
					+ "VALUES ('"+dni+"','"+nombre+"','"+direccion+"','"+poblacion+"','"+codpostal+"','"+fechaCarnetConducir.toString()+" 00:00:00',"+digitosTC+","+mesTC+","+añoTC+","+cvcTC+",'"+tipoTC+"')");
			connManager.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	*/
}
