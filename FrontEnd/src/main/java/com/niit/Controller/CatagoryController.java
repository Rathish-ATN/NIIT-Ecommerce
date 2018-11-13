package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.CatagoryDao;
import com.niit.model.Catagory;

@Controller
public class CatagoryController {
	@Autowired
	CatagoryDao catagoryDao;
	
	// Add or Update Catagory
		@RequestMapping(value = "/admin/Addcat", method = RequestMethod.POST)
		public String saveorUpdateCatagory(@ModelAttribute(name = "catagory") Catagory catagory) {
			System.out.println("Product Id in SaveCatagory method " + catagory.getCid());
			catagoryDao.saveOrUpdateCatagory(catagory);
			return "redirect:/admin/displayallcatagory";
		}

		// Add Catagory Form
		@RequestMapping(value = "/admin/Addcatagory")
		public ModelAndView addCatagory() {

			return new ModelAndView("addcatagory", "command", new Catagory());
		}

		// Update Catagory form
		@RequestMapping("/admin/updateCatagory/{id}")
		public ModelAndView updatecatagory(@PathVariable("id") int id) {
			System.out.println("Catagory Controller: Update Catagory");
			Catagory cat = catagoryDao.getid(id);
			return new ModelAndView("updatecatagory", "command", cat);
		}

		// Delete Product.
		@RequestMapping(value = "/admin/deleteCatagory/{id}")
		public String deleteCatagory(@PathVariable("id") int id) {
			System.out.println("Catagory Controller: Delete Catagory By Id Page");
			catagoryDao.deleteCatagory(id);
			return "redirect:/admin/displayallcatagory";
		}

		// Display Individual Product details.
		@RequestMapping("/admin/displayCatagory/{id}")
		public ModelAndView displaycatagory(@PathVariable("id") int id) {
			System.out.println("Catagory Controller: Display Catagory");
			Catagory list = catagoryDao.getid(id);
			return new ModelAndView("displaycatagory", "catList", list);
		}

		//Display All Catagorys
		@RequestMapping(value = "/admin/displayallcatagory")
		public ModelAndView displayallproduct() {
			List<Catagory> list = catagoryDao.listallcatagory();
			ModelAndView mv = new ModelAndView("displayallcatagorys", "up", list);
			return mv;
		}

}
