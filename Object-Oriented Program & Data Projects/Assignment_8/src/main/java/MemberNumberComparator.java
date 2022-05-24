//         Name: Eduardo Teodosio Campuzano

import java.util.Comparator;

public class MemberNumberComparator implements Comparator<Club> {

    // checks all cases described in the assignment but could be shorted to
    // return Integer.compare(obj1.getNumberOfMembers(), obj2.getNumberOfMembers());

    public int compare(Club obj1, Club obj2){
        if (obj1.getNumberOfMembers() < obj2.getNumberOfMembers()){
            return Integer.compare(obj1.getNumberOfMembers(), obj2.getNumberOfMembers());
        }
        else if (obj1.getNumberOfMembers() > obj2.getNumberOfMembers()){
            return Integer.compare(obj1.getNumberOfMembers(), obj2.getNumberOfMembers());
        }
        else{
            return Integer.compare(obj1.getNumberOfMembers(), obj2.getNumberOfMembers());
        }
    }
}
