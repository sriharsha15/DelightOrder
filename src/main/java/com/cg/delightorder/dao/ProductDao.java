package com.cg.delightorder.dao;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.util.ProductRepository;

public class ProductDao implements RawMaterialDao
{
     ProductRepository productRepository=new ProductRepository();
     Map<String, ProductStock> productlist=productRepository.getProductlist();
	 public ProductStock trackProductOrder(String orderId)
	 {
		 for (Entry<String, ProductStock> map:productlist.entrySet()) 
		 {
	            if (map.getValue().getOrderId().contentEquals(orderId))
	            {
		 
		         return productlist.get(orderId);
	            }
	          
		 }
		 return null;
	 }
	 public boolean doesProductOrderIdExist(String orderId) 
	 {
		 
		 for (Entry<String, ProductStock> map:productlist.entrySet()) 
		 {
	            if (map.getValue().getOrderId().contentEquals(orderId))
	            {
	            	return true;
	            }
		 }
		 return false;
	 }
	 public String updateExitDateinStock(String orderId,Date exitDate) 
	 {
		 for (Entry<String,ProductStock> map:productlist.entrySet()) 
		 {
			 if (map.getValue().getOrderId().equals(orderId))
			 {
	           map.getValue().setExitDate(exitDate);      
             }
			 
		 }
		 return "Data Inserted";
	 }
	 public String updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck)
	 { 
		 for (Entry<String , ProductStock> map:productlist.entrySet()) 
		 {
			 if (map.getValue().getOrderId().contentEquals(orderId))
			 {
	           map.getValue().setManufacturingDate(manufacturing_date);
	           map.getValue().setExpiryDate(expiry_date);
	           map.getValue().setQualityCheck(qualityCheck);
			 }
		 }
		 return "Data Inserted";
	 }
	
}
