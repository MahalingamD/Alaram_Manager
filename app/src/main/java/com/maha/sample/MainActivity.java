package com.maha.sample;

import android.content.Intent;
import android.os.Build;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.maha.sample.service.Alarm;
import com.maha.sample.service.TestService;

public class MainActivity extends AppCompatActivity {

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );


     // Alarm aAlarm = new Alarm(); //passing context
    //  LocalBroadcastManager.getInstance( this ).registerReceiver( aAlarm, null );

    //  aAlarm.setAlarm( this );

      if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O ) {
         startForegroundService( new Intent( this, TestService.class ) );
      } else {
         startService( new Intent( this, TestService.class ) );
      }
   }
}
