package css.project1wilsonkrueger;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Class for holding the items of the layout in the recycler view
 *
 * @author Wilson Krueger
 */
public class CowViewHolder extends RecyclerView.ViewHolder {
    TextView textViewId;
    TextView textViewDob;
    TextView textViewGender;

    /**
     * Constructor for declaring the items in the layout
     *
     * @param itemView current View
     */
    public CowViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewId = itemView.findViewById(R.id.textViewId);
        textViewDob = itemView.findViewById(R.id.textViewDob);
        textViewGender = itemView.findViewById(R.id.textViewGender);
    }
}
