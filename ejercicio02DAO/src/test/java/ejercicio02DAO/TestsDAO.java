package ejercicio02DAO;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.curso.java.ejercicio02DAO.AulaDAOList;
import com.curso.java.oo.model.Aula;

public class TestsDAO {

	List<Aula> aulas;
	AulaDAOList aulaDAOList;
	Aula aula1;
	Aula aula2;
	
	@Before
	public void setUp() throws Exception {
		aulas = new ArrayList<Aula>();
		aula1 = new Aula("Aula1", true, true);
		aula2 = new Aula("Aula2", false, true);
		aulas.add(aula1);
		aulas.add(aula2);
		aulaDAOList = new AulaDAOList();
		aulaDAOList.setAulas(aulas);
	}
	
	@Test
	public void test() {
		Aula aulaPrueba = new Aula(aula1.getNombre(), aula1.isProyector(), aula1.isPizarra());
		Aula aulaPruebaDAO = aulaDAOList.createAula(aulaPrueba);
		Object array1[] = {aula1.getNombre(), aula1.isPizarra(), aula1.isProyector()};
		Object array2[] = {aulaPruebaDAO.getNombre(), aulaPruebaDAO.isPizarra(), aulaPruebaDAO.isProyector()};
		assertArrayEquals(array1,array2);
		
		assertNotNull(aulaDAOList.getAulas());
		
		aula1.setPizarra(false);
		assertNotNull(aulaDAOList.updateAula(aula1));
		
		assertEquals(new Boolean(true), aulaDAOList.deleteAula(aula1.getNombre()));
		
		assertEquals(aula2, aulaDAOList.getAula(aula2.getNombre()));
		
	}

}
