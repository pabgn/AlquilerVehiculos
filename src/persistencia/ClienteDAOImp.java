package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ClienteDTO;
import excepciones.DAOExcepcion;

public class ClienteDAOImp implements IClienteDAO {

	protected ConnectionManager connManager;

	public ClienteDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}

	public ClienteDTO buscarCliente(String nombre) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Cliente where NOMBRE= '"+nombre+"'");
			connManager.close();
		
			if (rs.next())
				return new ClienteDTO(rs.getString("NOMBREYAPELLIDOS"),
						 rs.getString("DIRECCION"),  rs.getString("POBLACION"),  rs.getString("CODPOSTAL"),
						rs.getDate("FECHACARNETCONDUCIR").toLocalDate(), rs.getString("DIGITOSTC"), rs.getInt("MESTC"),
						rs.getInt("AÑOTC"), rs.getInt("CVCTC"), rs.getString("TIPOTC"),rs.getString("DNI"));
				
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}

	
	public List<ClienteDTO> obtenerClientes() throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Cliente");						
			connManager.close();
	  	  
			List<ClienteDTO> listaClienteDTO = new ArrayList<ClienteDTO>();
				
			try{				
				while (rs.next()){
					ClienteDTO cliDTO = new ClienteDTO(
							rs.getString("NOMBREAPELLIDOS"),	
							rs.getString("DIRECCION"),
							rs.getString("POBLACION"),
							rs.getString("CODPOSTAL"),
							rs.getDate("FECHACARNETCONDUCIR").toLocalDate(),
							rs.getString("DIGITOSTC"),
							rs.getInt("MESTC"),
							rs.getInt("ANOTC"),
							rs.getInt("CVCTC"),
							rs.getString("TIPOTC"),
							rs.getString("DNI"));	 
					listaClienteDTO.add(cliDTO);
				}
				return listaClienteDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);}
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){		throw e;}

	}

	@Override
	public void crearCliente(ClienteDTO cliente) throws DAOExcepcion {
		try {
			connManager.connect();
			String dni = cliente.getDni();
			String nombre = cliente.getNombreyApellidos();
			String direccion = cliente.getDireccion();
			String poblacion = cliente.getPoblacion();
			String codpostal = cliente.getCodPostal();
			LocalDate fechaCarnetConducir = cliente.getFechaCanetConducir();
			String digitosTC = cliente.getDigitosTC();
			int mesTC = cliente.getMesTC();
			int añoTC = cliente.getAñoTC();
			int cvcTC = cliente.getCvcTC();
			String tipoTC = cliente.getTipoTC();
			connManager.queryDB("INSERT INTO Cliente (DNI,NOMBREAPELLIDOS,DIRECCION,POBLACION,CODPOSTAL,FECHACARNETCONDUCIR,DIGITOSTC,MESTC,ANOTC,CVCTC,TIPOTC)"
					+ "VALUES ('"+dni+"','"+nombre+"','"+direccion+"','"+poblacion+"','"+codpostal+"','"+fechaCarnetConducir.toString()+" 00:00:00',"+digitosTC+","+mesTC+","+añoTC+","+cvcTC+",'"+tipoTC+"')");
			connManager.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
