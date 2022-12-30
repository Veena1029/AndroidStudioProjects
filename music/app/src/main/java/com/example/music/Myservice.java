package com.example.music;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;
public class Myservice extends Service {
    public Myservice() {
    }
    MediaPlayer play;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public int onStartCommand(Intent intent,int flags,int startid)
    {
        play = MediaPlayer.create(this, R.raw.music);
        play.setLooping(true);
        play.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        play.stop();
    }
}