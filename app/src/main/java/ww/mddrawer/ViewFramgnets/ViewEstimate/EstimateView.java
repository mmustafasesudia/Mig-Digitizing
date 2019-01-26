package ww.mddrawer.ViewFramgnets.ViewEstimate;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ww.mddrawer.R;


public class EstimateView extends Fragment {

    RecyclerView rv;
    ArrayList<EstimateDetail> data2 = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estimate_view, container, false);

        getActivity().setTitle("Estimate View");

        rv = view.findViewById(R.id.estimate);
        rv.setHasFixedSize(true);
        EstimateDetail Details1 = new EstimateDetail("Mr Craftsman", "4 Nov", "$20", "Unpaid (Paynow)", "");
        data2.add(Details1);
        AdapterEstimate adap = new AdapterEstimate(getActivity(), data2);
        rv.setAdapter(adap);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;
    }


}
