package addressBookSrc;

import java.awt.*;									//Importing java.awt for use later
import java.awt.event.ActionEvent;					//Importing java.awt.event.ActionEvent for use later
import java.awt.event.ActionListener;				//Importing java.awt.event.ActionListener
import javax.swing.*;								//Importing javax.swing for use later

public class GUI implements ActionListener {		//Initialising the class GUI and inheriting the interface ActionListener

	private JFrame window;							//Declaring the private JFrame window
	
	//Declaring multiple JPanels with different variable names to be used later in the program
	private JPanel northPanel , friendPanel, workPanel, actionsPanel, getPCPanel, getWCPanel;
	
	//Declaring multiple JButtons with different variable names to be used later in the program
	private JButton viewWorkContactBtn, removeWCContactBtn, viewFriendContactBtn, addFriendContactBtn, addWorkContactBtn, retrieveFriendContactBtn, getPersonalContact, 
					getWorkContact, retrieveWorkContactBtn, removeFriendContactBtn, removeWorkContactBtn, editFriendContactbtn, editWorkContactBtn, backBtn, exitBtn, addPersonalContactBtn,
					addFormalContactBtn, removePCContactBtn, editPCContact, editWCContact;
	
	//Declaring multiple JTextFields with different variable names to be used later in the program
	private JTextField findFirstnameTxt, findSurnameTxt, nameTxt, firstNameTxt, surnameTxt, phoneNumberTxt, addressTxt, companyNameTxt, companyAddressTxt, jobTitleTxt ;
	
	//Declaring multiple JLabels with different variable names to be used later in the program
	private JLabel jobTitleLbl, nameLbl, firstNameLbl, surnameLbl,  phoneNumberLbl, addressLbl, companyNameLbl, companyAddressLbl, foundNameLbl, foundNumberLbl, foundAddressLbl,
					foundJobTitleLbl, foundCompanyNameLbl, findSurnameLbl, findFirstnameLbl;
	
