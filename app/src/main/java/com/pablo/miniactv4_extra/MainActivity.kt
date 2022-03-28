package com.pablo.miniactv4_extra

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pablo.miniactv4_extra.actions.BuleriaAction
import com.pablo.miniactv4_extra.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buleriaButton.setOnClickListener(this)
        binding.noRompasButton.setOnClickListener(this)
        binding.senoritaButton.setOnClickListener(this)
        binding.stopButton.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val buleriaAction = BuleriaAction(resourceUri(R.raw.buleria))
        val intent = buleriaAction.getIntent()
        setResult(RESULT_OK, intent)
        finish()
    }

}

fun Context.resourceUri(resourceId: Int): Uri = with(resources) {
    Uri.Builder()
        .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
        .authority(getResourcePackageName(resourceId))
        .appendPath(getResourceTypeName(resourceId))
        .appendPath(getResourceEntryName(resourceId))
        .build()
}