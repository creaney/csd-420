package ReaneyModule5ProgrammingAssignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.TreeSet;

/**
*  Assignment: Module 5
*  Date: 04/05/2025
*  @author Christopher Reaney
* 
*  This class is used to read words from a file, remove any duplicates, 
*       and then display them sorted in ascending and then descending order.
*/
public class NonDuplicateWordSorter {

    public static void main(String[] args) {
        System.out.println("This application is used to read words from a given text file");
        System.out.println("and then remove duplicates, and print out the non-duplicates");
        System.out.println("in ascending and then descending order.\n");
        
        String fileName = "collection_of_words.txt";
        // Read the words from the file into a TreeSet (to automatically remove duplicates)
        //      TreeSet sorts automatically in ascending order.
        TreeSet<String> wordSet = new TreeSet<>(); 

        try {
            // Read all lines from the provided file
            System.out.println("Now reading from the text file...\n");
            List<String> lines = Files.readAllLines(Paths.get(fileName));

            for (String line : lines) {
                // Split each line into words
                String[] words = line.split("\n");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        // Change all words to lowercase in case there are "case" differences
                        wordSet.add(word.toLowerCase()); 
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }

        // Display words in ascending order, since TreeSet already sorts them
        //      that way.
        System.out.println("Now printing words in ascending order:");
        wordSet.forEach(System.out::println);

        // Use a new TreeSet and reverse the order with descendingSet
        System.out.println("\nNow printing words in descending order:");
        TreeSet<String> reversedWordSet = new TreeSet<>(wordSet.descendingSet());
        reversedWordSet.forEach(System.out::println);
    }
}
