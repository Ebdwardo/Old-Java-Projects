// Name: Eduardo Teodosio Campuzano
// Description: This class is used in our Class Club.

// Setting up the class and instance variables
public class President {
    private String firstName;
    private String lastName;
    private String academicLevel;

// Creating our constructor and setting values
    public President() {
        firstName = "?";
        lastName = "?";
        academicLevel = "?";
    }

// Creating get methods in case we need info
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAcademicLevel() {
        return academicLevel;
    }

// Creating set methods so we can assign values as we would like
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAcademicLevel(String academicLevel) {
        this.academicLevel = academicLevel;
    }

// toString to show the information we need in the main program.
    public String toString() {
        return lastName + "," + firstName + "(" + academicLevel + ")";
    }
}
