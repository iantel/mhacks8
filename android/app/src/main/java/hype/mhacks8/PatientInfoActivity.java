package hype.mhacks8;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.beardedhen.androidbootstrap.BootstrapButton;

import org.w3c.dom.Text;

import hype.mhacks8.adapters.PrescriptionViewAdapter;

public class PatientInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String name = getIntent().getStringExtra("NAME");
        final String condition = getIntent().getStringExtra("CONDITION");

        TextView mName = (TextView) findViewById(R.id.patient_info_name);
        TextView mCondition  = (TextView) findViewById(R.id.patient_condition_name);

        mName.setText(name);
        mCondition.setText(condition);

        final PrescriptionViewAdapter adapter = new PrescriptionViewAdapter(10);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        final RecyclerView patientPrescriptions = (RecyclerView) findViewById(R.id.prescription_view);
        patientPrescriptions.setAdapter(adapter);
        patientPrescriptions.setLayoutManager(manager);

        final BootstrapButton addPrescription = (BootstrapButton) findViewById(R.id.add_prescription);

        addPrescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View newPill = findViewById(R.id.prescription_adapter_item);
                TextView drugName = (TextView) newPill.findViewById(R.id.drug_name);
                TextView conditionName = (TextView) newPill.findViewById(R.id.condition);

                drugName.setText("Drug " + patientPrescriptions.getAdapter().getItemCount());
                conditionName.setText("Condition " + patientPrescriptions.getAdapter().getItemCount());
                patientPrescriptions.setAdapter(new PrescriptionViewAdapter(adapter.getItemCount() + 1));
                adapter.count += 1;
            }
        });
    }

}
