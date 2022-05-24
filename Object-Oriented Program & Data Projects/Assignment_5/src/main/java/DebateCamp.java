//         Name: Eduardo Teodosio Campuzano

//Here we import all the necessary things to make our code work
import java.text.NumberFormat;
import java.util.Locale;

// We need DebateCamp to extend SummerCamp
public class DebateCamp extends SummerCamp {

    private double materialFee;
    private boolean groupDiscount;

    //We create its' constructor by calling the parents and adding to it
    public DebateCamp(String title, String location, double rate, int weeks, double fee, String discount) {
        super(title, location, rate, weeks);
        this.materialFee = fee;
        this.groupDiscount = discount.equalsIgnoreCase("yes");

    }

    //We override the abstract parent method to make it unique to this class
    @Override
    public void computeTotalCosts() {
        totalCost = (weeklyRate * numberOfWeeks);
        if (groupDiscount) {
            totalCost = (totalCost * .9) + materialFee;
        }
        else {
            totalCost += materialFee;
        }
    }

    //Same goes for the parent's toString method. We take it and expand on it
    @Override
    public String toString() {
        Locale usMoney = new Locale("en", "US");
        NumberFormat formatDebate = NumberFormat.getCurrencyInstance(usMoney);
        String groupDiscountString;
        if (groupDiscount) {
            groupDiscountString = "yes";
        } else {
            groupDiscountString = "no";
        }
        StringBuilder debate = new StringBuilder();
        debate.append("\nDebate Camp:")
                .append(super.toString())
                .append("Material Fee:\t\t").append(formatDebate.format(materialFee)).append("\n")
                .append("Group Discount:\t\t").append(groupDiscountString).append("\n\n");
        return debate.toString();
    }
}
