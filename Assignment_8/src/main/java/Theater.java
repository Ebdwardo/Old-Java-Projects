//Importing all the tools I'll need
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Theater {
    private double[][] seats;
    private double totalSales;
    private int totalSeats;

    //Constructor
    public Theater() throws FileNotFoundException {
        //Setting variables
        int numRows = 3;
        int numColumns = 4;
        seats = new double[numRows][numColumns];
        totalSales = 0;
        totalSeats = 0;
        //Setting up the file reading and making and filling the array
        //File file = new File("/autograder/submission/seatPrices.txt");
        Path path = Paths.get("seatPrices.txt").toAbsolutePath();
        File file = new File(path.toString());
        Scanner scan = new Scanner(file);
        for (int i = 0; i <= numRows - 1; i++) {
            for (int j = 0; j <= numColumns - 1; j++) {
                seats[i][j] = scan.nextDouble();
            }
        }
    }

    //This method returns the formatted total to display
    public String getTotal() {
        NumberFormat fmt = NumberFormat.getCurrencyInstance(Locale.US);
        String values = fmt.format(totalSales);
        return values;
    }

    // Prints out each elements in the array in a table
    public void displayChart() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }
    }

    //Finds if the ticket is available for sale and then sets that value to zer oif it is and increments the total seats counter to keep track of how many are sold
    public boolean sellTicket(int i, int j) {
        if (i <= 2 && j <= 3) {
            if (seats[i][j] != 0) {
                totalSales += seats[i][j];
                seats[i][j] = 0;
                totalSeats++;
                return true;
            } else return false;
        }
        if (i > 2 && j > 3) {
            System.out.println("Invalid row and column request. Rows are numbered 0-2, columns are numbered 0-3");
        } else if (i > 2) {
            System.out.println("Illegal row request. Rows are numbered 0-2");
            return false;
        } else if (j > 3) {
            System.out.println("Illegal column request. Columns are numbered 0-3");
            return false;
        } return false;
    }

    // gives back the value of the number of seats sold
    public int numSold() {
        return totalSeats;
    }

    // tells if all the seats are sold out
    public boolean soldOut() {
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 3; j++) {
                if (seats[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
