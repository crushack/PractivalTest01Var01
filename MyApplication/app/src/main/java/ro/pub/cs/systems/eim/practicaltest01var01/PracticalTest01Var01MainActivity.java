package ro.pub.cs.systems.eim.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    private Button North;
    private Button South;
    private Button East;
    private Button West;
    private Button Navigate;

    private TextView Summary;

    private long clickedButtons;

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey("clickedButtons")) {
            clickedButtons = savedInstanceState.getLong("clickedButtons");
        } else {
            clickedButtons = 0;
        }
        Log.d("alup", String.valueOf(clickedButtons));
    }

    @Override
    protected void onSaveInstanceState(Bundle instanceState) {
        instanceState.putLong("clickedButtons", clickedButtons);

        super.onSaveInstanceState(instanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        North = (Button) findViewById(R.id.north);
        South = (Button) findViewById(R.id.south);
        East = (Button) findViewById(R.id.east);
        West = (Button) findViewById(R.id.west);
        Navigate = (Button) findViewById(R.id.navigate);

        Navigate.setOnClickListener(this);
        North.setOnClickListener(this);
        South.setOnClickListener(this);
        East.setOnClickListener(this);
        West.setOnClickListener(this);

        Summary = (TextView) findViewById(R.id.summary);

        Log.d("alup", String.valueOf(clickedButtons));
    }

    public void addDirection(String s) {
        if (Summary.length() == 0) {
            Summary.append(s);
        } else {
            Summary.append(", " + s);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        ++clickedButtons;
        if (v == North) {
            addDirection("North");
        } else if (v == South) {
            addDirection("South");
        } else if (v == East) {
            addDirection("East");
        } else if (v == West) {
            addDirection("West");
        } else if (v == Navigate) {
            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var01MainActivity.class);
            intent.putExtra("commands", Summary.getText());
            startActivityForResult(intent, 1);
            --clickedButtons;
        } else {
            --clickedButtons;
        }
    }
}
