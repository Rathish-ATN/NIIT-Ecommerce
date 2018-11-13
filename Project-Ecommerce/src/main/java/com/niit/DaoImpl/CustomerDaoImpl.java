package com.niit.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.CustomerDao;
import com.niit.model.Authorities;
import com.niit.model.Customer;
import com.niit.model.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void registerCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		customer.getUser().setEnabled(true);// user.enabled=true
		Authorities authorities = new Authorities();System.out.println("enabled true");
		User user=new User();
		authorities.setRole("ROLE_USER");
		user.setRole("ROLE_USER");
		authorities.setUser(customer.getUser());// authorities-> user authorities.user=customer.user
		System.out.println("authorities user name setted");
		customer.getUser().setAuthorities(authorities);// user->authorities user.authorities=authorities	
		System.out.println("authorities authorities setted");
		System.out.println(authorities);
		System.out.println(customer);
		session.save(customer);
		// customer refers to user,billingaddress,shippingaddress
	}

	public boolean isEmailUnique(String email) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, email);
		if (user == null)
			return true;// unique
		else
			return false;// duplicate email id
	}
	
	public Customer getCustomer(String Username) {
		Session session = sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, Username);
        Customer customer =	user.getCustomer();
        return customer;
		}
	}
