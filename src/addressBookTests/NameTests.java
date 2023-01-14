package addressBookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import addressBookSrc.Name;

class NameTests {

	Name fullname = new Name("Micheal Bakari Jordan");							//Initialising the Name class using the full name constructor
	Name name2Args = new Name("Tim", "Cook");									//Initialising the Name class using the first name and last name constructor
	Name name3Args = new Name("Tej", "Singh", "Sohi");							//Initialising the Name class using the first name, middle name and last name constructor
	
	
	//Unit test that tests the constructor with 2 parameters

	@Test
	void testName2Args()
	{
		assertEquals("Tim", name2Args.getFirstName());
		assertEquals("Cook", name2Args.getLastName());
	}

	//Unit test that tests the constructor with 3 parameters
	@Test
	void testName3Args() {
		assertEquals("Tej", name3Args.getFirstName());
		assertEquals("Singh", name3Args.getMiddleName());
		assertEquals("Sohi", name3Args.getLastName());
	}
	
	//Unit test that tests the constructor with 1 parameter
	@Test
	void testFullname() {
		assertEquals("Micheal Bakari Jordan", fullname.getFullName());
	}
	
	//Unit test that tests the setter and getter for the firstName property
	@Test
	void testSetFirstName() {
		name3Args.setFirstName("Emily");
		assertEquals("Emily", name3Args.getFirstName());
	}
	
	//Unit test that tests the setter and getter for the middleName property
	@Test 
	void testSetMiddleName() {
		name3Args.setMiddleName("Bett");
		assertEquals("Bett", name3Args.getMiddleName());
	}
	
	//Unit test that tests the setter and getter for the lastName property
	@Test
	void testSetLastName() {
		name3Args.setLastName("Rickards");
		assertEquals("Rickards", name3Args.getLastName());
	}
	
	//Unit test that tests the method to get the first and last name
	@Test
	void testGetFirstAndLastName() {
		assertEquals("Tej Sohi", name3Args.getFirstAndLastName());
	}
	
	//Unit test that tests the method to get the last name comma and first name
	@Test
	void testGetLastCommaFirst() {
		assertEquals("Sohi, Tej", name3Args.getLastCommaFirst());
	}
	
	

}
