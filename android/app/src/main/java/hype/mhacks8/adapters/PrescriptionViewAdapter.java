package hype.mhacks8.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import hype.mhacks8.R;

/**
 * Created by Ian on 2016-10-08.
 */
public class PrescriptionViewAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View tripsView = inflater.inflate(R.layout.prescription_adapter_item, parent, false);
        return new PrescriptionViewHolder(tripsView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PrescriptionViewHolder) holder).mDrugNameTextView.setText("Drug " + String.valueOf(position));
        ((PrescriptionViewHolder) holder).mConditionTextView.setText("Condition " + String.valueOf(position) );
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    //Individual items in the prescription list
    private static class PrescriptionViewHolder extends RecyclerView.ViewHolder{
        TextView mDrugNameTextView;
        TextView mConditionTextView;

        public PrescriptionViewHolder(View itemView) {
            super(itemView);
            mDrugNameTextView = (TextView) itemView.findViewById(R.id.drug_name);
            mConditionTextView = (TextView) itemView.findViewById(R.id.condition);
        }
    }
}
