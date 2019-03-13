package com.maha.sample.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

import com.maha.sample.MainActivity;

public class Alarm extends BroadcastReceiver {


   public Alarm() {

   }

   @Override
   public void onReceive( Context context, Intent intent ) {

      PowerManager pm = ( PowerManager ) context.getSystemService( Context.POWER_SERVICE );
      PowerManager.WakeLock wl = pm.newWakeLock( PowerManager.FULL_WAKE_LOCK, "" );
      PowerManager.WakeLock wakeLock = pm.newWakeLock( ( PowerManager.SCREEN_BRIGHT_WAKE_LOCK | PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP ), "TAG" );
      // wl.acquire();
      wakeLock.acquire();

      Log.e( "Error", "Alaram" );
      // Put here YOUR code.
      Toast.makeText( context, "Alarm !!!!!!!!!!", Toast.LENGTH_LONG ).show(); // For example

      //wakeLock.release();
      // wl.release();
   }

   public void setAlarm( Context context ) {
      AlarmManager am = ( AlarmManager ) context.getSystemService( Context.ALARM_SERVICE );
      Intent i = new Intent( context, Alarm.class );
      PendingIntent pi = PendingIntent.getBroadcast( context, 0, i, 0 );
      am.setRepeating( AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), 1000 * 60 * 1, pi ); // Millisec * Second * Minute

     // context.startService( new Intent( context, TestService.class ) );
   }


   public void cancelAlarm( Context context ) {
      Intent intent = new Intent( context, Alarm.class );
      PendingIntent sender = PendingIntent.getBroadcast( context, 0, intent, 0 );
      AlarmManager alarmManager = ( AlarmManager ) context.getSystemService( Context.ALARM_SERVICE );
      alarmManager.cancel( sender );
   }

}
