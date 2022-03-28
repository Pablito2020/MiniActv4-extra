package com.pablo.miniactv4_extra.actions

import android.content.Intent
import android.net.Uri

class BuleriaAction(private val uri: Uri) : Action {

    override fun getIntent(): Intent {
        val intent = Intent(Intent.ACTION_SEND).setType("audio/*")
        intent.type = "audio/*"
        intent.putExtra(Intent.EXTRA_STREAM, uri.toString())
        intent.putExtra("music_uri", uri.toString())
        return intent
    }

}