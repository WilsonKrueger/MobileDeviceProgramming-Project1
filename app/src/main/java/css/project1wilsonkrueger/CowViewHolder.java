package css.project1wilsonkrueger;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CowViewHolder extends RecyclerView.ViewHolder {
    TextView textViewId;
    TextView textViewDob;
    TextView textViewGender;

    public CowViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewId = itemView.findViewById(R.id.textViewId);
        textViewDob = itemView.findViewById(R.id.textViewDob);
        textViewGender = itemView.findViewById(R.id.textViewGender);
    }
}
