package addressBookSrc;								//Importing the name package which has the name of addressBookSrc			
	
import java.io.BufferedReader;						//Importing java.io.BufferedReader for use later												
import java.io.BufferedWriter;						//Importing java.io.BufferedWriter for use later
import java.io.File;								//Importing java.io.File for use later
import java.io.FileReader;							//Importing java.io.FileReader for use later
import java.io.FileWriter;							//Importing java.io.FileWriter for use later
import java.io.IOException;							//Importing java.io.IOException for use later
import java.io.PrintWriter;							//Importing java.io.PrintWriter for use later
import java.util.ArrayList;							//Importing java.util.ArrayList for use later
import java.util.Scanner;							//Importing java.util.Scanner for use later

public class PersonalContact implements IPersonalContact {							//Initialising the class PersonalContact and inheriting the IPersonalContact interface
	
	private Name name;																//Declaring the private Name property name
	private String phoneNumber;														//Declaring the private string property phoneNumber
	private String address;															//Declaring the private string property address																
	private ArrayList<PersonalContact> personalContactList;							//Declaring the private static ArrayList property with a type of PersonalContact personalContactlist
	
	/* A constructor that takes 1 Name parameter and 2 String parameters
	 * the property name is set to the Name parameter name
	 * the property phoneNumber is set to the String parameter phoneNumber
	 * the property address is set to the String parameter address
	 * the constructor does not return a value
	 */
	public PersonalContact(Name name, String phoneNumber, String address) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	/* Constructor that takes no parameters
	 * Initialises the property personalContactList to be a new ArrayList
	 * the constructor does not return a value
	 */
	public PersonalContact() {
		personalContactList = new ArrayList();
	}

	/*A method that takes a single parameter of type PersonalContact
	 * The method adds the PersonalContact object to the personalContactList array
	 * the method has a return type of void
	 */
	public void add(PersonalContact p) {
		personalContactList.add(p);
	}
	
	//Getter that returns the value of the property name as a Name object
	public Name getName() {
		return name;
	}

	//Setter that sets the value of the property name to the Name object name
	public void setName(Name name) {
		this.name = name;
	}

	//Getter that returns the value of the string property phoneNumber
	public String getPhoneNumber() {
		return phoneNumber;
	}

	//Setter that sets the value of the property phoneNumber to the string parameter phoneNumber
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//Getter that returns the value of the string property address
	public String getAddress() {
		return address;
	}

	//Setter that sets the value of the property address to the string parameter address
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Method that returns an integer the size of the personalContactList array
	public int getSize() {
		return personalContactList.size();
	}
	
	/* Method that returns an ArrayList of type PersonalContact
	 * the method calls another method readContactsFile in order to populate the ArrayList
	 * the populated ArrayList is then returned
	 */
	public ArrayList<PersonalContact> listAllContacts() {
		readContactsFile();
		return personalContactList;
	}

