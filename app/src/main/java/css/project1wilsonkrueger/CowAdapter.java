package css.project1wilsonkrueger;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class for adapting the recycler view
 *
 * @author Wilson Krueger
 */
public class CowAdapter extends RecyclerView.Adapter<CowViewHolder>{
    Application application;
    MainViewModel mainViewModel;

    /**
     * Constructor - create an object of this class
     *
     * @param application takes in the application
     * @param mainViewModel takes in access to the main view model
     */
    public CowAdapter(Application application, MainViewModel mainViewModel)
    {
        this.application = application;
        this.mainViewModel = mainViewModel;
    }

    /**
     * Method for inflating the layout
     *
     * @param parent
     * @param viewType
     * @return new instance of the view holder
     */
    @NonNull
    @Override
    public CowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cow_row, parent, false);

        return new CowViewHolder(view);
    }

    /**
     * Method to bind the layout with the current cow
     *
     * @param holder current CowViewHolder
     * @param position in the recycler view
     */
    @Override
    public void onBindViewHolder(@NonNull CowViewHolder holder, int position) {
        Cow currentCow = mainViewModel.getCow(position);
        holder.textViewId.setText(currentCow.getId());
        holder.textViewDob.setText(currentCow.getDateOfBirth());
        holder.textViewGender.setText(currentCow.getGender());
    }

    /**
     * Method for get the number of items in the recycler view
     *
     * @return number of cow objects from the mainViewModel
     */
    @Override
    public int getItemCount() {
        return mainViewModel.getNumberCows();
    }
}
