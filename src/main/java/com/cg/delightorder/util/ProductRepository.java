package com.cg.delightorder.util;



import java.util.HashMap;
import java.util.Map;

import com.cg.delightorder.dto.ProductStock;

public class ProductRepository
{

 Map<String, ProductStock> productlist=new HashMap<String,ProductStock>();
	
	/**
 * @param productlist the productlist to set
 */
public void setProductlist(Map<String, ProductStock> productlist)
{
	this.productlist = productlist;
}

	public Map<String,ProductStock> getProductlist() 
	{
		return productlist;
	}

public ProductRepository()
{
   productlist.put("A1",new ProductStock("A1","rice",1000,100,1,100000,"war1"));
   productlist.put("A2",new ProductStock("A2","cloth",800,9,1,21000,"war2"));
   productlist.put("A3",new ProductStock("A3","bucket",200,80,10,32000,"war3"));

	}
}
