package com.niit.Dao;

import java.util.List;

import com.niit.model.Catagory;
import com.niit.model.Product;

public interface ProductDao {
	public Product saveOrUpdateProduct(Product product);
	boolean saveProduct(Product product);
	boolean deleteProduct(int id);
	boolean updateProduct(Product product);
	List<Product> listallproduct();
	Product getid(int id);
	List<Catagory> listallcatagory();

}
