package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.User;
import collegematch.UserManager;


class readUsersTest{
    
    @Test
	void test() throws IOException {
	UserManager userManager = new UserManager();
	ArrayList<User> allUsers = userManager.readUsers();
    boolean match = false;
		for(User user : allUsers) {
			if(user.getUsername().equals("batman")&&(user.getSatScore() ==1600)
					&&(user.getGpa()==4.0) &&user.getCampusPreference().equals("rural")) {
				match = true;
			}
		}
	assertEquals(true, match);
	}

}
