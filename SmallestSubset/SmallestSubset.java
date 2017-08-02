package com.subset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SmallestSubset
{
	//Logic for finding smallest subset
	public int[] findSubset(int[] nums, int val)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		int sum = 0;
		
		for(int i = nums.length; i > 0; i--)
		{
			// Check if running sum exceeded given value else add to resultset
			if(sum > val)
				break;
			else
			{
				sum += nums[i-1];
				ans.add(nums[i-1]);
			}
		}
		
		//Converting arraylist to array of int
		int[] result = new int[ans.size()];
		for(int i = 0; i < ans.size(); i++)
		{
			result[i] = ans.get(i);
		}
		return result;
	}
	
	//Printing result on console
	public void printResult(int[] nums)
	{
		String display="";
		for(int i: nums)
		{
			display += ","+i;
		}
		System.out.println(display.substring(1));
	}
	
	public static void main(String[] args) throws IOException
	{
		// local variables used in reading
		File file = new File("Sample.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		String[] input = new String[2];
		String line;
		int val, i=0;
		
		while (( line = br.readLine()) != null) {
			input[i] = line;
			i++;
		}
		
		//closing readers
		if (br != null)
			br.close();

		if (fileReader != null)
			fileReader.close();
		
		// setting value from file
		val = Integer.parseInt(input[0]);
		String[] strVals = input[1].split(",");
		
		//Setting array from file
		int[] nums = new int[strVals.length];
		for(int j = 0; j <nums.length; j++)
		{
			nums[j] = Integer.parseInt(strVals[j]);
		}
		
		SmallestSubset obj = new SmallestSubset();
		Arrays.sort(nums);
		obj.printResult(obj.findSubset(nums, val));
	}

}
