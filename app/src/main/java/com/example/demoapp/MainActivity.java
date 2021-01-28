package com.example.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int AttemptsCounter =0;
    Button btnlogin;
    TextView counterview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = (Button) findViewById(R.id.buttonLogin);
        counterview = (TextView) findViewById(R.id.loginAttemptsCounter);
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
        switch (view.getId()){
            case R.id.buttonLogin:
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                AttemptsCounter++;
                counterview.setText(AttemptsCounter +" login attempts");
                Intent hIntent = new Intent(MainActivity.this,HomeActivity.class);
                EditText nameEditText;
                nameEditText = findViewById(R.id.etPersonName);
                String name = nameEditText.getText().toString();
                hIntent.putExtra("studentsname",name);
                startActivity(hIntent);


                break;

            case R.id.buttonCancel:
                Toast.makeText(this, "Login Cancelled", Toast.LENGTH_SHORT).show();
                break;
        }

    }

}