// Name: Eduardo Teodosio Campuzano
// Description: This is the Class Club that is used in the main program

//Assigning our instance variables
public class Club {
    private String clubName;
    private int numberOfMembers;
    private String university;
    private President currentPresident;

// Setting up our constructor
    public Club() {
        clubName = "?";
        numberOfMembers = 0;
        university = "?";
        currentPresident = new President();

    }

// Here we are creating getter methods in case we need to see that information
    public String getClubName() {
        return clubName;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public String getUniversity() {
        return university;
    }

    public President getCurrentPresident() {
        return currentPresident;
    }

// Here we are creating methods that allow us to set values to what we want
    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setCurrentPresident(String firstName, String lastName, String academicLevel) {
        currentPresident.setFirstName(firstName);
        currentPresident.setLastName(lastName);
        currentPresident.setAcademicLevel(academicLevel);
    }

// The toString method displays the valuable information
    public String toString() {
        return "\nClub Name:\t\t" + clubName + "\n"
                + "Number Of Members:\t" + numberOfMembers + "\n"
                + "University:\t\t" + university + "\n"
                + "President:\t\t" + currentPresident + "\n\n";
    }
}
