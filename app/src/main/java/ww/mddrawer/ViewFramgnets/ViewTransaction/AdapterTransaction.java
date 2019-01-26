package ww.mddrawer.ViewFramgnets.ViewTransaction;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;

public class AdapterTransaction extends RecyclerView.Adapter<AdapterTransaction.MyViewHolder> {

    private Context acontext;
    private ArrayList<TransactionDetail> arrayList;

    public AdapterTransaction(Context context, ArrayList<TransactionDetail> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_transaction, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TransactionDetail current = arrayList.get(position);
        holder.tv_orderid.setText("Order Id : " + current.getOrderid());
        holder.tv_user.setText("User : " + Config.getEmail(acontext));
        holder.tv_paieddate.setText("Paid Date : " + current.getPaieddate());
        holder.tv_invoiceNo.setText("Invoice No. : " + current.getInvoiceNo());
        holder.tv_transtype.setText("Trans. Type : " + current.getTranstype());
        holder.tv_createDate.setText("Create Date : " + current.getCreateDate());
        holder.tv_dateInvoiceCreated.setText("Invoice Created : " + current.getDateInvoiceCreated());
        holder.tv_payDate.setText("Pay Date : " + current.getPayDate());
        holder.tv_refId.setText("Ref Id : " + current.getRefId());
        holder.tv_chargeBy.setText("Charged By : " + current.getChargeBy());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView tv_orderid, tv_user, tv_paieddate, tv_invoiceNo, tv_transtype, tv_createDate, tv_dateInvoiceCreated, tv_payDate, tv_refId, tv_chargeBy;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.transaction_card);
            tv_orderid = v.findViewById(R.id.tv_orderid);
            tv_user = v.findViewById(R.id.tv_user);
            tv_paieddate = v.findViewById(R.id.tv_paieddate);
            tv_invoiceNo = v.findViewById(R.id.tv_invoiceNo);
            tv_transtype = v.findViewById(R.id.tv_transtype);
            tv_createDate = v.findViewById(R.id.tv_createDate);
            tv_dateInvoiceCreated = v.findViewById(R.id.tv_dateInvoiceCreated);
            tv_payDate = v.findViewById(R.id.tv_payDate);
            tv_refId = v.findViewById(R.id.tv_refId);
            tv_chargeBy = v.findViewById(R.id.tv_chargeBy);

        }

    }
}
