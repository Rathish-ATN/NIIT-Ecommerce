package com.niit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.Catagory;
import com.niit.model.Supplier;
import com.niit.model.User;

@Controller
public class HomeController {
	@RequestMapping(value= {"/","/home"})
	public String homepage()
	{
		return "home";
	}

	@RequestMapping("/aboutus")
	public String aboutus()
	{
		return "aboutus";
	}
	
	@RequestMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	
	@RequestMapping("/login")
	public ModelAndView login()
	{
		System.out.println("Home Controller: Login page");
		return new ModelAndView("login","command",new User());
	}
	
	
	
	@RequestMapping("/addsupplier")
	public ModelAndView addsupplier()
	{
		System.out.println("Home Controller: Add Supplier");
		return new ModelAndView("addsupplier","command",new Supplier());
	}
	
	@RequestMapping("/addcatagory")
	public ModelAndView addcatagory()
	{
		System.out.println("Home Controller: Add Catagory");
		return new ModelAndView("addcatagory","command",new Catagory());
	}
}
