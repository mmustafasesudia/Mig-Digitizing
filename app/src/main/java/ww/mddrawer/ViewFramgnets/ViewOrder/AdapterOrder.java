package ww.mddrawer.ViewFramgnets.ViewOrder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ww.mddrawer.R;
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
        holder.tv_order_id.setText("" + current.getOrderid());
        holder.tv_order_name.setText("" + current.getDesignname());
        holder.tv_amount.setText("" + current.getAmount());
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
            tv_amount = v.findViewById(R.id.tv_amount);
            tv_order_detail = v.findViewById(R.id.tv_order_detail);
            tv_order_detail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    /*TextView tv_order_id = findViewById(R.id.tv_order_id);
        //tv_order_id.setText(orderDetails.indexOf(0));
        TextView tv_client_id = findViewById(R.id.tv_client_id);
        TextView tv_order_date = findViewById(R.id.tv_order_date);
        TextView tv_c_email = findViewById(R.id.tv_c_email);
        TextView tv_d_name = findViewById(R.id.tv_d_name);
        TextView tv_color_name = findViewById(R.id.tv_color_name);
        TextView tv_width = findViewById(R.id.tv_width);
        TextView tv_height = findViewById(R.id.tv_height);
        TextView tv_fabric = findViewById(R.id.tv_fabric);
        TextView tv_fabric_type = findViewById(R.id.tv_fabric_type);
        TextView tv_appliq = findViewById(R.id.tv_appliq);
        TextView tv_no_of_appli = findViewById(R.id.tv_no_of_appli);
        TextView tv_color_of_app = findViewById(R.id.tv_color_of_app);
        TextView tv_design_format = findViewById(R.id.tv_design_format);
        TextView tv_time_frame = findViewById(R.id.tv_time_frame);
        TextView tv_sew = findViewById(R.id.tv_sew);
        TextView tv_auto_thre = findViewById(R.id.tv_auto_thre);
        TextView tv_status = findViewById(R.id.tv_status);
        TextView tv_inst = findViewById(R.id.tv_inst);
        TextView tv_comments = findViewById(R.id.tv_comments);
        TextView tv_order_creation_date = findViewById(R.id.tv_order_creation_date);
        TextView tv_invoice_no = findViewById(R.id.tv_invoice_no);
        TextView tv_invoice_status = findViewById(R.id.tv_invoice_status);
        TextView tv_stiches = findViewById(R.id.tv_stiches);
        TextView tv_amount_to_pay = findViewById(R.id.tv_amount_to_pay);*/
                    OrderViewDetail current = arrayList.get(getAdapterPosition());
                    Intent intent = new Intent(acontext, OrderDetail.class);
                    //intent.putExtra("myList", new Gson().toJson( arrayList));
                    //intent.putExtra("myList", arrayList);
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
