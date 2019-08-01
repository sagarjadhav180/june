package org.com.automation.practise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class pattern_programing {

	
	@Test(enabled=false)
	public void test1(){
		int row=3;
		int star=1;
		int hash=5;
		
		for(int i=1;i<=row;i++){
			
			for(int j=1;j<=hash;j++){
				
				if(i==1 && j==1 || i==2 && j>3 || i==3 && j<4){
					System.out.print("*");
				}
				else{
		System.out.print("#");
				}
			}
			
			
			
			System.out.println();
		}


			
	}
	
	@Test(enabled=false)
	public void test2(){
		int row=5;
		int star=5; 
		int space=0;
		
		for(int i=0;i<=row;i++){
			
			for(int k=0;k<=space;space++){
				System.out.print(" "); 
			}
			
			for(int j=1;j<=star;j++){
				System.out.print("*");
			}  
			
			System.out.println(); 
			star--;
			space++;
		}
		 
	}	
	
	@Test(enabled=false)
	public void test3()
	{
		int star=5;
		int space=0; 
		int row=5;
		int mid=(row/2);
	int test;	
		
		for(int i=1;i<=row;i++){
			
			for(int j=0;j<=space;j++){
				System.out.print(" ");
			}
			
			for(int k=1;k<=star;k++){
				System.out.print("*");
			}
			System.out.println();
			if(i<=mid){
			star=star-2;
			space++;
			}
			else{
				star=star+2;
				space--;
			
			}
			
		}
			
		
	}
	
	
	@Test(enabled=false)
	public void test4(){
	
		int star=1;
		int row=5;
		
		for(int i=1;i<=row;i++){
			for(int j=1;j<=star;j++){
				
				System.out.print("*");
			}
			
			star=star+2;
			System.out.println();
		}
		
	}
	
	
	@Test(enabled=false)
	public void test5(){
		
		int row=5;
		int star=5;
		int space=0;
		int mid=(row+1)/2;
		
		for(int i=1;i<=row;i++){
			
			for(int j=0;j<=space;j++){
				System.out.print(" ");
			}
			for(int k=1;k<=star;k++){
				System.out.print("*");
			}
			System.out.println();
			if(i<mid){
				space++;
				star=star=star-2;
			}
			else if(i>=mid){
				space--;
				star=star=star+2;
			}
		}
	}	
	
	@Test(enabled=false)
	public void test6(){
		
		int row=5;
		int star=5;
		int space=0;
		int mid=(row+1)/2;
		
		for(int i=1;i<=row;i++){
			
			for(int j=0;j<=space;j++){
				System.out.print(" ");
			}
			for(int k=1;k<=star;k++){
				System.out.print("*");
			}
			System.out.println();
			if(i<mid){
				star=star-2;
				space=space+2;
			}
			else if(i>=mid){
				star=star+2;
				space=space-2;
			}
		}
	}	
	
	
	
	
	
}
