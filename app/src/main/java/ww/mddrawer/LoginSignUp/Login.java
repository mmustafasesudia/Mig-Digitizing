package ww.mddrawer.LoginSignUp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import ww.mddrawer.DrawerLatest.Drawer;
import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.ProgressDialogClass;

public class Login extends AppCompatActivity {


    EditText etemail;
    EditText etpass;
    TextView signuplink, forgot_pass;

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button login = findViewById(R.id.login_btn);
        etemail = findViewById(R.id.etemail);
        etpass = findViewById(R.id.etpass);
        signuplink = findViewById(R.id.signuplink);
        forgot_pass = findViewById(R.id.forgot_pass);

        AndroidNetworking.initialize(getApplicationContext());


        if (Config.getEmail(this).length() > 0) {
            Intent i = new Intent(Login.this, Drawer.class);
            startActivity(i);
            finish();
        }
        signuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUpActivity.class));
            }
        });
        forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, ForgotActivity.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etemail.getText().toString().isEmpty() || !isValidEmail(etemail.getText().toString())) {
                    etemail.setError("Invalid Email");
                    Config.requestFocus(Login.this, etemail);
                    return;
                }
                if (etpass.getText().toString().isEmpty()) {
                    etpass.setError("Password Cannot Be Empty");
                    Config.requestFocus(Login.this, etpass);
                    return;
                }
               /* Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);*/
                ProgressDialogClass.showProgress(Login.this);
                AndroidNetworking.get(Config.URL)
                        .addQueryParameter("email", etemail.getText().toString())
                        .addQueryParameter("pass", etpass.getText().toString())
                        .addQueryParameter("mode", "login")
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
                                        SharedPreferences preferences = getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putString("EMAIL", etemail.getText().toString());
                                        editor.putString("CLIENTID", response.getString("clientID"));
                                        editor.commit();

                                        Intent i = new Intent(Login.this, Drawer.class);
                                        startActivity(i);
                                        finish();

                                    } else {

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
