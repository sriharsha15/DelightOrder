package com.cg.delightorder.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;

import com.cg.delightorder.service.ProductServiceImpl;



public class DateTest 
{
	ProductServiceImpl obj=new ProductServiceImpl();
	@Test
	public void testDateIsNull() 
	{
		
		assertEquals(obj.exitDateCheck(new SimpleDateFormat("MM/dd/yyyy").format(12/04/2004)), "yyyy/MM/dd");
	}

	@Test
	public void testDayIsInvalid() {
		assertFalse(obj.exitDateCheck( ), "dd/MM/yyyy");
	}

	@Test
	public void testMonthIsInvalid() 
	{
		assertFalse(obj.exitDateCheck("3/20/2012"), "dd/MM/yyyy");
	}

	@Test
	public void testYearIsInvalid() 
	{
		assertFalse(obj.exitDateCheck("02/29/19991"), "MM/dd/yyyy");
	}

	@Test
	public void testDateIsValid()
	{
		assertTrue(obj.exitDateCheck("02/29/2012"),"dd/MM/yyyy");
	}

}
