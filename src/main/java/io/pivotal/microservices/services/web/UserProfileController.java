package io.pivotal.microservices.services.web;

import io.pivotal.microservices.services.web.Account;
import io.pivotal.microservices.users.User;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link WebAccountsService}.
 * 
 * @author Paul Chapman
 */
@Controller
public class UserProfileController {

	@Autowired
	protected UserProfileService userProfileService;

	protected Logger logger = Logger.getLogger(UserProfileController.class
			.getName());

	public UserProfileController(UserProfileService userProfileService) {
		this.userProfileService = userProfileService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields("accountNumber", "searchText");
	}

	@RequestMapping("/users")
	public String goHome() {
		return "index";
	}

	/*@RequestMapping("/accounts/{accountNumber}")
	public String byNumber(Model model,
			@PathVariable("accountNumber") String accountNumber) {

		logger.info("web-service byNumber() invoked: " + accountNumber);

		Account account = accountsService.findByNumber(accountNumber);
		logger.info("web-service byNumber() found: " + account);
		model.addAttribute("account", account);
		return "account";
	}*/
	
	@RequestMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {   
	     return  userProfileService.getUser(id);   
	 }  

	
}
