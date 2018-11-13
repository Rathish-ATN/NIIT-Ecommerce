package com.niit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CustomerDao;
import com.niit.Dao.UserDao;
import com.niit.model.Customer;
import com.niit.model.User;

@Controller
public class UserController {
	@Autowired
      UserDao userDao;

		
	@RequestMapping(value="/Logincheck")
	public ModelAndView loginCheck(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println("User controller Login check");
		String message;
		ModelAndView mv ;
		if (userDao.isValidUser(username,password)) 
		{
			message = "Successfully Logged in";
			 mv = new ModelAndView("logins");
		} else{
			message="Please enter a valid username and password";
			mv=new ModelAndView("loginf");
		}
		return mv;
	}
	
	
	@RequestMapping(value="/logins")
	public String logins()
	{
		return "logins";
	}
	
	@RequestMapping(value="/loginf")
	public String loginf()
	{
		return "loginf";	
	}
	
	@Autowired
	private CustomerDao customerDao;
		@RequestMapping("/register")
		public ModelAndView getRegistrationForm(){
			return new ModelAndView("register","customer",new Customer());
		}
		
		@RequestMapping(value="/all/register")
		public String registerCustomer(@ModelAttribute(name="customer") Customer customer,Model model){
			if(!customerDao.isEmailUnique(customer.getUser().getEmail())){
				model.addAttribute("error","Email Id already Exists.. please enter different email address");
				return "register";
			}
		   	customerDao.registerCustomer(customer);
		   	model.addAttribute("command", new User());
		   	return "login";
		}
}
