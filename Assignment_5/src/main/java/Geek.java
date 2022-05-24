// AUTHOR: Eduardo Teodosio Campuzano
// SPECIFICATION: this program is class geek, it is used in the test driver

class Geek {
    private String name;
    private int numberOfQuestions;

    //Constructor
    public Geek(String geekName) {
        name = geekName;
        numberOfQuestions = 0;
    }

    //This getName method returns the name currently assigned to a geek object
    public String getName() {
        return name;
    }

    //This getNumberOfQuestions method returns the number of questions the user has asked
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

    //This isEven method computes whether or not a number the user has input is even
    public boolean isEven(int num) {
        numberOfQuestions++;
        return num % 2 == 0;
    }

    //This method takes the string the user has inputted and concatenates it by the int the user inputs
    public String multiConcat(String text, int count) {
        numberOfQuestions++;
        String line = text;
        if (count < 2) {
            return text;
        } else {
            for (int i = 1; i < count; i++) {
                line += text;
            }
            return line;
        }
    }

    //This method find the sum of integers between 2 numbers excluding the number inputted
    public int sumRange(int num1, int num2) {
        numberOfQuestions++;
        int sum = 0;
        if (num1 < num2) {
            for (int i = num1 + 1; i < num2; i++) {
                sum = sum + i;
            }
            return sum;
        } else if (num1 == num2) {
            return sum;
        } else {
            return sum;
        }
    }

    //This method tell if the 3 numbers the user enters is in numerical order
    public boolean sorted(int num1, int num2, int num3) {
        numberOfQuestions++;
        if (num1 < num2) {
            return num1 < num3;
        }
        return false;
    }

    //This method tells the user how many a's there are in the string they entered
    public int countA(String text) {
        numberOfQuestions++;
        String toLowerCase = text.toLowerCase();
        int numA = 0;
        for (int i = 0; i < toLowerCase.length(); i++) {
            char charAt = toLowerCase.charAt(i);
            if (charAt == 'a') {
                numA++;
            }
        }
        return numA;
    }

    //This method tells the user how many digits are in the number they entered
    public int countDigits(int num) {
        numberOfQuestions++;
        int digits = 0;
        while (num != 0) {
            num = num / 10;
            digits++;
        }
        return digits;
    }

    //This method tells the user if the number they entered is prime
    public boolean isPrime(int num) {
        numberOfQuestions++;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
