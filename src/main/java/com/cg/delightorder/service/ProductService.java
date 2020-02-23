package com.cg.delightorder.service;

import java.util.Date;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;


public interface ProductService 
{
	public ProductStock trackProductOrder(String orderId)throws ProductException;
	public boolean doesProductOrderIdExist(String OrderId);
	public boolean exitDateCheck(Date exitDate)throws ProductException;
	public String updateExitDateinStock(String orderId,Date exitDate)throws ProductException;
	public boolean validateManfacturingDate(Date manufacturing_date)throws ProductException;
	public boolean validateExpiryDate(Date manufacturing_date,Date expiry_date)throws ProductException;
	public String updateProductStock(String orderId,Date manufacturing_date,Date expiry_date,String qualityCheck)throws ProductException;
	
}
