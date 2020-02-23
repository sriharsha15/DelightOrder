package com.cg.delightorder.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import com.cg.delightorder.dao.ProductDao;
import com.cg.delightorder.dao.RawMaterialDao;
import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;

public class ProductServiceImpl implements ProductService
{
	RawMaterialDao productDao=new ProductDao();
	public ProductStock trackProductOrder(String orderId) throws ProductException 
	{
    
    	  if(doesProductOrderIdExist(orderId))
    		  
    		  return productDao.trackProductOrder(orderId);
    	  else
    		 throw new ProductException("No OrderId Exist");
     
	}
	public boolean doesProductOrderIdExist(String orderId)  {
	
	       if(orderId==null)
	       {
	    	   return false;
	       }
	       else
	    	   
			return  productDao.doesProductOrderIdExist(orderId);

	}
	public boolean exitDateCheck(Date exitDate)throws ProductException
	{
      if(exitDate==null)
      {
		return false;
      }
    	  LocalDate date = exitDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
          LocalDate current = LocalDate.now();
          if( date.isAfter(current))
          {
        	  return true;
          }
          else
          {
        	  throw new ProductException("Not a valid date");
          }

	}
	public String updateExitDateinStock(String orderId,Date exitDate) throws ProductException {
		// TODO Auto-generated method stub
		if(exitDateCheck(exitDate))	
		{
			return productDao.updateExitDateinStock(orderId,exitDate);
		  
		}
		else 
			return "null";
	}
	public boolean validateManfacturingDate(Date manufacturing_date) throws ProductException {
		// TODO Auto-generated method stub
		if(manufacturing_date==null)
	      {
			return false;
	      }
	          
	    	  LocalDate date = manufacturing_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          LocalDate current = LocalDate.now();
	          if( date.isBefore(current))
	          {
	        	  return true;
	          }
	          else
	          {
	        	  throw new ProductException("Not a valid date");
	          }
			
	}
	public boolean validateExpiryDate(Date manufacturing_date, Date expiry_date) throws ProductException {
		if(manufacturing_date==null || expiry_date==null)
	      {
			return false;
	      } 
	
	          
	    	  LocalDate date1 = manufacturing_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          LocalDate date2 = expiry_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	          if( date2.isAfter(date1))
	          {
	        	  return true;
	          }
	          else
	          {
	        	  throw new ProductException("Not a valid date");
	          }
		 

	}
	public String updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck) throws ProductException
	{
		if(validateManfacturingDate( manufacturing_date) && validateExpiryDate( manufacturing_date,expiry_date))
		{	
		
				return productDao.updateProductStock(orderId,manufacturing_date, expiry_date, qualityCheck);
		}
		else
		{
			return "null";
		}
		
	}	 
}