	public GUI() {
		window = new JFrame("Address Book");										//Creating a new JFrame with the name Address Book
		window.setBounds(100, 100, 1000, 1000);										//Set the dimensions of the JFrame												
		northPanel = new JPanel();													//Creating a new JPanel
		northPanel.setLayout(new GridLayout(11,1));									//Setting the grid layout of northPanel 

		addFriendContactBtn = new JButton("Add Personal Contact");					//Initialising a JButton with the text Add Personal Contact						
		addFriendContactBtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		addFriendContactBtn.setToolTipText("Click this to add a personal contact to the address book");
		addWorkContactBtn = new JButton("Add Work Contact");						//Initialising a JButton with a the text Add Work Contact
		addWorkContactBtn.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		addWorkContactBtn.setToolTipText("Click this to add a formal contact to the address book");
		retrieveFriendContactBtn = new JButton("Get personal contact");				//Initialising a JButton with the text personal contact	
		retrieveFriendContactBtn.addActionListener(this);							//Adding an action listener to the button when it is clicked on
		retrieveFriendContactBtn.setToolTipText("Click this to retrieve a specific personal contact from the address book");
		retrieveWorkContactBtn = new JButton("Get work contact");					//Initialising a JButton with the text Get work contact
		retrieveWorkContactBtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		retrieveWorkContactBtn.setToolTipText("Click this to retrieve a specific formal contact from the address book");
		removeFriendContactBtn = new JButton("Remove Friend Contact");				//Initialising a JButton with the text Remove friend contact
		removeFriendContactBtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		removeFriendContactBtn.setToolTipText("Click this to remove a personal contact from the address book");
		removeWorkContactBtn = new JButton("Remove Work Contact");					//Initialising a JButton with the text Remove work contact
		removeWorkContactBtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		removeWorkContactBtn.setToolTipText("Click this to remove a formal contact from the address book");
		editFriendContactbtn = new JButton("Edit Friend Contact");					//Initialising a JButton with the text Edit friend contact
		editFriendContactbtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		editFriendContactbtn.setToolTipText("Click this to edit a personal contact in the address book");
		editWorkContactBtn = new JButton("Edit Work Contact");						//Initialising a JButton with the text Edit work contact
		editWorkContactBtn.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		editWorkContactBtn.setToolTipText("Click this to edit a formal contact in the address book");
		viewFriendContactBtn = new JButton("View all Friend Contacts");				//Initialising a JButton with the text View all Friend Contacts
		viewFriendContactBtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		viewFriendContactBtn.setToolTipText("Click this to view all personal contacts in the address book");
		viewWorkContactBtn = new JButton("View all Work Contacts");					//Initialising a JButton with the text View all Work Contacts
		viewWorkContactBtn.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		viewWorkContactBtn.setToolTipText("Click this to view all formal contacts in the address book");
		exitBtn = new JButton("Exit Address Book");									//Initialising a JButton with the text Exit Address Book
		exitBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		exitBtn.setToolTipText("Click this to exit the program");

		//All the buttons above are added to the northPanel 
		northPanel.add(viewFriendContactBtn);
		northPanel.add(viewWorkContactBtn);
		northPanel.add(addFriendContactBtn);
		northPanel.add(addWorkContactBtn);
		northPanel.add(retrieveFriendContactBtn);
		northPanel.add(retrieveWorkContactBtn);
		northPanel.add(removeFriendContactBtn);
		northPanel.add(removeWorkContactBtn);
		northPanel.add(editFriendContactbtn);
		northPanel.add(editWorkContactBtn);
		northPanel.add(exitBtn);

		//The northPanel is added to the north part of the JFrame
		window.getContentPane().add(northPanel, BorderLayout.NORTH);

		//The visibility of the JFrame is set to true
		window.setVisible(true);
	}

	
	/*
	 * This method creates a form for the user in which they input the details,
	 * of a contact and the contact is then added to the address book 
	 */
	public void addFriendContactForm() {
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		addPersonalContactBtn = new JButton("Add Contact");
		addPersonalContactBtn.addActionListener(this);								//Adding an action listener to the button when it is clicked on
		addPersonalContactBtn.setToolTipText("Click this to add the new contact with the details provided");
		
		friendPanel = new JPanel();													//Creating a new JPanel
		friendPanel.setLayout(new GridLayout(4,2));									//Setting the grid layout of friendPanel 
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
		actionsPanel.add(addPersonalContactBtn);									//adding the addPersonalContactBtn to the actionsPanel
		
		firstNameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("Firstname:");									//Creating a JLabel that contains the text "FirstName:"
		surnameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("Surname:");										//Creating a JLabel that contains the text "Surname:"
		phoneNumberTxt = new JTextField(15);										//Creating a JTextfield that is 15 characters long
		phoneNumberLbl = new JLabel("Phone Number:");								//Creating a JLabel that contains the text "PhoneNumber:"
		addressTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		addressLbl = new JLabel("Address:");
		
		
		//The labels and text fields created above are added to the friends panel
		friendPanel.add(firstNameLbl);
		friendPanel.add(firstNameTxt);
		friendPanel.add(surnameLbl);
		friendPanel.add(surnameTxt);
		friendPanel.add(phoneNumberLbl);
		friendPanel.add(phoneNumberTxt);
		friendPanel.add(addressLbl);
		friendPanel.add(addressTxt);
		
		
		window.getContentPane().add(friendPanel, BorderLayout.NORTH);				//The friendPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
	}

