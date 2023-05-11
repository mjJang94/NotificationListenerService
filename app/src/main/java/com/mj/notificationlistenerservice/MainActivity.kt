package com.mj.notificationlistenerservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!notificationAccessPermCheck()){
            Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS").also {
                startActivity(it)
            }
        }
    }

    private fun notificationAccessPermCheck(): Boolean {
        val sets = NotificationManagerCompat.getEnabledListenerPackages(this)
        return sets.contains(packageName)
    }
}