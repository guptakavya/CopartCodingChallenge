package com.stock;

import java.util.ArrayList;

public class Plot
{
	public void printGraph(ArrayList<Double> data)
	{
		System.out.println("\n------------Graph for Stock1-------------");
		for(double val: data)
		{
			int price = (int) val;
			
			for(int i = 0; i < price; i++)
				System.out.print("*");
			
			System.out.println();
		}
	}	
}
