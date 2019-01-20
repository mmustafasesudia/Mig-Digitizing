package ww.mddrawer.ViewFramgnets.ViewEdit;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

        return view;
    }

}
