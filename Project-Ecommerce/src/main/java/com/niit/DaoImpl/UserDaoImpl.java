package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.UserDao;
import com.niit.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	public UserDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	public UserDaoImpl()
	{}
	
	
	public boolean saveUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.save(user);
		return true;
	}

	public boolean deleteUser(int id) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User) session.load(User.class, id);		
			session.delete(user);
		return true;
	}

	public boolean updateUser(User user) {
		Session session=sessionFactory.getCurrentSession();
		session.update(user);
		return true;
	}

	public List<User> listalluser() {
		String query="FROM User";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<User> list=q.list();
		return list;
	}

	public List<User> getid(int id) {
		String query="FROM User WHERE ID="+id;
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<User> list=q.list();
		return list;
	}

	@Transactional
	public boolean isValidUser(String email, String password) {
		System.out.println("User Dao Impl VALID User Check");
		String hql ="from User where Email= '" + email + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if(list != null && !list.isEmpty())
		{
		
			return true;
		}
		return false;

	}

}
