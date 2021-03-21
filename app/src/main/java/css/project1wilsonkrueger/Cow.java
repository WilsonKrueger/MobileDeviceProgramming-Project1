package css.project1wilsonkrueger;

import java.io.Serializable;

/**
 * Class for creating a cow object with id, date of birth, and gender
 *
 * @author Wilson Krueger
 */
public class Cow implements Serializable {
    private String id;
    private String dateOfBirth;
    private String gender;

    /**
     * Default Constructor - sets String variables to empty Strings
     */
    public Cow() {
        id = "";
        dateOfBirth = "";
        gender = "";
    }

    /**
     * Parameter Constructor - takes in String variables as parameters
     *
     * @param inId Id of the cow
     * @param inDateOfBirth date of birth of the cow
     * @param inGender gender of the cow
     */
    public Cow(String inId, String inDateOfBirth, String inGender) {
        id = inId;
        dateOfBirth = inDateOfBirth;
        gender = inGender;
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
     * @param inDateOfBirth String to set date of birth to
     */
    public void setDateOfBirth(String inDateOfBirth) {
        dateOfBirth = inDateOfBirth;
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