	public void addWorkContactForm() {
		window.getContentPane().removeAll();
		window.repaint();
		
		backBtn = new JButton("Main Menu");												//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);												//Adding an action listener to the button when it is clicked on
		addFormalContactBtn = new JButton("Add Contact");								//Initialising a JButton with the text Add Contact
		addFormalContactBtn.setToolTipText("Click this to add the new contact with the details provided");
		addFormalContactBtn.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		
		workPanel = new JPanel();														//Creating a new JPanel
		workPanel.setLayout(new GridLayout(7,2));										//Setting the grid layout of workPanel
		actionsPanel = new JPanel();													//Creating a new JPanel
		
		//Adding the backBtn and addFormalContactBtn to the actions panel
		actionsPanel.add(backBtn);														
		actionsPanel.add(addFormalContactBtn);
		
		firstNameLbl = new JLabel("Firstname:");										//Creating a JLabel that contains the text "FirstName:"
		firstNameTxt = new JTextField(20);												//Creating a JTextfield that is 20 characters long 
		surnameLbl = new JLabel("Surname:");											//Creating a JLabel that contains the text "Surname:"
		surnameTxt = new JTextField(20);												//Creating a JTextfield that is 20 characters long
		jobTitleLbl = new JLabel("Job Title:");											//Creating a JLabel that contains the text "Job Title:"
		jobTitleTxt = new JTextField(40);												//Creating a JTextfield that is 40 characters long 
		phoneNumberLbl = new JLabel("Phone Number:");									//Creating a JLabel that contains the text "PhoneNumber:"	
		phoneNumberTxt = new JTextField(15);											//Creating a JTextfield that is 15 characters long 
		companyNameLbl = new JLabel("Company Name:");									//Creating a JLabel that contains the text "Company Name:"
		companyNameTxt = new JTextField(50);											//Creating a JTextfield that is 50 characters long 
		companyAddressLbl = new JLabel("Company Address:");								//Creating a JLabel that contains the text "Company Address"
		companyAddressTxt = new JTextField(50);											//Creating a JTextfield that is 50 characters long 
		

		//The labels and text fields created above are added to the work panel
		workPanel.add(firstNameLbl);
		workPanel.add(firstNameTxt);
		workPanel.add(surnameLbl);
		workPanel.add(surnameTxt);
		workPanel.add(jobTitleLbl);
		workPanel.add(jobTitleTxt);
		workPanel.add(phoneNumberLbl);
		workPanel.add(phoneNumberTxt);
		workPanel.add(companyNameLbl);
		workPanel.add(companyNameTxt);
		workPanel.add(companyAddressLbl);
		workPanel.add(companyAddressTxt);
			
		window.getContentPane().add(workPanel, BorderLayout.NORTH);					//The workPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
	}
	
	public void getPersonalContact() {
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		getPersonalContact = new JButton("Get Contact");							//Initialising a JButton with the text Get Contact
		getPersonalContact.setToolTipText("Click this to get the personal contact with the information provided");
		getPersonalContact.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		
		
		getPCPanel = new JPanel();													//Creating a new JPanel
		getPCPanel.setLayout(new GridLayout(2,2));									//Setting the grid layout of getPCPanel 	
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
		actionsPanel.add(getPersonalContact);										//adding the getPersonalContact button to the actionsPanel
		
		
		firstNameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("Firstname:");									//Creating a JLabel that contains the text "FirstName:"
		surnameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("Surname:");										//Creating a JLabel that contains the text "Surname:"
		

		//The labels and text fields created above are added to the getPCPanel
		getPCPanel.add(firstNameLbl);
		getPCPanel.add(firstNameTxt);
		getPCPanel.add(surnameLbl);
		getPCPanel.add(surnameTxt);
		
		window.getContentPane().add(getPCPanel, BorderLayout.NORTH);				//The getPCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
		
	}
	
	public void getWorkContact() { 
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		getWorkContact = new JButton("Get Contact");								//Initialising a JButton with the text Get Contact
		getWorkContact.setToolTipText("Click this to get the formal contact with the informaiton provided");
		getWorkContact.addActionListener(this);										//Adding an action listener to the button when it is clicked on
			
		getWCPanel = new JPanel();													//Creating a new JPanel
		getWCPanel.setLayout(new GridLayout(3,2));									//Setting the grid layout of getWCPanel
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
		actionsPanel.add(getWorkContact);											//adding the getWorkContact button to the actionsPanel

		firstNameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("Firstname:");									//Creating a JLabel that contains the text "FirstName:"
		surnameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("Surname:");										//Creating a JLabel that contains the text "Surname:"
		companyNameTxt = new JTextField(20);										//Creating a JTextfield that is 20 characters long
		companyNameLbl = new JLabel("Company Name: ");								//Creating a JLabel that contains the text "Company Name:"
		

		//The labels and text fields created above are added to the getWCPanel
		getWCPanel.add(firstNameLbl);
		getWCPanel.add(firstNameTxt);
		getWCPanel.add(surnameLbl);
		getWCPanel.add(surnameTxt);
		getWCPanel.add(companyNameLbl);
		getWCPanel.add(companyNameTxt);
		
		
		window.getContentPane().add(getWCPanel, BorderLayout.NORTH);				//The getWCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
	}
	
