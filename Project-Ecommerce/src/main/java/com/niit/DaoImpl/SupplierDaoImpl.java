package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.SupplierDao;
import com.niit.model.Supplier;

@Repository("supplierDaoImpl")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		super();
		this.sessionFactory=sessionFactory;
	}
	public SupplierDaoImpl()
	{}

	public boolean saveSupplier(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		session.save(supplier);
		return true;
	}

	public Supplier saveOrUpdateSupplier(Supplier supplier) {
		System.out.println("ID " + supplier.getId());//Transient
	    Session session=sessionFactory.getCurrentSession();
	    session.saveOrUpdate(supplier);//insert or update based on the value of Product id
	    //Persistent
	    System.out.println("ID " + supplier.getId());
	    return supplier;
	}
	
	public boolean deleteSupplier(int id) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supplier=(Supplier) session.load(Supplier.class, id);		
			session.delete(supplier);
			return true;
	}

	public boolean updateSupplier(Supplier supplier) {
		Session session=sessionFactory.getCurrentSession();
		session.update(supplier);
		return true;
	}

	public List<Supplier> listallsupplier() {
		String query="FROM Supplier";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Supplier> list=q.list();
		return list;		
	}

	public Supplier getid(int id) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Supplier supplier=(Supplier) session.get(Supplier.class, id);
		trans.commit();
		session.flush();
		session.close();
		return supplier;
	}

}
