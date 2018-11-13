package com.niit.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.Dao.CartItemDao;
import com.niit.Dao.CustomerDao;
import com.niit.Dao.ProductDao;
import com.niit.model.CartItem;
import com.niit.model.Customer;

@Controller
public class PaymentController {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	CartItemDao cartItemDao;
	@Autowired
	CustomerDao customerDao;
	
	
	@RequestMapping(value="/payment")
	public String payment() {
		
	return "payment";
	}
	
	@RequestMapping(value="/Invoice")
	public String Invoice(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){
		String email=principal.getName();
		List<CartItem> cartItems=cartItemDao.getCartItems(email);
		Customer customer=customerDao.getCustomer(email);
		
		System.out.println(email);
		
		model.addAttribute("Invoicebind2",principal);
		model.addAttribute("Invoicebind",cartItems);
		model.addAttribute("Invoicebind1",customer);
		
		for(CartItem cartItem:cartItems) {
		cartItemDao.removeCartItem(cartItem.getItemId());
		}
		return "Invoice";
	}

}
