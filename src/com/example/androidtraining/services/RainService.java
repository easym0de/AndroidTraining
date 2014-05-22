package com.example.androidtraining.services;


import com.example.androidtraining.R;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class RainService extends Service {
	
	MediaPlayer m_mediaPlayer;

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("RainService", "oncreate of Rainservice called");
		Toast.makeText(this,"Service created ...", Toast.LENGTH_SHORT).show();
		Thread initBkgdThread = new Thread(new Runnable() {
			public void run() { 
				startRain();
			} 
		});
		initBkgdThread.start();
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		stopRain();
		Toast.makeText(this, "Service destroyed ...", Toast.LENGTH_SHORT).show();
	}
	

	private void startRain() {

		m_mediaPlayer = MediaPlayer.create(this, R.raw.rain); 
		m_mediaPlayer.start();


	}
	
	private void stopRain(){
		m_mediaPlayer.stop();
	}
}
