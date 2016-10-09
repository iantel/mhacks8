package hype.mhacks8;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hype.mhacks8.adapters.PrescriptionViewAdapter;


public class MedicineScheduleFragment extends Fragment {

    public MedicineScheduleFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_medicine_schedule, container, false);
        RecyclerView prescriptionView = (RecyclerView) v.findViewById(R.id.prescription_view);
        PrescriptionViewAdapter adapter = new PrescriptionViewAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        prescriptionView.setAdapter(adapter);
        prescriptionView.setLayoutManager(layoutManager);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
