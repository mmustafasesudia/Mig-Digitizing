package ww.mddrawer.LoginSignUp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.TimeZone;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;


public class SignUp extends Fragment implements View.OnClickListener {

    String[] find_us_at = new String[]{
            "Select", "Google", "Website"
    };
    String[] company_type = new String[]{
            "Select", "Google", "Website"
    };

    String spinnerget = "";
    Button btn_register;
    EditText et_first_name, et_last_name, et_mobile, et_email, et_input_password, et_input_password_confirm, et_address, et_company_name, et_postal_code, et_city, et_country, et_tel_number;
    Spinner sp_company_type, sp_time_zone, sp_find_us_at;
    /*mode=signup
    &fname=uzair&
    lname=m.rafiq&
    mobile=03012541277&
    email=uzairrafiq_@hotmail.com&
    password=125&
    address=defence&
    company=urds&
    ctype=software&
    zip=74400&
    city=karachi&
    country=pakistan&
    phone=&
    timezone=Asia/Karachi&
    findusat=*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        et_first_name = view.findViewById(R.id.et_first_name);
        et_last_name = view.findViewById(R.id.et_last_name);
        et_mobile = view.findViewById(R.id.et_mobile);
        et_email = view.findViewById(R.id.et_email);
        et_input_password = view.findViewById(R.id.et_input_password);
        et_input_password_confirm = view.findViewById(R.id.et_input_password_confirm);
        et_address = view.findViewById(R.id.et_address);
        et_company_name = view.findViewById(R.id.et_company_name);
        et_postal_code = view.findViewById(R.id.et_postal_code);
        et_city = view.findViewById(R.id.et_city);
        et_country = view.findViewById(R.id.et_country);
        et_tel_number = view.findViewById(R.id.et_tel_number);

        sp_company_type = view.findViewById(R.id.sp_company_type);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, company_type);
        adap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_company_type.setAdapter(adap);

        sp_time_zone = view.findViewById(R.id.sp_time_zone);
        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<CharSequence>(getActivity(), android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        String[] TZ = TimeZone.getAvailableIDs();
        ArrayList<String> TZ1 = new ArrayList<String>();
        for (int i = 0; i < TZ.length; i++) {
            if (!(TZ1.contains(TimeZone.getTimeZone(TZ[i]).getDisplayName()))) {
                TZ1.add(TimeZone.getTimeZone(TZ[i]).getDisplayName());
            }
        }
        for (int i = 0; i < TZ1.size(); i++) {
            adapter.add(TZ1.get(i));
        }
        sp_time_zone.setAdapter(adapter);
        for (int i = 0; i < TZ1.size(); i++) {
            if (TZ1.get(i).equals(TimeZone.getDefault().getDisplayName())) {
                sp_time_zone.setSelection(i);
            }
        }


        sp_find_us_at = view.findViewById(R.id.sp_find_us_at);
        ArrayAdapter<String> adap1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, find_us_at);
        adap1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_find_us_at.setAdapter(adap1);


        btn_register = view.findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);


        return view;
    }

    public void sendData() {
        if (et_first_name.getText().toString().isEmpty()) {
            et_first_name.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_first_name);
        }
        if (et_last_name.getText().toString().isEmpty()) {
            et_last_name.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_last_name);
        }
        if (et_mobile.getText().toString().isEmpty()) {
            et_mobile.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_mobile);
        }
        if (et_email.getText().toString().isEmpty()) {
            et_email.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_email);
        }
        if (et_input_password.getText().toString().isEmpty()) {
            et_input_password.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_input_password);
        }
        if (et_input_password_confirm.getText().toString().isEmpty()) {
            et_input_password_confirm.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_input_password_confirm);
        }
        if (et_address.getText().toString().isEmpty()) {
            et_address.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_address);
        }
        if (et_company_name.getText().toString().isEmpty()) {
            et_company_name.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_company_name);
        }
        if (et_postal_code.getText().toString().isEmpty()) {
            et_postal_code.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_postal_code);
        }
        if (et_city.getText().toString().isEmpty()) {
            et_city.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_city);
        }
        if (et_country.getText().toString().isEmpty()) {
            et_country.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_country);
        }
        if (et_tel_number.getText().toString().isEmpty()) {
            et_tel_number.setError("Field Cannot Be Empty");
            Config.requestFocus(getActivity(), et_tel_number);
        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_register:
                sendData();
                break;
        }
    }
}
