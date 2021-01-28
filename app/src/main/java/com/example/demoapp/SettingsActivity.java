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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    String [] settingsOptions = new String[]{"Profile","Change Language","Log out", "Check for updates"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_settings);

        LinearLayout layout = new LinearLayout (this);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.settitems_textsview,settingsOptions);
        ListView listView = (ListView) findViewById(R.id.settings_listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 1:
                        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                        PopupWindow pw = new PopupWindow(inflater.inflate(R.layout.languages_list, null, false),
                                LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, true);
                        pw.showAtLocation(layout, Gravity.CENTER, 0, 0);

                        break;

                    case 2:
                        View dialogView = LayoutInflater.from(SettingsActivity.this).inflate(R.layout.languages_list, (ViewGroup)null);
                        AlertDialog.Builder mBuilder = (new AlertDialog.Builder(SettingsActivity.this, R.style.alertDialog)).setView(dialogView);
                        AlertDialog alertDialog = mBuilder.create();
/*
                        Intrinsics.checkExpressionValueIsNotNull(var10000, "mBuilder.create()");
*/
                        final AlertDialog dialog = alertDialog;
                        View layout = dialogView.findViewById(R.id.ll_langlist);
                        /*layout.setOnClickListener((OnClickListener)(new OnClickListener() {
                            public final void onClick(View it) {
                                if (BaseActivity.this.getSharedPref().getBooleanValue(AppConstants.INSTANCE.getIS_LOGGED_IN_SESSION())) {
                                    dialog.dismiss();
                                }

                            }
                        }));*/
                        Window langwindow = dialog.getWindow();
                        if (langwindow != null) {
                            langwindow.setBackgroundDrawableResource(android.R.color.transparent);
                        }
                        dialog.show();
                        break;

                        /*LayoutInflater inflater = (LayoutInflater)
                                getSystemService(LAYOUT_INFLATER_SERVICE);
                        View popupView = inflater.inflate(R.layout.languages_list, null);
                        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                        boolean focusable = true;
                        PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

                        popupView.setOnTouchListener(new View.OnTouchListener() {
                            @Override
                            public boolean onTouch (View v, MotionEvent event) {
                                popupWindow.dismiss();
                                return true;
                            }
                        });*/
                }
                String selectedItem = (String) parent.getItemAtPosition(position);
                Toast.makeText(SettingsActivity.this,"Selected option " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }



}
