package css.project1wilsonkrueger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.Calendar;

/**
 * Class for running the main activity to operate the cow tracker application
 *
 * @author Wilson Krueger
 */
public class MainActivity extends AppCompatActivity{

    //Layout components
    Button buttonCalendar;
    EditText editTextId;
    Button buttonInsert;
    RadioButton radioButtonMale;
    RadioButton radioButtonFemale;
    RadioButton radioButtonUnknown;


    //Declare recycler, adapter, and view
    RecyclerView recyclerViewCow;
    CowAdapter cowAdapter;
    MainViewModel mainViewModel;

    // variables for the Firebase database
    FirebaseDatabase database;
    DatabaseReference myDatabase;

    /**
     * Method for creating an instance of the Main Activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup mainViewModel
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //Setup layout components
        editTextId = findViewById(R.id.editTextId);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        radioButtonUnknown = findViewById(R.id.radioButtonUnknown);

        // setup firebase variables
        database = FirebaseDatabase.getInstance();
        myDatabase = database.getReference("COW_OBJECTS");

        //Setup activity
        setupButtonCalendar();
        setupButtonInsert();
        setupRecyclerViewer();
        setupFirebaseUpdates();
    }

    /**
     * Method for Firebase updates
     */
    private void setupFirebaseUpdates() {
        // Read from the database
        myDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mainViewModel.clearList();

                // Loop through the items, each is contained in its own DataSnapshot
                for(DataSnapshot itemSnapshot : dataSnapshot.getChildren()){
                    Cow cow = itemSnapshot.getValue(Cow.class);
                    mainViewModel.addCow(cow);
                }

                cowAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.d("CIS 3334", "Failed to read value.", error.toException());
            }
        });
    }

    /**
     * Method for instantiating the buttonInsert
     */
    private void setupButtonInsert() {
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get the id from the user input
                mainViewModel.setId(editTextId.getText().toString());

                //Access the radio buttons to retrieve the gender
                if(radioButtonMale.isChecked())
                {
                    mainViewModel.setGender(radioButtonMale.getText().toString());
                }
                else if(radioButtonFemale.isChecked())
                {
                    mainViewModel.setGender(radioButtonFemale.getText().toString());
                }
                else
                {
                    mainViewModel.setGender(radioButtonUnknown.getText().toString());
                }

                //Create a cow object with user data
                Cow cow = new Cow(mainViewModel.getId(), mainViewModel.getDateOfBirth(), mainViewModel.getGender());
                mainViewModel.addCow(cow);

                //Send cow object to the database
                myDatabase.push().setValue(cow);
            }
        });
    }

    /**
     * Method for instantiating the recyclerView
     */
    private void setupRecyclerViewer() {
        cowAdapter = new CowAdapter(this.getApplication(), mainViewModel);
        recyclerViewCow = findViewById(R.id.recyclerViewCow);
        recyclerViewCow.setAdapter(cowAdapter);
        recyclerViewCow.setLayoutManager(new LinearLayoutManager(this));
    }

    /**
     * Method for instantiating the buttonCalendar
     */
    private void setupButtonCalendar() {
        buttonCalendar = findViewById(R.id.buttonCalendar);
        buttonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    /**
     * Method for showing new fragment with calendar
     */
    public void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}