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
			System.out.printf("%.3f\n",val);
		}
	}

	
	public static void main(String[] args)
	{
		// local variables used in reading
		long start_time=System.currentTimeMillis();
		File file = new File("data.txt");
		Scanner sc;
		ArrayList<Double> data = new ArrayList<>();		//stock data
		
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
		
		StockQuotes stock1 = new StockQuotes();
		stock1.printData(data);
		
		Plot plotStock1 = new Plot();
		plotStock1.printGraph(data);
		
		Pattern pattern = new Pattern();
		pattern.quoteSuggestion(data);
		
		long end_time=System.currentTimeMillis();
		long total_time= end_time- start_time;
		System.out.println("\nTime: "+total_time+" ms");
	}

}
