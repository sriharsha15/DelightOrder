package com.cg.delightorder.daotest;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Date;

import org.junit.jupiter.api.Test;

import com.cg.delightorder.dao.ProductDao;

import com.cg.delightorder.util.ProductRepository;

public class ProductDaoTest 
{
	ProductDao productDaoTest=new ProductDao();
	ProductRepository productRepository=new ProductRepository();
	@Test
	public void trackProductOrderTest() 
	{
		assertEquals(productDaoTest.trackProductOrder("A1"),ProductRepository.productlist.get("A1"));
		assertEquals(productDaoTest.trackProductOrder("A7"),null);
	}
	@Test
	public void updateExitDateTest() 
	{
		
		Date exitDate=new Date();
		assertEquals(productDaoTest.updateExitDateinStock("A1", exitDate),"Data Inserted");
	}
	@Test
	public void updateProductStockTest() 
	{
		Date expiry_date=new Date();
		Date manufacturing_date=new Date();
		assertEquals(productDaoTest.updateProductStock("A1", manufacturing_date, expiry_date, "good"),"Data Inserted");
	}
	@Test
	public void doesProductOrderIdExistTest () 
	{
		assertEquals(productDaoTest.doesProductOrderIdExist("A1"),true);
		assertEquals(productDaoTest.doesProductOrderIdExist("A7"),false);
	}
	
}
