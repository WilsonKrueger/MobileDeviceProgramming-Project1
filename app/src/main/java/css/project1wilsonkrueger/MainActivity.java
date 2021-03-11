package css.project1wilsonkrueger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    Button buttonCalendar;
    EditText editTextId;
    Button buttonInsert;

    RecyclerView recyclerViewCow;
    CowAdapter cowAdapter;
    MainViewModel mainViewModel;

    // variables for the Firebase database
    FirebaseDatabase database;
    DatabaseReference myDatabase;

    //Additional Variables
    String dateOfBirth;
    String gender;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        editTextId = findViewById(R.id.editTextId);

        // setup firebase variables
        database = FirebaseDatabase.getInstance();
        myDatabase = database.getReference("COW_OBJECTS");

        setupButtonCalendar();
        setupButtonInsert();
        setupRecyclerViewer();
        setupFirebaseUpdates();
    }

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

    private void setupButtonInsert() {
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                Cow cow = new Cow(id, "test DOB", "test gender");
                //mainViewModel.insert(id, "Test DOB", "Test Gender");
                myDatabase.push().setValue(cow);
            }
        });
    }

    private void setupRecyclerViewer() {
        cowAdapter = new CowAdapter(this.getApplication(), mainViewModel);
        recyclerViewCow = findViewById(R.id.recyclerViewCow);
        recyclerViewCow.setAdapter(cowAdapter);
        recyclerViewCow.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupButtonCalendar() {
        buttonCalendar = findViewById(R.id.buttonCalendar);
        buttonCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
    }

    public void showDatePickerDialog() {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");

    }
}