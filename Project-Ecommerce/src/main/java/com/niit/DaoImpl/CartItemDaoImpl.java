package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.CartItemDao;
import com.niit.model.CartItem;
import com.niit.model.Catagory;
import com.niit.model.User;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;
		public User getUser(String username) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, username);
		return user;
		}

		public void saveOrUpdateCartItem(CartItem cartItem) {
			Session session=sessionFactory.getCurrentSession();
			session.saveOrUpdate(cartItem);

		}

		public List<CartItem> getCartItems(String username) {
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from CartItem where user.Username=?");
			query.setString(0, username);
			List<CartItem> cartItems=query.list();
			return cartItems;
		}

		public void removeCartItem(int itemId) {
			Session session=sessionFactory.getCurrentSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class, itemId);
			session.delete(cartItem);
			
		}
		
		public CartItem getCartItems(int itemid) {
			Session session=sessionFactory.openSession();
			Transaction trans=session.beginTransaction();
			CartItem cartItem=(CartItem) session.get(CartItem.class, itemid);
			trans.commit();
			session.flush();
			session.close();
			return cartItem;
		}

}
