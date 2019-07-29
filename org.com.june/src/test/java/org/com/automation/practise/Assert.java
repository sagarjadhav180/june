package org.com.automation.practise;

public class Assert
{
	
	public static int n=3;
	
	public static int getn()
	{
		
		return n;
		
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		
		for(int i=0;i<20;i++)
		{
			if(n>0)
			{
			System.out.println(getn());
			}
			n--;
		
			
		}
		
	}

}
