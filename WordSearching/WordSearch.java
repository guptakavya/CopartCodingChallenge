
import java.util.HashSet;

import java.util.List;

import java.util.Set;

import java.util.concurrent.ThreadLocalRandom;

public class WordSearch implements Driver {

	private int n;

	private final Set<String> result = new HashSet<>();

	private List<String> words;

	// Defining all the characters in the CHARS variable
	private static final char[] CHARS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'w', 'y', 'x', 'y', 'z' };

	// Text Characters for the given word puzzle

	private static final char[][] TEST_CHARS = {

			{ 'm', 'v', 'i', 'l', 'i', 'x', 'a', 'p', 'e' },

			{ 'j', 'h', 'b', 'x', 'e', 'e', 'n', 'p', 'p' },

			{ 'h', 'k', 't', 't', 'h', 'b', 's', 'w', 'y' },

			{ 'r', 'w', 'a', 'i', 'n', 'u', 'y', 'z', 'h' },

			{ 'p', 'p', 'f', 'x', 'r', 'd', 'z', 'k', 'q' },

			{ 't', 'p', 'n', 'l', 'q', 'o', 'y', 'j', 'y' },

			{ 'a', 'n', 'h', 'a', 'p', 'f', 'g', 'b', 'g' },

			{ 'h', 'x', 'm', 's', 'h', 'w', 'y', 'l', 'y' },

			{ 'u', 'j', 'f', 'j', 'h', 'r', 's', 'o', 'a' }

	};

	public WordSearch(List<String> words) {

		this.words = words;

	}

	public WordSearch(List<String> words, int n) {

		this.words = words;

		this.n = n;

	}

	public void resolve() {

		words.forEach(s -> {

			findWords(s, TEST_CHARS);

			findDiagonalWords(s, TEST_CHARS);

		}

		);

		result.forEach(System.out::println);

	}

	// Function to find words in the puzzle
	private void findWords(String s, char[][] chars) {
		// Convert the string to characters
		char[] charArray = s.toCharArray();

		int charArrayIndex = 0;
		// Constraint that length should be greater than 4
		if (s.length() < 4) {

			return;

		}

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i <= chars.length - 1; i++) {

			for (int k = 0; k < chars[i].length - 1; k++) {

				if (charArray[charArrayIndex] == chars[i][k]) {

					if (i != chars.length - 1 && charArray[charArrayIndex + 1] == chars[i + 1][k]) {

						String downWords = getDownWords(chars, s, k, i, builder);

						if (downWords.equals(s)) {

							result.add(downWords);

						}

						builder.delete(0, builder.length());

					}

					if (i != 0 && charArray[charArrayIndex + 1] == chars[i - 1][k]) {

						String upWords = getUpWords(chars, s, k, i, builder);

						if (upWords.equals(s)) {

							result.add(upWords);

						}

						builder.delete(0, builder.length());

					}

					if (k != chars[i].length - 1 && charArray[charArrayIndex + 1] == chars[i][k + 1]) {

						String rightWords = getRightWords(chars, s, k, i, builder);

						if (rightWords.equals(s)) {

							result.add(rightWords);

						}

						builder.delete(0, builder.length());

					}

					if (k != 0 && charArray[charArrayIndex + 1] == chars[i][k - 1]) {

						String LeftWords = getLeftWords(chars, s, k, i, builder);

						if (LeftWords.equals(s)) {

							result.add(LeftWords);

						}

						builder.delete(0, builder.length());

					}

				}

			}

		}

	}

	private String getLeftWords(char[][] chars, String s, int index, int line, StringBuilder builder) {

		int step = s.length();

		if (step <= index + 1) {

			while (step != 0) {

				builder.append(chars[line][index]);
				// Left Traversal
				index--;

				step--;

			}

		}

		return builder.toString();

	}

	private String getRightWords(char[][] chars, String s, int index, int line, StringBuilder builder) {

		int step = s.length();

		if (step + index <= chars[line].length) {

			while (step != 0) {

				builder.append(chars[line][index]);
				// Right traversal
				index++;

				step--;

			}

		}

		return builder.toString();

	}

	private String getUpWords(char[][] chars, String s, int index, int line, StringBuilder builder) {

		int step = s.length();
		// It should not be the first line
		// If not first line then,
		if (line - step >= 0) {

			while (step != 0) {

				builder.append(chars[line][index]);
				// Going Upwards
				line--;

				step--;

			}

		}

		return builder.toString();

	}

	private String getDownWords(char[][] chars, String s, int index, int line, StringBuilder builder) {

		int step = s.length();

		if (line + step <= chars.length) {

			while (step != 0) {

				builder.append(chars[line][index]);
				// Going Downwards
				line++;

				step--;

			}

		}

		return builder.toString();

	}

	private char[][] randomFilledArray() {

		char[][] return_array = new char[n][n];

		for (int i = 0; i <= return_array.length - 1; i++) {

			for (int j = 0; j <= return_array[i].length - 1; j++) {

				int index = ThreadLocalRandom.current().nextInt(0, CHARS.length);

				return_array[i][j] = CHARS[index];

			}

		}

		return return_array;

	}

	private void findDiagonalWords(String s, char[][] chars) {

		StringBuilder stringBuilder = new StringBuilder();

		int k = 0;

		for (int i = 0; i <= chars.length - 1; i++, k++) {

			if (k == i) {

				stringBuilder.append(chars[i][k]);

			}

		}

		boolean isFound =

				stringBuilder.toString().contains(s.toLowerCase()) || stringBuilder.reverse().toString()

						.contains(s.toLowerCase());

		if (isFound) {

			result.add(s);

		}

		backDiagonals(s, chars);

	}

	private void backDiagonals(String s, char[][] chars) {

		StringBuilder stringBuilder = new StringBuilder();

		int k = chars[0].length - 1;

		for (int i = 0; i <= chars.length - 1; i++, k--) {

			if (i + k == chars.length - 1) {

				stringBuilder.append(chars[i][k]);

			}

		}

		boolean isFound =

				stringBuilder.toString().contains(s.toLowerCase()) || stringBuilder.reverse().toString().contains(s.toLowerCase());

		if (isFound) {

			result.add(s);

		}

	}

}