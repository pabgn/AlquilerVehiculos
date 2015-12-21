//ISucursalDAO
package persistencia;

import java.util.List;

import persistencia.dto.SucursalDTO;
import excepciones.*;

public interface ISucursalDAO {
 public List <SucursalDTO> obtenerSucursales() throws DAOExcepcion;
}
