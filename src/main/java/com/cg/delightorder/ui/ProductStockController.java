package com.cg.delightorder.ui;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import com.cg.delightorder.service.ProductServiceImpl;

public class ProductStockController 
{
	public static void main(String[] args) throws ParseException 
	{
	ProductServiceImpl pss=new ProductServiceImpl();

    Scanner sc=new Scanner(System.in);
    
    System.out.println("1->TrackProductorder\n2->updateExitDate\n3->updateProductStock");
    System.out.println("Enter the choice");
    int choice=sc.nextInt();
    sc.nextLine();
    switch(choice)
    {
    case 1:
    {
    	 System.out.println("Enter orderId");
    	 String orderId=sc.nextLine();
    	 System.out.println(pss.doesProductOrderIdExist(orderId));
    	 System.out.println(pss.trackProductOrder(orderId));
    	 break;
    }
    case 2:
    {
    	 System.out.println("Enter Exit date in this format -> MM/dd/yyyy");
         String date=sc.nextLine();
         Date exitDate=new SimpleDateFormat("MM/dd/yyyy").parse(date); 
         System.out.println(pss.exitDateCheck(exitDate));
         System.out.println("Enter orderId");
         String orderId=sc.nextLine();
        System.out.println(pss.updateExitDateinStock(orderId,exitDate));
        break;
    }
    case 3:
    {
    	System.out.println("Enter Manufacturing date");
        String date1=sc.nextLine();
        Date manufacturing_date=new SimpleDateFormat("MM/dd/yyyy").parse(date1); 
        System.out.println(pss.validateManfacturingDate(manufacturing_date));
        System.out.println("Enter expiry date");
        String date2=sc.nextLine();
        Date expiry_date=new SimpleDateFormat("MM/dd/yyyy").parse(date2);
        System.out.println(pss.validateExpiryDate(manufacturing_date, expiry_date));
        System.out.println("Enter Quality Check");
        String qualityCheck=sc.nextLine();
        System.out.println("Enter OrderId");
        String orderId=sc.nextLine();
        System.out.println(pss.updateProductStock(orderId,manufacturing_date, expiry_date, qualityCheck));
        break;
    }
    default:
    {
    	System.out.println("Enter choice is invalid");
    	break;
    }
    }
    sc.close();	
	}
	
}
