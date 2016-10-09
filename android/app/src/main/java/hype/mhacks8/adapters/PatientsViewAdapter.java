package hype.mhacks8.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import hype.mhacks8.R;

/**
 * Created by Ian on 2016-10-08.
 */
public class PatientsViewAdapter extends RecyclerView.Adapter{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tripsView = inflater.inflate(R.layout.patient_adapter_item, parent, false);
        return new PrescriptionViewHolder(tripsView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PrescriptionViewHolder) holder).mPatientNameTextView.setText("Patient " + String.valueOf(position));
        ((PrescriptionViewHolder) holder).mPatientConditionTextView.setText("Condition " + String.valueOf(position) );
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
        ImageView mDrugImage;

        public PrescriptionViewHolder(View itemView) {
            super(itemView);
            mPatientNameTextView = (TextView) itemView.findViewById(R.id.patient_name);
            mPatientConditionTextView = (TextView) itemView.findViewById(R.id.patient_condition);
        }
    }
}
