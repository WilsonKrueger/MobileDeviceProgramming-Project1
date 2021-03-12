package css.project1wilsonkrueger;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    private CowRepository cowRepository;
    String id;
    String dateOfBirth;
    String gender;

    public MainViewModel(@NonNull Application application) {
        super(application);
        cowRepository = new CowRepository();
        id = "";
        dateOfBirth = "";
        gender = "";
    }

    public Integer getNumberCows() {
        return cowRepository.getNumberCows();
    }

    public Cow getCow(Integer position) {
        return cowRepository.getCow(position);
    }

    public void clearList() {
        cowRepository = new CowRepository();
    }

    public void addCow(Cow cow) {
        cowRepository.insert(cow);
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String inDate) {
        dateOfBirth = inDate;
        Log.d("CIS 3334", "inDate = " + inDate);
    }

    public String getId() {
        return id;
    }

    public void setId(String inId) {
        id = inId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String inGender) {
        gender = inGender;
    }

}
