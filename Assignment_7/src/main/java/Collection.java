// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: This class contains all the methods and is what creates a new Collection object. It is used in the main file Assignment7.java.


public class Collection {
    private int count;
    private int[] numArray;

    //Constructor
    public Collection(int arraySize) {
        numArray = new int[arraySize];
        count = 0;
    }

    //Helper method
    private int search(int searchingNum) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (numArray[i] == searchingNum) {
                return i;
            }
        }
        return index;
    }

    //This method tells if the number is already in the array and adds it in the lowest index available if not
    public boolean add(int numberToAdd) {
        if (search(numberToAdd) == -1) {
            if (count == numArray.length) {
                doubleArray();
            }
            numArray[count] = numberToAdd;
            count++;
            return true;
        }
        return false;
    }

    //This method finds a number the user inputs and removes it while shifting the numbers to the right of it left one space
    public boolean remove(int numberToRemove) {
        int index = search(numberToRemove);
        if (index != -1) {
            for (int i = index; i < count -1; i++) {
                numArray[i] = numArray[i + 1];
            }
            count--;
            return true;
        }
        return false;
    }

    //Helper method
    private void doubleArray() {
        int[] temp = new int[2 * numArray.length];
        for (int i = 0; i < count; i++) {
            temp[i] = numArray[i];
        }
        numArray = temp;
    }

    //This method finds the largest value in an array
    public int findLargest() {
        int largest = numArray[0];
        for (int i = 1; i < count; i++) {
            if (numArray[i] > largest) {
                largest = numArray[i];
            }
        }
        return largest;
    }

    //this method computes the average of all values in the array
    public double computeAvg() {
        double sum = 0;
        int numOfElements = 0;
        double average = 0;
        for (int i = 0; i < count; i++) {
            sum += numArray[i];
            numOfElements++;
        }
        average = (sum / numOfElements);
        return average;
    }

    //This method counts the number of positive elements in an array
    public int countPositives() {
        int numOfPositives = 0;
        for (int i = 0; i < count; i++) {
            if (numArray[i] > 0) {
                numOfPositives++;
            }
        }
        return numOfPositives;
    }

    //Returns a string that shows the array
    public String toString() {
        String startBracket = "{";
        String endBracket = "}";
        String array = "";
        for (int i = 0; i < count; i++) {
            array += numArray[i];
            if (i < count-1) {
                array += ",";
            }
        }
        return startBracket + array + endBracket;
    }
}
