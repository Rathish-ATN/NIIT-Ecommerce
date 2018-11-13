package com.niit.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.CatagoryDao;
import com.niit.model.Catagory;
import com.niit.model.Product;

@Repository("categoryDao")
@Transactional
public class CatagoryDaoImpl implements CatagoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public CatagoryDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}

	public boolean saveCatagory(Catagory catagory) {
		Session session=sessionFactory.getCurrentSession();
		session.save(catagory);
		return true;
	}
	
	public Catagory saveOrUpdateCatagory(Catagory catagory) {
		System.out.println("ID " + catagory.getCid());//Transient
	    Session session=sessionFactory.getCurrentSession();
	    session.saveOrUpdate(catagory);//insert or update based on the value of Product id
	    //Persistent
	    System.out.println("ID " + catagory.getCid());
	    return catagory;
	}

	public boolean deleteCatagory(int id) {
		Session session=sessionFactory.getCurrentSession();
		Catagory catagory=(Catagory) session.load(Catagory.class, id);
		session.delete(catagory);
		return true;
	}

	public boolean updateCatagory(Catagory catagory) {
		Session session=sessionFactory.getCurrentSession();
		session.update(catagory);
		return true;
	}

	public List<Catagory> listallcatagory() {
		String query="FROM Catagory";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Catagory> list=q.list();
		return list;
	}

	public Catagory getid(int cid) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Catagory catagory=(Catagory) session.get(Catagory.class, cid);
		trans.commit();
		session.flush();
		session.close();
		return catagory;
	}

}
