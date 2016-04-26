package base;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.StudentDomainModel;

public class Student_Test {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		StudentDomainModel sdm = new StudentDomainModel("Ryan", "Daniel", "Boedeker", LocalDate.of(1996, 10, 12));
		System.out.println(sdm);
		StudentDAL.addStudent(sdm);
		assertTrue(1==1);
	}
}