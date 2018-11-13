package com.niit.Controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.Dao.CartItemDao;
import com.niit.Dao.ProductDao;
import com.niit.model.CartItem;
import com.niit.model.Product;
import com.niit.model.User;

import sun.security.krb5.PrincipalName;

@Controller
public class CartItemController {
	
	@Autowired
	private ProductDao productDao;
	@Autowired
   private CartItemDao cartItemDao;
	int quantity;
	
@RequestMapping(value="/cart/addtocart/{productId}")
public String addToCart(@PathVariable int productId,@RequestParam int requestedQuantity,@AuthenticationPrincipal  Principal principal ){
	String email=principal.getName();//Email id of the logged in user
	/*System.out.println(email+" "+productId+" "+requestedQuantity);
	Product product=productDao.getid(productId);
	quantity=product.getQuantity()-requestedQuantity;
	if(requestedQuantity<=product.getQuantity()) {
		
	List<CartItem> cartItems=cartItemDao.getCartItems(email);
	
	for(CartItem cartItem:cartItems){
		if(cartItem.getProduct().getId()==productId){
			cartItem.setQuantity(requestedQuantity);
			product.setQuantity(quantity);
			System.out.println(quantity);
			productDao.saveOrUpdateProduct(product);
			cartItem.setTotalPrice(requestedQuantity * product.getPrice() );
			cartItemDao.saveOrUpdateCartItem(cartItem);//update
			return "redirect:/cart/purchasedetails";
		}*/
	Product product=productDao.getid(productId);
		
	List<CartItem> cartItems=cartItemDao.getCartItems(email);
	int totalQnt=0;
	int prodQnt=product.getQuantity();
	for(CartItem cartItem:cartItems){
		if(cartItem.getProduct().getId()==productId){
			if(cartItem.getQuantity()!=0) {
				System.out.println("inside total quantity "+cartItem.getQuantity()+" product "+prodQnt);
				totalQnt=cartItem.getQuantity();
				prodQnt-=totalQnt;
				totalQnt=totalQnt-requestedQuantity;System.out.println("inside total quantity "+totalQnt+" "+cartItem.getQuantity()+" product "+prodQnt);
				cartItem.setQuantity(requestedQuantity);
				cartItem.setTotalPrice(requestedQuantity * product.getPrice() );
				cartItemDao.saveOrUpdateCartItem(cartItem);//update					
				product.setQuantity(prodQnt);
				productDao.saveOrUpdateProduct(product);
				return "redirect:/cart/purchasedetails";
			}			
		}
	}
	
	CartItem cartItem=new CartItem();
	prodQnt-=requestedQuantity;
	User user=cartItemDao.getUser(email);
	cartItem.setProduct(product);
	cartItem.setQuantity(requestedQuantity);
	cartItem.setUser(user);
	cartItem.setTotalPrice(requestedQuantity * product.getPrice());
	product.setQuantity(prodQnt);
	System.out.println(prodQnt);
	productDao.saveOrUpdateProduct(product);
	cartItemDao.saveOrUpdateCartItem(cartItem);//insert
	
	return "redirect:/cart/purchasedetails";
	}
	


@RequestMapping(value="/cart/purchasedetails")
public String getPurchaseDetails(@AuthenticationPrincipal Principal principal,Model model,HttpSession session){
	String email=principal.getName();
	List<CartItem> cartItems=cartItemDao.getCartItems(email);
	model.addAttribute("cartItems",cartItems);
	session.setAttribute("cartSize",cartItems.size() );
	return "cart";
}


/*@RequestMapping(value="/cart/deletecartitem/{itemId}")// cart/**  ROLE_USER
public String removeCartItem(@PathVariable int itemId){
	
	CartItem cartitem=new CartItem();
	Product product=productDao.getid(cartitem.getProduct().getId());
	int cartquantity=cartitem.getQuantity();
	System.out.println("1");
	int quantity=product.getQuantity()+cartquantity;
	System.out.println("2");
	product.setQuantity(quantity);
	System.out.println("3");
	productDao.saveOrUpdateProduct(product);
	System.out.println("4");
	cartItemDao.removeCartItem(itemId);
	System.out.println("5");
	return "redirect:/cart/purchasedetails";
}*/

@RequestMapping(value="/cart/deletecartitem/{itemId}")// cart/**  ROLE_USER
public String removeCartItem(@PathVariable int itemId, @AuthenticationPrincipal Principal principal){	
	String email=principal.getName();
	CartItem cartItems=cartItemDao.getCartItems(itemId);
	int totalQnt=cartItems.getQuantity(),prodQnt=cartItems.getProduct().getQuantity();
	prodQnt+=totalQnt;
	Product product=productDao.getid(cartItems.getProduct().getId());
	product.setQuantity(prodQnt);
	productDao.updateProduct(product);
	cartItemDao.removeCartItem(itemId);
	return "redirect:/cart/purchasedetails";
}


@RequestMapping(value="/cart/clearcart")
public String clearCart(@AuthenticationPrincipal Principal principal){
	String email=principal.getName();
	List<CartItem> cartItems=cartItemDao.getCartItems(email);
	int totalQnt=0,prodQnt=0;
	for(CartItem cartItem:cartItems){
		Product product=productDao.getid(cartItem.getProduct().getId());
		prodQnt=cartItem.getProduct().getQuantity();
		totalQnt=cartItem.getQuantity();
		prodQnt+=totalQnt;
		product.setQuantity(prodQnt);
		productDao.updateProduct(product);
		cartItemDao.removeCartItem(cartItem.getItemId());
	}
	return "redirect:/cart/purchasedetails";
}

}
