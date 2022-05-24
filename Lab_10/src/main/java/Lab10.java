// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This program reads the lines in the file Input.txt


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Lab10 {
    public static void main(String[] args) {
        // ============================================================
        // Step 2. Declaring Variables You Need

        // These constants are used to define 2D array and loop conditions
        final int NUM_ROWS = 4;
        final int NUM_COLS = 3;
        String filename = "Input.txt";
        // A String variable used to save the lines read from input file
        // -->
        String lineRead = "";


        // ============================================================
        // Step 3. Declare the Array for File Input
        // Please involve the two constants NUM_ROWS and NUM_COLS in the
        // constructor. 
        // -->
        String[][] stringArray = new String[NUM_ROWS][NUM_COLS];


        // ============================================================
        // Step 4: Preparing an Input File
        // 
        // Make a text file and write 12 strings in it, one string in each line, 
        // and then save it in the folder where your Lab10.java is.
        //  
        // Note: If you are using Eclipse, please save the file out of "src"
        // folder.
        // 
        // !!!!! NO CODE REQUIRED IN THIS SECTION !!!!!


        // ============================================================
        // Step 5. Reading the File 
        // (Please make sure your input file is prepared in Step 4)

        // try-catch statement handles the exception (runtime error)
        // 
        // There are two Exceptions might occur when reading a file
        // 
        // - FileNotFoundException: thrown by FileReader when the file doesn't exist
        // - IOException: thrown by BufferedReader's readLine() when some I/O error occurs
        // 
        // Please check the textbook for details
        try {
            // Instantiate a FileReader object to open the input file
            // Note: "filename" should match the input file you made in Step 4

            //FileReader fr = new FileReader(filename);
            //FileReader fr = new FileReader("/autograder/submission/" + filename);
            Path path = Paths.get("Input.txt").toAbsolutePath();
            FileReader fr = new FileReader(path.toString());

            // BufferedReader is for efficient reading of characters
            BufferedReader bfReader = new BufferedReader(fr);

            // Just like scanner.nextLine(), whenever you invoke .readLine()
            // on BufferedReader, it will read a single line from the file.
            // 
            // As we have determined the number of lines in our file, we will
            // use constants to define the loop conditions
            for (int i = 0; i <= NUM_ROWS - 1; i++) {
                for (int j = 0; j <= NUM_COLS - 1; j++) {
                    // Read a line from the file 
                    // Please invoke .readLine() on the BufferedReader bfReader
                    // and save the returned value to the element at array position (i, j)
                    // -->
                    lineRead = bfReader.readLine();
                    stringArray[i][j] = lineRead;
                }
            }

            // It is very important to close your file after reading is done
            bfReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("I/O error occurs");
        }


        // ============================================================
        // Step 6. Print the Elements in the 2D Array

        for (int i = 0; i <= NUM_ROWS - 1; i++) {
            for (int j = 0; j <= NUM_COLS - 1; j++) {
                // Print the element at position (i, j)
                // -->
                System.out.print(stringArray[i][j] + "\t");
            }
            System.out.println();
        }

    }  // End of main
}  // End of class
