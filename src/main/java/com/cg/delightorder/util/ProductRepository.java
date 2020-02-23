package com.cg.delightorder.util;



import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.cg.delightorder.dto.ProductStock;

public class ProductRepository
{

 public static Map<String, ProductStock> productlist=new HashMap<String,ProductStock>();
	
	/**
 * @param productlist the productlist to set
 */
public static void setProductlist(Map<String, ProductStock> productlistref)
{
	productlist = productlistref;
}

	public Map<String,ProductStock> getProductlist() 
	{
		return productlist;
	}

static
{
   productlist.put("A1",new ProductStock("A1","Chair",1000,100,1,100000,"war1",new Date(2020,02,18)));
   productlist.put("A2",new ProductStock("A2","Table",800,9,1,21000,"war2",new Date(2020,02,17)));
   productlist.put("A3",new ProductStock("A3","Bucket",200,80,10,32000,"war3",new Date(2020,02,16)));
   productlist.put("A4",new ProductStock("A4","Bag",800,9,1,21000,"war2",new Date(2020,02,17)));
   productlist.put("A5",new ProductStock("A5","Box",200,80,10,32000,"war3",new Date(2020,02,16)));
	}
}
