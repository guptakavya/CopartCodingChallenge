package com.stock;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pattern
{
	public void quoteSuggestion(ArrayList<Double> data)
	{
		System.out.println("\n----------Suggestions for stock1-------------");
		// up-down trend count
		int upCount = 0, downCount =0;
		String stock =  "";
		DecimalFormat df = new DecimalFormat("0.000");
		
		
		for(int i = 0; i < data.size(); i++)
		{
			stock = (i+1)+"\t"+df.format(data.get(i));
			
			if(i > 0)
			{
				// check for up trend
				if(data.get(i) > data.get(i-1))
				{
					upCount++;
					// check for shift to up trend after at least 3 down trend and suggest
					if(downCount >= 3)
					{
						stock += "\t\t" + "Buy";
					}
					downCount = 0;		//reset down trend
				}
				//check for down trend
				else if(data.get(i) < data.get(i-1))
				{
					downCount++;
					// check for shift to down trend after at least 3 up trend and suggest
					if(upCount >= 3)
					{
						stock += "\t\t" + "Sell";
					}
					upCount = 0;		//reset up trend
				}
			}
			System.out.println(stock);
			stock = "";
		}
	}
}
