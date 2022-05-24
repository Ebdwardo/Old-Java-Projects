//         Name: Eduardo Teodosio Campuzano

import java.text.NumberFormat;
import java.util.Locale;

//Here we create our abstract class that wont be instantiated and create instance variables
public abstract class SummerCamp {
    protected String title;
    protected String location;
    protected double weeklyRate;
    protected int numberOfWeeks;
    protected double totalCost;

    //Here we create the parent constructor that all the other subclasses will build upon
    public SummerCamp(String someTitle, String someLocation, double someWeeklyRate, int someNumberOfWeeks) {
        this.title = someTitle;
        this.location = someLocation;
        this.weeklyRate = someWeeklyRate;
        this.numberOfWeeks = someNumberOfWeeks;
        this.totalCost = 0.0;
    }

    //We create this method so that we can use it to search for our SummerCamp objects later
    public String getCampTitle() {
        return this.title;
    }

    //Here we create the abstract method with no body that the child classes must implement
    public abstract void computeTotalCosts();

    //Here we create the toString method that the child classes will again, build upon
    public String toString() {
        Locale usMoney = new Locale("en", "US");
        NumberFormat format = NumberFormat.getCurrencyInstance(usMoney);
        StringBuilder sb = new StringBuilder();
        sb.append("\nCamp Title:\t\t").append(title).append("\n")
                .append("Location:\t\t").append(location).append("\n")
                .append("Weekly Rate:\t\t").append(format.format(weeklyRate)).append("\n")
                .append("Weeks:\t\t\t").append(numberOfWeeks).append("\n")
                .append("Total Cost:\t\t").append(format.format(totalCost)).append("\n");
        return sb.toString();
    }

}
