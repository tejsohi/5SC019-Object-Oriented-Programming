package addressBookSrc;														//Importing the name package which has the name of addressBookSrc	

import java.util.ArrayList;													//Importing java.util.ArrayList for use later

public interface IPersonalContact {											//Initialising IPersonalContact interface

	public void add(PersonalContact p);													//declaring the public method add with a PersonalContact parameter passed in and no return type
	public int getSize();																//declaring the public method getSize with no parameters passed in and an integer return type
	public ArrayList<PersonalContact> listAllContacts();								//declaring the public method listAllContacts with no parameters 
	public void addToAddressBook(Name name, String phoneNumber, String address);		//declaring the public method addToAddressBook with 1 Name parameter and 2 string parameters with a void return type
	public PersonalContact getContactByName(Name name);									//declaring the public method getContactBySurnameAndCompanyAddress with 1 Name parameter with a return type of PersonalContact
	public void readContactsFile();														//declaring the public method readContactsFile with no parameters and a void return type
	public void processLine(String line);												//declaring the public method processLine with a String parameter and a void return type
	public void editContact(String existingTerm, Name newName, String newPhoneNumber, String newAddress);		//declaring the public method editContact with 3 String parameters and 1 Name parameter with a void return type
	public void removeFromAddressBook(Name name);										//declaring the public method removeFromAddressBook with a Name parameter and a void return type
	
}
