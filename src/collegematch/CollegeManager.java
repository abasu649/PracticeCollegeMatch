package collegematch;

import java.io.*; 

import java.util.Scanner;  

import java.util.ArrayList;

public class CollegeManager {
	private ArrayList<College> colleges;
	
	public CollegeManager() {
		this.colleges = new ArrayList<College>();
		College washU = new College("Washington University", 1470, 3.5, "urban");
		College harvard = new College("Harvard College", 1600, 3.9, "urban");
		College dartmouth = new College("Dartmouth College", 1490, 3.8, "rural");
		College iowaState = new College("Iowa State University", 1400, 3.2, "rural");
		colleges.add(washU);
		colleges.add(harvard);
		colleges.add(dartmouth);
		colleges.add(iowaState);
	}
	
	public void searchCollege(String collegeName) {
		boolean collegeNotFound = true;
		for (College college : colleges) {
			if (college.getName().contains(collegeName)) {
				college.displayCollegeInformation();
				collegeNotFound = false;
			}
		}
		if(collegeNotFound) {
			System.out.println("College not found.");
		}
	}
	
	public ArrayList<College> getColleges(){
		return colleges;
	}
}
