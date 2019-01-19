package ww.mddrawer.Utills;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;

public class Config {


    public static final String URL = "https://migdigitizing.net/App/service.php";
    public static final String URL_IMAGE = "https://migdigitizing.net/App/image.php";


    public static String getEmail(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        if (prefs.getString("EMAIL", "").length() > 0) {
            return prefs.getString("EMAIL", "");
        } else
            return "";
    }

    public static String getClinetID(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        if (prefs.getString("CLIENTID", "").length() > 0) {
            return prefs.getString("CLIENTID", "");
        } else
            return "";
    }

    public static String getName(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        if (prefs.getString("NAME", "").length() > 0) {
            return prefs.getString("NAME", "");
        } else
            return "";
    }

    public static void requestFocus(AppCompatActivity activity, View view) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
        return;
    }

    public static void requestFocus(Activity activity, View view) {
        if (view.requestFocus()) {
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
        return;
    }

    public static void clearshareprefrence(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }

}