	public void viewFriendContacts() {
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		
		PersonalContact p = new PersonalContact();									//Initialising the PersonalContact class
		var contacts = p.listAllContacts();											//Calling the method listAllContacts from the PersonalContact class and storing in the variable contacts
			
		getPCPanel = new JPanel();													//Creating a new JPanel
		getPCPanel.setLayout(new GridLayout(p.getSize(),3));						//Setting the grid layout of getPCPanel 
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
	
		/* A for loop that will run the length of the contacts object
		* the loop will get the name, phone number and addresses of all the contacts in the object
		* and then add them to the getPCPanel
		*/
		for(var contact : contacts) {
			nameLbl = new JLabel (contact.getName().getFirstAndLastName());
			phoneNumberLbl = new JLabel(contact.getPhoneNumber());
			addressLbl = new JLabel(contact.getAddress());
			
			getPCPanel.add(nameLbl);
			getPCPanel.add(phoneNumberLbl);
			getPCPanel.add(addressLbl);
			
		}
				
		window.getContentPane().add(getPCPanel, BorderLayout.NORTH);				//The getPCPanel is added to the north part of the JFrame
	    window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true

	}
	
	public void viewWorkContacts() {
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		
		WorkContact w = new WorkContact();											//Initialising the WorkContact class
		var contacts = w.listAllContacts();											//Calling the method listAllContacts from the WorkContact class and storing in the variable contacts
			
		getWCPanel = new JPanel();													//Creating a new JPanel
		getWCPanel.setLayout(new GridLayout(w.getSize(),5));						//Setting the grid layout of getWCPanel 
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
	

		/* A for loop that will run the length of the contacts object
		* the loop will get the name, phone number, job title, company name and company addresses of all the contacts in the object
		* and then add them to the getWCPanel
		*/
		for(var contact : contacts) {
			nameLbl = new JLabel (contact.getName().getFirstAndLastName());
			jobTitleLbl = new JLabel(contact.getJobTitle());
			phoneNumberLbl = new JLabel(contact.getPhoneNumber());
			companyNameLbl = new JLabel(contact.getCompanyName());
			addressLbl = new JLabel(contact.getCompanyAddress());
			
			getWCPanel.add(nameLbl);
			getWCPanel.add(jobTitleLbl);
			getWCPanel.add(phoneNumberLbl);
			getWCPanel.add(companyNameLbl);
			getWCPanel.add(addressLbl);
			
		}
				
		window.getContentPane().add(getWCPanel, BorderLayout.NORTH);				//The getWCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true

	}
	
	public void removeFriendContact() {
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		removePCContactBtn = new JButton("Remove Contact");							//Initialising a JButton with the text Remove Contact
		removePCContactBtn.setToolTipText("Click this to remove a personal contact from the provided details");
		removePCContactBtn.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		
		getPCPanel = new JPanel();													//Creating a new JPanel
		getPCPanel.setLayout(new GridLayout(2,2));									//Setting the grid layout of getPCPanel
		
		firstNameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("Firstname:");									//Creating a JLabel that contains the text "FirstName:"
		surnameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("Surname:");										//Creating a JLabel that contains the text "Surname:"
		

		//The labels and text fields created above are added to the getPCPanel
		getPCPanel.add(firstNameLbl);
		getPCPanel.add(firstNameTxt);
		getPCPanel.add(surnameLbl);
		getPCPanel.add(surnameTxt);
		
		
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
		actionsPanel.add(removePCContactBtn);										//adding the backBtn to the removePCContactBtn
		
		window.getContentPane().add(getPCPanel, BorderLayout.NORTH);				//The getPCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
		
	}
	
