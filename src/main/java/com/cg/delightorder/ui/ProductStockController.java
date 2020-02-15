package com.cg.delightorder.ui;

import java.util.Date;
import java.util.Scanner;

import com.cg.delightorder.dto.ProductStock;
import com.cg.delightorder.service.ProductServiceImpl;

public class ProductStockController 
{
	public static void main(String[] args) 
	{
	ProductServiceImpl pss=new ProductServiceImpl();
    ProductStock ps=new ProductStock("A1","rice",1000,100,1,100000,"war1","good");
    ProductStock ps1=new ProductStock("A2","cloth",800,9,1,21000,"war2","bad");
    ProductStock ps2=new ProductStock("A3","bucket",200,80,10,32000,"war3","good");
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter orderId");
    String orderId=sc.nextLine();
    pss.addProductStock(ps2);
    pss.addProductStock(ps1);
    pss.addProductStock(ps);
    System.out.println(pss.doesProductOrderIdExist(orderId));
  
    System.out.println("Enter Exit date");
    Date d1=new Date(2020,03,27);
    
    ps.setExitDate(d1);
    sc.close();
    
	
	
	
	}
	
}
