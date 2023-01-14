package addressBookSrc;										//Importing the name package which has the name of addressBookSrc	

import java.util.ArrayList;									//Importing java.util.ArrayList for use later

public interface IWorkContact {								//Initialising IWorkContact interface
	
	public void add(WorkContact w);																									//declaring the public method add with a WorkContact parameter passed in and no return type
	public int getSize();																											//declaring the public method getSize with no parameters passed in and an integer return type
	public ArrayList<WorkContact> listAllContacts();																				//declaring the public method listAllContacts with no parameters 
	public void addToAddressBook(Name name, String jobTitle, String phoneNumber, String companyName, String companyAddress);		//declaring the public method addToAddressBook with 1 Name parameter and 4 string parameters with a void return type
	public WorkContact getContactBySurnameAndCompanyAddress(Name name, String companyName);		//declaring the public method getContactBySurnameAndCompanyAddress with 1 Name parameter and 1 String parameter with a return type of WorkContact
	public void readContactsFile();																//declaring the public method readContactsFile with no parameters and a void return type										
	public void processLine(String line);														//declaring the public method processLine with a String parameter and a void return type
	public void editContact(String editTerm, Name newName, String newJobTitle, String newPhoneNumber, String newCompanyName, String newCompanyAddress);			//declaring the public method editContact with 5 String parameters and 1 Name parameter with a void return type
	public void removeFromAddressBook(Name name);												//declaring the public method removeFromAddressBook with a Name parameter and a void return type
}