	public void removeWorkContact() {
		window.getContentPane().removeAll();										//remove all the content on the JFrame
		window.repaint();															//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");											//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);											//Adding an action listener to the button when it is clicked on
		removeWCContactBtn = new JButton("Remove Contact");							//Initialising a JButton with the text Remove Contact
		removeWCContactBtn.setToolTipText("Click this to remove a formal contact from the provided details");
		removeWCContactBtn.addActionListener(this);									//Adding an action listener to the button when it is clicked on
		
		firstNameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("Firstname:");									//Creating a JLabel that contains the text "FirstName:"
		surnameTxt = new JTextField(20);											//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("Surname:");										//Creating a JLabel that contains the text "Surname:"
		
		getWCPanel = new JPanel();													//Creating a new JPanel
		getWCPanel.setLayout(new GridLayout(2,2));									//Setting the grid layout of getWCPanel

		//The labels and text fields created above are added to the getWCPanel
		getWCPanel.add(firstNameLbl);				
		getWCPanel.add(firstNameTxt);
		getWCPanel.add(surnameLbl);
		getWCPanel.add(surnameTxt);
		
		
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
		actionsPanel.add(removeWCContactBtn);										//adding the backBtn to the removeWCContactBtn
		
		window.getContentPane().add(getWCPanel, BorderLayout.NORTH);				//The getWCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
	}
	
	public void editPersonalContact() {
		window.getContentPane().removeAll();													//remove all the content on the JFrame
		window.repaint();																		//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");														//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);														//Adding an action listener to the button when it is clicked on
		editPCContact = new JButton("Edit Contact");											//Initialising a JButton with the text editPCContact
		editPCContact.setToolTipText("Click this to edit the personal contact with the details provided");
		editPCContact.addActionListener(this);													//Adding an action listener to the button when it is clicked on
		
		var titleOne = new JLabel("Edit the name of the contact you wish to enter.");			//Creating a new JLabel with a string phrase
		var titleTwo = new JLabel("Then enter what you would like to change the fields to");	//Creating a new JLabel with a string phrase
		findFirstnameLbl = new JLabel("Firstname of existing contact:");						//Creating a JLabel with a string phrase
		findFirstnameTxt = new JTextField(20);													//Creating a JTextfield that is 20 characters long
		findSurnameLbl = new JLabel("Surname of existing contact:");							//Creating a JLabel with a string phrase
		findSurnameTxt = new JTextField(20);													//Creating a JTextfield that is 20 characters long
		firstNameTxt = new JTextField(20);														//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("New Firstname:");											//Creating a JLabel with a string phrase
		surnameTxt = new JTextField(20);														//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("New Surname:");												//Creating a JLabel with a string phrase
		phoneNumberTxt = new JTextField(15);													//Creating a JTextfield that is 15 characters long
		phoneNumberLbl = new JLabel("New Phone Number:");										//Creating a JLabel with a string phrase
		addressTxt = new JTextField(20);														//Creating a JTextfield that is 20 characters long
		addressLbl = new JLabel("New Address:");												//Creating a JLabel with a string phrase
		
			
		actionsPanel = new JPanel();												//Creating a new JPanel
		actionsPanel.add(backBtn);													//adding the backBtn to the actionsPanel
		actionsPanel.add(editPCContact);											//adding the backBtn to the editPCContact

		getPCPanel = new JPanel();													//Creating a new JPanel
		getPCPanel.setLayout(new GridLayout(7,2));									//Setting the grid layout of getPCPanel
		
		//The labels and text fields created above are added to the getPCPanel
		getPCPanel.add(titleOne);
		getPCPanel.add(titleTwo);
		getPCPanel.add(findFirstnameLbl);
		getPCPanel.add(findFirstnameTxt);
		getPCPanel.add(findSurnameLbl);
		getPCPanel.add(findSurnameTxt);
		getPCPanel.add(firstNameLbl);
		getPCPanel.add(firstNameTxt);
		getPCPanel.add(surnameLbl);
		getPCPanel.add(surnameTxt);
		getPCPanel.add(phoneNumberLbl);
		getPCPanel.add(phoneNumberTxt);	
		getPCPanel.add(addressLbl);
		getPCPanel.add(addressTxt);
		
		
		window.getContentPane().add(getPCPanel, BorderLayout.NORTH);				//The getPCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);				//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);													//The visibility of the JFrame is set to true
	}
	
