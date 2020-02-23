package com.cg.delightorder.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.exception.ProductException;
import com.cg.delightorder.service.ProductServiceImpl;
import com.cg.delightorder.util.ProductRepository;



public class ProductServiceImplTest 
{
	ProductServiceImpl productServiceTest=new ProductServiceImpl();
	ProductRepository productRepository=new ProductRepository();
	@Test
	public void trackProductOrder() throws ProductException 
	{
		
		assertEquals(productServiceTest.trackProductOrder("A1"),productRepository.productlist.get("A1"));
		Throwable exception= assertThrows(ProductException.class,()->{productServiceTest.trackProductOrder("A7");});
		assertEquals("No OrderId Exist",exception.getMessage());
		Throwable exception1= assertThrows(ProductException.class,()->{productServiceTest.trackProductOrder(null);});
		assertEquals("No OrderId Exist",exception.getMessage());
	}
	@Test
	public void doesProductOrderIdExist() 
	{
		assertFalse(productServiceTest.doesProductOrderIdExist(null));
		assertFalse(productServiceTest.doesProductOrderIdExist("A7"));
		assertFalse(productServiceTest.doesProductOrderIdExist(null));
		assertTrue(productServiceTest.doesProductOrderIdExist("A1"));
	}
	@Test
	public void exitDateTest() throws ParseException, ProductException 
	{
		 String date="03/02/2020";
		 String date1="02/03/2020";
		 Date exitDate2=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
         Date exitDate=new SimpleDateFormat("MM/dd/yyyy").parse(date);
         Date exitDate1=null;
		 assertTrue(productServiceTest.exitDateCheck(exitDate));
		 assertFalse(productServiceTest.exitDateCheck(exitDate1));
		 Throwable exception= assertThrows(ProductException.class,()->{productServiceTest.exitDateCheck(exitDate2);});
		 assertEquals("Not a valid date",exception.getMessage());
		
	}
	@Test
	public void updateExistDate() throws ParseException, ProductException 
	{
		String date="03/02/2020";
		Date exitDate=new SimpleDateFormat("MM/dd/yyyy").parse(date);
		Date exitDate1=null;
		assertEquals(productServiceTest.updateExitDateinStock("A1", exitDate),"Data Inserted");
		assertEquals(productServiceTest.updateExitDateinStock("A1", exitDate1),"null");
	}
	@Test
	public void validateManufacturingDateTest() throws ParseException, ProductException 
	{
		 String date1="02/02/2020";
		 String date2="03/03/2020";
		 Date manufacturing_date1=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
         Date manufacturing_date2=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
		 assertTrue(productServiceTest.validateManfacturingDate(manufacturing_date1));
		 Throwable exception= assertThrows(ProductException.class,()->{productServiceTest.validateManfacturingDate(manufacturing_date2);});
		 assertEquals("Not a valid date",exception.getMessage());
		
	}
	@Test
	public void validateExpiryDateTest() throws ParseException, ProductException 
	{
		 String date1="02/02/2020";
		 String date2="03/03/2020";
		 String date3="01/02/2020";
		 String date4="03/01/2019";
		 String date5="03/03/2019";
		 String date6="03/02/2019";
		 Date manufacturing_date1=null;
         Date expiry_date1=null;
         Date manufacturing_date2=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
         Date expiry_date2=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
         Date manufacturing_date3=new SimpleDateFormat("MM/dd/yyyy").parse(date3); 
         Date expiry_date3=new SimpleDateFormat("MM/dd/yyyy").parse(date4);
         Date manufacturing_date4=null;
         Date expiry_date4=new SimpleDateFormat("MM/dd/yyyy").parse(date5);
         Date manufacturing_date5=new SimpleDateFormat("MM/dd/yyyy").parse(date6);
         Date expiry_date5=null;
         assertFalse(productServiceTest.validateExpiryDate(manufacturing_date1, expiry_date1));
         assertTrue(productServiceTest.validateExpiryDate(manufacturing_date2, expiry_date2));
         Throwable exception= assertThrows(ProductException.class,()->{productServiceTest.validateExpiryDate(manufacturing_date3, expiry_date3);});
         assertEquals("Not a valid date",exception.getMessage());
         assertEquals(productServiceTest.validateExpiryDate(manufacturing_date4, expiry_date4),false);
         assertEquals(productServiceTest.validateExpiryDate(manufacturing_date5, expiry_date5),false);
	}
	@Test
	public void updateProductStock() throws ParseException, ProductException 
	{
		 String date1="02/02/2020";
		 String date2="03/03/2020";
		 String date3="03/02/2020";
		 String date4="02/03/2020";
		 Date manufacturing_date=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
         Date expiry_date=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
         Date manufacturing_date1=null;
         Date expiry_date1=null;
         Date manufacturing_date2=new SimpleDateFormat("MM/dd/yyyy").parse(date3);
         Date expiry_date2=new SimpleDateFormat("MM/dd/yyyy").parse(date4);
         assertEquals(productServiceTest.updateProductStock("A1", manufacturing_date, expiry_date, "good"),"Data Inserted");
         assertEquals(productServiceTest.updateProductStock("A1", manufacturing_date1, expiry_date, "good"),"null");
         assertEquals(productServiceTest.updateProductStock("A1", manufacturing_date1, expiry_date1, "good"),"null");
         Throwable exception1= assertThrows(ProductException.class,()->{productServiceTest.updateProductStock("A1", manufacturing_date2, expiry_date1, "good");});
         assertEquals("Not a valid date",exception1.getMessage());
         assertEquals(productServiceTest.updateProductStock("A1", manufacturing_date, expiry_date1, "bad"),"null");
	}

}
