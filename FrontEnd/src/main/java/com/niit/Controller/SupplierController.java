package com.niit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.SupplierDao;
import com.niit.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	SupplierDao supplierDao;

	// Add or Update Supplier
	@RequestMapping(value = "/admin/Addsupp", method = RequestMethod.POST)
	public String saveorUpdateSupplier(@ModelAttribute(name = "supplier") Supplier supplier) {
		System.out.println("Product Id in SaveSupplier method " + supplier.getId());
		supplierDao.saveOrUpdateSupplier(supplier);
		return "redirect:/displayallsupplier";
	}

	// Add Supplier Form
	@RequestMapping(value = "/admin/Addsupplier")
	public ModelAndView addSupplier() {

		return new ModelAndView("addsupplier", "command", new Supplier());
	}

	// Update Supplier form
	@RequestMapping("/admin/updateSupplier/{id}")
	public ModelAndView updatesupplier(@PathVariable("id") int id) {
		System.out.println("Supplier Controller: Update Supplier");
		Supplier supp = supplierDao.getid(id);
		return new ModelAndView("updatesupplier", "command", supp);
	}

	// Delete Product.
	@RequestMapping(value = "/admin/deleteSupplier/{id}")
	public String deleteSupplier(@PathVariable("id") int id) {
		System.out.println("Supplier Controller: Delete Supplier By Id Page");
		supplierDao.deleteSupplier(id);
		return "redirect:/displayallsupplier";
	}

	// Display Individual Product details.
	@RequestMapping("/admin/displaySupplier/{id}")
	public ModelAndView displaysupplier(@PathVariable("id") int id) {
		System.out.println("Supplier Controller: Display Supplier");
		Supplier list = supplierDao.getid(id);
		return new ModelAndView("displaysupplier", "suppList", list);
	}

	//Display All Suppliers
	@RequestMapping(value = "/displayallsupplier")
	public ModelAndView displayallproduct() {
		List<Supplier> list = supplierDao.listallsupplier();
		ModelAndView mv = new ModelAndView("displayallsuppliers", "up", list);
		return mv;
	}

}
