package ww.mddrawer.OrdersFramgents;


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


public class SelectOrder extends Fragment {


    String[] arraySpinner = new String[]{
            "Order Type", "Digitizing", "Vector", "Embroidered Patches"
    };

    public SelectOrder() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_select_order, container, false);

        Spinner s = view.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragmentName = null;
                Fragment Order_Digit = new OrderDigit();
                Fragment Order_Vector = new OrderVector();
                Fragment OrderPatches = new OrderPatches();

                if (position == 0) {

                } else if (position == 1) {
                    fragmentName = Order_Digit;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

                } else if (position == 2) {
                    fragmentName = Order_Vector;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

                } else if (position == 3) {

                    fragmentName = OrderPatches;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }
}






