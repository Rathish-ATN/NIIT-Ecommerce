package com.niit.Dao;

import java.util.List;

import com.niit.model.Catagory;

public interface CatagoryDao {
	public Catagory saveOrUpdateCatagory(Catagory catagory);
	boolean saveCatagory(Catagory catagory);
	boolean deleteCatagory(int id);
	boolean updateCatagory(Catagory catagory);
	List<Catagory> listallcatagory();
	public Catagory getid(int cid);

}