	public void editWorkContact() {
		window.getContentPane().removeAll();																//remove all the content on the JFrame
		window.repaint();																					//refresh the JFrame as all of the content has now been removed
		
		backBtn = new JButton("Main Menu");																	//Initialising a JButton with the text Main Menu
		backBtn.setToolTipText("Click this to return to the main menu");
		backBtn.addActionListener(this);																	//Adding an action listener to the button when it is clicked on
		editWCContact = new JButton("Edit Contact");														//Initialising a JButton with the text Edit Contact
		editWCContact.setToolTipText("Click this to edit the formal contact with the details provided");
		editWCContact.addActionListener(this);																//Adding an action listener to the button when it is clicked on
		
		var titleOne = new JLabel("Enter the name of the contact you wish to edit.");						//Creating a new JLabel with a string phrase
		var titleTwo = new JLabel("Then enter what you would like to change the fields to");				//Creating a new JLabel with a string phrase
		findFirstnameLbl = new JLabel("Firstname of existing contact:");									//Creating a new JLabel with a string phrase
		findFirstnameTxt = new JTextField(20);																//Creating a JTextfield that is 20 characters long
		findSurnameLbl = new JLabel("Surname of existing contact:");										//Creating a JLabel with a string phrase
		findSurnameTxt = new JTextField(20);																//Creating a JTextfield that is 20 characters long
		firstNameLbl = new JLabel("New Firstname:");														//Creating a JLabel with a string phrase
		firstNameTxt = new JTextField(20);																	//Creating a JTextfield that is 20 characters long
		surnameLbl = new JLabel("New Surname:");															//Creating a JLabel with a string phrase
		surnameTxt = new JTextField(20);																	//Creating a JTextfield that is 20 characters long
		jobTitleLbl = new JLabel("New Job Title");															//Creating a JLabel with a string phrase
		jobTitleTxt = new JTextField(50);																	//Creating a JTextfield that is 50 characters long
		phoneNumberLbl = new JLabel("New Phone Number:");													//Creating a JLabel with a string phrase	
		phoneNumberTxt = new JTextField(15);																//Creating a JTextfield that is 15 characters long
		companyNameLbl = new JLabel("New Company Name");													//Creating a JLabel with a string phrase
		companyNameTxt = new JTextField(50);																//Creating a JTextfield that is 50 characters long
		companyAddressLbl = new JLabel("New Company Address");												//Creating a JLabel with a string phrase
		companyAddressTxt = new JTextField(50);																//Creating a JTextfield that is 50 characters long
		
			
		actionsPanel = new JPanel();														//Creating a new JPanel
		actionsPanel.add(backBtn);															//adding the backBtn to the actionsPanel
		actionsPanel.add(editWCContact);													//adding the backBtn to the editPCContact

		getWCPanel = new JPanel();															//Creating a new JPanel
		getWCPanel.setLayout(new GridLayout(9,2));											//Setting the grid layout of getWCPanel
		
		//The labels and text fields created above are added to the getWCPanel
		getWCPanel.add(titleOne);
		getWCPanel.add(titleTwo);
		getWCPanel.add(findFirstnameLbl);
		getWCPanel.add(findFirstnameTxt);
		getWCPanel.add(findSurnameLbl);
		getWCPanel.add(findSurnameTxt);
		getWCPanel.add(firstNameLbl);
		getWCPanel.add(firstNameTxt);
		getWCPanel.add(surnameLbl);
		getWCPanel.add(surnameTxt);
		getWCPanel.add(jobTitleLbl);
		getWCPanel.add(jobTitleTxt);
		getWCPanel.add(phoneNumberLbl);
		getWCPanel.add(phoneNumberTxt);
		getWCPanel.add(companyNameLbl);
		getWCPanel.add(companyNameTxt);
		getWCPanel.add(companyAddressLbl);
		getWCPanel.add(companyAddressTxt);
		
		
		window.getContentPane().add(getWCPanel, BorderLayout.NORTH);						//The getPCPanel is added to the north part of the JFrame
		window.getContentPane().add(actionsPanel, BorderLayout.CENTER);						//The actionsPanel is added to the centre part of the JFrame
		window.setVisible(true);															//The visibility of the JFrame is set to true
	}

