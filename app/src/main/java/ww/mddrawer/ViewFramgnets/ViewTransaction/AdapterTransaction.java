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
        holder.invoice.setText(current.getInvoice());
        holder.whattype.setText(current.getType());
        holder.transaction_date.setText(current.getDnt());
        holder.status.setText(current.getStatus1());
        holder.amount.setText(current.getAmount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView invoice, whattype, transaction_date, status, amount;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.transaction_card);
            invoice = v.findViewById(R.id.invoice);
            whattype = v.findViewById(R.id.type);
            transaction_date = v.findViewById(R.id.date);
            status = v.findViewById(R.id.status);
            amount = v.findViewById(R.id.amount);

        }

    }
}