	/* Method that take 1 Name parameter and 2 String parameters
	 * the method uses a try catch system to create a new text file
	 * The parameters that are passed through to the method are then added to the text file
	 * if the try fails the catch will print an input/output exception  
	 */
	public void addToAddressBook(Name name, String phoneNumber, String address) {
		try {
			FileWriter fw = new FileWriter("FriendContacts.txt", true);				//A new text file is created called FriendContacs.txt
			BufferedWriter bw = new BufferedWriter(fw);								//Buffered writer is initialised to allow writing and appending to the text file
			bw.append(name.getFirstAndLastName() + ", ");							//The first and last name of the name object is appended to the text file
			bw.append(phoneNumber + ", ");											//The phoneNumber variable is appended to the text file
			bw.append(address + "\n");												//The address variable is appended to the text file
			bw.close();																//Buffered Writer is closed to avoid resource leaking and improve performance
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/* Method that takes 1 Name parameter and returns a PersonalContact object
	 * The method will attempt to read the Friends Contact text file and check if the name object can be found in the text file
	 * If a match is made, a new PersonalContact object is made and returned
	 * If a match is not made, an empty PersonalContact object is returned
	 * If there is a problem with the text file
	 * The error is caught and output to the console.
	 */
	public PersonalContact getContactByName(Name name) {
		PersonalContact p = new PersonalContact(name, "", "");
		readContactsFile();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("FriendContacts.txt"));
			String currentLine;

			while((currentLine = reader.readLine()) != null) {
			    String trimmedLine = currentLine.trim();
			    if(trimmedLine.contains(name.getFirstAndLastName().toString())) {
			    	String parts[] = trimmedLine.split(",");
					Name foundName = new Name(parts[0]);
					String phoneNumber = parts[1];
					String companyAddress = parts[2];
					p = new PersonalContact(foundName, phoneNumber, companyAddress);
					return p;
			    }
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return p;
	}
	
	/* Method that takes no parameters and does not return anything
	 * This method opens the friends contacts text file to begin the processing of each line
	 * The processing of each line is done by the process line method and the string parameter line is passed through
	 * If there is an error with the text file and IOException is caught and output to the console 
	 */
	public void readContactsFile() {
		try {
			FileReader fileReader = new FileReader("FriendContacts.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while (bufferedReader.ready()) {
				String line = bufferedReader.readLine();
				processLine(line);
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	/* Method that takes a String parameter line and does not return anything
	 * This method receives each line from the text file and breaks the line down further into respective variables
	 * such as name, phoneNumber and address.
	 * A new object is created from this and added to the personalContactList ArrayList
	 * If there is a problem with the text file
	 * The error is caught and output to the console.
	 */
	public void processLine(String line) {
		try {
			String parts[] = line.split(",");
			Name name = new Name(parts[0]);
			String phoneNumber = parts[1];
			String address = parts[2];
			PersonalContact p = new PersonalContact(name, phoneNumber, address);
			this.add(p);
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/*Method that takes in 3 String parameters and 1 Name parameter
	 *This method searches the friendConctact text file for an existing contact with using an existing name in the address book
	 *If there is a match on the line where the contact is found, the parameters passed in are used in place of the old details
	 *If there is no match then the contact details are re-written to the file.
	 *If there is an error with the file the error is caught and output to the console
	 */
	public void editContact(String existingTerm, Name newName, String newPhoneNumber, String newAddress) {
		String tempFile = "tempFriendContacts.txt";																				//String variable with a new temporayFriendsContact text file
		File oldFile = new File ("FriendContacts.txt");																			//Name of the current existing text file
		File newFile = new File(tempFile);																						//A new file is created with the tempFile name
		
		String name = ""; String phoneNumber = ""; String address = ""; 														//3 empty string variables to be used later
		try {
			FileWriter fw = new FileWriter(tempFile, true);																		//A file writer is initialised to write to the tempFile
			BufferedWriter bw = new BufferedWriter(fw);																			//A buffered writer is initialised to write to the tempFile
			PrintWriter pw = new PrintWriter(bw);																				//A print writer is initialised to write to the tempFile
			Scanner x = new Scanner(new File("FriendContacts.txt"));															//Scanner is initialised to scan the friends Contacts file
			x.useDelimiter("[,\n]");																							//This determines how each line is separated
				
			while(x.hasNext()) {																								//While loop while the text file has lines																								
				name = x.next();																								//Stores the name variable from the text file
				phoneNumber = x.next();																							//Stores the phoneNumber variable from the text file
				address = x.next();																								//Stores the address variable from the text file
				
				if (name.contains(existingTerm) || phoneNumber.contains(existingTerm) || address.contains(existingTerm)) {		
					pw.println(newName.getFirstAndLastName() + "," + newPhoneNumber + "," + newAddress);						//This will write to the file if the if variables in the if statement matches the passed in existingTerm parameter
				} else {
					pw.println(name + "," + phoneNumber + "," + address);														//This will write to the file if the variables in the if statements does not match the passed in existingTerm parameter
				}
			}
			x.close();												//closes Scanner to avoid resource leak to improve performance																											
			pw.flush();												//flushes the stream
			pw.close();                                             //closes print writer to avoid resource leak to improve performance		
			
			//This if statement ensures that the old file is deleted to make sure the renaming of the temporary file does not error
			if(!oldFile.delete()) {
                if (oldFile.exists()) {
                    for (int i = 0; i < 6; i++) {
                        Thread.sleep(500);
                        System.gc();
                        if (oldFile.delete())
                           break;
                    }
            	}
            }
			boolean successful = newFile.renameTo(new File("FriendContacts.txt"));				//rename the temporary file and store is as a boolean
			
			//Check to see if the renaming of the file was successful 
			if (successful) {
				System.out.println("Changed file name");
			} else if(!successful) {
				
			}
		} catch (Exception e) {
			System.out.println("Failed to edit contact in the address book" + e); 
		}
	}
	
	/*Method that takes in 1 Name parameter
	 *This method will read the file and check to see if the name parameter is found in the file
	 * If there is a match, the line with the matching name is removed from the text file
	 * If there is no match, the line is left alone
	 * If there is an error with the file the error is caught and output to the console
	 */	
	public void removeFromAddressBook(Name name) {
		File inputfile = new File("FriendContacts.txt");
		File tempFile = new File("tempFriendContacts.txt");
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(inputfile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

			
			String currentLine;

			while((currentLine = reader.readLine()) != null) {											//A while loop that runs while the lines are not null in the text file
			    // trim newline when comparing with lineToRemove
			    String trimmedLine = currentLine.trim();												//Trim is used to trim leading and trailing spaces on the line
			    if(trimmedLine.contains(name.getFirstAndLastName().toString())) continue;				//If the if statement is not true, then the loop will move onto the next line
			    writer.write(currentLine + System.getProperty("line.separator"));						//If the if statement is true, then it will write the current line to the file							
			}
			writer.close(); 						//close buffered writer to avoid resource leak
			reader.close();							//close buffered reader to avoid resource leak								
			
			//This if statement ensures that the old file is deleted to make sure the renaming of the temporary file does not error
			if(!inputfile.delete()) {
                if (inputfile.exists()) {
                    for (int i = 0; i < 6; i++) {
                        Thread.sleep(500);
                        System.gc();
                        if (inputfile.delete())
                           break;
                    }
            	}
            }			
			
			boolean successful = tempFile.renameTo(new File("FriendContacts.txt"));				//rename the temporary file and store is as a boolean
			
			//This if statement ensures that the old file is deleted to make sure the renaming of the temporary file does not error
			if (successful) {
				System.out.println("Changed file name");
			} else if(!successful) {
				
			}
			
			
		} catch(Exception e) {
			System.out.println("Failed to remove person from address book" + e);
		}
	}
	
	//Method that deletes the friendsContacts text file
	public void deleteFile() {
		File file = new File("FriendContacts.txt"); 
		if (file.delete()) { 
			System.out.println("Deleted the file: " + file.getName());
	    } 
	}
	
}
