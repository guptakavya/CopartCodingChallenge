import java.util.ArrayList;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// Start-Time at the start of program
		long startTime = System.currentTimeMillis();

		System.out.print("Enter a string to find the longest repeating subsequence ");

		// Get input string from the user
		Scanner input = new Scanner(System.in);
		// Get the next substring of the string
		String temp = input.next();
		// Storing the list in subsequence
		ArrayList<String> subsequence = Substring.LongestRepeatedSubstring(temp);

		System.out.println("Longest Repeated Substring is: " + subsequence);

		// End time for the program execution
		long endTime = System.currentTimeMillis();
		//Total Time
		long totalTime = endTime - startTime;
		System.out.println(totalTime);

	}

}