package ww.mddrawer.EstimateFragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.FragmentReplace;
import ww.mddrawer.Utills.NetworkConnectivityClass;
import ww.mddrawer.Utills.ProgressDialogClass;


public class EstimateVector extends Fragment implements View.OnClickListener {

    String[] arraySpinner = new String[]{
            "Vector", "Digitizing", "Embroidered Patches"
    };
    String[] colornumber = new String[]{
            "Number of Colors", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "14", "15", "16"
    };
    String[] sizetypes = new String[]{
            "Inches", "Cm", "Mm"};

    String[] types = new String[]{
            "Format", ".AI", "PES"};

    String[] timeframe1 = new String[]{
            "Time Frame", "Normal Turnaround (12-24 hours)", "Urgent (3-6 hours)"};


    Spinner sp_mig_type, sp_no_of_color, sp_size_type, sp_emb_type, sp_time_frame;
    Button btn_submit, btn_attach_pic;
    EditText et_design_name, et_color_name, et_height, et_width, et_desc, et_order_number;
    CheckBox cb_non_prop_size;
    ImageView img_attach_preview;

    Bitmap bitmap;
    ByteArrayOutputStream bStream;
    byte[] byteArray;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_estimate_vector, container, false);


        et_design_name = view.findViewById(R.id.et_design_name);
        et_color_name = view.findViewById(R.id.et_color_name);
        et_height = view.findViewById(R.id.et_height);
        et_width = view.findViewById(R.id.et_width);
        et_desc = view.findViewById(R.id.et_desc);
        et_order_number = view.findViewById(R.id.et_order_number);

        cb_non_prop_size = view.findViewById(R.id.cb_non_prop_size);

        img_attach_preview = view.findViewById(R.id.img_attach_preview);

        btn_attach_pic = view.findViewById(R.id.btn_attach_pic);
        btn_submit = view.findViewById(R.id.btn_submit);


        sp_mig_type = view.findViewById(R.id.sp_mig_type);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_mig_type.setAdapter(adapter);
        sp_mig_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Fragment fragmentName = null;
                Fragment Order_Digit = new EstimateDigit();
                Fragment OrderPatches = new EstimatePatches();

                if (position == 0) {

                } else if (position == 1) {
                    fragmentName = Order_Digit;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);
                } else if (position == 2) {
                    fragmentName = OrderPatches;
                    FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        sp_no_of_color = view.findViewById(R.id.sp_no_of_color);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, colornumber);
        adap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_no_of_color.setAdapter(adap);


        sp_size_type = view.findViewById(R.id.sp_size_type);
        ArrayAdapter<String> adap1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, sizetypes);
        adap1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_size_type.setAdapter(adap1);

        sp_emb_type = view.findViewById(R.id.sp_emb_type);
        ArrayAdapter<String> adap3 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, types);
        adap3.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_emb_type.setAdapter(adap3);


        sp_time_frame = view.findViewById(R.id.sp_time_frame);
        ArrayAdapter<String> adap4 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, timeframe1);
        adap4.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_time_frame.setAdapter(adap4);


        btn_attach_pic.setOnClickListener(this);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_sp_mig_type = sp_mig_type.getSelectedItem().toString();
                String str_sp_no_of_color = sp_no_of_color.getSelectedItem().toString();
                String str_sp_size_type = sp_size_type.getSelectedItem().toString();
                String str_sp_time_frame = sp_time_frame.getSelectedItem().toString();
                String str_sp_emb_type = sp_emb_type.getSelectedItem().toString();

                String str_desgin_name = et_design_name.getText().toString();
                String str_color_name = et_color_name.getText().toString();
                String str_height = et_height.getText().toString();
                String str_width = et_width.getText().toString();
                String str_desc = et_desc.getText().toString();

                String str_cb_non_prop_size = "";


                if (cb_non_prop_size.isChecked()) {
                    str_cb_non_prop_size = "YES";
                }

                if (et_design_name.getText().toString().isEmpty()) {
                    et_design_name.setError("Design Name Cannot Be Empty");
                    requestFocus(et_design_name);
                }
                if (sp_no_of_color.getSelectedItemPosition() == 0) {
                    Toast.makeText(getActivity(), "Please Select Number of Colors", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (et_color_name.getText().toString().isEmpty()) {
                    et_color_name.setError("Colors Cannot Be Empty");
                    requestFocus(et_color_name);
                }
                if (et_height.getText().toString().isEmpty()) {
                    et_height.setError("Height Cannot Be Empty");
                    requestFocus(et_height);
                }
                if (et_width.getText().toString().isEmpty()) {
                    et_width.setError("Width Cannot Be Empty");
                    requestFocus(et_width);
                }

                if (sp_time_frame.getSelectedItemPosition() == 0) {
                    Toast.makeText(getActivity(), "Please Select Time Frame", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (bitmap == null) {
                    //et_order_number.setError("Design Name Cannot Be Empty");
                    //requestFocus(et_order_number);
                    Toast.makeText(getActivity(), "Please Upload Image", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (NetworkConnectivityClass.isNetworkAvailable(getActivity())) {
                    sendData();
                } else {
                    Snackbar.make(getActivity().findViewById(android.R.id.content), "Internet Not Connected",
                            Snackbar.LENGTH_SHORT).show();
                }
                Toast.makeText(getActivity(), "Done", Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }


    private void startDialog() {
        AlertDialog.Builder myAlertDialog = new AlertDialog.Builder(
                getActivity());
        myAlertDialog.setTitle("Upload Pictures Option");
        myAlertDialog.setMessage("How do you want to set your picture?");

        myAlertDialog.setPositiveButton("Gallery",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(pickPhoto, 1);

                    }
                });

        myAlertDialog.setNegativeButton("Camera",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {

                        Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                        startActivityForResult(takePicture, 0);
                    }
                });
        myAlertDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {
            case 0:
                if (resultCode == getActivity().RESULT_OK) {

                    bitmap = (Bitmap) imageReturnedIntent.getExtras().get("data");
                    bStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
                    byteArray = bStream.toByteArray();
                    img_attach_preview.setVisibility(View.VISIBLE);
                    img_attach_preview.setImageBitmap(bitmap);

                }

                break;
            case 1:
                if (resultCode == getActivity().RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
//                    img_profile_image.setImageURI(selectedImage);

                    bitmap = null;
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), selectedImage);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    bStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
                    byteArray = bStream.toByteArray();
                    img_attach_preview.setVisibility(View.VISIBLE);
                    img_attach_preview.setImageBitmap(bitmap);

                }
                break;
        }
    }


    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_attach_pic:
                startDialog();
                break;
        }
    }

    public void sendData() {

        ProgressDialogClass.showProgress(getActivity());
        String currentDateandTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        AndroidNetworking.get(Config.URL)
                .addQueryParameter("mode", "order_add")
                .addQueryParameter("email", Config.getEmail(getActivity()))
                .addQueryParameter("clientid", Config.getClinetID(getActivity()))
                .addQueryParameter("timeget", currentDateandTime)
                .addQueryParameter("formtype", "1")

                .addQueryParameter("order_type", "2")
                .addQueryParameter("designname", et_design_name.getText().toString())

                .addQueryParameter("color_number", sp_no_of_color.getSelectedItem().toString())
                .addQueryParameter("color_name", et_color_name.getText().toString())

                .addQueryParameter("size", sp_size_type.getSelectedItem().toString())
                .addQueryParameter("size_height", et_height.getText().toString())
                .addQueryParameter("size_width", et_width.getText().toString())

                .addQueryParameter("fabric_product", "")
                .addQueryParameter("fabric_type", "")

                .addQueryParameter("sew_out", "")
                .addQueryParameter("thread_cutting", "")

                .addQueryParameter("qty", "")

                .addQueryParameter("backing_material", "")

                .addQueryParameter("time_frame", sp_time_frame.getSelectedItem().toString())

                .addQueryParameter("dformat", sp_emb_type.getSelectedItem().toString())

                .addQueryParameter("appliques", "")
                .addQueryParameter("no_appliques", "")
                .addQueryParameter("color_appliques", "")

                .addQueryParameter("image", "")
                .addQueryParameter("instruct", et_desc.getText().toString())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ProgressDialogClass.hideProgress();
                        String check = "false";

                        try {
                            check = response.getString("success");
                            if (!check.equals("false")) {
                                Toast.makeText(getActivity(), "Please Wait While..." + response, Toast.LENGTH_SHORT).show();
                                uploadPic(response.getString("ID"));
                            } else {
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        ProgressDialogClass.hideProgress();
                        Toast.makeText(getActivity(), "Server Not Responding", Toast.LENGTH_SHORT).show();
                    }
                });

    }


    public void uploadPic(String order_id) {
        /*https://migdigitizing.net/App/service.php?mode=img&id=&md=&image*/
        ProgressDialogClass.showProgress(getActivity());
        try {
            AndroidNetworking.upload(Config.URL)
                    .addMultipartFile("image", returnFile(bitmap, order_id))
                    .addMultipartParameter("mode", "file")
                    .addMultipartParameter("id", order_id)
                    .addMultipartParameter("mode", "img")
                    .addMultipartParameter("md", "es")
                    .setPriority(Priority.HIGH)
                    .build()
                    .getAsJSONObject(new JSONObjectRequestListener() {
                        @Override
                        public void onResponse(JSONObject response) {
                            // do anything with response
                            ProgressDialogClass.hideProgress();
                            Toast.makeText(getActivity(), "Detail Submitted", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onError(ANError error) {
                            // handle error
                            ProgressDialogClass.hideProgress();
                            Toast.makeText(getActivity(), "Server Not Responding", Toast.LENGTH_SHORT).show();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File returnFile(Bitmap bmp, String order_id) throws IOException {
        File f = new File(getActivity().getCacheDir(), "md.png");
        f.createNewFile();
        //Convert bitmap to byte array
        Bitmap bitmap = bmp;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, bos);
        byte[] bitmapdata = bos.toByteArray();
        //write the bytes in file
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bitmapdata);
        fos.flush();
        fos.close();
        return f;
    }
}




