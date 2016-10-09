package hype.mhacks8;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class PatientInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String name = getIntent().getStringExtra("NAME");
        String condition = getIntent().getStringExtra("CONDITION");
        TextView mName = (TextView) findViewById(R.id.patient_info_name);
        TextView mCondition  = (TextView) findViewById(R.id.patient_condition_name);
        mName.setText(name);
        mCondition.setText(condition);
    }

}
