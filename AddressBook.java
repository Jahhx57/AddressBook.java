import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.IOException;

public class AddressBook extends JFrame implements ActionListener {
	private JLabel taxIDLabel,firstnameLabel, lastNameLabel,indoorHobbies, outdoorHobbies,groupHobbies,instagramLabel, faceBookLabel, snapChatLabel, whatsAppLabel,professionalSummaryLabel, sideGigsLabel, incomeLabel, seniorityLabel, degreeLabel, newsletterssubscribedLabel, workPhoneLabel, homePhoneLabel, femaleLabel, maleLabel,fullNameLabel,educationStatusLabel, UniversityNameLabel,genderLabel, ageLabel; 
    private JTextField taxIDField,firstNameField, lastNameField,instagramText, faceBookText, snapChatText, whatsAppText,fullNameField,sideGigstextField, incomeField, degreeField, newsletterField, workPhoneField, homePhoneField, universityNameField,otherLabel, ageTextField;
    private JPanel nPanel,cPanel,wPanel,ePanel,sPanel;
    private ButtonGroup genderGroup;
    private JRadioButton femaleOption, maleOption, Instagram,faceBook,snapChat, WhatsApp ;
    private ImageIcon femaleIcon, maleIcon,InstagramIcon, faceBookIcon, snapChatIcon, whatsAppIcon;;
    private JComboBox seniorityBox,educationStatus,maritalStatus, currentIndustry;
    private JButton submitButton, resetButton, cancelButton;
    private JCheckBox otherField, readingCheckbox , paintingCheckbox ,groupHobbiesCheckbox,cookingCheckbox ,hikingCheckbox,gardeningCheckbox,birdwatchingCheckbox, boardGamesCheckbox, teamSportsCheckbox , bookClubCheckbox ;
    private JTextArea commentBox;
    private ServerSocket serverSocket;
	private Socket socket;
	private ObjectInputStream input;
	

public AddressBook() {
	super("Address Book");
	firstnameLabel = new JLabel("First Name: ");
	lastNameLabel = new JLabel("Last Name: ");
	firstNameField = new JTextField(15);
	lastNameField = new JTextField(15);
	UniversityNameLabel = new JLabel("University");
	universityNameField = new JTextField(15);
	String maritalStatusList[] =  {"--Select Marital Status--", "married", "umarried", "divorced", "separated"};
	maritalStatus= new JComboBox<Object>(maritalStatusList);
	String educationStatusList[] = {"--Select Education Status--", "Student", "Employed", "Unemployed", "Self-Employed", "Retired"};
	educationStatus= new JComboBox<Object>(educationStatusList);
	ageLabel = new JLabel("age:" );
	ageTextField= new JTextField(2);
	femaleOption = new JRadioButton("Female");
    femaleIcon = new ImageIcon("C:\\Users\\Jason\\Downloads\\female.gif");
    femaleLabel = new JLabel(femaleIcon);
    maleOption = new JRadioButton("Male");
    maleIcon = new ImageIcon("C:\\Users\\Jason\\Downloads\\male.gif");
    maleLabel = new JLabel(maleIcon);
    taxIDLabel = new JLabel("Tax ID");
    taxIDField = new JTextField(15);
    
	genderLabel = new JLabel("Gender :");
	genderGroup = new ButtonGroup();
    genderGroup.add(femaleOption);
    genderGroup.add(maleOption);
    
	otherField = new JCheckBox("Other");
	otherLabel = new JTextField(10);
	nPanel = new JPanel();
	nPanel.add(taxIDLabel);
	nPanel.add(taxIDField);
	nPanel.add(firstnameLabel);
	nPanel.add(firstNameField);
	nPanel.add(lastNameLabel);
	nPanel.add(lastNameField);
	nPanel.add(ageLabel);
	nPanel.add(ageTextField);
	nPanel.add(UniversityNameLabel);
	nPanel.add(universityNameField);
	nPanel.add(maritalStatus);
	nPanel.add(educationStatus);
	nPanel.add(genderLabel);
	nPanel.add(femaleLabel);
    nPanel.add(femaleOption);
    nPanel.add(maleLabel);
    nPanel.add(maleOption);
	nPanel.add(otherField);
	nPanel.add(otherLabel);
	add(nPanel,BorderLayout.NORTH);

    professionalSummaryLabel = new JLabel("Professional Summary:");
    sideGigsLabel = new JLabel("Side Gig:");
    sideGigstextField = new JTextField(8);
    incomeLabel = new JLabel("income");
    incomeField = new JTextField(15);
    workPhoneField = new JTextField(5);
    seniorityLabel = new JLabel("seniority:");
    String seniorityBoxList[] = {"--Select Professional seniority--","Entry-Level", "Mid-Level", "Senior", "Managerial", "Director/Executive", "Specialist/Subject Matter Expert", "Consultant/Freelancer"};
	seniorityBox = new JComboBox <Object>(seniorityBoxList);
    degreeLabel = new JLabel("current/highest degree earned");
    degreeField = new JTextField(14);
    newsletterssubscribedLabel  = new JLabel("subscribed NewsPapers");
    newsletterField = new JTextField(14);
    workPhoneLabel = new JLabel("work number: ");
    workPhoneField = new JTextField(14);
    homePhoneLabel = new JLabel("Home phone Number");
    homePhoneField  = new JTextField(14);
    
    wPanel = new JPanel(new GridLayout(0,1));
    wPanel.add(professionalSummaryLabel);
    wPanel.add(sideGigsLabel);
    wPanel.add(sideGigstextField);
    wPanel.add(incomeLabel);
    wPanel.add(incomeField);
    wPanel.add(seniorityLabel);
    wPanel.add(seniorityBox);
    wPanel.add(degreeLabel);
    wPanel.add(degreeField);
    wPanel.add(newsletterssubscribedLabel);
    wPanel.add(newsletterField);
    wPanel.add(workPhoneLabel);
    wPanel.add(workPhoneField);
    wPanel.add(homePhoneLabel);
    wPanel.add(homePhoneField);
    add(wPanel, BorderLayout.WEST);
    
	String IndustryList[] = {"--Select industry type Status--", "Agriculture", "Automotive", "Banking", "Construction", "Education", "Entertainment", "Fashion", "Food and Beverage", "Healthcare", "Information Technology", "Manufacturing", "Media", "Oil and Gas", "Retail", "Telecommunications", "Transportation", "Travel and Tourism", "Utilities", "Other"};
    currentIndustry = new JComboBox<Object>(IndustryList);   
    
    indoorHobbies = new JLabel("Indoor Hobbies: ");
    outdoorHobbies = new JLabel("Outdoor Hobbies: ");
    groupHobbies = new JLabel("Group Hobbies: " );
  
    
    readingCheckbox = new JCheckBox("Reading");
    paintingCheckbox = new JCheckBox("Painting");
    cookingCheckbox = new JCheckBox("Cooking");
    hikingCheckbox = new JCheckBox("Hiking");
    gardeningCheckbox = new JCheckBox("Gardening");
    birdwatchingCheckbox = new JCheckBox("Birdwatching");
    boardGamesCheckbox = new JCheckBox("Board Games");
    teamSportsCheckbox = new JCheckBox("Team Sports"); 
    bookClubCheckbox = new JCheckBox("Book Club");
    
    commentBox = new JTextArea (5,10);
    
    cPanel = new JPanel(new GridLayout(0,1));
    cPanel.add(currentIndustry);
    cPanel.add(indoorHobbies);
    cPanel.add(readingCheckbox);
    cPanel.add(paintingCheckbox);
    cPanel.add(cookingCheckbox);
    cPanel.add(outdoorHobbies);
    cPanel.add(hikingCheckbox);
    cPanel.add(gardeningCheckbox);
    cPanel.add(birdwatchingCheckbox);
    cPanel.add(groupHobbies);
    cPanel.add(boardGamesCheckbox);
    cPanel.add(teamSportsCheckbox);
    cPanel.add(bookClubCheckbox);
    cPanel.add(commentBox);
    add(cPanel, BorderLayout.CENTER);
    
   
    
    


    Instagram = new JRadioButton("Instagram: ");
 	InstagramIcon = new ImageIcon("C:\\Users\\Jason\\Downloads\\Instagram.png");
    instagramLabel = new JLabel(InstagramIcon);
    
    faceBook  = new JRadioButton("Facebook : ");
    faceBookIcon = new ImageIcon("C:\\Users\\Jason\\Downloads\\FaceBook.png");
    faceBookLabel = new JLabel(faceBookIcon);
    
    snapChat =  new JRadioButton("SnapChat: ");
    snapChatIcon = new ImageIcon("C:\\Users\\Jason\\Downloads\\SnapChat.png");
    snapChatLabel = new JLabel(snapChatIcon);
    
    WhatsApp =  new JRadioButton("WhatsApp: ");
    whatsAppIcon = new ImageIcon("C:\\Users\\Jason\\Downloads\\whatsApp.png");
    whatsAppLabel= new JLabel(whatsAppIcon);
    
    instagramText = new JTextField(10);
    faceBookText = new JTextField(10);
    snapChatText = new JTextField(10);
    whatsAppText = new JTextField(10);
    ePanel = new JPanel(new GridLayout(4,3));
    ePanel.add(instagramLabel); // Add the JLabel with the icon
    ePanel.add(Instagram);
    ePanel.add(instagramText);
    
    ePanel.add(faceBookLabel); // Add the JLabel with the icon
    ePanel.add(faceBook);
    ePanel.add(faceBookText);
    
    ePanel.add(snapChatLabel); // Add the JLabel with the icon
    ePanel.add(snapChat);
    ePanel.add(snapChatText);
    
    ePanel.add(whatsAppLabel); // Add the JLabel with the icon
    ePanel.add(WhatsApp);
    ePanel.add(whatsAppText);
    add(ePanel, BorderLayout.EAST);

    
    
	submitButton = new JButton("Submit");
    cancelButton = new JButton("Cancel");
    resetButton = new JButton("Reset");
    submitButton.addActionListener(this);
    cancelButton.addActionListener(this);
    resetButton.addActionListener(this);
    
    sPanel = new JPanel();
    sPanel.add(submitButton);
    sPanel.add(cancelButton);
    sPanel.add(resetButton);
    add(sPanel, BorderLayout.SOUTH);
	
	setTitle("Address Book");
    setSize(500, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    
 
}


	
	  public static void main(String[] args) {
	        AddressBook app = new AddressBook();
	    }
	  
	  

	  public void actionPerformed(ActionEvent e) {
		  if (e.getSource() ==submitButton) {
			String firstName = firstNameField.getText();
			 String lastName = lastNameField.getText();
			 String UniversityName = universityNameField.getText();
			 String gender = "";
			 if (femaleOption.isSelected()) {
	                gender = "Female";
	       } else if (maleOption.isSelected()) {
	                gender = "Male";
	            }
	        else if (otherField.isSelected()) {
	                	gender = otherLabel.getText();
		  }
	      
			
			 String industryType = (String) currentIndustry.getSelectedItem();
			 String SideGig = (String) sideGigstextField.getText();
			 String income = (String) incomeField.getText();
			 String JobSeniority = seniorityBox.getSelectedItem().toString();
			 String currentDegree = degreeField.getText();
			 String workPhone = workPhoneField.getText();
			 String homePhone= homePhoneField.getText();
			 String marital_status = maritalStatus.getSelectedItem().toString();
			 String education_status = educationStatus.getSelectedItem().toString();
			 	
			 
			 String taxIDText = taxIDField.getText();
			 int taxID = 0; // Default value if the field is empty
			 if (!taxIDText.isEmpty()) {
			     taxID = Integer.parseInt(taxIDText);
			 }
			 
			 String ageText = ageTextField.getText();
			 int age = 0;
			 if (!ageText.isEmpty());
			 age = Integer.parseInt(ageText);
			 
			 String indoorHobbiesText = "";
			 String outdoorHobbiesText = "";
			 String groupHobbiesText = "";

			 // Indoor Hobbies
			 if (readingCheckbox.isSelected()) {
			     indoorHobbiesText += "Reading, ";
			 }
			 if (paintingCheckbox.isSelected()) {
			     indoorHobbiesText += "Painting, ";
			 }
			 if (cookingCheckbox.isSelected()) {
			     indoorHobbiesText += "Cooking/Baking, ";
			 }

			 // Outdoor Hobbies
			 if (hikingCheckbox.isSelected()) {
			     outdoorHobbiesText += "Hiking, ";
			 }
			 if (gardeningCheckbox.isSelected()) {
			     outdoorHobbiesText += "Gardening, ";
			 }
			 if (birdwatchingCheckbox.isSelected()) {
			     outdoorHobbiesText += "Birdwatching, ";
			 }

			 // Group Hobbies
			 if (boardGamesCheckbox.isSelected()) {
			     groupHobbiesText += "Board Games, ";
			 }
			 if (teamSportsCheckbox.isSelected()) {
			     groupHobbiesText += "Team Sports (e.g., Soccer, Basketball), ";
			 }
			 if (bookClubCheckbox.isSelected()) {
			     groupHobbiesText += "Book Club Participation, ";
			 }
			 
			 String comment = commentBox.getText();
			 String instagramInfo = "";
			 String faceBookInfo = "";
			 String snapChatInfo = "";
			 String whatsAppInfo = "";

			 if (Instagram.isSelected()) {
			     instagramInfo = instagramText.getText();
			 }
			 if (faceBook.isSelected()) {
			     faceBookInfo = faceBookText.getText();
			 }
			 if (snapChat.isSelected()) {
			     snapChatInfo = snapChatText.getText();
			 }
			 if (WhatsApp.isSelected()) {
			     whatsAppInfo = whatsAppText.getText();
			 }
		        
			
		        
	         String message = "Full name: " + firstName + "\n";
	         message += "last name: " + lastName +"\n";
	         message += "Age :" + age+"\n";
	         message += "university Name: " + UniversityName + "\n";
	         message +=  "Gender: " + gender + "\n";
	         message += "current industry:" + industryType  + "\n";
	         message += "marital status: " + marital_status + "\n";
	         message += "Education Status: " + education_status + "\n";
	         message += "Side Gig:" +   SideGig + "\n";
	         message += "Income: " + income   + "\n";
	         message +=  "Professional Seniority: " +  JobSeniority  + "\n";
	         message +=  "current Degree: "    +  currentDegree  + "\n";
	         message +=   "Work Phone: "    +  workPhone  + "\n";
	         message += "Home phone: "    +  homePhone  + "\n";
	         message += "indoor Activies: " + indoorHobbiesText +"\n";
	         message += "outdoor Hobbies" + outdoorHobbiesText +"\n";
	         message += "Group Hobbies: " + groupHobbiesText +"\n";
	         message += "Instagram: " + instagramInfo + "\n";
	         message += "Facebook: " + faceBookInfo + "\n";
	         message += "SnapChat: " + snapChatInfo + "\n";
	         message += "WhatsApp: " + whatsAppInfo + "\n";
	         message += "comment: " + comment + "\n";
	         
			 JOptionPane.showMessageDialog(this, message, "Submitted Information", JOptionPane.INFORMATION_MESSAGE);
			 
			 String databaseName = "addressBook";
			 String userName = "root";
			 String password = "";
		     String url = "jdbc:mysql://localhost/" + databaseName + "?user=" + userName + "&password=" + password;
			 try {
					Class.forName("com.mysql.jdbc.Driver");
					System.out.println("Connect to JDBC successfully");
					
					Connection connection = DriverManager.getConnection(url);
					System.out.println("Log in to MySQL succefully.");
					Statement stmt = connection.createStatement();
					
					String selectStatement = "SELECT * FROM basic_information";            
	                stmt.execute(selectStatement);
	                
	                String insertCommand = "INSERT INTO basic_information (taxID, first_name, last_name, Age, University_name, Marital_status, Education_level, Gender) " +
	                        "VALUES ('" + taxIDText + "  ',   '" + firstName + "',  '" + lastName + "',  " + ageText + ",  '" + UniversityName + "',  '" +
	                        marital_status + "',  '" + education_status + "',  '" + gender +  "')";

	                stmt.execute(insertCommand);

	                String selectCommand = "SELECT * FROM basic_information";
	                ResultSet result = stmt.executeQuery(selectCommand);
					while(result.next()) {
						int TaxID = result.getInt(1);
						String firstname = result.getString(2); // This refers to the first column- looking only at the student ID.
						String lastname = result.getString(3);
						int Age = result.getInt(4);
						String university = result.getString(5);
						String MaritalStatus = result.getString(6);
						String EducationStatus = result.getString(7);
						String GENDER = result.getString(8);

						System.out.println("Tax ID: " + TaxID +"First Name :" + firstname + "Last Name: " + lastname + "age" + Age + "University Name: " + university + "Marital Status: " + MaritalStatus + "Education Level: " + EducationStatus + "Gender: " + GENDER);

					}
					
			  
			     }
			 

				catch(ClassNotFoundException  cnfe) {
					cnfe.printStackTrace();
				}
				catch(SQLException sqle) {
					sqle.printStackTrace();
				}
				
				

			 
			 
		  }

	  }
}
	  

