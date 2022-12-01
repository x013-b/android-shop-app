package com.example.myapplication;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSms extends AppCompatActivity {

    String zamowienie;
    EditText number;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            zamowienie = extras.getString("key");
        }

        number = findViewById(R.id.messageNumber);
        button = findViewById(R.id.sendMessage);


        button.setOnClickListener(e -> {
            sendWithSmsManager();
        });

    }

    private void sendWithSmsManager() {
        if (checkPermission(Manifest.permission.SEND_SMS)) {;

            String nr = number.getText().toString();

            if (!nr.equals("") && !zamowienie.equals("")) {
                SmsManager smsManager = SmsManager.getDefault();

                smsManager.sendTextMessage(nr, null, zamowienie, null, null);

                Toast.makeText(this, "SMS send", Toast.LENGTH_SHORT).show();
                Log.v("sms123", "SMS send");
            } else {
                Toast.makeText(getApplicationContext(), "Permissions denied", Toast.LENGTH_SHORT).show();
                Log.v("sms123", "Permission denied");
            }
        }
    }

    private ActivityResultLauncher<String> requestPermissionLauncher =
            registerForActivityResult(new ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {

                } else {

                }
            });

    private boolean checkPermission(String sendSms) {

        if(ContextCompat.checkSelfPermission(this, sendSms) == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            requestPermissionLauncher.launch(
                    sendSms);
            return false;
        }

    }
}