package ww.mddrawer.ViewFramgnets.ViewTransaction;


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

        getActivity().setTitle("Your Recent Invoices");
        rv = view.findViewById(R.id.transaction);
        rv.setHasFixedSize(true);

        loadData();

        return view;
    }

    public void loadData() {
        /*mode=getorder&email=mm@gmail.com*/
        ProgressDialogClass.showProgress(getActivity());
        AndroidNetworking.get(Config.URL)
                .addQueryParameter("mode", "all_transc")
                .addQueryParameter("email", /*Config.getEmail(getActivity())*/"im.uk90@gmail.com")
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
                                TransactionDetail transactionDetail = new TransactionDetail(
                                        jsonObject.getString("orderid"), jsonObject.getString("paieddate"),
                                        jsonObject.getString("invoiceNo"), jsonObject.getString("transtype"),
                                        jsonObject.getString("createDate"), jsonObject.getString("dateInvoiceCreated"),
                                        jsonObject.getString("payDate"), jsonObject.getString("refId"),
                                        jsonObject.getString("chargeBy")
                                );
                                data.add(transactionDetail);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        AdapterTransaction adapter = new AdapterTransaction(getActivity(), data);
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
