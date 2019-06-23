package com.hatbd.firebasepushnotification;

import android.app.Notification;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyMessageService extends FirebaseMessagingService {


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        showNotification(remoteMessage.getNotification().getTitle(),remoteMessage.getNotification().getBody());
    }

    public void showNotification(String title, String message) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "MyNotification")
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_stat_name)
                .setAutoCancel(true)
                .setContentText(message);

        NotificationManagerCompat manage = NotificationManagerCompat.from(this);
        manage.notify(999, builder.build());
    }
}

