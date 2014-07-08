#Occurrence Calculator

This is a simple Java program to sort the frequency of lines
in a text file. They are sorted in descending order.

##Files
The implementation is in 2 files
+ Main.java the main file, entry point
+ OccurrenceCalculater.java - responsible for file handling and calculations.
+ Various test file

##The Implementation
My approach was as following
+ read each line from the text file
+ input the line in the map
+ when finished the, put the map in a comparator with overridden compare function to compare the values of the map
+ the above will sort the map
+ put the map in an empty TreeMap, We can reuse the above map if space is of concern.
+ output the treemap, it will be sorted
	
##Limitations

This method is limited in the following cases.
+ If a file contains empty lines, it will output their occurrence

##Enjoy!!