import java.util.ArrayList;

import java.util.Arrays;

import java.util.Iterator;

public class Substring {

	public static ArrayList<String> LongestRepeatedSubstring(String input) {

		// If no input by the user
		if (input == null || input.isEmpty()) {
			return null;

		} else {
			// Length of the string
			int length = input.length();
			
			String[] string_array = new String[length];
			for (int i = 0; i < length; i++) {
				// Storing the string characters in array
				string_array[i] = input.substring(i);

			}

			Arrays.sort(string_array);

			String result = "";
			ArrayList<String> result_list = new ArrayList<String>();
			for (int i = 0; i < length - 1; i++) {

				String longestsequence = GetLongestCommonString(string_array[i], string_array[i + 1]);
				if (longestsequence.length() >= result.length()) {

					result = longestsequence;

					if (!result_list.contains(longestsequence)) {

						result_list.add(longestsequence);

					}

				}

			}

			Iterator<String> results = result_list.iterator();

			while (results.hasNext()) {

				String s = results.next();

				if (s.length() < result.length())

					results.remove();

			}

			return result_list;

		}

	}

	private static String GetLongestCommonString(String a, String b)

	{

		String output = "";

		int max_compare = Math.min(a.length(), b.length());
		for (int i = 0; i < max_compare; i++) {

			if (a.charAt(i) == b.charAt(i)) {

				output = output + a.charAt(i);

			}

			else {

				break;

			}

		}

		return output;

	}

}