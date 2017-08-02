package com.stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class StockQuotes
{
	public void printData(ArrayList<Double> data)
	{
		System.out.println("----------Data For Stock1----------");
		for(double val: data)
		{
			System.out.println(val);
		}
	}

	
	public static void main(String[] args)
	{
		File file = new File("data.txt");
		Scanner sc;
		ArrayList<Double> data = new ArrayList<>();
		
		try
		{
			sc = new Scanner(file);
			while(sc.hasNextDouble())
			{
				data.add(sc.nextDouble());
			}
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!");
		}
		
//		StockQuotes stock1 = new StockQuotes();
//		stock1.printData(data);
//		
//		Plot plotStock1 = new Plot();
//		plotStock1.printGraph(data);
		
		Pattern pattern = new Pattern();
		pattern.quoteSuggestion(data);
	}

}
