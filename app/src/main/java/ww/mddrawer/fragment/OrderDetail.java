package ww.mddrawer.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.ViewFramgnets.ViewOrder.OrderViewDetail;


public class OrderDetail extends Activity {

    ArrayList<OrderViewDetail> orderDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_order_detail);

        if (getIntent() != null && getIntent().getStringExtra("order_id") != null) {
            /*String jsonList = getIntent().getStringExtra("myList");
            orderDetails = new Gson().fromJson(jsonList, new TypeToken<ArrayList<OrderViewDetail>>() {
            }.getType());*/

            // ArrayList<OrderViewDetail> filelist =  (ArrayList<OrderViewDetail>)getIntent().getParcelableExtra("myList");

            //String orderDetails = getIntent().getStringExtra("myList");
            Log.v("JSON_LIST", "" + getIntent().getStringExtra("order_id"));

           /* intent.putExtra("order_id", current.getOrderid());
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
            intent.putExtra("amt", current.getAmount());*/

            TextView tv_order_id = findViewById(R.id.tv_order_id);
            tv_order_id.setText("" + getIntent().getStringExtra("order_id"));
            TextView tv_client_id = findViewById(R.id.tv_client_id);
            tv_client_id.setText("" + Config.getClinetID(this));
            TextView tv_order_date = findViewById(R.id.tv_order_date);
            tv_order_date.setText("" + getIntent().getStringExtra("order_date"));
            TextView tv_c_email = findViewById(R.id.tv_c_email);
            tv_c_email.setText("" + getIntent().getStringExtra("order_by"));
            TextView tv_d_name = findViewById(R.id.tv_d_name);
            tv_d_name.setText("" + getIntent().getStringExtra("design_name"));
            TextView tv_color_name = findViewById(R.id.tv_color_name);
            tv_color_name.setText("" + getIntent().getStringExtra("name_color"));
            TextView tv_width = findViewById(R.id.tv_width);
            tv_width.setText("" + getIntent().getStringExtra("width"));
            TextView tv_height = findViewById(R.id.tv_height);
            tv_height.setText("" + getIntent().getStringExtra("height"));
            TextView tv_fabric = findViewById(R.id.tv_fabric);
            tv_fabric.setText("" + getIntent().getStringExtra("fabric"));
            TextView tv_fabric_type = findViewById(R.id.tv_fabric_type);
            tv_fabric_type.setText("" + getIntent().getStringExtra("f_type"));
            TextView tv_appliq = findViewById(R.id.tv_appliq);
            tv_appliq.setText("" + getIntent().getStringExtra("appli"));
            TextView tv_no_of_appli = findViewById(R.id.tv_no_of_appli);
            tv_no_of_appli.setText("" + getIntent().getStringExtra("num_app"));
            TextView tv_color_of_app = findViewById(R.id.tv_color_of_app);
            tv_color_of_app.setText("" + getIntent().getStringExtra("color_app"));
            TextView tv_design_format = findViewById(R.id.tv_design_format);
            tv_design_format.setText("" + getIntent().getStringExtra("d_format"));
            TextView tv_time_frame = findViewById(R.id.tv_time_frame);
            tv_time_frame.setText("" + getIntent().getStringExtra("time_frame"));
            TextView tv_sew = findViewById(R.id.tv_sew);
            tv_sew.setText("" + getIntent().getStringExtra("sew"));
            TextView tv_auto_thre = findViewById(R.id.tv_auto_thre);
            tv_auto_thre.setText("" + getIntent().getStringExtra("auto"));
            TextView tv_status = findViewById(R.id.tv_status);
            tv_status.setText("" + getIntent().getStringExtra("state"));
            TextView tv_inst = findViewById(R.id.tv_inst);
            tv_inst.setText("" + getIntent().getStringExtra("instr"));
            TextView tv_comments = findViewById(R.id.tv_comments);
            tv_comments.setText("" + getIntent().getStringExtra("order_id"));
            TextView tv_order_creation_date = findViewById(R.id.tv_order_creation_date);
            tv_order_creation_date.setText("" + getIntent().getStringExtra("inv_date"));
            TextView tv_invoice_no = findViewById(R.id.tv_invoice_no);
            tv_invoice_no.setText("" + getIntent().getStringExtra("order_id"));
            TextView tv_invoice_status = findViewById(R.id.tv_invoice_status);
            tv_invoice_status.setText("" + getIntent().getStringExtra("modify_status"));
            TextView tv_stiches = findViewById(R.id.tv_stiches);
            tv_stiches.setText("" + getIntent().getStringExtra("stic"));
            TextView tv_amount_to_pay = findViewById(R.id.tv_amount_to_pay);
            tv_amount_to_pay.setText("" + getIntent().getStringExtra("amt"));

        }


    }
}
