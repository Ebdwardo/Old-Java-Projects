//         Name: Eduardo Teodosio Campuzano

import java.util.ArrayList;
import java.util.Scanner;

public class SummerCampParser {

    //Here we create the method we will use to create objects from strings the user types
    public static SummerCamp parseStringToSummerCamp(String lineToParse) {

        //We use the scanner to read the parameter and then change the delimiter to read what we want it to
        Scanner scan = new Scanner(lineToParse).useDelimiter(":");

        //Here we create the ArrayList that will store the string that we will use to create our SummerCamp objects
        ArrayList<String> arrayList = new ArrayList<>();

        //Here we read the string and add what we want to our ArrayList
        while (scan.hasNext()) {
            String word = scan.next();
            arrayList.add(word);
        }

        //Here we take the first item in the array list, which tell us the type of object it will be
        //We take that String and use it to compare to the cases to see what object it should build
        String compare = (String) arrayList.get(0);
        compare = compare.toLowerCase();

        //Once it knows what case to use it will create an object and use the rest of the array list items to fill in the objects parameters
        switch (compare) {
            case "debatecamp":
                DebateCamp debate1 = new DebateCamp(arrayList.get(1), arrayList.get(2), Double.parseDouble(arrayList.get(3)), Integer.parseInt(arrayList.get(4)), Double.parseDouble(arrayList.get(5)), arrayList.get(6));
                return debate1;
            case "roboticscamp":
                RoboticsCamp robot1 = new RoboticsCamp(arrayList.get(1), arrayList.get(2), Double.parseDouble(arrayList.get(3)), Integer.parseInt(arrayList.get(4)), Double.parseDouble(arrayList.get(5)), Double.parseDouble(arrayList.get(6)));
                return robot1;
            case "mathcamp":
                MathCamp math1 = new MathCamp(arrayList.get(1), arrayList.get(2), Double.parseDouble(arrayList.get(3)), Integer.parseInt(arrayList.get(4)), arrayList.get(5));
                return math1;

        }
        return null;
    }
}
