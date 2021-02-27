package com.example.demoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    public static String TAG = MainActivity.class.getSimpleName();
    private int AttemptsCounter =0;
    Button btnlogin;
    TextView counterview;
    Spinner spinner;

    String[] studentsPlug = {"dhruvil","sai", "shubam","farhan"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = (Button) findViewById(R.id.buttonLogin);
        counterview = (TextView) findViewById(R.id.loginAttemptsCounter);
        Toast.makeText(this, "created", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am in onCreate");

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ListView studentlistViewsocket = findViewById(R.id.listView);
        registerForContextMenu(studentlistViewsocket);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,studentsPlug);
        studentlistViewsocket.setAdapter(adapter);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "started", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "resumed", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "paused", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "stopped", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destroyed", Toast.LENGTH_SHORT).show();
        Log.i(TAG,"i am onDestroy");

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.student_list_context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()) {
            case R.id.add_menuitem:
                Toast.makeText(this, "adding a student", Toast.LENGTH_SHORT).show();
                break;
            case R.id.update_menuitem:
                Toast.makeText(this, "updating a student", Toast.LENGTH_SHORT).show();

                break;
            case R.id.delete_menuitem:
                Toast.makeText(this, "deleting a student", Toast.LENGTH_SHORT).show();

                break;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(this,"Opening Settings", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, SettingsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.faq:
                Toast.makeText(this,"Opening FAQ", Toast.LENGTH_SHORT).show();
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }



    public void loginClickHandler(View view) {
        EditText nameEditText;
        nameEditText = findViewById(R.id.etPersonName);
        switch (view.getId()) {
            case R.id.buttonLogin:
                //startHomeActivity(nameEditText);
                String name = nameEditText.getText().toString();
                TextView resultTextView = findViewById(R.id.txtviewName);
                resultTextView.setText(name);


                break;

            case R.id.buttonCancel:
                Toast.makeText(this, "Login Cancelled", Toast.LENGTH_SHORT).show();
                EditText pwdEditText;
                pwdEditText = findViewById(R.id.etPassword);
                String pwd = pwdEditText.getText().toString();
                Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + pwd));
                startActivity(dialIntent);
                break;

            case R.id.alarmbtn:
                createAlarm("milk boiled", 20, 24);
                break;

            case R.id.watsapsharebtn:
                Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
                whatsappIntent.setType("text/plain");
                whatsappIntent.setPackage("com.whatsapp");
                whatsappIntent.putExtra(Intent.EXTRA_TEXT, nameEditText.getText().toString());
                try {
                    this.startActivity(whatsappIntent);
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(this,"Whatsapp have not been installed.",Toast.LENGTH_SHORT).show();
                }
        }


    }

    private void startHomeActivity(EditText nameEditText) {
        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
        AttemptsCounter++;
        counterview.setText(AttemptsCounter + " login attempts");
        Intent hIntent = new Intent(MainActivity.this, HomeActivity.class);
        String name = nameEditText.getText().toString();
        hIntent.putExtra("studentsname", name);
        startActivity(hIntent);
    }

    public void createAlarm(String message, int hour, int minutes){
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,message)
                .putExtra(AlarmClock.EXTRA_HOUR,hour)
                .putExtra(AlarmClock.EXTRA_MINUTES,minutes);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String itemSelected = adapterView.getItemAtPosition(position).toString();
        Toast.makeText(this, itemSelected, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}