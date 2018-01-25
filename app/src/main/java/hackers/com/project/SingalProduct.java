package hackers.com.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SingalProduct extends AppCompatActivity {
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singal__product_activity);

        tv= findViewById(R.id.product_name);
        tv.setText(getIntent().getStringExtra("Productname"));
    }
}
