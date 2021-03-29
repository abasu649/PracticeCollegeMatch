package collegematch;

import java.util.ArrayList;

import java.util.Scanner;

public class UserManager {
	
	private ArrayList<User> users;
	private Scanner keyboardIn;
	
	public UserManager() {
		this.users = new ArrayList<User>();
	}
	
	public User logIn(String userName) {
		for (User user: users) {
			if (user.getUsername().equals(userName)) {
				return user;
			}
		}
		return null;
	}
	
	public void register(String userName, int satScore, double gpa, String campusPreference) {
		User user = new User(userName, satScore, gpa, campusPreference);
		users.add(user);
	}
	
	public boolean validateCampusPreference(String campusPreference) {
		if (campusPreference.equals("rural" )|| campusPreference.equals("urban")) {
			return true;
		}
		return false;
	}

	public boolean checkForDuplicateUsername(String userName) {
		for (User user: users) {
			if (user.getUsername() == userName) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validateSATScore(int satScore) {
		if (satScore >= 400 && satScore <= 1600) {
			return true;
		}
		return false;
	}
	
	public boolean validateGPA(double gpa) {
		if (gpa >= 0.0 && gpa <= 4.0) {
			return true;
		}
		return false;
	}
	
	public void displayUserSavedCollegeList(User user) {
		user.displaySavedColleges();
	}

	public ArrayList<College> getCollegeMatches(User user, ArrayList<College> colleges) {
		ArrayList<College> matches = user.getCollegeMatches(colleges);
		return matches;
	}
}
