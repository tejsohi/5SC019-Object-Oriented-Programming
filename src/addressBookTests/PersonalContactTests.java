package addressBookTests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import addressBookSrc.Name;
import addressBookSrc.PersonalContact;

class PersonalContactTests {

	Name name = new Name("Tej", "Sohi");									//Initialising the Name class with 2 String parameters
	PersonalContact personalContactNoArgs = new PersonalContact();			//Initialising the PersonalContact class with no parameters
	
	//Unit test that tests the listAllContacts method in the PersonalContact class
	@Test
	public void testPersonalContactNoArgs() {
		personalContactNoArgs.deleteFile();
		assertTrue(personalContactNoArgs.listAllContacts().isEmpty());
	}
	
	
	PersonalContact personalContactArgs = new PersonalContact(name, "12345678912", "Address");		//Initialising the PersonalContact class with 3 parameters
	
	//Unit tests that test the PersonalContact constructor with 3 parameters
	@Test
	public void testPersonalContactArgs() {
		assertEquals("Tej Sohi", personalContactArgs.getName().getFirstAndLastName());
		assertEquals("12345678912", personalContactArgs.getPhoneNumber());
		assertEquals("Address", personalContactArgs.getAddress());
	}
	
	//Unit test that test the method AddPersonalContact and getSize
	@Test
	public void testAddPersonalContactAndGetPersonalContactSize() {
		personalContactNoArgs.add(personalContactArgs);
		assertEquals(1, personalContactNoArgs.getSize());
	}
	
	//Unit test that tests the setter and getter for the Name property in PersonalContact
	@Test
	public void testSetName() {
		personalContactNoArgs.setName(name);
		assertEquals("Tej Sohi", personalContactNoArgs.getName().getFirstAndLastName());
	}
	
	//Unit test that tests the setter and getter for the phoneNumber property in PersonalContact
	@Test
	public void testSetPhoneNumber() {
		personalContactNoArgs.setPhoneNumber("1234");
		assertEquals("1234", personalContactNoArgs.getPhoneNumber());
	}
	
	//Unit test that tests the setter and getter for the address property in PersonalContact
	@Test
	public void testSetAddress() {
		personalContactNoArgs.setAddress("Test Address");
		assertEquals("Test Address", personalContactNoArgs.getAddress());
	}
	
	//Unit test that tests the method addToAddressBook in PersonalContact
	//The unit test asserts that when the method is called, it does not throw and exception
	@Test 
	public void testAddToAddressBook() {
		assertDoesNotThrow(() -> personalContactNoArgs.addToAddressBook(name, "1234", "address"));
	}
	
	//Unit test that tests the method getContactByName in PersonalContact
	//The unit test asserts that the value returned for the method are correct
	@Test 
	public void testGetContactByName() {	
		Name newName = new Name("New", "Name");
		personalContactNoArgs.addToAddressBook(newName, "1111", "old address");
		var p = personalContactNoArgs.getContactByName(newName);
		
		assertEquals("New Name", p.getName().getFirstAndLastName());
		assertEquals(" 1111", p.getPhoneNumber());
		assertEquals(" old address", p.getAddress());
	}
	
	//Unit tests that test the editContact method in PersonalContact
	//The unit test adds a new contact to the address book and then edits that contact
	//The unit test then asserts that the edited contact has the correct new details
	@Test 
	public void testEditContact() {
		Name uniqueName = new Name("Unique", "Unique");
		Name testName = new Name("Name", "is");
		personalContactNoArgs.addToAddressBook(uniqueName, "1111", "old address");
		personalContactNoArgs.editContact("Unique Unique", testName, "1234", "new address");
		var editedContact = personalContactNoArgs.getContactByName(testName);
		
		assertEquals(testName.getFirstAndLastName(), editedContact.getName().getFirstAndLastName());
		assertEquals("1234", editedContact.getPhoneNumber());
		assertEquals("new address", editedContact.getAddress());
	}
	
	//Unit test that tests the method removeFromAddressBook0
	//The unit test asserts that an exception is not thrown when the method is called
	@Test
	public void testRemoveFromAddressBook() {
		assertDoesNotThrow(() -> personalContactNoArgs.removeFromAddressBook(name));
	}
}
