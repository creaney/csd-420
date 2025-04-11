package ReaneyModule6ProgrammingAssignment;

import java.util.Comparator;

/**
*  Assignment: Module 6
*  Date: 04/11/2025
*  @author Christopher Reaney
* 
*  This class is used to create a few arrays, and then sort them using Bubble Sort
*/
public class BubbleSorter {

    public static void main(String[] args) {
        System.out.println("This program creates an array of numbers that will then");
        System.out.println("be printed and sorted using two different methods:");
        System.out.println("comparable and comparator (in that order).");
        System.out.println("\n Each of the sorts will show what numbers are being swapped");
        System.out.println("as it happens, so that the workings of the bubble sorts can");
        System.out.println("be more easily visualized.");
        
        //  Create the number array
        Integer[] numbersArray = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};

        System.out.println("\nArray of numbers before sorting with comparable:");
        printArray(numbersArray);
        
        // Sort using Comparable (using natural order, since that's what it does)
        bubbleSort(numbersArray); 
        System.out.println("\nNumbers sorted with Comparable:");
        printArray(numbersArray);

        System.out.println("\nArray of numbers before sorting with comparator:");
        printArray(numbersArray);

        //  I reversed the direction here, so we could see how Comparator works.
        //      Using your example of only one array, I didn't want to create a
        //      second array. If I had used the already sorted array, it would
        //      have done basically nothing. This also showcases how comparators
        //      are more customizable with their comparisons.
        bubbleSort(numbersArray, Comparator.reverseOrder());
        System.out.println("\nWords sorted with Comparator (descending order):");
        printArray(numbersArray);
    }

    /**
     * Sorts an array of elements using the bubble sort algorithm.
     * Elements must implement the Comparable interface.
     *
     * @param <E> the type of elements in the array, must be Comparable: In this case
     *      they are integers
     * @param list the array object to be sorted
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean needNextPass = true;

        // Loop for each pass
        for (int k = 1; k < list.length && needNextPass; k++) {
            
            // Reset this to false, in case this may be the last pass
            needNextPass = false;

            // Inner loop to compare neighbor elements
            for (int i = 0; i < list.length - k; i++) {
                // If the current element is greater than the next one, swap them
                if (list[i].compareTo(list[i + 1]) > 0) {
                    // Swap the elements
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    // Print that a swap occurred with the details
                    System.out.println("Swapped " + list[i + 1] + " and " + list[i]);

                    // A swap occurred, so another pass might be needed
                    needNextPass = true;
                }
            }
            // Print array after each outer pass
            System.out.print("After pass " + k + ": ");
            printArray(list);
        }
    }

    /**
     * Sorts an array of elements using the bubble sort algorithm and a specified comparator.
     *
     * @param <E> the type of elements in the array: In this case Integers
     * @param list the array object to be sorted
     * @param comparator the comparator used to compare array elements
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean needNextPass = true;

        // Loop for each pass
        for (int k = 1; k < list.length && needNextPass; k++) {
            // Reset this to false, in case this may be the last pass
            needNextPass = false;

            // Inner loop to compare neighbor elements
            for (int i = 0; i < list.length - k; i++) {
                // Use the comparator to decide order
                if (comparator.compare(list[i], list[i + 1]) > 0) {
                    // Swap the elements
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    // Print that a swap occurred with the details
                    System.out.println("Swapped " + list[i + 1] + " and " + list[i]);

                    // A swap occurred, so another pass might be needed
                    needNextPass = true;
                }
            }
            // Print array after each outer pass
            System.out.print("After pass " + k + ": ");
            printArray(list);
        }
    }

    /**
     * Prints the elements of an array to the console window.
     *
     * @param <E> the type of elements in the array: In this case Integers
     * @param list the array object to be printed
     */
    public static <E> void printArray(E[] list) {
        for (E e : list) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
}