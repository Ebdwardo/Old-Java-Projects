//         Name: Eduardo Teodosio Campuzano

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
    public static void sort(ArrayList<Club> clubList, int size, Comparator<Club> club) {
        // for every index i in the list
        for (int i = 0; i < clubList.size(); i++) {
            int candidate = i; // mark the current index as the "swap candidate"

            // search the rest of the list for better candidates
            // for every remaining index j
            for (int j = candidate + 1; j < clubList.size(); j++)
                // if j is lesser than the candidate, it becomes the new candidate
                if (club.compare(clubList.get(j), clubList.get(candidate)) < 0)
                    candidate = j;

            // if candidate is no longer what we started with, swap them
            if (candidate != i) {
                Club swap = clubList.get(candidate);
                clubList.set(candidate, clubList.get(i));
                clubList.set(i, swap);
            }
        }
    }
}

