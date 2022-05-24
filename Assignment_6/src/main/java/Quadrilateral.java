// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: this class will run with our main class and provides the methods used in that class

public class Quadrilateral {
    private int side1, side2, side3, side4;

    public Quadrilateral(int s1, int s2, int s3, int s4) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
        side4 = s4;
    }

    // These getters and setters will allow the user to change and retrieve the information of any side
    public int getSide1() {
        return side1;
    }

    public int getSide2() {
        return side2;
    }

    public int getSide3() {
        return side3;
    }

    public int getSide4() {
        return side4;
    }

    public void setSide1(int length) {
        side1 = length;
    }

    public void setSide2(int length) {
        side2 = length;
    }

    public void setSide3(int length) {
        side3 = length;
    }

    public void setSide4(int length) {
        side4 = length;
    }

    // These private helper method will be used by our other methods
    private int longest() {
        int max1 = Math.max(side1, side2);
        int max2 = Math.max(side3, side4);
        return Math.max(max1, max2);
    }

    private int shortest() {
        int min1 = Math.min(side1, side2);
        int min2 = Math.min(side3, side4);
        return Math.min(min1, min2);
    }

    private boolean pythagorean() {
        int hypOne = (int) Math.hypot(side1, side4);
        int hypTwo = (int) Math.hypot(side2, side3);
        return hypOne == hypTwo;
    }

    // This method will tell the user if the sides they choose make a rectangle or not using our pythagorean helper method
    public boolean isRectangle() {
        if ((side1 == side3) && (side2 == side4)) {
            return this.pythagorean();
        }
        return false;
    }

    // This method will tell the user if the sides the inputted make a square using our longest and shortest helper methods
    public boolean isSquare() {
        return this.shortest() == this.longest();
    }

    // This method will display the side information about the shape the user creates
    public String toString() {
        return "Sides: " + side1 + " " + side2 + " " + side3 + " " + side4;
    }
}
