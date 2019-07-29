package org.com.automation.practise;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ObjectHandling 
{
	
	List<String> list=new ArrayList<String>();
	
	@Test
	public void test1()
	{
		list.add("ramesh");
		list.add("suresh");
		list.add("chandru");
		
		Object[][] data=new Object[2][2];
		
		for(int i=0;i<list.size();i++)
		{

			String str = list.get(i);
			data[0][0]=str;
		}
		
		for(Object obj1:data)
		{
			System.out.println(obj1);
		}
		
	}
	
	
	
	 
	
	

}
