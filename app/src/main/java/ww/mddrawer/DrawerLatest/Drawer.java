package ww.mddrawer.DrawerLatest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

import ww.mddrawer.ActivityNew.AboutUsActivity;
import ww.mddrawer.ActivityNew.PrivacyPolicyActivity;
import ww.mddrawer.EstimateFragments.SelectEstimate;
import ww.mddrawer.LoginSignUp.Login;
import ww.mddrawer.OrdersFramgents.SelectOrder;
import ww.mddrawer.R;
import ww.mddrawer.Utills.Config;
import ww.mddrawer.Utills.FragmentReplace;
import ww.mddrawer.Utills.ProgressDialogClass;
import ww.mddrawer.fragment.AdvancePayment;
import ww.mddrawer.fragment.DashboardFramgent;
import ww.mddrawer.fragment.RequestEdit;

public class Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tv_header_name, tv_header_email, tv_header_credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        tv_header_name = navigationView.getHeaderView(0).findViewById(R.id.tv_header_name);
        tv_header_name.setText("" + Config.getName(this));

        tv_header_email = navigationView.getHeaderView(0).findViewById(R.id.tv_header_email);
        tv_header_email.setText("" + Config.getEmail(this));

        tv_header_credit = navigationView.getHeaderView(0).findViewById(R.id.tv_header_credit);

        Fragment homeFragment = null;
        Fragment homeF = new DashboardFramgent();
        homeFragment = homeF;
        FragmentReplace.replaceFragment(Drawer.this, homeFragment, R.id.frame_container);

        showCredit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            //Dashboard
            Fragment homeFragment = null;
            Fragment homeF = new DashboardFramgent();
            homeFragment = homeF;
            FragmentReplace.replaceFragment(Drawer.this, homeFragment, R.id.frame_container);

        } else if (id == R.id.nav_photos) {
            //Order
            Fragment homeFragment = null;
            Fragment homeF = new SelectOrder();
            homeFragment = homeF;
            FragmentReplace.replaceFragment(Drawer.this, homeFragment, R.id.frame_container);

        } else if (id == R.id.nav_movies) {
            //Estimate
            Fragment homeFragment = null;
            Fragment homeF = new SelectEstimate();
            homeFragment = homeF;
            FragmentReplace.replaceFragment(Drawer.this, homeFragment, R.id.frame_container);

        } else if (id == R.id.nav_notifications) {
            //Edit
            Fragment homeFragment = null;
            Fragment homeF = new RequestEdit();
            homeFragment = homeF;
            FragmentReplace.replaceFragment(Drawer.this, homeFragment, R.id.frame_container);

        } else if (id == R.id.nav_settings) {
            //Advance Payment
            Fragment homeFragment = null;
            Fragment homeF = new AdvancePayment();
            homeFragment = homeF;
            FragmentReplace.replaceFragment(Drawer.this, homeFragment, R.id.frame_container);

        } else if (id == R.id.nav_about_us) {
            startActivity(new Intent(this, AboutUsActivity.class));
        } else if (id == R.id.nav_privacy_policy) {
            startActivity(new Intent(this, PrivacyPolicyActivity.class));
        } else if (id == R.id.nav_log_out) {
            Intent intent = new Intent(Drawer.this, Login.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            Config.clearshareprefrence(Drawer.this);
            finish();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void showCredit() {
        ProgressDialogClass.showProgress(this);
        AndroidNetworking.get(Config.URL)
                .addQueryParameter("mode", "showcredit")
                .addQueryParameter("email", Config.getEmail(this))
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        ProgressDialogClass.hideProgress();

                        try {
                            String credit = response.getString("credit");
                            tv_header_credit.setText("Credit : " + credit);

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
}
