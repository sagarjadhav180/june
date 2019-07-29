package org.com.automation.practise;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BusinessLogic
{
	
	
	static Set set;
	
	public static void main(String[] args)
	{
		Sort sort=new Sort();
		set=new TreeSet(sort);
		
		set.add(new Student(41,"ramesh",'m'));
		set.add(new Student(43,"stella",'f'));
		
	 
		
		
		for(Object one:set)
		{
			System.out.println(one);
		}
		
		System.out.println("------------------------------------------------------");
		set=new HashSet();
		
//		set.add(20);
//		set.add(50);
		set.add(new Student(41,"ramesh",'m'));
		set.add(new Student(43,"stella",'f'));
		
		System.out.println(set);
		
		
	}

}
