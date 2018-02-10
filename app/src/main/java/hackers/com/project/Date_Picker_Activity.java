package hackers.com.project;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
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


import hackers.com.project.model.ResSignupModel;

/**
 * Created by Tejas Soni on 19-10-2017.
 */


public class Date_Picker_Activity extends AppCompatActivity {

    private Calendar calendar = Calendar.getInstance();
    private ImageButton btnShow;
    private TextView txtv, intv;
    private EditText fname, lname, mobileno, email, password, confmpassword;
    private Button reset, submit;
    private RadioGroup radiogp;
    private RadioButton male, female;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);
        btnShow = (ImageButton) findViewById(R.id.date_button);
        intv = (TextView) findViewById(R.id.iamid);
        txtv = (TextView) findViewById(R.id.enterbirthdate);
        fname = (EditText) findViewById(R.id.first_name);
        lname = (EditText) findViewById(R.id.lastname);
        radiogp = (RadioGroup) findViewById(R.id.radiogp);
        male = (RadioButton) findViewById(R.id.male);
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
            txtv.setText(getFormattedDate("yyyy-MM-dd"));

        }
    };

    private String getFormattedDate(
            final String formatOfDate) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat(formatOfDate, Locale.getDefault());
        return dateFormat.format(calendar.getTime());

    }

    ;

    public void resetbutton() {
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
                intv.setText("");
                radiogp.clearCheck();

            }
        });

    }
    public String we;

    public void radiobtnclick(View view){
        String userGender = "";
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.male:
                if(checked) {
                    userGender = "male";
                    we=userGender;
                    break;
                }
            case R.id.female:
                if(checked){
                    userGender="female";
                    we=userGender;
                    break;

                }
        }

    }

    public void submitbutton() {

        submit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                final String pswd = password.getText().toString();
                final String cnfpaswd = confmpassword.getText().toString();
               final String fname1 = fname.getText().toString().trim();
                final String lname1 = lname.getText().toString().trim();
                final String radiogroup = we;
                final String mobilenum = mobileno.getText().toString().trim();
                final String emailid = email.getText().toString().trim();
                final String birthdate = txtv.getText().toString().trim();




                if (fname.getText().toString().length() == 0) {
                    fname.setError("First Name Not Entered");
                    fname.requestFocus();
                } else if (lname.getText().toString().length() == 0) {
                    lname.setError("Last Name Not Entered");
                    lname.requestFocus();
                } else if (radiogp.getCheckedRadioButtonId() == -1) {
                    male.setError("Gender Not Selected");
                    female.setError("Gender Not Selected");
                    female.requestFocus();
                } else if (mobileno.getText().toString().length() == 0) {
                    mobileno.setError("Mobile Number Not Entered");
                    mobileno.requestFocus();
                } else if (email.getText().toString().length() == 0) {
                    email.setError("Email Not Entered");
                    email.requestFocus();
                } else if (!emailid.matches(emailPattern)) {
                    email.setError("Enter Valid Email id");
                    email.requestFocus();
                } else if (password.getText().toString().length() == 0) {
                    password.setError("Password Not Entered");
                    password.requestFocus();
                } else if (password.getText().toString().length() < 8) {
                    password.setError("Password Must be Alteast 8 character");
                    password.requestFocus();
                } else if (confmpassword.getText().toString().length() == 0) {
                    confmpassword.setError("Confirm Password Not Entered");
                    confmpassword.requestFocus();
                } else if (!pswd.equals(cnfpaswd)) {
                    password.setError("Password Not Same");
                    password.requestFocus();
                    confmpassword.setError("Confirm Password Not Same");
                    confmpassword.requestFocus();
                } else if (txtv.getText().toString().length() == 0) {
                    txtv.setError("Enter Birth Date");
                    txtv.requestFocus();
                } else {

                    new Date_Picker_Activity.AsyncSignup().execute(fname1,lname1,radiogroup,mobilenum,emailid,pswd,birthdate);

//                    ChangeActivity();
                }


            }
        });

    }

//    public void ChangeActivity() {
//
//        Intent intent = new Intent(Date_Picker_Activity.this, Product_activity.class);
//        startActivity(intent);
//        finish();
//
//    }
    private class AsyncSignup extends AsyncTask<String,Void,Void> {

        private WSSignUp wsSignup;
        private ProgressDialog progressDialog;
        private ResSignupModel resSignupModel;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(Date_Picker_Activity.this,"","Please wait");
        }

        @Override
        protected Void doInBackground(String... strings) {
            wsSignup = new WSSignUp(Date_Picker_Activity.this);
            resSignupModel = wsSignup.executeService(strings[0],strings[1],strings[2],strings[3],strings[4],strings[5],strings[6]);
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(resSignupModel.getResponse() ==0){
                Intent intent = new Intent(Date_Picker_Activity.this,Product_activity.class);
                startActivity(intent);
                finish();
            }else{
                // Toast.makeText(MainActivity.this, resSignupModel.getMessage(), Toast.LENGTH_SHORT).show();

              //  edtEmail.setError(resSignupModel.getMessage());
            }
            if(progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }

    }
    }






