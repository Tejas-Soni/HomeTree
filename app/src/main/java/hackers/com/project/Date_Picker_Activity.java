package hackers.com.project;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Calendar;

/**
 * Created by Tejas Soni on 19-10-2017.
 */


public class Date_Picker_Activity extends AppCompatActivity {

    private Calendar calendar = Calendar.getInstance();
    private ImageButton btnShow;
    private TextView txtv;
    private  EditText fname,lname,mobileno,email,password,confmpassword;
    private Button reset,submit;
    private RadioGroup radiogp;
    private RadioButton male,female;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        btnShow = (ImageButton) findViewById(R.id.date_button);
        txtv = (TextView) findViewById(R.id.enterbirthdate);
        fname= (EditText) findViewById(R.id.first_name);
        lname= (EditText) findViewById(R.id.lastname);
        radiogp = (RadioGroup) findViewById(R.id.radiogp);
        male= (RadioButton) findViewById(R.id.male);
        female = (RadioButton) findViewById(R.id.female);
        mobileno = (EditText) findViewById(R.id.mobileno);
        email = (EditText) findViewById(R.id.emailid);
        password = (EditText) findViewById(R.id.password);
        confmpassword = (EditText) findViewById(R.id.confirm_password);
        reset = (Button) findViewById(R.id.reset_button);
        submit = (Button) findViewById(R.id.submit_button);
        resetbutton();
        submitbutton();
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog
                        = new DatePickerDialog(Date_Picker_Activity.this,
                        dateSetListener,
                        calendar.get(java.util.Calendar.YEAR),
                        calendar.get(java.util.Calendar.MONTH),
                        calendar.get(java.util.Calendar.DAY_OF_MONTH));


                datePickerDialog.show();


            }

        });
        txtv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final DatePickerDialog datePickerDialog
                        = new DatePickerDialog(Date_Picker_Activity.this,
                        dateSetListener,
                        calendar.get(java.util.Calendar.YEAR),
                        calendar.get(java.util.Calendar.MONTH),
                        calendar.get(java.util.Calendar.DAY_OF_MONTH));


                datePickerDialog.show();

            }
        });

    }


    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int DayOfMonth) {
            final String date = DayOfMonth + "-" + (month + 1) + "-" + year;
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, DayOfMonth);
            txtv.setText(getFormattedDate("dd-MM-yyyy"));

        }
    };

    private String getFormattedDate(
            final String formatOfDate) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(formatOfDate, Locale.getDefault());
        return dateFormat.format(calendar.getTime());

    }

    ;
    public void resetbutton(){
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname.setText("");
                lname.setText("");
                mobileno.setText("");
                email.setText("");
                password.setText("");
                confmpassword.setText("");
                txtv.setText("");
                radiogp.clearCheck();

            }
        });

    }

    public void submitbutton(){

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String pswd =password.getText().toString();
                final  String cnfpaswd = confmpassword.getText().toString();

                if(!pswd.equals(cnfpaswd)){
                   // Toast.makeText(Date_Picker_Activity.this,"Password Not Matching",Toast.LENGTH_LONG).show();
                    Snackbar snackbar;
                    Snackbar.make(submit,"Password Not Same",Snackbar.LENGTH_LONG).show();
                }

            }
        });
    }
}


