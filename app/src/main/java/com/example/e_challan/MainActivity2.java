package com.example.e_challan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_next=findViewById(R.id.bt_notificaion);
        String message = "this is a notification";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity2.this
        )
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("New Notification")
                .setContentText(message)
                .setAutoCancel(true);


        Intent a = new Intent(MainActivity2.this,notificatiom.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        a.putExtra("message",message);

        PendingIntent pendingIntent =PendingIntent.getActivity(MainActivity2.this,0,a,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,builder.build());
    }
}