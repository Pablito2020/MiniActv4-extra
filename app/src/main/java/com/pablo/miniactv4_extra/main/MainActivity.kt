package com.pablo.miniactv4_extra.main

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pablo.miniactv4_extra.databinding.ActivityMainBinding
import com.pablo.miniactv4_extra.pickable.MusicExtras
import com.pablo.miniactv4_extra.pickable.UriConstants

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var service: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buleriaButton.setOnClickListener(this)
        binding.noRompasButton.setOnClickListener(this)
        binding.senoritaButton.setOnClickListener(this)
        binding.stopButton.setOnClickListener(this)
        service = Intent(this, MusicService::class.java)
        if (!hasPermissions())
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 0)
    }

    fun hasPermissions(): Boolean = checkSelfPermission(
        Manifest.permission.READ_EXTERNAL_STORAGE
    ) == PackageManager.PERMISSION_GRANTED

    override fun onClick(p0: View) {
        when (p0.id) {
            binding.buleriaButton.id -> {
                service.putExtra(MusicExtras.EXTRA_MUSIC, UriConstants.BULERIA.uri)
                startService(service)
            }
            binding.noRompasButton.id -> {
                service.putExtra(MusicExtras.EXTRA_MUSIC, UriConstants.NO_ROMPAS_MAS.uri)
                startService(service)
            }
            binding.senoritaButton.id -> {
                service.putExtra(MusicExtras.EXTRA_MUSIC, UriConstants.SENORITA.uri)
                startService(service)
            }
            binding.stopButton.id -> stopService(service)
            else -> throw Error("Unsupported Button")
        }
    }

}