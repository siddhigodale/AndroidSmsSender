package com.example.messagesender;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initialize variable
    EditText number, message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        number = findViewById(R.id.number);
        message = findViewById(R.id.message);
        send = findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get values from edit text
                String phoneno = number.getText().toString();
                String sms = message.getText().toString();

                try {
                    //Initialize the sms manager
                    SmsManager smsManager = SmsManager.getDefault();
                    //Send text message
                    smsManager.sendTextMessage(phoneno, null, sms, null, null);
                    //Display toast
                    Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    //Display toast
                    Toast.makeText(getApplicationContext(), "Failed to send message", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}


