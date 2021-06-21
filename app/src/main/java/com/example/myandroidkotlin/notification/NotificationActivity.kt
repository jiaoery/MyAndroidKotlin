package com.example.myandroidkotlin.notification

import android.app.Notification.EXTRA_NOTIFICATION_ID
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import com.example.myandroidkotlin.MainActivity
import com.example.myandroidkotlin.R
import com.example.myandroidkotlin.databinding.ActivityNotificationBinding
import com.example.myandroidkotlin.reciever.ExistRecievr
import com.example.myandroidkotlin.reciever.ExistRecievr.Companion.CLEAR_ACTION

class NotificationActivity : AppCompatActivity() {

    companion object{
        const val CHANNEL_ID:String = "notification"
    }

    private lateinit var binding:ActivityNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification)
        createNotificationChannel()
    }


    public fun onClick(view:View){
        when(view.id){
            R.id.btn_create_notification->createNotification()
            R.id.btn_big_text_notification->createBigNotification()
            R.id.btn_action_notification->createActionNotification()
            R.id.btn_progress_notification->createProgressNotification()
            R.id.btn_bigimg_notification->createBigImageNotification()
            R.id.btn_alarm_notification->createAlarmNotification()
        }
    }


    /**
     * create a Notification
     */
    private fun createNotification(){

        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        //also can be service or BroadcastReciever
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.fengche)
            .setContentTitle("标题")
            .setContentText("我是一个小测试符号")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                //normal intent
            .setContentIntent(pendingIntent)
            //full screen  intent
//            .setFullScreenIntent(pendingIntent)
            .setAutoCancel(true)
        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(2312321,builder.build())
    }

    /**
     * create a big text Notification
     */
    private fun createBigNotification(){
        var builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.fengche)
            .setContentTitle("标题")
            .setContentText("我是一个小测试符号")
            .setStyle(NotificationCompat.BigTextStyle()
                .bigText("From fairest creatures we desire increase," +
                        "That thereby beauty's rose might never die," +
                        "But as the riper should by time decease," +
                        "His tender heir might bear his memory:" +
                        "But thou contracted to thine own bright eyes," +
                        "Feed'st thy light's flame with self-substantial fuel," +
                        "Making a famine where abundance lies," +
                        "Thy self thy foe, to thy sweet self too cruel:" +
                        "Thou that art now the world's fresh ornament," +
                        "And only herald to the gaudy spring," +
                        "Within thine own bud buriest thy content," +
                        "And tender churl mak'st waste in niggarding:" +
                        "Pity the world, or else this glutton be," +
                        "To eat the world's due, by the grave and thee"))
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(2312321,builder.build())
    }


    /**
     * create a  Notification with action
     */
    private fun createActionNotification(){

        // Create an explicit intent for an Activity in your app
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        //also can be service or BroadcastReciever
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val snoozeIntent = Intent(this, ExistRecievr::class.java).apply {
            action = CLEAR_ACTION
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                putExtra(EXTRA_NOTIFICATION_ID, 2312321)
            }
        }
        val snoozePendingIntent: PendingIntent =
            PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.fengche)
            .setContentTitle("标题")
            .setContentText("我是一个小测试符号")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .addAction(R.drawable.clear,getString(R.string.clear),snoozePendingIntent)
            //normal intent
            .setContentIntent(pendingIntent)
            //full screen  intent
//            .setFullScreenIntent(pendingIntent)
            .setAutoCancel(true)
        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(2312321,builder.build())
    }


    private fun createProgressNotification(){
        val builder = NotificationCompat.Builder(this, CHANNEL_ID).apply {
            setContentTitle("Download")
            setContentText("Download in progress")
            setSmallIcon(R.drawable.star)
            priority = NotificationCompat.PRIORITY_LOW
        }
        val PROGRESS_MAX = 100
        val PROGRESS_CURRENT = 50
        NotificationManagerCompat.from(this).apply {
            // Issue the initial notification with zero progress
            builder.setProgress(PROGRESS_MAX, PROGRESS_CURRENT, false)
            notify(2312321, builder.build())
        }
    }


    private fun createBigImageNotification(){
        val myBitmap = BitmapFactory.decodeResource(resources, R.drawable.oip)
        var notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.star)
            .setContentTitle("沙皇")
            .setContentText("let's see some more interesting")
            .setStyle(NotificationCompat.BigPictureStyle()
                .bigPicture(myBitmap))
            .build()

        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(2312321,notification)

    }







    /**
     * Create the NotificationChannel, but only on API 26+ because
     * the NotificationChannel class is new and not in the support library
     */
    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)

            val soundUri = Uri.parse("android.resource://$packageName/${R.raw.notice}")
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            //设置通知铃声
            val att = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build()
            channel.setSound(soundUri, att)
            //设置震动
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(1000, 500, 2000)
            //是否可以绕过请勿打扰模式
            channel.canBypassDnd()
            //是否可以显示icon角标
            channel.canShowBadge()
            channel.setShowBadge(true)
            //是否显示通知闪灯
            channel.enableLights(true)
            //收到消息时震动提示
            channel.enableVibration(true)
            //设置绕过免打扰
            channel.setBypassDnd(true)
            channel.lockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC
            //设置闪光灯颜色
            channel.lightColor = Color.RED
            //获取设置铃声设置
//            channel.audioAttributes
            //设置震动模式
            val patterns = longArrayOf(100L, 200L, 100L)
            channel.vibrationPattern = patterns
            //是否会闪光
            channel.shouldShowLights()
            // Register the channel with the system
            val notificationManager: NotificationManager =
                getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun createAlarmNotification(){
        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        //also can be service or BroadcastReciever
        val pendingIntent: PendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val snoozeIntent = Intent(this, ExistRecievr::class.java).apply {
            action = CLEAR_ACTION
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                putExtra(EXTRA_NOTIFICATION_ID, 2312321)
            }
        }
        val snoozePendingIntent: PendingIntent =
            PendingIntent.getBroadcast(this, 0, snoozeIntent, 0)

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.fengche)
            .setContentTitle("标题")
            .setContentText("我是一个小测试符号")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .addAction(R.drawable.clear,getString(R.string.clear),snoozePendingIntent)
            //normal intent
            .setContentIntent(pendingIntent)
            .setDefaults(NotificationCompat.DEFAULT_SOUND)
            //full screen  intent
//            .setFullScreenIntent(pendingIntent)
            .setAutoCancel(true)
        val notificationManager: NotificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(2312321,builder.build())
    }



}