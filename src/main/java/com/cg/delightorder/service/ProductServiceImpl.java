package com.cg.delightorder.service;

import java.util.Date;
import java.util.List;

import com.cg.delightorder.dao.ProductDao;
import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;

public class ProductServiceImpl implements ProductService
{
	ProductDao ps=new ProductDao();
	
	 public boolean addProductStock(ProductStock obj)
	  {
		  return ps.addProductStockDao(obj);
		  
	  }
//	 public ProductStock getlist(String orderId)
//	 {
//		 
//		 return ps.trackProductOrder(orderId);
//	 }
	public ProductStock trackProductOrder(String orderId) throws ProductException
	{

      if(orderId !=null)
      {
    	  if(doesProductOrderIdExist(orderId))
    		  
    		  return ps.trackProductOrder(orderId);
    	  else
    		 throw new ProductException("No OrderId Exist");
      }
      else
		return null;
	}
	public boolean doesProductOrderIdExist(String orderId) {
	
	 return  ps.doesProductOrderIdExist(orderId);
	    
	}
	public boolean exitDateCheck(ProductStock productStock)
	{
      
		return false;
	}
	public String updateExitDateinStock(ProductStock productStock) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean validateManfacturingDate(Date manufacturing_date) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean validateExpiryDate(Date manufacturing_date, Date expiry_date) {
		// TODO Auto-generated method stub
		return false;
	}
	public String updateProductStock(ProductStock productStock) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean doesProductOrderIdExistInStock(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}
	 
	 
}
