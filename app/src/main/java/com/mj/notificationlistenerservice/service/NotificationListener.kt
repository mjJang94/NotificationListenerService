package com.mj.notificationlistenerservice.service

import android.app.Notification
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

class NotificationListener: NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
        val notiInfo = sbn?.notification ?: return

        val title = notiInfo.extras.getString(Notification.EXTRA_TITLE)
        val text = notiInfo.extras.getString(Notification.EXTRA_TEXT)
        val subText = notiInfo.extras.getString(Notification.EXTRA_SUB_TEXT)

        Log.d("NotificationListener","onNotificationPosted - title : $title, text : $text, subText : $subText")

    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)

        val notiInfo = sbn?.notification ?: return

        val title = notiInfo.extras.getString(Notification.EXTRA_TITLE)
        val text = notiInfo.extras.getString(Notification.EXTRA_TEXT)
        val subText = notiInfo.extras.getString(Notification.EXTRA_SUB_TEXT)

        Log.d("NotificationListener","onNotificationRemoved - title : $title, text : $text, subText : $subText")
    }
}