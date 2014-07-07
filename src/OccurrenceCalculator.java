import java.io.BufferedReader;
/** 
 * OccurrenceCalculator deals with file handling and sorting the text occurrence 
 * as it reads line by line. Then it outputs the sorted occurrences
 * 
 * @author Tremayne
 *
 */
public class OccurrenceCalculator {
	/**
	 * The reader associated with the input text file.
	 */
	BufferedReader reader;
	 /**
	  * Constructor assigns the reader
	  * 
	  * @param reader the buffered reader associated with the input text file
	  */
	public OccurrenceCalculator(BufferedReader reader) {
		this.reader = reader;
	}

}