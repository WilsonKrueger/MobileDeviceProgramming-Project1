package css.project1wilsonkrueger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class to instantiate the second activity with cow details
 *
 * @author Wilson Krueger
 */
public class SecondActivity extends AppCompatActivity {

    TextView textViewIdSecond;
    TextView textViewDobSecond;
    TextView textViewGenderSecond;
    Button buttonRTM;
    String id;
    String dob;
    String gender;

    /**
     * Method to create aspects when activity starts
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Connect local variables to components on layout
        textViewIdSecond = findViewById(R.id.textViewIdSecond);
        textViewDobSecond = findViewById(R.id.textViewDobSecond);
        textViewGenderSecond = findViewById(R.id.textViewGenderSecond);
        buttonRTM = findViewById(R.id.buttonRTM);

        //Get extras from the main activity
        Bundle extras = getIntent().getExtras();
        id = extras.getString("MainId");
        dob = extras.getString("MainDob");
        gender = extras.getString("MainGender");

        //Set the texts based on the extras
        textViewIdSecond.setText(id);
        textViewDobSecond.setText(dob);
        textViewGenderSecond.setText(gender);

        //Create listener for the return to main button
        buttonRTM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}