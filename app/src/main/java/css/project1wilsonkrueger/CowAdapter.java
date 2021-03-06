package css.project1wilsonkrueger;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CowAdapter extends RecyclerView.Adapter<CowViewHolder>{
    Application application;
    MainViewModel mainViewModel;

    public CowAdapter(Application application, MainViewModel mainViewModel)
    {
        this.application = application;
        this.mainViewModel = mainViewModel;
    }

    @NonNull
    @Override
    public CowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cow_row, parent, false);

        return new CowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CowViewHolder holder, int position) {
        Cow currentCow = mainViewModel.getCow(position);
        holder.textViewId.setText(currentCow.getId());
        holder.textViewDob.setText(currentCow.getDateOfBirth());
        holder.textViewGender.setText(currentCow.getGender());
    }

    @Override
    public int getItemCount() {
        return mainViewModel.getNumberCows();
    }
}
