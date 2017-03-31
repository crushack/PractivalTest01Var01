package ro.pub.cs.systems.eim.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity
        implements  View.OnClickListener{

    private TextView TextV;
    private Button Register;
    private Button Cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);

        Register = (Button)findViewById(R.id.register);
        Cancel = (Button)findViewById(R.id.cancel);
        TextV = (TextView)findViewById(R.id.textView);

        Register.setOnClickListener(this);
        Cancel.setOnClickListener(this);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("commands")) {
            TextV.setText(intent.getExtras().getString("commands"));
        }
    }

    @Override
    public void onClick(View v) {
        if (v == Register) {
            setResult(RESULT_OK, null);
        } else {
            setResult(RESULT_CANCELED, null);
        }
        finish();
    }
}
