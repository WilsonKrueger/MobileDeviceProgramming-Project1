package css.project1wilsonkrueger;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonCalendar;
    EditText editTextId;
    Button buttonInsert;

    RecyclerView recyclerViewCow;
    CowAdapter cowAdapter;
    MainViewModel mainViewModel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        editTextId = findViewById(R.id.editTextId);

        setupButtonCalendar();
        setupButtonInsert();
        setupRecyclerViewer();
    }

    private void setupButtonInsert() {
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = editTextId.getText().toString();
                mainViewModel.insert(id, "Test DOB", "Test Gender");
                cowAdapter.notifyDataSetChanged();
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