//         Name: Eduardo Teodosio Campuzano

import java.util.Comparator;

public class ClubNameComparator implements Comparator<Club> {
    public int compare (Club first, Club second){

        // checks all cases described in the assignment but could be shorted to
        // return first.getClubName().compareTo(second.getClubName());

        if (first.getClubName().compareTo(second.getClubName()) < 0){
            return first.getClubName().compareTo(second.getClubName());
        }
        else if (first.getClubName().compareTo(second.getClubName()) > 0){
            return first.getClubName().compareTo(second.getClubName());
        }
        else{
            return 0;
        }
    }
}
