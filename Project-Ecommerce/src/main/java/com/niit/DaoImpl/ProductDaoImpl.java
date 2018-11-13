package com.niit.DaoImpl;

import java.util.List;
//import java.util.function.Supplier;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.ProductDao;
import com.niit.model.Catagory;
import com.niit.model.Product;


@Repository("productDaoImpl")
@Transactional
public class ProductDaoImpl implements ProductDao {	

	@Autowired
	private SessionFactory sessionFactory;
	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		super();
	this.sessionFactory=sessionFactory;	
		
	}
	public ProductDaoImpl() {
 	}
	public boolean saveProduct(Product product) {

//		Session session=sessionFactory.openSession();
//		session.beginTransaction();
//		session.saveOrUpdate(product);
//		session.getTransaction().commit();
		
		 		Session session=sessionFactory.getCurrentSession();
		System.out.println("Before Save ID: "+product.getId());
		session.save(product);
		System.out.println("After Save ID: "+product.getId());
		return true;
	}

	public Product saveOrUpdateProduct(Product product) {
		System.out.println("ID " + product.getId());//Transient
	    Session session=sessionFactory.getCurrentSession();
	    session.saveOrUpdate(product);//insert or update based on the value of Product id
	    //Persistent
	    System.out.println("ID " + product.getId());
	    return product;
	}
	
	public boolean deleteProduct(int id) {
		Session session=sessionFactory.getCurrentSession();
		Product product= (Product) session.load(Product.class, id);
		session.delete(product);
		return true;
	}

	public boolean updateProduct(Product product) {
		Session session=sessionFactory.getCurrentSession();
		session.update(product);
		return true;
	}
	public List<Product> listallproduct() {
		String query="From Product";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Product> list=q.list();
		return list;
	}

	public Product getid(int id) {
		Session session=sessionFactory.openSession();
		Transaction trans=session.beginTransaction();
		Product product=(Product) session.get(Product.class, id);
		trans.commit();
		session.flush();
		session.close();
		return product;
		
		
	}

	public List<Catagory> listallcatagory() {
		String query="FROM Catagory";
		Session session=sessionFactory.openSession();
		Query q=session.createQuery(query);
		List<Catagory> list=q.list();
		return list;
	}
}
