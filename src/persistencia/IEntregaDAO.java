//IReservaDAO
package persistencia;

import java.util.List;

import persistencia.dto.EntregaDTO;
import excepciones.*;

public interface IEntregaDAO {
 
 public void crearEntrega(EntregaDTO entrega) throws DAOExcepcion;
 
}
