package css.project1wilsonkrueger;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to store a list of Cow objects
 *
 * @author Wilson Krueger
 */
public class CowRepository {
    private List<Cow> cowList;

    /**
     * Default Constructor - creates cowList as a new ArrayList
     */
    public CowRepository() {
        cowList = new ArrayList<Cow>();
    }

    /**
     * Inserts Cow object into the repository
     *
     * @param cow Cow object to add to list of cows
     */
    public void insert(Cow cow) {
        cowList.add(cow);
    }

    /**
     * Gets the number of cows in the repository
     *
     * @return The size of the list
     */
    public Integer getNumberCows() {
        return cowList.size();
    }

    /**
     * Gets Cow object from the list
     *
     * @param position Integer location in list of Cow objected wanted
     * @return Cow object based on position parameter
     */
    public Cow getCow(Integer position) {
        return cowList.get(position);
    }
}
