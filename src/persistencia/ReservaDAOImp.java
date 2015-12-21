package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import persistencia.dto.ReservaDTO;
import excepciones.DAOExcepcion;

public class ReservaDAOImp implements IReservaDAO{
	protected ConnectionManager connManager;

	public ReservaDAOImp() throws DAOExcepcion {
		super();
		try{
		connManager= new ConnectionManager("alquilervehiculosBD");
		}
		catch (ClassNotFoundException e){	
			throw new DAOExcepcion(e);
			}
	}
	
	@Override
	public ReservaDTO buscarReserva(int identificador) throws DAOExcepcion {
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Reserva where NOMBRE= '"+identificador+"'");
			connManager.close();
		
			if (rs.next())
				return new ReservaDTO(
							rs.getInt("ID"),
							rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getString("MODALIDADALQUILER"),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));
			else
				return null;	
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
	}
	@Override
	public List<ReservaDTO> obtenerTodasReservas() throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Reserva");
			connManager.close();
		
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
			
			try{				
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getString("MODALIDADALQUILER"),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));	 
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);
			}
			
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){ throw e;}
	}
	
	@Override
	public List<ReservaDTO> obtenerReservasPorSucursalOrigen(int idSucursal) throws DAOExcepcion{
		try{
			connManager.connect();
			ResultSet rs=connManager.queryDB("select * from Reserva where SUCURSALRECOGIDA= '"+idSucursal+"'");
			connManager.close();
		
			List<ReservaDTO> listaReservaDTO = new ArrayList<ReservaDTO>();
			
			try{				
				while (rs.next()){

					ReservaDTO resDTO = new ReservaDTO(
							rs.getInt("ID"),
							rs.getDate("FECHARECOGIDA").toLocalDate(),
							rs.getDate("FECHADEVOLUCION").toLocalDate(),
							rs.getString("MODALIDADALQUILER"),
							rs.getString("CATEGORIA"),
							rs.getString("CLIENTEREALIZA"),
							rs.getInt("SUCURSALRECOGIDA"),
							rs.getInt("SUCURSALDEVOLUCION"));	 
					listaReservaDTO.add(resDTO);
				}
				return listaReservaDTO;
			}
			catch (Exception e){	throw new DAOExcepcion(e);
			}
			
		}
		catch (SQLException e){	throw new DAOExcepcion(e);}	
		catch (DAOExcepcion e){ throw e;}
	}

	@Override
	public void crearReserva(ReservaDTO reserva) throws DAOExcepcion {
		try {
			connManager.connect();
			int id = reserva.getId();
			LocalDate fechaRecogida = reserva.getFechaRecogida();
			LocalDate fechaDevolucion = reserva.getFechaDevolucion();
			String modalidadAlquiler = reserva.getModalidadAlquiler();
			String categoria = reserva.getNombreCategoria();
			String cliente = reserva.getDniCliente();
			int sucursalR = reserva.getIdSucursalRecogida();
			int sucursalD = reserva.getIdSucursalDevolucion();
			
			connManager.queryDB("INSERT INTO Reserva (ID,FECHARECOGIDA,FECHADEVOLUCION,MODALIDADALQUILER,CATEGORIA,CLIENTEREALIZA,SUCURSALRECOGIDA,SUCURSALDEVOLUCION)"
					+ "VALUES ("+id+",'"+fechaRecogida.toString()+" 00:00:00','"+fechaDevolucion.toString()+" 00:00:00','"+modalidadAlquiler+"','"+categoria+"','"+cliente+"',"+sucursalR+","+sucursalD+")");
			connManager.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
