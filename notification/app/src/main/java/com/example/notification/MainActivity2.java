package com.example.notification;



import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    String p;
    TextView txt, txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        onNewIntent(getIntent());
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //to cancel the notification based on the notificationId.
        notificationManager.cancel(100);
    }

    @Override
    protected void onNewIntent(Intent intent) {

        Bundle extras = intent.getExtras();
        if (extras != null) {
            if (extras.containsKey("message")) {
                setContentView(R.layout.activity_main2);
                // extract the extra-data in the Notification
                String msg = extras.getString("message");
                txt = (TextView) findViewById(R.id.textView);
                txt.setText("Report: " + msg);
            }

            super.onNewIntent(intent);
        }
    }

}
