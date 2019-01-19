package ww.mddrawer.LoginSignUp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.ProgressDialogClass;

public class ForgotActivity extends AppCompatActivity {

    EditText et_email;
    Button btn_reset_pass;

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        et_email = findViewById(R.id.et_email);
        btn_reset_pass = findViewById(R.id.btn_reset_pass);
        btn_reset_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_email.getText().toString().isEmpty() || !isValidEmail(et_email.getText().toString())) {
                    et_email.setError("Invalid Email");
                    Config.requestFocus(ForgotActivity.this, et_email);
                    return;
                }

                // Toast.makeText(ForgotActivity.this, "" + et_email.getText().toString(), Toast.LENGTH_SHORT).show();
                ProgressDialogClass.showProgress(ForgotActivity.this);
                AndroidNetworking.get(Config.URL)
                        .addQueryParameter("email", et_email.getText().toString())
                        .addQueryParameter("mode", "forget")
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
                                        startActivity(new Intent(ForgotActivity.this, Login.class));
                                        Toast.makeText(ForgotActivity.this, "Password Sent To Your Email", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(ForgotActivity.this, "Email Not Registered", Toast.LENGTH_LONG).show();
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
        });
    }
}
