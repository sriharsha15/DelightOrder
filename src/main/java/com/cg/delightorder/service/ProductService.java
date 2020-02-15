package com.cg.delightorder.service;

import java.util.Date;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;

public interface ProductService 
{
	public ProductStock trackProductOrder(String orderId) throws ProductException;
	public boolean doesProductOrderIdExist(String OrderId);
	public boolean exitDateCheck(ProductStock productStock);
	public String updateExitDateinStock(ProductStock productStock);
	public boolean validateManfacturingDate(Date manufacturing_date);
	public boolean validateExpiryDate(Date manufacturing_date,Date expiry_date);
	public String updateProductStock(ProductStock productStock);
	public boolean doesProductOrderIdExistInStock(String orderId);
}
