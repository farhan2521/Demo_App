package com.example.demoapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class SettingsActivity extends AppCompatActivity {
    String [] settingsOptions = new String[]{"Profile","Change Language","Log out", "Check for updates"};
    public TextView setButton;
    public TextView cancelButton;
    public RadioGroup radiolangGroup;
    public RadioButton radiolangButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_settings);

         setButton = (TextView) findViewById(R.id.setlangbtn);
         cancelButton = (TextView) findViewById(R.id.cancellangbtn);
         radiolangGroup = (RadioGroup) findViewById(R.id.lang_group);

        LinearLayout layout = new LinearLayout (this);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.settitems_textsview,settingsOptions);
        ListView listView = (ListView) findViewById(R.id.settings_listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        View dialogView = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.languages_list, (ViewGroup)null);
                        AlertDialog.Builder mBuilder = (new AlertDialog.Builder(SettingsActivity.this, R.style.alertDialog)).setView(dialogView);
                        AlertDialog alertDialog = mBuilder.create();

                        Window langwindow = alertDialog.getWindow();
                        if (langwindow != null) {
                            langwindow.setBackgroundDrawableResource(android.R.color.transparent);
                        }
                        alertDialog.show();

                        /*setButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                int selectedId = radiolangGroup.getCheckedRadioButtonId();
                                radiolangButton=(RadioButton)findViewById(selectedId);
                                Toast.makeText(SettingsActivity.this,radiolangButton.getText(),Toast.LENGTH_SHORT).show();
                            }
                        });

                        cancelButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                            }
                        });*/


/*
                        Intrinsics.checkExpressionValueIsNotNull(var10000, "mBuilder.create()");
*/
                        /*final AlertDialog dialog = alertDialog;
                        View layout = dialogView.findViewById(R.id.ll_langlist);*/
                        /*layout.setOnClickListener((OnClickListener)(new OnClickListener() {
                            public final void onClick(View it) {
                                if (BaseActivity.this.getSharedPref().getBooleanValue(AppConstants.INSTANCE.getIS_LOGGED_IN_SESSION())) {
                                    dialog.dismiss();
                                }

                            }
                        }));*/
                        break;

                    case 0:
                        break;


                    case 2:
                        View AlertDialog = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.logout_dialoglayout,(ViewGroup)null);
                        AlertDialog.Builder mBuilder1 = (new AlertDialog.Builder(SettingsActivity.this, R.style.alertDialog)).setView(AlertDialog);
                        AlertDialog alertDialog1 = mBuilder1.create();
                        alertDialog1.show();
                        break;
                }
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(SettingsActivity.this,"Selected option " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }



}
