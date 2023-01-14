package addressBookSrc;  														//Importing the name package which has the name of addressBookSrc

public class Name {																//Initialising the class Name
	
	private String firstName;													//Declaring the private string property firstName 
	private String middleName;													//Declaring the private string property middleName
	private String lastName;													//Declaring the private string property lastName

	/*
	 * Declaring the constructor Name with 2 string parameters 
	 * The constructor initialises 2 of the string properties using the 2 parameters
	 * one of the properties is initialised as empty string
	 * The constructor does not return anything
	 */
	public Name(String fName, String lName) {									
		firstName = fName;
		middleName = "";
		lastName = lName;
	}

	/*
	 * Declaring the constructor Name with 3 string parameters 
	 * The constructor initialises the 3 the string properties using the 3 parameters
	 * The constructor does not return anything
	 */
	public Name(String fName, String mName, String lName) {
		firstName = fName;
		middleName = mName;
		lastName = lName;
	}

	/*
	 * Declaring the constructor Name with 1 string parameter
	 * The constructor separates the string parameter by spaces
	 * each separated string is then stored in one of the string properties
	 * The constructor does not return anything
	 */
	public Name(String fullName) {
		int spacePos1 = fullName.indexOf(' ');
		firstName = fullName.substring(0, spacePos1);
		int spacePos2 = fullName.lastIndexOf(' ');
		if (spacePos1 == spacePos2)
			middleName = "";
		else
			middleName = fullName.substring(spacePos1 + 1, spacePos2);
		lastName = fullName.substring(spacePos2 + 1);
	}

	//Getter that returns the value of the firstName property
	public String getFirstName() {
		return firstName;
	}
	
	//Getter that returns the value of the middleName property
	public String getMiddleName() {
		return middleName;
	}

	//Getter that returns the value of the lastName
	public String getLastName() {
		return lastName;
	}

	//Setter that sets the value of firstName using the string parameter
	public void setFirstName(String fn) {
		firstName = fn;
	}

	//Setter that sets the value of middleName using the string parameter
	public void setMiddleName(String mn) {
		middleName = mn;
	}

	//Setter that sets the value of middleName using the string parameter
	public void setLastName(String ln) {
		lastName = ln;
	}

	//Method that returns the values of firstName and lastName
	public String getFirstAndLastName() {
		return firstName + " " + lastName;
	}

	//Method that returns the values of lastName and firstName with a comma in between 
	public String getLastCommaFirst() {
		return lastName + ", " + firstName;
	}

	// Method that that returns the values of firstName, middleName and lastName all as one string
	public String getFullName() {
		String result = firstName + " ";
		if (!middleName.equals("")) {
			result += middleName + " ";
		}
		result += lastName;
		return result;
	}
}
