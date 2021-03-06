package css.project1wilsonkrueger;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    private CowRepository cowRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        cowRepository = new CowRepository();
    }

    public void insert(String id, String dob, String gender) {
        Cow cow = new Cow(id, dob, gender);
        cowRepository.insert(cow);
    }

    public Integer getNumberCows() {
        return cowRepository.getNumberCows();
    }

    public Cow getCow(Integer position) {
        return cowRepository.getCow(position);
    }
}
