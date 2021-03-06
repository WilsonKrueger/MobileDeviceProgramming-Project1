package css.project1wilsonkrueger;

public class Cow {
    private String id;
    private String dateOfBirth;
    private String gender;

    public Cow(String inId, String inDateOfBirth, String inGender) {
        id = inId;
        dateOfBirth = inDateOfBirth;
        gender = inGender;
    }

    public String getId() {
        return id;
    }

    public void setId(String inId) {
        id = inId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String inDateOfBirth) {
        dateOfBirth = inDateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String inGender) {
        gender = inGender;
    }
}
