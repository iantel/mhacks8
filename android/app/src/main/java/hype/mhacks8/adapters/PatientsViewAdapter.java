package hype.mhacks8.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hype.mhacks8.PatientInfoActivity;
import hype.mhacks8.R;

/**
 * Created by Ian on 2016-10-08.
 */
public class PatientsViewAdapter extends RecyclerView.Adapter{
    private ArrayList<String> patients;

    private Context context;

    public PatientsViewAdapter(){

    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tripsView = inflater.inflate(R.layout.patient_adapter_item, parent, false);

        return new PrescriptionViewHolder(tripsView);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        ((PrescriptionViewHolder) holder).mPatientNameTextView.setText("Patient " + String.valueOf(position));
        ((PrescriptionViewHolder) holder).mPatientConditionTextView.setText("Condition " + String.valueOf(position) );
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent patientInfoIntent = new Intent(PatientsViewAdapter.this.context, PatientInfoActivity.class);
                patientInfoIntent.putExtra("NAME",(((PrescriptionViewHolder) holder).mPatientNameTextView.getText().toString()));
                patientInfoIntent.putExtra("CONDITION",(((PrescriptionViewHolder) holder).mPatientConditionTextView.getText().toString()));
                context.startActivity(patientInfoIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //TODO Replace item count with number according to DB call
        return 10;
    }

    //Individual items in the prescription list
    private static class PrescriptionViewHolder extends RecyclerView.ViewHolder{
        TextView mPatientNameTextView;
        TextView mPatientConditionTextView;
        String patientSchedule;
        ImageView mDrugImage;

        public PrescriptionViewHolder(View itemView) {
            super(itemView);
            mPatientNameTextView = (TextView) itemView.findViewById(R.id.patient_name);
            mPatientConditionTextView = (TextView) itemView.findViewById(R.id.patient_condition);
        }
    }
}
