package com.cg.delightorder.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.cg.delightorder.dao.ProductDao;
import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;

public class ProductServiceImpl implements ProductService
{
	ProductDao ps=new ProductDao();
	public ProductStock trackProductOrder(String orderId) 
	{
    try
    {
    	  if(doesProductOrderIdExist(orderId))
    		  
    		  return ps.trackProductOrder(orderId);
    	  else
    		 throw new ProductException("No OrderId Exist");
      }
      catch(ProductException e)
    {
    	 System.out.println(e);
    }
    return null;
	}
	public boolean doesProductOrderIdExist(String orderId)  {
	
	 
		try {
			return  ps.doesProductOrderIdExist(orderId);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
	}
	public boolean exitDateCheck(Date exitDate)
	{
      if(exitDate==null)
      {
		return false;
      }

      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
      String Date=new SimpleDateFormat("MM/dd/yyyy").format(exitDate);
      sdf.setLenient(false);
      try {
			Date date = sdf.parse(Date);
		} 
       catch (ParseException e) 
       {
			
			e.printStackTrace();
			return false;
		}	
		return true;
	}
	public String updateExitDateinStock(String orderId,Date exitDate) {
		// TODO Auto-generated method stub
		if(exitDateCheck(exitDate))	
		{
		try {
			return ps.updateExitDateinStock(orderId,exitDate);
		} catch (ProductException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else 
			return "null";
		return orderId;
	}
	public boolean validateManfacturingDate(Date manufacturing_date) {
		// TODO Auto-generated method stub
		if(manufacturing_date==null)
	      {
			return false;
	      }

	      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	      String Date=new SimpleDateFormat("MM/dd/yyyy").format(manufacturing_date);
	      sdf.setLenient(false);
	      try {
				
				Date date = sdf.parse(Date);
			
			} catch (ParseException e) 
	      {
				
				e.printStackTrace();
				return false;
			}	
			return true;
			
	}
	public boolean validateExpiryDate(Date manufacturing_date, Date expiry_date) {
		if(manufacturing_date==null || expiry_date==null)
	      {
			return false;
	      }
	      SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	      String Date1=new SimpleDateFormat("MM/dd/yyyy").format(manufacturing_date);
	      String Date2=new SimpleDateFormat("MM/dd/yyyy").format(manufacturing_date);
	      sdf.setLenient(false);
	      try 
	      {
				Date date1 = sdf.parse(Date1);
				Date date2 = sdf.parse(Date2);
				
			} 
	      catch (ParseException e) 
	      {	
				e.printStackTrace();
				return false;
			}	
	      try
   	      {
   	      if(expiry_date.compareTo(manufacturing_date)>0)
			{
				return true;
			}
			else 
			{
				throw new ProductException("No OrderId Exist");
			}
   	        }
	    	  catch(ProductException e)
	    	    {
	    	    	 System.out.println(e);
	    	    	 return false;
	    	    }
		
	}
	public ProductStock updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck)
	{
		//if(validateManfacturingDate( manufacturing_date) && validateExpiryDate( manufacturing_date,expiry_date))	
			try {
				return ps.updateProductStock(orderId,manufacturing_date, expiry_date, qualityCheck);
			} catch (ProductException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//else 
				//return null;
			return null;
		
	}
	public boolean doesProductOrderIdExistInStock(String orderId) {
		// TODO Auto-generated method stub
		return false;
	}
	
//	public boolean exitDateCheck(Date exitDate) {
//		// TODO Auto-generated method stub
//		return false;
//	}
	
	 
	 
}
