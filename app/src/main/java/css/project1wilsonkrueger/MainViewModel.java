package css.project1wilsonkrueger;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

/**
 * Class for maintaining the cow data of the program
 *
 * @author Wilson Krueger
 */
public class MainViewModel extends AndroidViewModel {
    private CowRepository cowRepository;
    String id;
    String dateOfBirth;
    String gender;

    /**
     * Constructor - creates the cow repository and sets the variables to empty Strings
     *
     * @param application takes in the Application
     */
    public MainViewModel(@NonNull Application application) {
        super(application);
        cowRepository = new CowRepository();
        id = "";
        dateOfBirth = "";
        gender = "";
    }

    /**
     * Gets the number of cows in the repository
     *
     * @return number of cows by calling getNumberCows from the repository
     */
    public Integer getNumberCows() {
        return cowRepository.getNumberCows();
    }

    /**
     * Gets a cow object from the repository
     *
     * @param position Integer value of the location of cow object in repository
     * @return cow object from repository based on position parameter
     */
    public Cow getCow(Integer position) {
        return cowRepository.getCow(position);
    }

    /**
     * Clears cow repository
     */
    public void clearList() {
        cowRepository = new CowRepository();
    }

    /**
     * Adds cow object to the repository
     *
     * @param cow object of Cow to add to the repository
     */
    public void addCow(Cow cow) {
        cowRepository.insert(cow);
    }

    /**
     * Gets the cow's date of birth
     *
     * @return date of birth of cow
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the cow's date of birth
     *
     * @param inDate String to set date of birth to
     */
    public void setDateOfBirth(String inDate) {
        dateOfBirth = inDate;
        Log.d("CIS 3334", "inDate = " + inDate);
    }

    /**
     * Gets the cow's id
     *
     * @return id of cow
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the cow's id
     *
     * @param inId String to set id to
     */
    public void setId(String inId) {
        id = inId;
    }

    /**
     * Gets the cow's gender
     *
     * @return gender of the cow
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the cow's gender
     *
     * @param inGender String to set gender of cow to
     */
    public void setGender(String inGender) {
        gender = inGender;
    }

}
