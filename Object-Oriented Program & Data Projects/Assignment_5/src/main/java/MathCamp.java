//         Name: Eduardo Teodosio Campuzano


////Here we import all the necessary things to make our code work
import java.text.NumberFormat;
import java.util.Locale;

// We need MathCamp to extend SummerCamp
public class MathCamp extends SummerCamp {
    private boolean takingTest;

    //We create its' constructor by calling the parents and adding to it
    public MathCamp(String title, String location, double rate, int weeks, String tTaking) {
        super(title, location, rate, weeks);
        this.takingTest = tTaking.equalsIgnoreCase("yes");
    }

    //We override the abstract parent method to make it unique to this class
    @Override
    public void computeTotalCosts() {
        totalCost = weeklyRate * numberOfWeeks;
        if (takingTest){
            totalCost += 25;
        }
    }

    //Same goes for the parent's toString method. We take it and expand on it
    @Override
    public String toString() {
        String takingTestString;
        if (takingTest) {
            takingTestString = "yes";
        } else {
            takingTestString = "no";
        }
        StringBuilder math = new StringBuilder();
        math.append("\nMath Camp:")
                .append(super.toString())
                .append("Test Taking:\t\t").append(takingTestString).append("\n\n");
        return math.toString();
    }
}
