package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.PaymentDao;
import com.niit.model.CartItem;

@Transactional
@Repository
public class PaymentDaoImpl implements PaymentDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean PaymentDone() {
		/*Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where user.Username=?");
		query.setString(0, username);
		List<CartItem> cartItems=query.list();*/
		return false;
	}

}
