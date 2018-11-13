package com.niit.Dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao {
	boolean saveSupplier(Supplier supplier);
	boolean deleteSupplier(int id);
	boolean updateSupplier(Supplier supplier);
	List<Supplier> listallsupplier();
	public Supplier getid(int id);
	public Supplier saveOrUpdateSupplier(Supplier supplier);
}
