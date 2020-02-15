package com.cg.delightorder.dao;

import java.util.Map;
import java.util.Map.Entry;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;
import com.cg.delightorder.util.ProductRepository;


public class ProductDao 
{
     ProductRepository productRepository=new ProductRepository();
     Map<String ,ProductStock> productlist=productRepository.getProductlist();
     
	 public boolean addProductStockDao(ProductStock obj) 
	  {
         
		 productRepository.addProductIntoList(obj);
		  return true;
	  }
	 
	 public ProductStock trackProductOrder(String orderId)throws ProductException
	 {
		 
   		    return productlist.get(orderId);
		 
		 
	 }
	 public boolean doesProductOrderIdExist(String orderId)
	 {
		 
		 for (Entry<String, ProductStock> mp:productlist.entrySet()) 
		 {
	            if (mp.getKey().contentEquals(orderId))
	            {
	            	return true;
	            }
         }
		 return false;
		 
	 }
	 
}
