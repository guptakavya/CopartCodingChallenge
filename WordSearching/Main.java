import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		// Start-Time at the start of program
		long startTime = System.currentTimeMillis();
		Driver resolver = new WordSearch(
				Arrays.asList("algorithm", "syzygys", "ansyzy", "epyhqy", "qwerty", "uxhlr"));

		resolver.resolve();
		// End time for the program execution
		long endTime = System.currentTimeMillis();
		// Total Time
		long totalTime = endTime - startTime;
		System.out.println("Total executiion time:" +totalTime +" millisec");

	}
}
