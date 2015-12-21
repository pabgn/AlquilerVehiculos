package controllers;
import java.time.LocalDate;
import java.util.List;

import models.Cliente;
import models.Entrega;
import models.Reserva;
import excepciones.DAOExcepcion;
import persistencia.*;
import persistencia.dto.CategoriaDTO;
import persistencia.dto.ClienteDTO;
import persistencia.dto.CocheDTO;
import persistencia.dto.EntregaDTO;
import persistencia.dto.ReservaDTO;
import persistencia.dto.SucursalDTO;


public class DAL{

private static DAL INSTANCIA = new DAL();
private CategoriaDAOImp catDAO;
private SucursalDAOImp sucDAO;
private ClienteDAOImp cliDAO;
private ReservaDAOImp resDAO;
private EntregaDAOImp entDAO;
private CochesDAOImp cochDAO;

public static DAL getDAL(){
	return INSTANCIA;
}
private DAL(){
	try {
		this.catDAO = new CategoriaDAOImp();
		this.sucDAO = new SucursalDAOImp();
		this.cliDAO = new ClienteDAOImp();
		this.resDAO = new ReservaDAOImp();
		this.cochDAO = new CochesDAOImp();
		this.entDAO = new EntregaDAOImp();
		
	} catch (DAOExcepcion e) {
		e.printStackTrace();
	}
}

public List<CategoriaDTO> obtenerCategorias() {
	try {
		return catDAO.obtenerCategorias();
	} catch (DAOExcepcion e) {
	return null;
	}
}

public List<SucursalDTO> obtenerSucursales() {
	try {
		return sucDAO.obtenerSucursales();
	} catch (DAOExcepcion e) {
	return null;
	}
}

public List<ClienteDTO> obtenerClientes() {
	try {
		return cliDAO.obtenerClientes();
	} catch (DAOExcepcion e) {
	return null;
	}
}


public List<ReservaDTO> obtenerReservas(int idSucursal) {
	try {
		return resDAO.obtenerReservasPorSucursalOrigen(idSucursal);
	} catch (DAOExcepcion e) {
	return null;
	}
}
public List<ReservaDTO> obtenerTodasReservas() {
	try {
		return resDAO.obtenerTodasReservas();
	} catch (DAOExcepcion e) {
	return null;
	}
}
public List<CocheDTO> obtenerCochesPorSucursal(int idSucursal) {
	try {
		return cochDAO.obtenerCochesPorSucursal(idSucursal);
	} catch (DAOExcepcion e) {
	return null;
	}
}

public void insertarReserva(Reserva r) {
	try {
		ReservaDTO re = new ReservaDTO(r.getId(), r.getFechaRecogida(),
				r.getFechaDevolucion(), r.getModalidadAlquiler(),
				r.getNombreCategoria(), r.getDniCliente(),  r.getIdSucursalRecogida(),
				r.getIdSucursalDevolucion());
		resDAO.crearReserva(re);
	} catch (DAOExcepcion e) {
	}
}

public void insertarEntrega(Entrega en) {
	try {
		EntregaDTO e = new EntregaDTO(en.getId(),
				en.getFecha(), 
				en.getTipoSeguro(),
				en.getKms(), 
				en.getCombustible(), 
				en.getCoche().getMatricula(),
				en.getEmpleado());
		entDAO.crearEntrega(e);
	} catch (DAOExcepcion e) {
	}
}
public boolean existeEntrega(Reserva r){
	try {
		return entDAO.existeEntragaConReseva(r.getId());
	} catch (DAOExcepcion e) {
	}
	return false;
}
public void insertarCliente(Cliente c) {
	try {
		ClienteDTO cl = new ClienteDTO(c.getNombreyApellidos(), c.getDireccion(), c.getPoblacion(), c.getCodPostal(), c.getFechaCarnetConducir(), c.getDigitosTC(), c.getMesTC(), c.getAñoTC(), c.getCvcTC(), c.getTipoTC(), c.getDNI());
		cliDAO.crearCliente(cl);
	} catch (DAOExcepcion e) {
	}
}
}
