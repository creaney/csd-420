package ReaneyModule3ProgrammingAssignment;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
*  Assignment: Module 3
*  Date: 03/28/2025
*  @author Christopher Reaney
* 
*  This class is used to generate one ArrayList that contains 50 numbers ranging
*       from 1-20. After which a method is called to remove duplicates and this
*       creates a new list of only unique values. 
*/
public class ALGetter {

    public static void main(String[] args) {
        //  Generates a stream of Integers from 1-20 that is 50 elements long
        //      and then stores in an ArrayList to be used later. All combined
        //      into a lambda, rather than using a longer method.
        ArrayList<Integer> originalArrayList = IntStream.generate(() -> ThreadLocalRandom.current().nextInt(1, 21)).limit(50).boxed().collect(Collectors.toCollection(ArrayList::new));

        // Call the removeDuplicates method with the ArrayList created above
        ArrayList<Integer> uniqueOnlyArrayList = removeDuplicates(originalArrayList);

        // Verify and display the results
        System.out.println("Original ArrayList: " + originalArrayList);
        System.out.println("Unique Values Only ArrayList: " + uniqueOnlyArrayList);
        System.out.println("Fun fact: The Unique Values ArrayList is " + uniqueOnlyArrayList.size() + " elements long.");
    }
    
    //  This method accepts an array and then removes any duplicates from it. 
    //      Ideally because there is 1-20, it would likely be ~20 elements long,
    //      but because of the random nature, it may not be.
    //  @param: list - The arraylist which is being parsed for duplicates
    //  @return: A list with only unique values.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueOnlyArrayList = new ArrayList<>();

        // Iterate through the original list in a for-each loop
        for(E item : list) {
            // If the item is not in the unique list, add it
            if (!uniqueOnlyArrayList.contains(item)) {
                uniqueOnlyArrayList.add(item);
            }
        }
        // Return the list with only unique values.
        return uniqueOnlyArrayList;
    }
}
