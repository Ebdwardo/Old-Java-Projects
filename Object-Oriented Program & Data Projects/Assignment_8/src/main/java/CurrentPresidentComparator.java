//         Name: Eduardo Teodosio Campuzano

import java.util.Comparator;

public class CurrentPresidentComparator implements Comparator<Club> {
    public int compare(Club obj1, Club obj2) {

        // checks all cases described in the assignment but could be shorted to
        // return obj1.getCurrentPresident().getLastName().compareTo(obj2.getCurrentPresident().getLastName());

        if (obj1.getCurrentPresident().getLastName().compareTo(obj2.getCurrentPresident().getLastName()) < 0) {
            return obj1.getCurrentPresident().getLastName().compareTo(obj2.getCurrentPresident().getLastName());
        } else if (obj1.getCurrentPresident().getLastName().compareTo(obj2.getCurrentPresident().getLastName()) > 0) {
            return obj1.getCurrentPresident().getLastName().compareTo(obj2.getCurrentPresident().getLastName());
        } else if (obj1.getCurrentPresident().getLastName().compareTo(obj2.getCurrentPresident().getLastName()) == 0) {
            if (obj1.getCurrentPresident().getFirstName().compareTo(obj2.getCurrentPresident().getFirstName()) < 0) {
                return obj1.getCurrentPresident().getFirstName().compareTo(obj2.getCurrentPresident().getFirstName());
            } else if (obj1.getCurrentPresident().getFirstName().compareTo(obj2.getCurrentPresident().getFirstName()) > 0) {
                return obj1.getCurrentPresident().getFirstName().compareTo(obj2.getCurrentPresident().getFirstName());
            } else if (obj1.getCurrentPresident().getFirstName().compareTo(obj2.getCurrentPresident().getFirstName()) == 0) {
                return 0;
            }
        }
        return 0;
    }
}
