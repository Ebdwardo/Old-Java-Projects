//         Name: Eduardo Teodosio Campuzano


import java.text.NumberFormat;
import java.util.Locale;

// We need RoboticsCamp to extend SummerCamp
public class RoboticsCamp extends SummerCamp {
    private double facilityFee;
    private double competitionFee;

    //We create its' constructor by calling the parents and adding to it
    public RoboticsCamp(String title, String location, double rate, int weeks, double facilityFee, double compFee) {
        super(title, location, rate, weeks);
        this.facilityFee = facilityFee;
        this.competitionFee = compFee;
    }

    //We override the abstract parent method to make it unique to this class
    @Override
    public void computeTotalCosts() {
        totalCost = weeklyRate * numberOfWeeks;
        totalCost += facilityFee + competitionFee;
    }

    //Same goes for the parent's toString method. We take it and expand on it
    @Override
    public String toString() {
        Locale usMoney = new Locale("en", "US");
        NumberFormat formatRobotics = NumberFormat.getCurrencyInstance(usMoney);
        StringBuilder robotics = new StringBuilder();
        robotics.append("\nRobotics Camp:")
                .append(super.toString())
                .append("Facility Fee:\t\t").append(formatRobotics.format(facilityFee)).append("\n")
                .append("Competition Fee:\t").append(formatRobotics.format(competitionFee)).append("\n\n");
        return robotics.toString();
    }
}
