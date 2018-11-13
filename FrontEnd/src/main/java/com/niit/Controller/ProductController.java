package com.niit.Controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.Dao.ProductDao;
import com.niit.Dao.CatagoryDao;
import com.niit.model.Catagory;
import com.niit.model.Product;
@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CatagoryDao catagoryDao;
	
	//Add and Update product data received from jsp page and send to back end
	@RequestMapping(value="/admin/Addprod",method=RequestMethod.POST)
	public String saveOrUpdateProduct(@ModelAttribute(name="product") Product product, BindingResult result ,Model model,HttpServletRequest request){
		if(result.hasErrors()){
			model.addAttribute("catagories",productDao.listallcatagory());
			if(product.getId()==0)//insert
			return "productform";
			else
			return "updateproductform";
		}
		System.out.println("Product Id in SaveProduct method " + product.getId());
        String rootContext= request.getServletContext().getRealPath("/");
        //........ project1frontend
        System.out.println(rootContext);
        
		productDao.saveOrUpdateProduct(product);
		
		Path paths=Paths.get(rootContext + "/resources/image/"+product.getId()+".png");
		MultipartFile productImage=product.getImage();
		if(productImage!=null && !productImage.isEmpty()){
			try {
				productImage.transferTo(new File(paths.toString()));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/displayallproduct";
	}
	
	
	//Add product Display form
	@RequestMapping(value="/admin/Addproduct")//blank form
	public String addproduct(Model model){
		
		//return new ModelAndView("addproduct","command",new Product());
		model.addAttribute("product",new Product());
		model.addAttribute("catagories",productDao.listallcatagory());
		return "addproduct";
	}
	
	//Update Product Display form
	@RequestMapping("/admin/updateProduct/{id}")
	public String updateproduct(@PathVariable("id") int id, Model model)
	{
		System.out.println("Product Controller: Update Product");
		Product prod=productDao.getid(id);
		model.addAttribute("product",prod);
		model.addAttribute("categories",productDao.listallcatagory());
		//return new ModelAndView("updateproduct","command",prod);
		return "updateproduct";
	}
	
	//Delete Product.
	@RequestMapping(value="/admin/deleteProduct/{id}")
	public String deleteProduct(@PathVariable("id") int id, HttpServletRequest request) {
		System.out.println("Product Controller: Delete Product By Id Page");
		productDao.deleteProduct(id);
		String rootContext=request.getServletContext().getRealPath("/");
		Path path=Paths.get(rootContext + "/resources/images/"+ id+".png");
		if(Files.exists(path)){
			try {
				Files.delete(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "redirect:/admin/displayallproduct";
	}
	
	//Display all product Page.
	@RequestMapping(value="/displayallproduct")
	public ModelAndView displayallproduct() {
		List<Product> list=productDao.listallproduct();
		ModelAndView mv=new ModelAndView("displayallproductuser","up",list);
		return mv;
	}
	
	//Display all product Page admin.
		@RequestMapping(value="/admin/displayallproduct")
		public ModelAndView displayallproductadmin() {
			List<Product> list=productDao.listallproduct();
			ModelAndView mv=new ModelAndView("displayallproducts","up",list);
			return mv;
		}

	//Display Individual Product details.
	@RequestMapping("/displayProduct/{id}")
	public ModelAndView displayproduct(@PathVariable("id") int id, Model model)
	{
		System.out.println("product display by id "+id);
		/*System.out.println("Product Controller: Display Product");
		Product list=productDao.getid(id);
		return new ModelAndView("displayproducts","prodList",list);*/
		
		Product prodlist=productDao.getid(id);
		Catagory cat=catagoryDao.getid(id);
		System.out.println("Product "+prodlist+" category "+cat);		
		model.addAttribute("c",cat);
		return new ModelAndView("displayproduct","p",prodlist);
	}
}