	//This method is called any time a button is clicked in the user interface. An ActionEvent object is passed in
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backBtn) {												//Check to see if the backBtn was clicked
			window.dispose();														//Closes the current window
			new GUI();																//Opens a new window returning the user to the main menu
		}
				
		if (e.getSource() == addFriendContactBtn) {									//Check to see if the addFriendContactBtn was clicked	
			addFriendContactForm();													//If true call the addFriendContactForm method
		}

		if (e.getSource() == addWorkContactBtn) {									//Check to see if the addWorkContactBtn was clicked
			addWorkContactForm();													//If true call the addWorkContactForm method
		}
		
		if(e.getSource() == retrieveFriendContactBtn) {								//Check to see if the retrieveFriendContactBtn was clicked
			getPersonalContact();													//If true call the getPersonalContact method
		}
		
		if(e.getSource() == retrieveWorkContactBtn) {								//Check to see if the retrieveWorkContactBtn was clicked
			getWorkContact();														//If true call the getWorkContact method
		}
		
		if(e.getSource() == viewFriendContactBtn) {									//Check to see if the viewFriendContactBtn was clicked
			viewFriendContacts();													//If true call the viewFriendContacts method
		}
		
		if(e.getSource() == viewWorkContactBtn) {									//Check to see if the viewWorkContactBtn was clicked
			viewWorkContacts();														//If true call the viewWorkContacts method
		}
		
		if(e.getSource() == removeFriendContactBtn) {								//Check to see if the removeFriendContactBtn was clicked
			removeFriendContact();													//If true call the removeFriendContact method
		}
		
		if(e.getSource() == removeWorkContactBtn) {									//Check to see if the removeWorkContactBtn was clicked
			removeWorkContact();													//If true call the removeWorkContact method
		}
		
		if(e.getSource() == editFriendContactbtn) {									//Check to see if the editFriendContactbtn was clicked
			editPersonalContact();													//If true call the editPersonalContact method
		}
		
		if(e.getSource() == editWorkContactBtn) {									//Check to see if the editWorkContactBtn was clicked
			editWorkContact();														//If true call the editWorkContact method
		}
		
		if (e.getSource() == exitBtn) {												//Check to see if the exitBtn was clicked
			System.exit(0);															//If true close the program
		}
		
		if(e.getSource() == addPersonalContactBtn) {								//Check to see if the addPersonalContactBtn was clicked
			/*This will get the values from the text fields in the form just submitted
			* and call add it to the address book using the PersonalContact class
			*/
			
			String firstNameStr = firstNameTxt.getText();							
			String surnameStr = surnameTxt.getText();								
			Name name = new Name(firstNameStr, surnameStr);
			String phoneNumber = phoneNumberTxt.getText();
			String address = addressTxt.getText();
			PersonalContact p = new PersonalContact();
			p.addToAddressBook(name, phoneNumber, address);
		}
		
		if(e.getSource() == addFormalContactBtn) {									//Check to see if the addFormalContactBtn was clicked
			/*This will get the values from the text fields in the form just submitted
			* and add it to the address book using the WorkContact class
			*/
			
			String firstNameStr = firstNameTxt.getText();
			String surnameStr = surnameTxt.getText();
			Name name = new Name(firstNameStr, surnameStr);
			String jobTitle = jobTitleTxt.getText();
			String phoneNumber = phoneNumberTxt.getText();
			String companyName = companyNameTxt.getText();
			String companyAddress = companyAddressTxt.getText();
			WorkContact w = new WorkContact();
			w.addToAddressBook(name, jobTitle, phoneNumber, companyName, companyAddress);
			
		}
		
		if(e.getSource() == getPersonalContact) {									//Check to see if the getPersonalContact was clicked
			/*This will get the values from the text fields in the form just submitted
			* and use the values to find the contact in the address book using the PersonalContact class
			* the result is then displayed to the user
			*/ 

			String firstNameStr = firstNameTxt.getText();
			String surnameStr = surnameTxt.getText();
			Name name = new Name(firstNameStr, surnameStr);
			PersonalContact p = new PersonalContact();
			var contact = p.getContactByName(name);
			foundNameLbl = new JLabel("Name: " + contact.getName().getFirstAndLastName());
			foundNumberLbl = new JLabel("Phone Number: " + contact.getPhoneNumber());
			foundAddressLbl = new JLabel("Address: " + contact.getAddress());
			actionsPanel.add(foundNameLbl);
			actionsPanel.add(foundNumberLbl);
			actionsPanel.add(foundAddressLbl);
			window.setVisible(true);
		}
		
		if (e.getSource() == getWorkContact) {										//Check to see if the getWorkContact was clicked
			/*This will get the values from the text fields in the form just submitted
			* and use the values to find the contact in the address book using the WorkContact class
			* the result is then displayed to the user
			*/ 

			String firstNameStr = firstNameTxt.getText();
			String surnameStr = surnameTxt.getText();
			String comanyName = companyNameTxt.getText();
			Name name = new Name(firstNameStr, surnameStr);
			WorkContact w = new WorkContact();
			var contact = w.getContactBySurnameAndCompanyAddress(name, comanyName);
			foundNameLbl = new JLabel("Name: " + contact.getName().getFirstAndLastName());
			foundJobTitleLbl = new JLabel("Job Title: " + contact.getJobTitle());
			foundNumberLbl = new JLabel("Phone Number: " + contact.getPhoneNumber());
			foundCompanyNameLbl = new JLabel("Company Name: " + contact.getCompanyName());
			foundAddressLbl = new JLabel("Company Address" + contact.getCompanyAddress());
	
			actionsPanel.add(foundNameLbl);
			actionsPanel.add(foundJobTitleLbl);
			actionsPanel.add(foundNumberLbl);
			actionsPanel.add(foundCompanyNameLbl);
			actionsPanel.add(foundAddressLbl);
			window.setVisible(true);
		}
		
		
		if(e.getSource() == removePCContactBtn) {									//Check to see if the removePCContactBtn was clicked
			/*This will get the values from the text fields in the form just submitted
			* and use the values to find the contact and remove it from them from the address book
			* this is done using the PersonalContact class
			*/ 
			String firstNameStr = firstNameTxt.getText();
			String surnameStr = surnameTxt.getText();
			Name name = new Name(firstNameStr, surnameStr);
			PersonalContact p = new PersonalContact();
			p.removeFromAddressBook(name);
		}
		
		if(e.getSource() == removeWCContactBtn) {									//Check to see if the removeWCContactBtn was clicked
		/*This will get the values from the text fields in the form just submitted
			* and use the values to find the contact and remove it from them from the address book
			* this is done using the WorkContact class
			*/ 
			String firstNameStr = firstNameTxt.getText();
			String surnameStr = surnameTxt.getText();
			Name name = new Name(firstNameStr, surnameStr);
			WorkContact w = new WorkContact();
			w.removeFromAddressBook(name);
		}
		
		if(e.getSource() == editPCContact) {									//Check to see if the editPCContact was clicked	
			/*This will get the values from the text fields in the form just submitted
			* and use the values to find the contact and edit it in the address book
			* this is done using the PersonalContact class
			*/ 
		
			String findFirstnameStr = findFirstnameTxt.getText();
			String findSurnameStr = findSurnameTxt.getText();
			String findName = findFirstnameStr + " " + findSurnameStr; 
			
			String newFirstNameStr = firstNameTxt.getText();
			String newSurnameStr = surnameTxt.getText();		
			Name newName = new Name(newFirstNameStr, newSurnameStr);
			String newPhoneNumber = phoneNumberTxt.getText();
			String newAddress = addressTxt.getText();
			
			PersonalContact p = new PersonalContact();
			p.editContact(findName, newName, newPhoneNumber, newAddress);
		}
		
		if(e.getSource() == editWCContact) {										//Check to see if the editWCContact was clicked
			/*This will get the values from the text fields in the form just submitted
			* and use the values to find the contact and edit it in the address book
			* this is done using the WorkContact class
			*/ 

			String findFirstnameStr = findFirstnameTxt.getText();
			String findSurnameStr = findSurnameTxt.getText();
			String findName = findFirstnameStr + " " + findSurnameStr; 
			
			String newFirstNameStr = firstNameTxt.getText();
			String newSurnameStr = surnameTxt.getText();		
			Name newName = new Name(newFirstNameStr, newSurnameStr);
			
			String newJobTitle = jobTitleTxt.getText();
			String newPhoneNumber = phoneNumberTxt.getText();
			String newCompanyName = companyNameTxt.getText();
			String newCompanyAddress = companyAddressTxt.getText();
			
			WorkContact w = new WorkContact();
			w.editContact(findName, newName, newJobTitle, newPhoneNumber, newCompanyName, newCompanyAddress);
		}
	}
}
