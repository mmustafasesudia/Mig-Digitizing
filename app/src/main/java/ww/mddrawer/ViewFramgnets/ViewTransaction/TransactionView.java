package ww.mddrawer.ViewFramgnets.ViewTransaction;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ww.mddrawer.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TransactionView extends Fragment {

    View v1;
    //Important to declare array for modal class
    ArrayList<TransactionDetail> data = new ArrayList<TransactionDetail>();

    RecyclerView rv;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction_view, container, false);

        rv = view.findViewById(R.id.transaction);
        rv.setHasFixedSize(true);
        TransactionDetail Details = new TransactionDetail("1", "dnt", "aa", "aa", "aa");
        data.add(Details);
        AdapterTransaction adapter = new AdapterTransaction(getActivity(), data);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;
    }

}
