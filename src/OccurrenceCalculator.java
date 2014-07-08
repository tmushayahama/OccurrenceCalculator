import java.io.BufferedReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * OccurrenceCalculator deals with file handling and sorting the text occurrence
 * as it reads line by line. Then it outputs the sorted occurrences
 * 
 * @author Tremayne
 * 
 */
public class OccurrenceCalculator {
	/**
	 * A comparator class to help sort the values of the occurrence map. It
	 * sorts by overriding the the compare function to sort by comparing the
	 * values of the map.
	 * 
	 */
	static class OccurrenceComparator implements Comparator<String> {

		Map<String, Integer> occurrenceMapBase;

		OccurrenceComparator(Map<String, Integer> occurrenceMapBase) {
			this.occurrenceMapBase = occurrenceMapBase;
		}

		/**
		 * Compares the values of a map. If the values are equal, it then
		 * compares the keys For descending order, a quick approach was to
		 * multiply by -1. Needs some improvement
		 * 
		 * @param a
		 *            the first value to be compared
		 * @param b
		 *            the second value to be compared
		 */
		@Override
		public int compare(String a, String b) {

			Integer firstInt = this.occurrenceMapBase.get(a);
			Integer secondInt = this.occurrenceMapBase.get(b);
			if (firstInt.equals(secondInt)) {
				return a.compareTo(b) * -1;
			}
			return firstInt.compareTo(secondInt) * -1;
		}
	}

	/**
	 * The reader associated with the input text file.
	 */
	BufferedReader reader;
	/**
	 * The map where the occurrences of strings are populated in.
	 */
	Map<String, Integer> occurrenceMap;

	/**
	 * Sort the values of the map in a descending order
	 */
	OccurrenceComparator occurrenceComparator;

	/**
	 * A sorted map for outputting the occurrence map
	 */
	Map<String, Integer> sortedOccurrenceMap;

	/**
	 * Constructor assigns the reader
	 * 
	 * @param reader
	 *            the buffered reader associated with the input text file
	 */
	public OccurrenceCalculator(BufferedReader reader) {
		this.reader = reader;
		this.occurrenceMap = new HashMap<String, Integer>();
		this.occurrenceComparator = new OccurrenceComparator(occurrenceMap);
		this.sortedOccurrenceMap = new TreeMap<String, Integer>(
				this.occurrenceComparator);
	}

	/**
	 * Adds a string key to the map. If a string key is new in the map, it will
	 * have an occurrence of 1 else it will increment it by one
	 * 
	 * @param line
	 *            the string being added to the map
	 */
	private void addToOccurrenceMap(String line) {
		if (this.occurrenceMap.containsKey(line)) {
			this.occurrenceMap.put(line, this.occurrenceMap.get(line) + 1);
		} else {
			this.occurrenceMap.put(line, 1);
		}
	}

	/**
	 * Populates the occurrenceMap by reading string per line and putting it to
	 * the map
	 * 
	 * @throws IOException if the reader doesn't close
	 */
	public void populateOccurrenceMap() throws IOException {
		String line;
		try {
			while ((line = this.reader.readLine()) != null) {
				this.addToOccurrenceMap(line);
			}
		} catch (IOException e) {
			System.out.println("Error reading the file");
			System.exit(1);
		} finally {
			reader.close();
		}
	}

	/**
	 * Sorts and outputs the map in descending order
	 */
	public void sortAndOutputOccurrenceMap() {
		this.sortedOccurrenceMap.putAll(this.occurrenceMap);
		for (String key : this.sortedOccurrenceMap.keySet())
			System.out.println(key + ": " + this.sortedOccurrenceMap.get(key));
	}

}