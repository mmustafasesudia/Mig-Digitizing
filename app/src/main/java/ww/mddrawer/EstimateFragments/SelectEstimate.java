package ww.mddrawer.EstimateFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import ww.mddrawer.R;
import ww.mddrawer.Utills.FragmentReplace;

public class SelectEstimate extends Fragment {

    String[] arraySpinner = new String[]{
            "Estimate Type", "Digitizing", "Vector", "Embroidered Patches"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_estimate, container, false);


        Spinner s = view.findViewById(R.id.spinner);
        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s.setAdapter(adapter);


        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragmentName = null;
                Fragment EstimateDigit = new EstimateDigit();
                Fragment EstimateVector = new EstimateVector();
                Fragment EstimatePatches = new EstimatePatches();

                if (position == 0) {


                } else if (position == 1) {
                    fragmentName = EstimateDigit;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

                } else if (position == 2) {

                    fragmentName = EstimateVector;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);
                } else if (position == 3) {

                    fragmentName = EstimatePatches;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }


    public void onNothingSelected(AdapterView<?> parent) {

    }


}
