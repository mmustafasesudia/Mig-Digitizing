package ww.mddrawer.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.ProgressDialogClass;
import ww.mddrawer.ViewFramgnets.ViewEdit.EditDetail;


public class RequestEdit extends Fragment implements View.OnClickListener {
    RecyclerView rv;
    ArrayList<EditDetail> data = new ArrayList<>();

    Spinner sp_order_edit_list;
    TextView tv_design_name;
    LinearLayout ll;
    EditText et_desc;
    Button btn_submit, btn_attach_pic;
    ImageView img_attach_preview;

    ArrayList<String> stringArrayList = new ArrayList<>();
    HashMap<String, String> stringHashMap;


    Bitmap bitmap;
    ByteArrayOutputStream bStream;
    byte[] byteArray;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_request_edit, container, false);

        sp_order_edit_list = view.findViewById(R.id.sp_order_edit_list);
        tv_design_name = view.findViewById(R.id.tv_design_name);
        et_desc = view.findViewById(R.id.et_desc);
        btn_submit = view.findViewById(R.id.btn_submit);
        btn_attach_pic = view.findViewById(R.id.btn_attach_pic);
        img_attach_preview = view.findViewById(R.id.img_attach_preview);
        btn_submit.setOnClickListener(this);
        btn_attach_pic.setOnClickListener(this);
        ll = view.findViewById(R.id.ll);
        ll.setVisibility(View.GONE);

        loadList();

        return view;
    }

    public void loadList() {
        String URL = "https://migdigitizing.net/App/service.php?mode=all_design&email=" + Config.getEmail(getActivity()) + "";
        Log.v("URL", URL);
        ProgressDialogClass.showProgress(getActivity());

        AndroidNetworking.get("https://migdigitizing.net/App/service.php?mode=all_design&email=im.uk90@gmail.com")
                /*.addQueryParameter("mode", "all_design")
                .addQueryParameter("email", Config.getEmail(getActivity()))*/
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        ProgressDialogClass.hideProgress();
                        stringArrayList = new ArrayList<>();
                        stringArrayList.add("Please select Order to edit");
                        stringHashMap = new HashMap<>();

                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                stringArrayList.add(jsonObject.getString("id") + "  (" + jsonObject.getString("designname") + ")");
                                //Log.v("LLL",""+jsonObject.getString("designname"));
                                stringHashMap.put(jsonObject.getString("id") + "  (" + jsonObject.getString("designname") + ")", jsonObject.getString("id"));
                            }
                            ArrayAdapter<String> adap = new ArrayAdapter<String>(getActivity(),
                                    android.R.layout.simple_spinner_item, stringArrayList);
                            adap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                            sp_order_edit_list.setAdapter(adap);
                            sp_order_edit_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position == 0) {
                                        ll.setVisibility(View.GONE);
                                        return;
                                    }
                                    ll.setVisibility(View.VISIBLE);
                                    String selectedItem = sp_order_edit_list.getSelectedItem().toString();
                                    //Toast.makeText(getActivity(), "" + stringHashMap.get(selectedItem), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    @Override
                    public void onError(ANError error) {
                        ProgressDialogClass.hideProgress();

                    }
                });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_submit:
                submit();
                break;
            case R.id.btn_attach_pic:
                startDialog();
                break;
        }
    }

    public void submit() {
        if (et_desc.getText().toString().isEmpty()) {
            Toast.makeText(getActivity(), "Description Cannot Be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if (bitmap == null) {
            Toast.makeText(getActivity(), "Image Cannot Be Empty", Toast.LENGTH_SHORT).show();
            return;
        }
        String selectedItem = sp_order_edit_list.getSelectedItem().toString();
        /*String URL = "https://migdigitizing.net/App/service.php?mode=add_edit&code=" + stringHashMap.get(selectedItem) +
                "&descript=" + et_desc.getText().toString() + "&email=" + Config.getEmail(getActivity()) + "";
        Log.v("URL", URL);*/
        ProgressDialogClass.showProgress(getActivity());
        /*https://migdigitizing.net/App/service.php?mode=add_edit&code=31267&descript=none&email=im.uk90@gmail.com*/
        AndroidNetworking.get(Config.URL)
                .addQueryParameter("mode", "add_edit")
                .addQueryParameter("email", Config.getEmail(getActivity()))
                .addQueryParameter("descript", et_desc.getText().toString())
                .addQueryParameter("code", stringHashMap.get(selectedItem))
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ProgressDialogClass.hideProgress();
                        // do anything with response
                        String check = "false";
                        try {
                            check = response.getString("success");
                            if (!check.equals("false")) {
                                Toast.makeText(getActivity(), "Please Wait While...", Toast.LENGTH_SHORT).show();
                                uploadPic(response.getString("ID"));
                            } else {

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        // handle error
                        ProgressDialogClass.hideProgress();
                    }
                });
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

    public void uploadPic(String order_id) {
        /*https://migdigitizing.net/App/service.php?mode=img&id=&md=&image*/
        ProgressDialogClass.showProgress(getActivity());
        try {
            AndroidNetworking.upload(Config.URL_IMAGE)
                    .addMultipartFile("image", returnFile(bitmap, order_id))
                    .addMultipartParameter("mode", "img")
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
                            Toast.makeText(getActivity(), "Order Updated", Toast.LENGTH_SHORT).show();
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
