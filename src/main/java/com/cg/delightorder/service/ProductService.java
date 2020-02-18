package com.cg.delightorder.service;

import java.util.Date;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;

public interface ProductService 
{
	public ProductStock trackProductOrder(String orderId);
	public boolean doesProductOrderIdExist(String OrderId);
	public boolean exitDateCheck(Date exitDate);
	public String updateExitDateinStock(String orderId,Date exitDate);
	public boolean validateManfacturingDate(Date manufacturing_date);
	public boolean validateExpiryDate(Date manufacturing_date,Date expiry_date);
	public ProductStock updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck);
	public boolean doesProductOrderIdExistInStock(String orderId);
}
