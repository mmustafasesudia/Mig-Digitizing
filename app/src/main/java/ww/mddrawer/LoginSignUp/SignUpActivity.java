package ww.mddrawer.LoginSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.TimeZone;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.ProgressDialogClass;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    String[] find_us_at = new String[]{
            "Select", "Google", "Website"
    };
    String[] company_type = new String[]{
            "Select", "IT", "Software", "Hardware", "Telecommunication", "Education", "Government"
    };

    String spinnerget = "";
    Button btn_register;
    EditText et_first_name, et_last_name, et_mobile, et_email, et_input_password, et_input_password_confirm, et_address, et_company_name, et_postal_code, et_city, et_country, et_tel_number;
    Spinner sp_company_type, sp_time_zone, sp_find_us_at;
    CheckBox checkbox_terms;

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

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_sign_up);

        et_first_name = findViewById(R.id.et_first_name);
        et_last_name = findViewById(R.id.et_last_name);
        et_mobile = findViewById(R.id.et_mobile);
        et_email = findViewById(R.id.et_email);
        et_input_password = findViewById(R.id.et_input_password);
        et_input_password_confirm = findViewById(R.id.et_input_password_confirm);
        et_address = findViewById(R.id.et_address);
        et_company_name = findViewById(R.id.et_company_name);
        et_postal_code = findViewById(R.id.et_postal_code);
        et_city = findViewById(R.id.et_city);
        et_country = findViewById(R.id.et_country);
        et_tel_number = findViewById(R.id.et_tel_number);

        checkbox_terms = findViewById(R.id.checkbox_terms);

        sp_company_type = findViewById(R.id.sp_company_type);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, company_type);
        adap.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_company_type.setAdapter(adap);

        sp_time_zone = findViewById(R.id.sp_time_zone);
        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<CharSequence>(this, android.R.layout.simple_spinner_item);
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

        sp_find_us_at = findViewById(R.id.sp_find_us_at);
        ArrayAdapter<String> adap1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, find_us_at);
        adap1.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        sp_find_us_at.setAdapter(adap1);


        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(this);


    }

    public void sendData() {
        if (et_first_name.getText().toString().isEmpty()) {
            et_first_name.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_first_name);
            return;
        }
        if (et_last_name.getText().toString().isEmpty()) {
            et_last_name.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_last_name);
            return;
        }
        if (et_mobile.getText().toString().isEmpty()) {
            et_mobile.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_mobile);
            return;
        }
        if (et_email.getText().toString().isEmpty() || !isValidEmail(et_email.getText().toString())) {
            et_email.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_email);
            return;
        }
        if (et_input_password.getText().toString().isEmpty()) {
            et_input_password.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_input_password);
            return;
        }
        if (et_input_password_confirm.getText().toString().isEmpty()) {
            et_input_password_confirm.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_input_password_confirm);
            return;
        }
        if (!validatePasswordConfirmation()) {
            return;
        }
        if (et_address.getText().toString().isEmpty()) {
            et_address.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_address);
            return;
        }
        if (et_company_name.getText().toString().isEmpty()) {
            et_company_name.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_company_name);
            return;
        }
        if (sp_company_type.getSelectedItemPosition() == 0) {
            Toast.makeText(SignUpActivity.this, "Please Select Company Type", Toast.LENGTH_SHORT).show();
            return;
        }

        if (et_postal_code.getText().toString().isEmpty()) {
            et_postal_code.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_postal_code);
            return;
        }
        if (et_city.getText().toString().isEmpty()) {
            et_city.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_city);
            return;
        }
        if (et_country.getText().toString().isEmpty()) {
            et_country.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_country);
            return;
        }
        if (et_tel_number.getText().toString().isEmpty()) {
            et_tel_number.setError("Field Cannot Be Empty");
            Config.requestFocus(this, et_tel_number);
            return;
        }

        if (sp_find_us_at.getSelectedItemPosition() == 0) {
            Toast.makeText(SignUpActivity.this, "Please Select Find Us At", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!checkbox_terms.isChecked()) {
            Toast.makeText(this, "Please Accept Term & Conditions", Toast.LENGTH_SHORT).show();
            return;
        }
        ProgressDialogClass.showProgress(SignUpActivity.this);
        AndroidNetworking.get(Config.URL)
                .addQueryParameter("mode", "signup")
                .addQueryParameter("fname", et_first_name.getText().toString())
                .addQueryParameter("lname", et_last_name.getText().toString())
                .addQueryParameter("mobile", et_mobile.getText().toString())
                .addQueryParameter("email", et_email.getText().toString())
                .addQueryParameter("password", et_input_password.getText().toString())
                .addQueryParameter("address", et_address.getText().toString())
                .addQueryParameter("company", et_company_name.getText().toString())
                .addQueryParameter("ctype", sp_company_type.getSelectedItem().toString())
                .addQueryParameter("zip", et_postal_code.getText().toString())
                .addQueryParameter("city", et_city.getText().toString())
                .addQueryParameter("country", et_country.getText().toString())
                .addQueryParameter("phone", et_tel_number.getText().toString())
                .addQueryParameter("timezone", sp_time_zone.getSelectedItem().toString())
                .addQueryParameter("findusat", sp_find_us_at.getSelectedItem().toString())
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ProgressDialogClass.hideProgress();
                        String check = "false";
                        try {
                            check = response.getString("success");
                            if (!check.equals("false")) {
                                startActivity(new Intent(SignUpActivity.this, Login.class));
                                finish();
                                Toast.makeText(SignUpActivity.this, "Registration Successful \n Now You Can Login From Here", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(SignUpActivity.this, "Registration Unsuccessful", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        ProgressDialogClass.hideProgress();                                // handle error
                    }
                });

    }

    private boolean validatePasswordConfirmation() {
        if (et_input_password_confirm.getText().toString().trim().isEmpty()) {
            et_input_password_confirm.setError("Confirm Password Cannot Be Empty");
            Config.requestFocus(this, et_input_password_confirm);
            return false;
        } else if (!et_input_password.getText().toString().equals(et_input_password_confirm.getText().toString())) {
            et_input_password_confirm.setError("Password Not Match");
            Config.requestFocus(this, et_input_password_confirm);
            return false;
        }
        return true;
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
