package ww.mddrawer.ViewFramgnets.ViewOrder;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ww.mddrawer.R;
import ww.mddrawer.Utills.FragmentReplace;
import ww.mddrawer.fragment.AdvancePayment;
import ww.mddrawer.fragment.OrderDetail;

public class AdapterOrder extends RecyclerView.Adapter<AdapterOrder.MyViewHolder> {


    private Context acontext;
    private ArrayList<OrderViewDetail> arrayList;

    public AdapterOrder(Context context, ArrayList<OrderViewDetail> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_order, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        OrderViewDetail current = arrayList.get(position);
        holder.tv_order_id.setText("" + current.getId());
        holder.tv_order_name.setText("" + current.getDesignname());
        holder.tv_amount.setText("Rs : " + current.getAmount());
        holder.tv_status.setText("" + current.getPaiedstatus());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        public TextView tv_order_id, tv_order_name, tv_order_detail, tv_order_cancel, tv_status, tv_amount;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.order_Card);
            tv_order_id = v.findViewById(R.id.tv_order_id);
            tv_order_name = v.findViewById(R.id.tv_order_name);
            tv_status = v.findViewById(R.id.tv_status);
            tv_status.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    OrderViewDetail current = arrayList.get(getAdapterPosition());
                    if (current.getPaiedstatus().equals("Un-Paid  (Pay Now)")) {
                        Fragment homeFragment = null;
                        Fragment homeF = new AdvancePayment();
                        homeFragment = homeF;
                        FragmentReplace.replaceFragment((AppCompatActivity) acontext, homeFragment, R.id.frame_container);

                    }
                }
            });
            tv_amount = v.findViewById(R.id.tv_amount);
            tv_order_detail = v.findViewById(R.id.tv_order_detail);
            tv_order_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    OrderViewDetail current = arrayList.get(getAdapterPosition());
                    Intent intent = new Intent(acontext, OrderDetail.class);
                    Log.v("OOO", "" + current.getOrderid() + "" + current.getDesignname());
                    intent.putExtra("order_id", current.getOrderid());
                    intent.putExtra("order_by", current.getOrderedby());
                    intent.putExtra("order_date", current.getOrderDate());
                    intent.putExtra("design_name", current.getDesignname());
                    intent.putExtra("name_color", current.getNamecolors());
                    intent.putExtra("width", current.getDesignsize_width());
                    intent.putExtra("height", current.getDesignsize_height());
                    intent.putExtra("fabric", current.getFabric());
                    intent.putExtra("f_type", current.getFabric_type());
                    intent.putExtra("appli", current.getApplique());
                    intent.putExtra("num_app", current.getNumappliques());
                    intent.putExtra("color_app", current.getColorappliques());
                    intent.putExtra("d_format", current.getDesignformat());
                    intent.putExtra("time_frame", current.getTimeframe());
                    intent.putExtra("sew", current.getSewsample());
                    intent.putExtra("auto", current.getAutothread());
                    intent.putExtra("state", current.getState());
                    intent.putExtra("instr", current.getInstructions());
                    intent.putExtra("inv_date", current.getInvoiceDate());
                    intent.putExtra("modify_status", current.getModify_status());
                    intent.putExtra("stic", current.getStiches());
                    intent.putExtra("amt", current.getAmount());
                    acontext.startActivity(intent);
                }
            });
            tv_order_cancel = v.findViewById(R.id.tv_order_cancel);
        }

    }

}
