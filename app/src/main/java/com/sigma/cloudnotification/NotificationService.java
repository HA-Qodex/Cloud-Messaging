package com.sigma.cloudnotification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class NotificationService extends FirebaseMessagingService {
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        String title = remoteMessage.getNotification().getTitle();
        String body = remoteMessage.getNotification().getBody();

        GetNotification(title, body);
    }

    private void GetNotification(String title, String body) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "channel_Id");
        builder.setContentTitle(title);
        builder.setContentText(body);
        builder.setSmallIcon(R.drawable.ic_mic_24);
        builder.setAutoCancel(true);

        Intent intent = new Intent(getApplicationContext(), CloudActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 101, intent, PendingIntent.FLAG_UPDATE_CURRENT );
        builder.setContentIntent(pendingIntent);

        int uniqueId = (int) System.currentTimeMillis();
        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.O){

            NotificationChannel notificationChannel = new NotificationChannel("channel_Id", "name", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
            notificationManager.notify(uniqueId, builder.build());

        } else {

            notificationManager.notify(uniqueId, builder.build());
        }
    }
}