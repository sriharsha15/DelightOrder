package com.cg.delightorder.dao;

import com.cg.delightorder.dto.ProductStock;

public interface RawMaterialDao 
{
	public String trackProductOrder(ProductStock productStock);
	public boolean processDateCheck(ProductStock productStock);
	public String updateExitDateinStock(ProductStock productStock);
	public String updateProductStock(ProductStock productStock);
	public boolean doesProductOrderIdExistInStock(String orderId);
}
