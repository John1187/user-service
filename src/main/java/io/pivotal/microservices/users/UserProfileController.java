package io.pivotal.microservices.users;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.pivotal.microservices.exceptions.AccountNotFoundException;
import io.pivotal.microservices.users.User;
import io.pivotal.microservices.users.UserProfileService;

/**
 * A RESTFul controller for accessing user profile information.
 * 
 * @author Paul Chapman
 */
@CrossOrigin
@RestController
public class UserProfileController {

	protected Logger logger = Logger.getLogger(UserProfileController.class.getName());
	UserProfileService userProfileService = new UserProfileService();
	ObjectMapper mapper = new ObjectMapper();

	public UserProfileController() {
		logger.info("Controller initialised");
	}

	/**
	 * Fetch User details for a specific user.
	 * 
	 * @param id
	 *            User id.
	 * @return The User details.
	 * @throws JsonProcessingException
	 * 
	 */

	// @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, headers
	// = "Accept=application/json")
	@RequestMapping("/v1/user/{id}")
	// @ResponseBody
	public String getUserById(@PathVariable("id") String id) throws JsonProcessingException {

		User userDetails = userProfileService.getUser(Integer.parseInt(id));
		// return new ResponseEntity<User>(userDetails, HttpStatus.OK);
		// Object to JSON in String
		String userDetailsJson = mapper.writeValueAsString(userDetails);
		return userDetailsJson;
	}

	/**
	 * Add a new user
	 * 
	 * @param user
	 *            User Details.
	 * @return The User details.
	 * @throws JsonProcessingException
	 * 
	 */

	@RequestMapping(value = "/v1/users", method = RequestMethod.POST, headers = "Accept=application/json")
	public String addUser(@RequestBody User user) throws JsonProcessingException {

		User userDetails = userProfileService.addUser(user);
		String userDetailsJson = mapper.writeValueAsString(userDetails);
		return userDetailsJson;
	}

	/**
	 * Delete a user
	 * 
	 * @param id
	 *            User Id.
	 * 
	 * @throws JsonProcessingException
	 * 
	 */

	@RequestMapping(value = "/v1/user/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteUser(@PathVariable("id") int id) {
		userProfileService.deleteUser(id);

	}

	/**
	 * List All the users
	 * 
	 * 
	 * @return List of all users.
	 * @throws JsonProcessingException
	 * 
	 */

	@RequestMapping(value = "/v1/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUsers() {
		List<User> listOfUsers = userProfileService.getAllUsers();
		return listOfUsers;
	}

}