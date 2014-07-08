import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	 * The storage of occurrence of strings
	 */
	Map<String, Integer> occurrenceMap;

	/**
	 * Constructor assigns the reader
	 * 
	 * @param reader
	 *            the buffered reader associated with the input text file
	 */
	public OccurrenceCalculator(BufferedReader reader) {
		this.reader = reader;
		this.occurrenceMap = new HashMap<String, Integer>();
	}

	/**
	 *  Populates the occurrenceMap by reading string per line and putting it to the map
	 */
	public void populateOccurrenceMap() {
		String line;
		try {
			while ((line = this.reader.readLine()) != null) {
				this.addToOccurrenceMap(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading the file");
			System.exit(1);
		}
	}

	/**
	 *  Adds a string key to the map. If a string key is new in the map, it will have an occurrence of
	 *  1 else it will increment it by one
	 * @param line the string being added to the map
	 */
	private void addToOccurrenceMap(String line) {
		if (this.occurrenceMap.containsKey(line)) {
			this.occurrenceMap.put(line, this.occurrenceMap.get(line)+1);
		} else {
			this.occurrenceMap.put(line, 1);
		}
	}
	/**
	 * Outputs the map 
	 * Checking before sorting
	 */
	public void outputOccurrenceMap() {
		for(String key: this.occurrenceMap.keySet())
			System.out.println(key+": "+this.occurrenceMap.get(key));
	}

}