package com.pablo.miniactv4_extra.main

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast
import com.pablo.miniactv4_extra.pickable.MusicExtras.EXTRA_MUSIC

class MusicService : Service() {

    private var choosePlayer: MediaPlayer? = null

    override fun onBind(p0: Intent?): IBinder = throw NotImplementedError("Unsupported")

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        if (choosePlayer != null) {
            choosePlayer!!.stop()
            Toast.makeText(this, "Already playing a song, stopping service", Toast.LENGTH_SHORT).show()
        }
        choosePlayer = MediaPlayer.create(
            this,
            Uri.parse(intent?.getStringExtra(EXTRA_MUSIC).toString())
        )
        choosePlayer?.isLooping = true
        choosePlayer?.start()
        return startId
    }

    override fun onDestroy() {
        super.onDestroy()
        if (choosePlayer != null && choosePlayer?.isPlaying == true)
            choosePlayer?.stop()
    }

    override fun stopService(name: Intent?): Boolean {
        super.stopService(name)
        if (choosePlayer != null && choosePlayer?.isPlaying == true)
            choosePlayer?.stop()
        choosePlayer = null
        return true
    }

}