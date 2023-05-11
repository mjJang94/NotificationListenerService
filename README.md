
<img src="https://img.shields.io/badge/Android-3DDC84?style=flat-square&logo=Android&logoColor=white"/>
  
Android SDK에서 제공하는 NotificationListenerService을 상속 받는 서비스를 만들고, 메소드 구현을 통해 모든 Notification에 대한 정보를 받을 수 있다.


상속을 통해 구현되는 이유는 Android SDK는 NotificationManager에 직접 listener를 등록하는 코드를 제공하지 않기 때문이다.



## NotificationListenerService 상속 받는 서비스 구현

```
class NotificationListener: NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        super.onNotificationPosted(sbn)
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
    }
}
```



## AndroidManifest 추가
```
  <service
      android:name="com.mj.notificationlistenerservice.service.NotificationListener"
      android:exported="false"
      android:label="My Notification Listener"
      android:permission="android.permission.BIND_NOTIFICATION_LISTENER_SERVICE">
      <intent-filter>
          <action android:name="android.service.notification.NotificationListenerService" />
      </intent-filter>
  </service>
```



## 사용자 권한 체크
```
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
```



## 결과
```
2023-05-11 12:01:02.876 22471-22471 D  onNotificationPosted - title : 카카오프렌즈, text : (광고)성년의 날엔 귀여운 선물을💓, subText : null
2023-05-11 12:01:17.609 22471-22471 D  onNotificationPosted - title : 충전 중 (3분 후 충전완료), text : 99% (3분 후 충전완료), subText : null
```

