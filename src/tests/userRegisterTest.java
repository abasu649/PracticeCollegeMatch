package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import collegematch.User;
import collegematch.UserManager;

class userRegisterTest {

	@Test
	void test() throws IOException {
		UserManager userManager = new UserManager();
		userManager.register("dan", 1100, 3.0, "rural");
		ArrayList<User> allUsers = userManager.readUsers();
		boolean match = false;
		for(User user : allUsers) {
			if(user.getUsername().equals("dan") 
					&&(user.getGpa()==3.0) &&user.getCampusPreference().equals("rural")) {
				match = true;
			}
		}
		assertEquals(true, match);
	}

}
