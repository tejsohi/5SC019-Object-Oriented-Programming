package addressBookTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import addressBookSrc.Name;
import addressBookSrc.WorkContact;

class WorkContactTests {
	
	Name name = new Name("Tej", "Sohi");									//Initialising the Name class with 2 String parameters
	WorkContact workContactNoArgs = new WorkContact();						//Initialising the WorkContact class with no parameters
	
	
	//Unit test that tests the listAllContacts method in the WorkContact class
	@Test
	void testWorkContactNoArgs() {
		workContactNoArgs.deleteFile();
		assertTrue(workContactNoArgs.listAllContacts().isEmpty());
	}
	
	WorkContact workContactArgs = new WorkContact(name, "Job Title", "1234", "Company Name", "Company Address");
	
	
	//Unit tests that test the WorkContact constructor with 5 parameters
	@Test
	public void testWorkContactArgs() {
		assertEquals("Tej Sohi", workContactArgs.getName().getFirstAndLastName());
		assertEquals("Job Title", workContactArgs.getJobTitle());
		assertEquals("1234", workContactArgs.getPhoneNumber());
		assertEquals("Company Name", workContactArgs.getCompanyName());
		assertEquals("Company Address", workContactArgs.getCompanyAddress());
	}
	
	@Test
	public void testReadContactsFile() {
		assertDoesNotThrow(() -> workContactNoArgs.readContactsFile());
	}
	
	//Unit test that test the method AddWorkContact and getSize
	@Test
	public void testAddWorkContactAndGetWorkContactSize() {
		workContactNoArgs.add(workContactArgs);
		assertEquals(1, workContactNoArgs.getSize());
	}
	
	//Unit test that tests the setter and getter for the Name property in WorkContact
	@Test
	public void testSetName() {
		workContactNoArgs.setName(name);
		assertEquals("Tej Sohi", workContactNoArgs.getName().getFirstAndLastName());
	}
	
	//Unit test that tests the setter and getter for the phoneNumber property in WorkContact
	@Test
	public void testSetPhoneNumber() {
		workContactNoArgs.setPhoneNumber("987654321");
		assertEquals("987654321", workContactNoArgs.getPhoneNumber());
	}
	
	//Unit test that tests the setter and getter for the jobTitle property in WorkContact
	@Test
	public void testSetJobTitle() {
		workContactNoArgs.setJobTitle("Apprentice Application Developer");
		assertEquals("Apprentice Application Developer", workContactNoArgs.getJobTitle());
	}
	
	//Unit test that tests the setter and getter for the companyAddress property in WorkContact
	@Test
	public void testSetCompanyAddress() {
		workContactNoArgs.setCompanyAddress("Google");
		assertEquals("Google", workContactNoArgs.getCompanyAddress());
	}
	
	//Unit test that tests the setter and getter for the companyName property in WorkContact
	@Test
	public void testSetCompanyName() {
		workContactNoArgs.setCompanyName("PebblePad");
		assertEquals("PebblePad", workContactNoArgs.getCompanyName());
	}
	
	//Unit test that tests the method addToAddressBook in WorkContact
	//The unit test asserts that when the method is called, it does not throw and exception
	@Test
	public void testAddToAddressBook() {
		assertDoesNotThrow(() -> workContactNoArgs.addToAddressBook(name, "Developer", "123456789", "Apple", "Apple Park"));
	}
	
	
	//Unit test that tests the method getContactByName in WorkContact
	//The unit test asserts that the value returned for the method are correct
	@Test
	public void testGetContactBySurnameAndCompanyAddress() {
		Name newName = new Name("New", "Name");
		workContactNoArgs.addToAddressBook(newName, "Old Job Title", "1111", "OnePlus", "Asia");
		var w = workContactNoArgs.getContactBySurnameAndCompanyAddress(newName, "OnePlus");
		
		assertEquals("New Name", w.getName().getFirstAndLastName());
		assertEquals("Old Job Title", w.getJobTitle());
		assertEquals("1111", w.getPhoneNumber());
		assertEquals("OnePlus", w.getCompanyName());
		assertEquals("Asia", w.getCompanyAddress());
	}
	
	//Unit tests that test the editContact method in WorkContact
	//The unit test adds a new contact to the address book and then edits that contact
	//The unit test then asserts that the edited contact has the correct new details
	@Test
	public void testEditContact() {
		Name uniqueName = new Name("Unique", "Unique");
		Name testName = new Name("Name", "is");
		workContactNoArgs.addToAddressBook(uniqueName, "Job Title", "1111", "Google", "Google Campus");
		workContactNoArgs.editContact("Unique Unique", testName, "Developer", "1234", "Apple", "Apple Park");
		var editedContact = workContactNoArgs.getContactBySurnameAndCompanyAddress(testName, "Apple");
		
		assertEquals(testName.getFirstAndLastName(), editedContact.getName().getFirstAndLastName());
		assertEquals("Developer", editedContact.getJobTitle());
		assertEquals("1234", editedContact.getPhoneNumber());
		assertEquals("Apple", editedContact.getCompanyName());
		assertEquals("Apple Park", editedContact.getCompanyAddress());
	}
	
	
	//Unit test that tests the method removeFromAddressBook0
	//The unit test asserts that an exception is not thrown when the method is called
	@Test
	public void testRemoveFromAddressBook() {
		assertDoesNotThrow(() -> workContactNoArgs.removeFromAddressBook(name));
	}
}
