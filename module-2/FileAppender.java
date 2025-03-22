package ReaneyModule2ProgrammingAssignment;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
*  Assignment: Module 2
*  Date: 03/21/2025
*  @author Christopher Reaney
* 
*  This class is used to append to or create a file. It will append
*       5 random integers and 5 random doubles. Afterwards the file 
*       contents are read.
*/
public class FileAppender {

    /**
    * @param args the command line arguments
    */
    public static void main(String[] args) {
        String intro = "This class calls on two programs to do the following:\n"  +
                       "1. Check for reaney-datafile.dat. If it doesn't exist, create it.\n" +
                       "2. Write two arrays, each of 5 length to the document. One\n" +
                       "array consists of ints, the next of doubles.\n" +
                       "3. Read the current content of the file into the terminal.\n";
        System.out.println(intro);
        fileWriter();
        fileReader();
    }   
    
    /**
    * This method appends or creates a file using the random int and double
    *   arrays that are passed in
    */
    public static void fileWriter(){
        //  Create the two arrays.
        int[] randomIntArray = ThreadLocalRandom.current().ints(5).toArray();
        double[] randomDoubleArray = ThreadLocalRandom.current().doubles(5).toArray();     
        
        //  Check for file. If it doesn't exist, create it.
        System.out.println("Now checking for file...\n");
        File f = new File("reaney-datafile.dat");
        if(!f.exists())
        {
            try{
                System.out.println("File does not exist. Now creating reaney-datafile.dat...\n");
                f.createNewFile();
            }
            catch(IOException e){
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("File exists.\n");
        }
        
        
        //  Append the 5 integers array and 5 doubles arrays to the file
        System.out.println("Now appending two arrays to the file...\n");
        BufferedWriter outputWriter = null;
        try{           
            outputWriter = new BufferedWriter(new FileWriter("reaney-datafile.dat", true));

            // Array of five random integers
            outputWriter.write("Integer Array:" + Arrays.toString(randomIntArray) + "\n");

            //  Append the 5 doubles  array to the file
            outputWriter.write("Double Array: " + Arrays.toString(randomDoubleArray) + "\n");
            
            //  Finish the write
            outputWriter.flush();
            outputWriter.close();
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }      
    }
    
    /**
    * This method reads the contents of the file and displays it in the terminal.
    */
    public static void fileReader(){
        System.out.println("Now reading contents of file...\n");
        try{
            BufferedReader in = new BufferedReader(new FileReader("reaney-datafile.dat"));

            String line;
            while((line = in.readLine()) != null)
            {
                System.out.println(line);
            }
            in.close();
        }
        catch(IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }   
    }
}