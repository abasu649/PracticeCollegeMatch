package collegematch;

import java.util.Scanner;

public class Menu {
	
	private Scanner keyboardIn;
	private UserManager userManager;
	private User currentUser;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		this.userManager = new UserManager();
	}

	public static void main(String[] args) {
		
		Menu collegeMatchMenu = new Menu();
		collegeMatchMenu.runMainMenu(collegeMatchMenu);
	}

	public void runMainMenu (Menu collegeMatchMenu) {
		this.displayLoginMenu();	
		keyboardIn.close();
	}
	
			

	private void displayLoginMenu() {
		System.out.println("Welcome to CollegeMatch!");
		System.out.println("Enter username: ");
		String userName = keyboardIn.nextLine();
		currentUser = userManager.logIn(userName);
		if(currentUser != null) {
			System.out.println("Login successful");
			displayStudentMenu();
			int selectedOption = this.getUserInput();
			this.processStudentMenu(selectedOption);
		} else {
			System.out.println("Login unsuccessful. Transferring you to Register menu");
			displayRegisterMenu();
			displayLoginMenu();
		}	
	}
	
	public void displayRegisterMenu() {
		System.out.println("Enter a username: ");
		String userName = keyboardIn.nextLine();
		while (userManager.checkForDuplicateUsername(userName)) {
			System.out.println("Username already exists.");
			System.out.println("Enter a different username: ");
			userName = keyboardIn.nextLine();
		}
		System.out.println("Enter your SAT Score: ");
		int satScore = keyboardIn.nextInt();
		while (!userManager.validateSATScore(satScore)) {
			System.out.println("SAT Scores must be between 400 and 1600");
			System.out.println("Enter your SAT Score: ");
			satScore = keyboardIn.nextInt();
		}
		System.out.println("Enter your GPA: ");
		double gpa = getUserGPAInput();
		while (!userManager.validateGPA(gpa)) {
			System.out.println("GPA must be between 0.0 and 4.0");
			System.out.println("Enter your GPA: ");
			gpa = getUserGPAInput();
		}
		System.out.println("Enter your whether you prefer \"rural\" or \"urban\" campuses: ");
		String campusPreference = keyboardIn.nextLine();
		while (!userManager.validateCampusPreference(campusPreference)) {
//			System.out.print("Response must be \"rural\" or \"urban\"");
			System.out.println("Responses must be \"rural\" or \"urban\". Please try again: ");
			campusPreference = keyboardIn.nextLine();
		}
		userManager.register(userName, satScore, gpa, campusPreference);
		System.out.println("Registration successful. Transferring you to Login menu");
	}

	public void displayStudentMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Display saved colleges");
		System.out.println("2. Get college matches");
		System.out.println("3. Search college database");
	}
	
	public void processStudentMenu(int studentOption) {
		if(studentOption == 1) {
			userManager.displayUserSavedCollegeList(currentUser);
		} else if (studentOption == 2) {
			System.out.println("Taking quiz");
		} else if (studentOption == 3) { 
			System.out.println("List of scores");
		}
	}
	//deletes new line at the end of string 
	private double getUserGPAInput() {
		double selected = keyboardIn.nextDouble();
		String notUsed = keyboardIn.nextLine();
		return selected;
	}
	
	private int getUserInput() {
		int selected = keyboardIn.nextInt();
		String notUsed = keyboardIn.nextLine();
		return selected;
	}

}
