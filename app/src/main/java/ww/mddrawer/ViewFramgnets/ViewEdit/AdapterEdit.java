package ww.mddrawer.ViewFramgnets.ViewEdit;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ww.mddrawer.R;

public class AdapterEdit extends RecyclerView.Adapter<AdapterEdit.MyViewHolder>


{

    private Context acontext;
    private ArrayList<EditDetail> arrayList;

    public AdapterEdit(Context context, ArrayList<EditDetail> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_edit, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EditDetail current = arrayList.get(position);
        holder.design.setText(current.getdName());
        holder.Status.setText(current.getStatus());
        holder.date.setText(current.getDate());
        holder.Amount.setText(current.getAmount());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView design, date, Status, Amount;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.edit_card);
            design = v.findViewById(R.id.dName);
            date = v.findViewById(R.id.date);
            Status = v.findViewById(R.id.status);
            Amount = v.findViewById(R.id.amount);

        }

    }

}
