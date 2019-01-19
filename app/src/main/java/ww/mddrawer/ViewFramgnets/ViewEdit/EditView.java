package ww.mddrawer.ViewFramgnets.ViewEdit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ww.mddrawer.R;


public class EditView extends Fragment {
    RecyclerView rv;
    ArrayList<EditDetail> data = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_view, container, false);


        rv = view.findViewById(R.id.edits);
        rv.setHasFixedSize(true);
        EditDetail Details = new EditDetail("Mr Craftsman", "4 Nov", "$20", "Unpaid (Paynow)");
        data.add(Details);
        AdapterEdit adapter12 = new AdapterEdit(getActivity(), data);
        rv.setAdapter(adapter12);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);

        return view;
    }


}
