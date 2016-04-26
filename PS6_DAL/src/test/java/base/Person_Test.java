package base;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import domain.PersonDomainModel;

public class Person_Test {

	private static PersonDomainModel person;
	
	private static Calendar cal = Calendar.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		person = new PersonDomainModel();
		person.setFirstName("Ryan");
		person.setLastName("Boedeker");
		cal.set(1996, 10, 12);
		person.setBirthday(cal.getTime());
		person.setCity("Bear");
		person.setPostalCode(19701);
		person.setStreet("96 Loblolly Lane");
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
	public void addPersonTest() {
		
		System.out.println(person);
		PersonDomainModel testPerson;
		testPerson = PersonDAL.getPerson(person.getPersonID());
		System.out.println(testPerson);
		assertNull("This person shouldn't be listed here", testPerson);
		
		PersonDAL.addPerson(person);
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertTrue("This person could not be found", testPerson != null);
		
		PersonDAL.deletePerson(person.getPersonID());
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
	}

	@Test
	public void getPersonTest() {
		PersonDomainModel testPerson;
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
		
		PersonDAL.addPerson(person);
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertTrue("This person could not be found", testPerson != null);
			
		PersonDAL.deletePerson(person.getPersonID());
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
	}
	
	@Test
	public void deletePersonTest() {
		
		PersonDomainModel testPerson;
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
		
		PersonDAL.addPerson(person);
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertTrue("This person could not be found", testPerson != null);
		
		PersonDAL.deletePerson(person.getPersonID());
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
	}

	@Test
	public void getPersonsTest() {
		PersonDomainModel testPerson;
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
		
		PersonDAL.addPerson(person);
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertTrue("This person could not be found", testPerson != null);
	
		ArrayList<PersonDomainModel> persons = PersonDAL.getPersons();
		System.out.println(persons.size() + " records retrieved");
		for (PersonDomainModel p : persons) {
			System.out.println(p);
		}
		
		PersonDAL.deletePerson(person.getPersonID());
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
	}

	@Test
	public void updatePersonTest() {		
		
		PersonDomainModel testPerson;
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
		
		PersonDAL.addPerson(person);
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertTrue("This person could not be found", testPerson != null);
		
		String newFirstName = "RyRy";
		testPerson.setFirstName(newFirstName);
		PersonDAL.updatePerson(testPerson);
		testPerson = PersonDAL.getPerson(testPerson.getPersonID());
		assertTrue("First name did not change",testPerson.getFirstName().equals(newFirstName));
		
		PersonDAL.deletePerson(person.getPersonID());
		testPerson = PersonDAL.getPerson(person.getPersonID());
		assertNull("This person shouldn't be listed here", testPerson);
	}
}