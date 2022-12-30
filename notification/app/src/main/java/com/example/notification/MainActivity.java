package com.example.notification;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et1,et2;
    Button btn;
    Integer st1,st2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editTextTextPersonName);
        et2=findViewById(R.id.editTextTextPersonName2);
        btn=findViewById(R.id.button);
    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void notify(View view){
        st1=Integer.parseInt(et1.getText().toString());
        st2=Integer.parseInt(et2.getText().toString());
        String message;
        int notificationId = 100;
        if(st1>=60 && st1<=120 ||st2==98.6){
            message="Your vitals are fine" ;
        }
        else
            message="You need to consult doctor";
        String CHANNEL_ID = "my_ch";
        String CHANNEL_NAME = "my_Channel";
        int importance = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
        NotificationManager notificationManager =(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(notificationChannel);

        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("message",message);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setContentIntent(pendingIntent);
        builder.setContentTitle("My Notification");
        builder.setContentText("BP: "+st1+" Temp: "+st2+"\n"+message);

        notificationManager.notify(notificationId,builder.build());
    }
}