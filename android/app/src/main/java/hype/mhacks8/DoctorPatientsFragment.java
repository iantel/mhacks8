package hype.mhacks8;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hype.mhacks8.adapters.PatientsViewAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class DoctorPatientsFragment extends Fragment {

    public DoctorPatientsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_doctor_patients, container, false);
        RecyclerView patientsView = (RecyclerView) v.findViewById(R.id.patients_view);
        LinearLayoutManager manager = new LinearLayoutManager(this.getActivity());
        PatientsViewAdapter adapter = new PatientsViewAdapter();
        patientsView.setAdapter(adapter);
        patientsView.setLayoutManager(manager);
        return v;
    }

}
