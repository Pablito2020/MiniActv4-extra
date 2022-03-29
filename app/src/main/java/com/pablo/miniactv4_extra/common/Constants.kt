package com.pablo.miniactv4_extra.pickable

import android.content.Intent

object MusicExtras {
    const val EXTRA_MUSIC = "music_uri"
}

enum class UriConstants(val uri: String) {
    BULERIA("content://media/external/audio/media/60"),
    NO_ROMPAS_MAS("content://media/external/audio/media/59"),
    SENORITA("content://media/external/audio/media/58");

    fun getIntent(): Intent {
        val intent = Intent()
        intent.putExtra(MusicExtras.EXTRA_MUSIC, this.uri)
        return intent
    }

}