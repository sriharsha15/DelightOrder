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
public void setProductlist(Map<String, ProductStock> productlist) {
	this.productlist = productlist;
}

	public Map<String,ProductStock> getProductlist() {
		return productlist;
	}


 
	public void addProductIntoList(ProductStock product)
	{
		productlist.put(product.getOrderId(),product);
	}
	
}
