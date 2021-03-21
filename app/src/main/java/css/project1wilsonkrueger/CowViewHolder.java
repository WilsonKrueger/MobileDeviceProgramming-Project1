package css.project1wilsonkrueger;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;

/**
 * Class for holding the items of the layout in the recycler view
 *
 * @author Wilson Krueger
 */
public class CowViewHolder extends RecyclerView.ViewHolder {
    TextView textViewId;
    TextView textViewDob;
    TextView textViewGender;
    Button buttonView;

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
        buttonView = itemView.findViewById(R.id.buttonView);

        buttonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textViewId = itemView.findViewById(R.id.textViewId);
                textViewDob = itemView.findViewById(R.id.textViewDob);
                textViewGender = itemView.findViewById(R.id.textViewGender);
                String id = textViewId.getText().toString();
                String dob = textViewDob.getText().toString();
                String gender = textViewGender.getText().toString();

                Intent secondIntent = new Intent(view.getContext(), SecondActivity.class);
                secondIntent.putExtra("MainId", id);
                secondIntent.putExtra("MainDob", dob);
                secondIntent.putExtra("MainGender", gender);
                view.getContext().startActivity(secondIntent);
            }
        });
    }
}
