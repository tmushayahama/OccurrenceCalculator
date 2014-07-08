import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * This is the main class of the Occurrence Calculator. It calls the OccurrenceCalculator 
 * to deal with file Handling and sorting then it outs the sorted occurrences.
 * 
 * @requires The input file should have text per line
 * 
 * @author Tremayne
 * 
 */
public class Main {

	/** This is the main of the program. It puts the file in the buffered reader
	 * 
	 * @param args the file path of the file where the occurrences are to be read
	 * @requires The input text file should have text separated by newline
	 */
	public static void main(String[] args) {
		BufferedReader fileReader;

		try {
			fileReader = new BufferedReader(new FileReader(args[0]));
			OccurrenceCalculator occurrenceCalculator = new OccurrenceCalculator(
					fileReader);
			occurrenceCalculator.populateOccurrenceMap();
			occurrenceCalculator.sortAndOutputOccurrenceMap();
		} catch (IOException ioe) {
			System.out.println("File not found");
			System.exit(1);
		}

	}

}
