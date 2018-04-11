package zyc.developer.note;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView importanturgent;
    TextView important;
    TextView urgent;
    TextView wait;

    SharedPreferences.Editor YYY;
    SharedPreferences XXX;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        importanturgent=(TextView)findViewById(R.id.important_urgent);
        important=(TextView)findViewById(R.id.important);
        urgent=(TextView)findViewById(R.id.urgent);
        wait=(TextView)findViewById(R.id.wait);
        XXX= PreferenceManager.getDefaultSharedPreferences(this);

        importanturgent.setText(XXX.getString("first",null));
        urgent.setText(XXX.getString("second",null));
        important.setText(XXX.getString("third",null));
        wait.setText(XXX.getString("fourth",null));




        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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
            Toast.makeText(this, "大概是最新版本吧", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(id == R.id.action_thanks){
            Toast.makeText(this, "谢谢支持", Toast.LENGTH_SHORT).show();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            // Handle the camera action
        } else if (id == R.id.nav_setting) {
            Dialog dialog=new AlertDialog.Builder(this).setTitle("设置").setMessage("\n作者有点懒≥﹏≤").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            }).create();
            dialog.show();

        } else if (id == R.id.nav_send) {
            LayoutInflater inflater=LayoutInflater.from(this);
            View view5=inflater.inflate(R.layout.layout_send,null);
            Button sendbuttonok=(Button)view5.findViewById(R.id.sendbuttonok);
            Button sendbuttoncancel=(Button)view5.findViewById(R.id.sendbuttoncancel);
            final Dialog alert5=new AlertDialog.Builder(this).setView(view5).create();
            alert5.show();
            sendbuttonok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this, "貌似出了些问题，预计下版本修复", Toast.LENGTH_SHORT).show();
                    alert5.cancel();
                }
            });
            sendbuttoncancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alert5.cancel();
                }
            });

        } else if (id == R.id.nav_about) {
            LayoutInflater inflater=LayoutInflater.from(this);
            View view6=inflater.inflate(R.layout.layout_about,null);
            Button aboutbutton=(Button)view6.findViewById(R.id.aboutbutton);
            final Dialog alert6=new AlertDialog.Builder(this).setView(view6).create();
            alert6.show();
            aboutbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alert6.cancel();
                }
            });

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void first(View view){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view1=inflater.inflate(R.layout.layout_up,null);
        Button firstbuttonok=(Button)view1.findViewById(R.id.firstbuttonok);
        Button firstbuttoncancel=(Button)view1.findViewById(R.id.firstbuttoncancel);
        final EditText firstedittext=(EditText)view1.findViewById(R.id.firstedittext);
        firstedittext.setText(importanturgent.getText().toString());
        final Dialog alert1=new AlertDialog.Builder(this).setView(view1).create();
        alert1.show();

        firstbuttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YYY=XXX.edit();
                YYY.putString("first",firstedittext.getText().toString());
                YYY.apply();
                importanturgent.setText(XXX.getString("first",null));
                alert1.cancel();
            }
        });
        firstbuttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert1.cancel();
            }
        });

    }
    public void second(View view){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view2=inflater.inflate(R.layout.layout_up_second,null);
        Button secondbuttonok=(Button)view2.findViewById(R.id.secondbuttonok);
        Button secondbuttoncancel=(Button)view2.findViewById(R.id.secondbuttoncancel);
        final EditText secondedittext=(EditText)view2.findViewById(R.id.secondedittext);
        secondedittext.setText(urgent.getText().toString());
        final Dialog alert2=new AlertDialog.Builder(this).setView(view2).create();
        alert2.show();

        secondbuttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YYY=XXX.edit();
                YYY.putString("second",secondedittext.getText().toString());
                YYY.apply();
                urgent.setText(XXX.getString("second",null));
                alert2.cancel();
            }
        });
        secondbuttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert2.cancel();
            }
        });

    }
    public void third(View view){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view3=inflater.inflate(R.layout.layout_up_third,null);
        Button thirdbuttonok=(Button)view3.findViewById(R.id.thirdbuttonok);
        Button thirdbuttoncancel=(Button)view3.findViewById(R.id.thirdbuttoncancel);
        final EditText thirdedittext=(EditText)view3.findViewById(R.id.thirdedittext);
        thirdedittext.setText(important.getText().toString());
        final Dialog alert3=new AlertDialog.Builder(this).setView(view3).create();
        alert3.show();

        thirdbuttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YYY=XXX.edit();
                YYY.putString("third",thirdedittext.getText().toString());
                YYY.apply();
                important.setText(XXX.getString("third",null));
                alert3.cancel();
            }
        });
        thirdbuttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert3.cancel();
            }
        });

    }
    public void fourth(View view){
        LayoutInflater inflater=LayoutInflater.from(this);
        View view4=inflater.inflate(R.layout.layout_up_fourth,null);
        Button fourthbuttonok=(Button)view4.findViewById(R.id.fourthbuttonok);
        Button fourthbuttoncancel=(Button)view4.findViewById(R.id.fourthbuttoncancel);
        final EditText fourthedittext=(EditText)view4.findViewById(R.id.fourthedittext);
        fourthedittext.setText(wait.getText().toString());
        final Dialog alert4=new AlertDialog.Builder(this).setView(view4).create();
        alert4.show();

        fourthbuttonok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                YYY=XXX.edit();
                YYY.putString("fourth",fourthedittext.getText().toString());
                YYY.apply();
                wait.setText(XXX.getString("fourth",null));
                alert4.cancel();
            }
        });
        fourthbuttoncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert4.cancel();
            }
        });
    }


}
