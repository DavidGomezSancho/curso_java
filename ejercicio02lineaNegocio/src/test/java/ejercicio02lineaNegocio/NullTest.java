package ejercicio02lineaNegocio;

import static org.junit.Assert.*;

import org.junit.Test;

import com.curso.java.ejercicio02DAO.AulaDAOList;
import com.curso.java.ejercicio02lineaNegocio.AulaLN;

public class NullTest {

	
	
	@Test
	public void test() {
		AulaDAOList estaEsMiImplementacionDeLaInterfazAulaDaoList = new AulaDAOList();
		AulaLN aula = new AulaLN(estaEsMiImplementacionDeLaInterfazAulaDaoList);
		assertNotNull(aula.nuevoAula(null, true, true, null));
	}

}
