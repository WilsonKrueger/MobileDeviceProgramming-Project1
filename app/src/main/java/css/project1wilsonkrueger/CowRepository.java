package css.project1wilsonkrueger;

import java.util.ArrayList;
import java.util.List;

public class CowRepository {
    private List<Cow> cowList;

    public CowRepository() {
        cowList = new ArrayList<Cow>();
    }

    public void insert(Cow cow) {
        cowList.add(cow);
    }

    public Integer getNumberCows() {
        return cowList.size();
    }

    public Cow getCow(Integer position) {
        return cowList.get(position);
    }
}
