package com.cg.delightorder.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.cg.delightorder.exception.ProductException;
import com.cg.delightorder.service.ProductService;
import com.cg.delightorder.service.ProductServiceImpl;

public class ProductStockController 
{
	public static void main(String[] args) throws ParseException, ProductException 
	{
    Scanner scan=new Scanner(System.in);
	ProductService productService=new ProductServiceImpl();
    while(true)
    {	
    System.out.println("*********************************Welcome to DelightOrder*********************************");
    System.out.println("\nPlease Enter the choice\n");
    System.out.println("1==TrackProductorder\n2==updateExitDate\n3==updateProductStock");
    String choice=scan.nextLine();
    switch(choice)
    {
    case "1":
    {
    	 while(true)
    	 {
    	 System.out.println("Enter orderId");
    	 String orderId=scan.nextLine();
    	 try {
    	 System.out.println(productService.trackProductOrder(orderId));
    	 
         break;
    	 }
    	 catch(ProductException exception)
    	 {
    		 System.out.println(exception.getMessage());
    	 }
    }
    	 break;
    }
    case "2":
    {
    	while(true)
    	{
    	 System.out.println("Enter Exit date in this format -> MM/dd/yyyy");
         String date=scan.nextLine();
         try
         {
         Date exitDate=new SimpleDateFormat("MM/dd/yyyy").parse(date); 
         System.out.println(productService.exitDateCheck(exitDate));
         System.out.println("Enter orderId");
         String orderId=scan.nextLine();
         System.out.println(productService.updateExitDateinStock(orderId,exitDate));
         break;
         }
         catch(ProductException exception)
         {
        	 System.out.println(exception.getMessage());
         }
         catch(ParseException exception)
         {
        	 System.out.println("Invalid date");
         }
    }
    	break;
    }
    case "3":
    {
    	while(true)
    	{
    	System.out.println("Enter Manufacturing date in this format -> MM/dd/yyyy");
        String date1=scan.nextLine();
        try {
        Date manufacturing_date=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
        System.out.println(productService.validateManfacturingDate(manufacturing_date));
        System.out.println("Enter expiry date in this format -> MM/dd/yyyy");
        String date2=scan.nextLine();
        Date expiry_date=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
        System.out.println(productService.validateExpiryDate(manufacturing_date, expiry_date));
        System.out.println("Enter Quality Check");
        String qualityCheck=scan.nextLine();
        System.out.println("Enter OrderId");
        String orderId=scan.nextLine();
        System.out.println(productService.updateProductStock(orderId,manufacturing_date, expiry_date, qualityCheck));
        break;
        }
        catch(ProductException exception)
        {
        	System.out.println(exception.getMessage());
    
        }
        catch(ParseException exception)
        {
       	 System.out.println("Invalid date");
        }
    	}
    	break;
    }
    
    default:
    {
    	System.out.println("Enter choice is invalid");
    	break;
    }
    }
   	}
	}
}
