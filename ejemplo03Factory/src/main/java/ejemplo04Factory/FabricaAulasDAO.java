package ejemplo04Factory;

import com.curso.java.ejercicio02DAO.AulaDAOList;
import com.curso.java.ejercicio02DAO.AulaDAOMap;
import com.curso.java.ejercicio02DAO.IAulaDAO;

public class FabricaAulasDAO {
	
	public static IAulaDAO getAulaInstance(String nombreImplementacion) {
		if (nombreImplementacion == "AulaDAOList") {
			return new AulaDAOList();
		}else {
			return new AulaDAOMap();
		}
	}
	
	private static String getNombreDeInstanciaDeFichero() {
		return "";
	}
	
}
