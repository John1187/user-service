package io.pivotal.microservices.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*  
 * It is just a helper class which should be replaced by database implementation.  
 * It is just used for demonstration.  
 */

public class UserProfileService {

	static HashMap<Integer, User> userMap = getUserMap();

	public UserProfileService() {
		super();

		if (userMap == null) {
			userMap = new HashMap<Integer, User>();
			// Creating some objects of Users while initializing

			User user1 = new User(1, "John", 32, "Male", "20401 N 19th Avenue");
			User user2 = new User(2, "Paul", 35, "Male", "20654 N 56th Avenue");
			User user3 = new User(3, "Joe", 32, "Female", "44444 N 19th Avenue");

			userMap.put(1, user1);
			userMap.put(2, user2);
			userMap.put(3, user3);

		}
	}

	public static HashMap<Integer, User> getUserMap() {
		return userMap;
	}

	/**
	 * Search for a specific user.
	 * 
	 */

	public User getUser(int id) {
		User user = userMap.get(id);
		return user;
	}

	/**
	 * Add a new User.
	 * 
	 */

	public User addUser(User user) {
		user.setId(getMaxId() + 1);
		userMap.put(user.getId(), user);
		return user;
	}

	/**
	 * Delete user
	 * 
	 */

	public void deleteUser(int id) {
		userMap.remove(id);
	}

	/**
	 * Get all user details
	 * 
	 */

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<User>(userMap.values());
		return users;
	}

	// Utility method to get max id
	public static int getMaxId() {
		int max = 0;
		for (int id : userMap.keySet()) {
			if (max <= id)
				max = id;

		}
		return max;
	}

}
