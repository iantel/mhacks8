package hype.mhacks8.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hype.mhacks8.Drug;
import hype.mhacks8.R;

/**
 * Created by Ian on 2016-10-08.
 */
public class PrescriptionViewAdapter extends RecyclerView.Adapter {
    public List<Drug> medications = new ArrayList<>();
    public PrescriptionViewAdapter (int i){
        super();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tripsView = inflater.inflate(R.layout.prescription_adapter_item, parent, false);
        return new PrescriptionViewHolder(tripsView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (!medications.isEmpty()) {
            ((PrescriptionViewHolder) holder).mDrugNameTextView.setText(medications.get(position).getName());
            ((PrescriptionViewHolder) holder).mConditionTextView.setText(medications.get(position).getDosage());
        }
    }

    @Override
    public int getItemCount() {
        //TODO Replace item count with number according to DB call
        return medications.size();
    }

    //Individual items in the prescription list
    public static class PrescriptionViewHolder extends RecyclerView.ViewHolder{
        TextView mDrugNameTextView;
        TextView mConditionTextView;
        ImageView mDrugImage;

        public PrescriptionViewHolder(View itemView) {
            super(itemView);
            mDrugNameTextView = (TextView) itemView.findViewById(R.id.drug_name);
            mConditionTextView = (TextView) itemView.findViewById(R.id.condition);
        }
    }
}
