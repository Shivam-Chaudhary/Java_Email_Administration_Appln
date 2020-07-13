package emailApp;

import java.util.Scanner;

public class email{
	private String firstName;
	private String lastName;
	private String password;
	private int defaultPasswordLength=6;
	private String department;
	private String email;
	private int mailboxCapacity=500;
	private String alternateEmail;
	private String organizationSuffix = "kiet.edu";
	
// constructor to receive first and last name
	public email(String firstName,String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		//System.out.println("Email Created: "+this.firstName+" "+this.lastName);
		
// call a method asking for department name
		this.department = setDepartment();
		//System.out.println("Department : "+this.department);
		
// call a method that returns random password
		this.password = randomPassword(defaultPasswordLength);
		//System.out.println("Your Password is : "+this.password);
		
// combine elements to generate email
		email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+organizationSuffix;
		//System.out.println("Your email is : "+email);
		
	}
	
	
// ask for the Department
	private String setDepartment(){
		System.out.println("New person: "+firstName+"Department codes:\n1 for MCA\n2 for B.tech\n3 for MBA\nPlease enter the code:");
		Scanner sc = new Scanner(System.in);
		int departmentChoice = sc.nextInt();
		if      (departmentChoice==1) {return "mca";}
		else if (departmentChoice==2) {return "mba";}
		else if (departmentChoice==3) {return "bba";}
		else                          {return "";}	
	}
	
// generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$&";
		char[] password = new char[length];
		for (int i=0; i<length;i++) {
			int random = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(random);	
		}
		return new String(password);	
	}
// set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
// set alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity(){ return mailboxCapacity; }
	public String getAlternateEmail(){ return alternateEmail; }
	public String getPassword() { return password; }
	
	public String showInfo() {
		return "DISPLAY NAME : "+firstName+" "+lastName +
				"\nORGANIZATION EMAIL : "+email +
				"\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
	}
	

}

