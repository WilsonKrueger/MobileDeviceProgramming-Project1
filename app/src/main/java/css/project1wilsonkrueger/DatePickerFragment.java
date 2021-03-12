package css.project1wilsonkrueger;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.DatePicker;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.DateFormat;
import java.util.Calendar;

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    String dob;
    MainViewModel mainViewModel;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        // Create a new instance of DatePickerDialog and return it
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        //Month is from 0 to 11 so need to increment once
        month++;
        //Store selected date in variable
        dob = month + "/" + day + "/" + year;
        Log.d("CIS 3334", "date = " + dob);

        //Set the date in the mainViewModel
        mainViewModel.setDateOfBirth(dob);
    }


}