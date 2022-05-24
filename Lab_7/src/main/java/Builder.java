// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: this is the class that is used in the builder


public class Builder {
    // ======================= Attributes =======================

    // A String called name
    private String name;

    // ======================= Constructors =======================

    public Builder(String name) {
        // Write the segment of code
        // that assigns input data to the instance variables (attributes)
        this.name = name;
    }

    // ======================= Methods =======================

    public String getName() {
        // Write a line of code that returns the name
        return name;
    }

    public String makeRow(int n, String s) {
        // Given an int n and string s, return a string that represents n
        // copies of s in one row.
        // Example: n = 5, s ="*", return a string "*****"
        String line = "";
        for (int i = 0; i < n; i++) {
            line += s;
        }
        return line;
    }

    public void makePyramid(int n, String s) {
        // Print the pyramid pattern as showed in the sample output by
        // the makeRow method
        String pyramidSides = "=";
        String result = "";
        int numSides = (n-1)/2; // find the number of = to put on the sides of each row
        int numRows = 1;// find the number of * in each row
        for (int i = 1; i <= n; i += 2) {
            result = makeRow(numSides, pyramidSides) + makeRow(numRows, s) + makeRow(numSides, pyramidSides);
            System.out.println(result);

            numSides-=1;// updates the number of = on each side
            numRows+=2;// updates the number of 8 on each row
        }

    }


    // Note this method does not return anything.
}
