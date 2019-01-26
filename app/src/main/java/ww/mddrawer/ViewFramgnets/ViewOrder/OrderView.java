package ww.mddrawer.ViewFramgnets.ViewOrder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.ProgressDialogClass;

/**
 * A simple {@link Fragment} subclass.
 */
public class OrderView extends Fragment {

    View v1;
    //Important to declare array for modal class
    ArrayList<OrderViewDetail> data1 = new ArrayList<OrderViewDetail>();

    RecyclerView rv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order_view, container, false);

        getActivity().setTitle("Order Detail");

        rv = view.findViewById(R.id.card_view_order);
        rv.setHasFixedSize(true);


        loadData();

        return view;
    }

    public void loadData() {
        /*mode=getorder&email=mm@gmail.com*/
        ProgressDialogClass.showProgress(getActivity());
        AndroidNetworking.get(Config.URL)
                .addQueryParameter("mode", "getorder")
                .addQueryParameter("email", Config.getEmail(getActivity()))
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        String applique = "", status = "", paidStatus = "";
                        ProgressDialogClass.hideProgress();
                        // do anything with response
                        for (int i = 0; i < response.length(); i++) {
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                if (jsonObject.getString("applique").equals("0")) {
                                    applique = "NO";
                                } else {
                                    applique = "YES";
                                }
                                if (jsonObject.getString("state").equals("1")) {
                                    status = "Process";
                                } else if (jsonObject.getString("state").equals("2")) {
                                    status = "In Audit";
                                } else if (jsonObject.getString("state").equals("3")) {
                                    status = "Cancel";
                                } else if (jsonObject.getString("state").equals("4")) {
                                    status = "Quality Check";
                                } else if (jsonObject.getString("state").equals("5")) {
                                    status = "Pending Payment";
                                } else if (jsonObject.getString("state").equals("6")) {
                                    status = "Complete";
                                } else if (jsonObject.getString("state").equals("8")) {
                                    status = "Billing Depart";
                                } else if (jsonObject.getString("state").equals("99")) {
                                    status = "Remove";
                                } else if (jsonObject.getString("state").equals("95")) {
                                    status = "On Hold";
                                }

                                if (jsonObject.getString("paiedstatus").equals("0")) {
                                    paidStatus = "Un-Paid  (Pay Now)";
                                } else if (jsonObject.getString("paiedstatus").equals("1")) {
                                    paidStatus = "Paid";
                                }
                                OrderViewDetail newDetails = new OrderViewDetail(
                                        jsonObject.getString("id"), jsonObject.getString("orderid"), jsonObject.getString("orderedby"),
                                        jsonObject.getString("orderDate"), jsonObject.getString("designname"), jsonObject.getString("formtype"),
                                        jsonObject.getString("order_type"), jsonObject.getString("is_estimate"), jsonObject.getString("jobid"),
                                        jsonObject.getString("nocolors"), jsonObject.getString("namecolors"),
                                        jsonObject.getString("designsize_height"), jsonObject.getString("designsize_width"), jsonObject.getString("designsize_format"),
                                        jsonObject.getString("patch_qty"), jsonObject.getString("fabric"), jsonObject.getString("fabric_type"),
                                        jsonObject.getString("baking_material"), jsonObject.getString("qty"), applique,
                                        jsonObject.getString("numappliques"), jsonObject.getString("colorappliques"), jsonObject.getString("designformat"),
                                        jsonObject.getString("timeframe"), jsonObject.getString("sewsample"), jsonObject.getString("autothread"),
                                        jsonObject.getString("instructions"), jsonObject.getString("filename"), status,
                                        jsonObject.getString("payment"), jsonObject.getString("estimatedate"), jsonObject.getString("deliverydate"),
                                        jsonObject.getString("stiches"), jsonObject.getString("findus"), jsonObject.getString("amount"),
                                        paidStatus, jsonObject.getString("originalfile"), jsonObject.getString("generatedfile"),
                                        jsonObject.getString("pdfFile"), jsonObject.getString("orderDetail"), jsonObject.getString("embFile"),
                                        jsonObject.getString("invoiceDate"), jsonObject.getString("eta"), jsonObject.getString("estimateDetail"),
                                        jsonObject.getString("assignto"), jsonObject.getString("digit_by"), jsonObject.getString("qc_by"),
                                        jsonObject.getString("modify_status")
                                );
                                data1.add(newDetails);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AdapterOrder adapter = new AdapterOrder(getActivity(), data1);
                        rv.setAdapter(adapter);
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        ProgressDialogClass.hideProgress();
                    }
                });
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
    }

}
