//         Name: Eduardo Teodosio Campuzano

import java.io.Serializable;
import java.util.ArrayList;

public class ClubManagement implements Serializable {
    private ArrayList<Club> clubList;
    private int numberOfClubs;
    private int maxSize;

    public ClubManagement(int num) {
        this.maxSize = num;
        clubList = new ArrayList<Club>(maxSize);
        numberOfClubs = 0;
    }

    public int clubExists(String clubName, String university) {

        // This method checks to see if a club exists in the array list

        for (int i = 0; i < clubList.size(); i++) {
            if (clubList.get(i).getClubName().equals(clubName) && clubList.get(i).getUniversity().equals(university)) {
                return i;
            }
        }
        return -1;
    }

    public int currentPresidentExists(String firstName, String lastName, String academicLevel) {

        // this method checks to see if a president already exists in an array list

        for (int i = 0; i < clubList.size(); i++) {
            if (clubList.get(i).getCurrentPresident().getFirstName().equals(firstName) && clubList.get(i).getCurrentPresident().getLastName().equals(lastName) && clubList.get(i).getCurrentPresident().getAcademicLevel().equals(academicLevel)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addClub(String clubName, int numberOfMembers, String university, String firstName, String lastName, String academicLevel) {

        //See if the club exists in the array list and if not then add and return true, but if it does return false

        if (numberOfClubs < maxSize) {
            for (int i = 0; i < maxSize; i++) {
                if (clubExists(clubName, university) == -1) {
                    Club newClub = new Club();
                    newClub.setNumberOfMembers(numberOfMembers);
                    newClub.setUniversity(university);
                    newClub.setClubName(clubName);
                    newClub.setCurrentPresident(firstName, lastName, academicLevel);
                    this.clubList.add(newClub);
                    numberOfClubs++;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean removeClub(String clubName, String university) {

        // removes a club if it exists in the array list

        int clubIndex = clubExists(clubName, university);
        if (clubIndex == -1) {
            return false;
        }
        clubList.remove(clubIndex);
        return true;
    }

    public void sortByClubNames() {

        // Calls on the sorts class and uses the comparator class we created to sort based on club names

        ClubNameComparator compareName = new ClubNameComparator();
        Sorts.sort(clubList, maxSize, compareName);
    }

    public void sortByMemberNumbers() {

        // Calls on the sorts class and uses the comparator class we created to sort based on club members

        MemberNumberComparator members = new MemberNumberComparator();
        Sorts.sort(clubList, maxSize, members);
    }

    public void sortByCurrentPresidents() {

        // Calls on the sorts class and uses the comparator class we created to sort based on President

        CurrentPresidentComparator presidents = new CurrentPresidentComparator();
        Sorts.sort(clubList, maxSize, presidents);
    }

    public String listClubs() {
        String clubs = "\n";
        if (clubList.size() > 0) {
            for (int i = 0; i < clubList.size(); i++) {
                clubs += clubList.get(i).toString();
            }
            return clubs + "\n";
        }

        return "\nno club\n\n";

    }

    public void closeClubManagement() {
        this.clubList.clear();
    }
}
