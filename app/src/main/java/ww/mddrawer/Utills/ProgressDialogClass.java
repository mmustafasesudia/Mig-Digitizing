package ww.mddrawer.Utills;

import android.content.Context;

import dmax.dialog.SpotsDialog;
import ww.mddrawer.R;

public class ProgressDialogClass {

    public static SpotsDialog progressDialog;

    public static void showProgress(Context context) {
        progressDialog = new SpotsDialog(context, R.style.CustomProgressDialog);
        progressDialog.show();
    }

    public static void hideProgress() {
        progressDialog.dismiss();
    }
}