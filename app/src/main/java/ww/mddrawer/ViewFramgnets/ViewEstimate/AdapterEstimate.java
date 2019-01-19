package ww.mddrawer.ViewFramgnets.ViewEstimate;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ww.mddrawer.R;

public class AdapterEstimate extends RecyclerView.Adapter<AdapterEstimate.MyViewHolder>


{
    private Context acontext;
    private ArrayList<EstimateDetail> arrayList;

    public AdapterEstimate(Context context, ArrayList<EstimateDetail> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_estimate, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EstimateDetail current = arrayList.get(position);
        holder.jId.setText(current.getJobId());
        holder.dName.setText(current.getDesignName());
        holder.status.setText(current.getStatus());
        holder.amount.setText(current.getAmount());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView jId, dName, status, amount, convert;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.estimate_card);
            jId = v.findViewById(R.id.jId);
            dName = v.findViewById(R.id.dName);
            status = v.findViewById(R.id.status);
            amount = v.findViewById(R.id.amount);
            convert = v.findViewById(R.id.cToOrder);
        }

    }

}
