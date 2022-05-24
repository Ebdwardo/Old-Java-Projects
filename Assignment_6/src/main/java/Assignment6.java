// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: this program will check if a shape is a rectangle or square based of off the information the user inputs
// and it will display the length of each side. it will do this until the user hits n when prompted.

import java.util.Scanner;

public class Assignment6 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num1, num2, num3, num4;
        String another;
        do {
            System.out.println("Enter the sides of the quadrilateral: ");
            //fill out the code to get the four sides
            System.out.println("Side 1: "); num1 = console.nextInt();
            System.out.println("Side 2: "); num2 = console.nextInt();
            System.out.println("Side 3: "); num3 = console.nextInt();
            System.out.println("Side 4: "); num4 = console.nextInt();
            Quadrilateral shape = new Quadrilateral(num1, num2, num3, num4);

            System.out.println(shape.toString());

            //fill out code it check for square
            if (shape.isSquare()) {
                System.out.println("\t\t It is a square");
            } else {
                System.out.println("\t\t It is not a square");
            }

            //fil in code to check for rectangle
            if (shape.isRectangle()) {
                System.out.println("\t\t It is a rectangle");
            } else {
                System.out.println("\t\t It is not a rectangle");
            }

            System.out.print("Check another Quadrilateral (y/n)? ");
            another = console.next();
        } while (another.equalsIgnoreCase("y"));
        console.close();
        ;
    }
}
