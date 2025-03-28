package ReaneyModule4ProgrammingAssignment;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
*  Assignment: Module 4
*  Date: 03/28/2025
*  @author Christopher Reaney
* 
*  This class is used to generate a LinkedList of two different sizes (50,000), 
*       (500,000). Then using these lists, they are traversed with both an iterator
*       and get(index) methods. At the same time, they are monitored for how long they 
*       take to execute so that it can be compared. 
*/
public class IteratorVsGetIndex {

    public static void main(String[] args) {

        System.out.println("This method creates and parses through LinkedLists");
        System.out.println("that are filled with x number of Integers. Two passes");
        System.out.println("will occur. One for 50,000 ints, and one for 500,000.\n");

        System.out.println("Now running for 50,000 Integers...\n");
        IteratorVsGetIndexTest(50000);

        System.out.println("Now running for 500,000 Integers (this may take a while)...\n");
        IteratorVsGetIndexTest(500000);

//      The Iterator method will 99.99% of the time be faster in cases like these. 
//      Iterator is much more efficient when dealing with LinkedLists. It uses a 
//      pointer that refers to each element directly when traversing. The iterator
//      can move directly to the next element and doesn't need to start back at the
//      beginning to figure out where it is, which is what happens in the get(index)
//      case. The iterator moves in constant time for LinkedList (O(1)), where 
//      getIndex gets slower the bigger the dataset is (O(n)). That's why the 
//      second run of this class takes so long. 
    }
        
    /*
    *   This method accepts a number that dictates the size of a LinkedList that
    *       it will create. The LinkedList is then parsed and this parsing is timed
    *       to see which of the two methods used are quickest. 
    *   @param: sizeOfList, the size of the list to be created, as an integer.
    */
    public static void IteratorVsGetIndexTest(int sizeOfList){
        // Create a LinkedList to store integers using a lambda. The size of 
        //      the list is passed as a parameter in this method. 
        LinkedList<Integer> linkedList = IntStream.generate(() -> ThreadLocalRandom.current().nextInt()).limit(sizeOfList).boxed().collect(Collectors.toCollection(LinkedList::new));

        // Test the time to parse the list using an iterator
        long startTime = System.currentTimeMillis();
        ListIterator<Integer> iterator = linkedList.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        long endTime = System.currentTimeMillis();
        
        long iteratorTotalTime = (endTime - startTime);

        // Test the time to parse the list using the get(index) method
        startTime = System.currentTimeMillis();
        for (int i = 0; i < linkedList.size(); i++) {  
            linkedList.get(i); 
        }       
        endTime = System.currentTimeMillis();
        
        long getIndexTotalTime = (endTime - startTime);

        //  Print the values for this run of the method, showing the length
        //      of the list that was parsed. 
        System.out.println("Amount of time for Iterator method using " + sizeOfList + " integers: " + iteratorTotalTime + " milliseconds.");
        System.out.println("Amount of time for Iterator method using " + sizeOfList + " integers: " + getIndexTotalTime + " milliseconds.");
       
        //  Check which was faster (should pretty much always be the iterator method.)
        if (iteratorTotalTime < getIndexTotalTime) {
            System.out.println("The Iterator method was faster for " + sizeOfList + " integers.\n");
        } else if (getIndexTotalTime < iteratorTotalTime) {
            System.out.println("The get(index) method was faster for " + sizeOfList + " integers.\n");
        } else {
            System.out.println("Both methods took the same amount of time for " + sizeOfList + " integers.\n");
        }     
    }    
}
