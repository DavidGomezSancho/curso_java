package ejercicio02lineaNegocio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.junit.Before;
import org.junit.Test;

import com.curso.java.ejercicio02DAO.AulaDAOList;
import com.curso.java.ejercicio02lineaNegocio.AulaLN;
import com.curso.java.oo.model.Alumno;
import com.curso.java.oo.model.Aula;
import com.curso.java.oo.model.PuestoDeTrabajo;

public class TestLN {
	AulaLN aulaLN;
	
	
	@Before
	public void setUp() throws Exception {
		AulaDAOList aulaDAOList = new AulaDAOList();
		List<Aula> aulas = new ArrayList<Aula>();
//		Aula aula1 = new Aula("Aula1", true, true);
//		Aula aula2 = new Aula("Aula2", false, true);
//		aulas.add(aula1);
//		aulas.add(aula2);
		aulaDAOList.setAulas(aulas);
		aulaLN = new AulaLN(aulaDAOList);
	}
	
	@Test
	public void test() {
		Set<PuestoDeTrabajo> puestosDeAlumnos1 = new HashSet<PuestoDeTrabajo>();
		puestosDeAlumnos1.add(new PuestoDeTrabajo());
		puestosDeAlumnos1.add(new PuestoDeTrabajo());
		assertNotNull(aulaLN.nuevoAula("Aula1", true, true, puestosDeAlumnos1));
		
		Set<PuestoDeTrabajo> puestosDeAlumnos2 = new HashSet<PuestoDeTrabajo>();
		puestosDeAlumnos2.add(new PuestoDeTrabajo());
		puestosDeAlumnos2.add(new PuestoDeTrabajo());
		assertNotNull(aulaLN.nuevoAula("Aula2", false, true, puestosDeAlumnos2));
		
		assertNotNull(aulaLN.getAlumnosPorAulas());
		
		assertTrue(aulaLN.getProfesoresPorAulas().get("Aula1").size()==0);
		
		assertFalse(aulaLN.eliminarAula("Aulaaa"));
		
		
		Alumno alumno = new Alumno();
		alumno.setNombre("Eustaquio");
		assertTrue(aulaLN.putAlumnoAula(alumno, "Aula1"));
		assertFalse(aulaLN.putAlumnoAula(alumno, "Aulafssd1"));
	}

}
