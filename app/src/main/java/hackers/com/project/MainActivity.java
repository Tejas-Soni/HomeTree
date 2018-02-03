package hackers.com.project;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button,button2;
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtEmail = findViewById(R.id.editText);
        edtPassword = findViewById(R.id.editText2);
        buttonclick();

    }
    public void buttonclick(){
        final Context context=this;
        button = (Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Date_Picker_Activity.class );
                startActivity(intent);
                finish();
            }
        });
        button2 = findViewById(R.id.login_button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Product_activity.class);
                startActivity(intent);
                finish();
                final String email = edtEmail.getText().toString().trim();
                final String password = edtPassword.getText().toString().trim();
                new AsyncLogin().execute(email,password);

            }
        });

    }


    private class AsyncLogin extends AsyncTask<String,Void,Void>{

        private WSLogin wsLogin;
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog = ProgressDialog.show(MainActivity.this,"","Please wait");
        }

        @Override
        protected Void doInBackground(String... strings) {
            wsLogin = new WSLogin(MainActivity.this);
            wsLogin.executeService(strings[0],strings[1]);
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(wsLogin.isSuccess()){

            }
            if(progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }


}
