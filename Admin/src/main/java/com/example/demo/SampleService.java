package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service 


public class SampleService {
	@Autowired
	 JdbcTemplate jd;
   
	public List<Map<String,Object>> productdetails(){
		
 		String str="select * from Products";
		
         return jd.queryForList(str);
		
	} 
	public int injectData(Products product) {
		int data; 
		
String str = "INSERT INTO Products (name, description, price, category_id, vendor_id) "
		+ "VALUES (?,?,?,?,?)" ;
		  int result = jd.update(str,product.getName(),product.getDescription(),product.getPrice(),product.getCategory_id(),product.getVendor_id());
		  return result;
	} 
	
	
	public int updatingData(Products product) { 
		int data ;
		String str = "update Products set price=? where name =?";
		data = jd.update(str,product.getPrice(),product.getName());
		return data;
	} 
	
	public List<Map<String,Object>> pathData(String name){
//		List<Map<String,Object>> data = new List<Map<String,Object>>();
		String data = "select * from Products where name=?" ;
		return jd.queryForList(data,name) ;
	}
	
}
