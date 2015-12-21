//IReservaDAO
package persistencia;

import java.util.List;

import persistencia.dto.CocheDTO;
import excepciones.*;

public interface ICocheDAO {
 
 public void crearCoche(CocheDTO coche) throws DAOExcepcion;
 
}
