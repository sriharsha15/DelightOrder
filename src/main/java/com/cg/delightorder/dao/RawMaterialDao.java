package com.cg.delightorder.dao;

import java.util.Date;

import com.cg.delightorder.dto.ProductStock;

public interface RawMaterialDao 
{
	public ProductStock trackProductOrder(String orderId);
	public String updateExitDateinStock(String orderId,Date exitDate);
	public String updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck);
	public boolean doesProductOrderIdExist(String orderId);
}
