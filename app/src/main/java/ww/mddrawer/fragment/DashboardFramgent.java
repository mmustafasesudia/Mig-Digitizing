package ww.mddrawer.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ww.mddrawer.EstimateFragments.SelectEstimate;
import ww.mddrawer.OrdersFramgents.SelectOrder;
import ww.mddrawer.R;
import ww.mddrawer.Utills.FragmentReplace;
import ww.mddrawer.ViewFramgnets.ViewEdit.EditView;
import ww.mddrawer.ViewFramgnets.ViewEstimate.EstimateView;
import ww.mddrawer.ViewFramgnets.ViewOrder.OrderView;
import ww.mddrawer.ViewFramgnets.ViewTransaction.TransactionView;


public class DashboardFramgent extends Fragment {


    LinearLayout placeorder;
    LinearLayout placeestimate;
    LinearLayout viewTransactions1;
    LinearLayout ViewOrder;
    LinearLayout ViewEstimate;
    LinearLayout ViewEdit;

    public DashboardFramgent() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        getActivity().setTitle("Dashboard");

        placeorder = view.findViewById(R.id.imageView);
        placeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragmentName = null;
                Fragment MapFragment = new SelectOrder();
                fragmentName = MapFragment;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

            }
        });
        placeestimate = view.findViewById(R.id.placeest1);
        placeestimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment fragmentName = null;
                Fragment MapFragment = new SelectEstimate();
                fragmentName = MapFragment;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

            }
        });

        viewTransactions1 = view.findViewById(R.id.vTransaction);

        viewTransactions1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentName = null;
                Fragment TransactionView = new TransactionView();
                fragmentName = TransactionView;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

            }
        });


        ViewEstimate = view.findViewById(R.id.vEstimate);

        ViewEstimate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentName = null;
                Fragment EstimateView = new EstimateView();
                fragmentName = EstimateView;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

            }
        });

        ViewOrder = view.findViewById(R.id.vOrder);

        ViewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentName = null;
                Fragment OrderView = new OrderView();
                fragmentName = OrderView;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);
            }
        });

        ViewEdit = view.findViewById(R.id.vEdit);

        ViewEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentName = null;
                Fragment EditView = new EditView();
                fragmentName = EditView;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);

            }
        });

        return view;
    }


}


