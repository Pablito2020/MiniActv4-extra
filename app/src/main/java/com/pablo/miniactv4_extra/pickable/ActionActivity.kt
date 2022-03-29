package com.pablo.miniactv4_extra.pickable

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pablo.miniactv4_extra.databinding.ActivityMainBinding

class ActionActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpButtons()
    }

    private fun setUpButtons() {
        binding.buleriaButton.setOnClickListener(this)
        binding.noRompasButton.setOnClickListener(this)
        binding.senoritaButton.setOnClickListener(this)
        binding.stopButton.visibility = View.INVISIBLE
    }

    override fun onClick(p0: View) {
        when (p0.id) {
            binding.senoritaButton.id -> sendIntentAndFinish(UriConstants.SENORITA)
            binding.noRompasButton.id -> sendIntentAndFinish(UriConstants.NO_ROMPAS_MAS)
            binding.buleriaButton.id -> sendIntentAndFinish(UriConstants.BULERIA)
            else -> throw Error("Unsupported Button")
        }
    }

    private fun sendIntentAndFinish(uri: UriConstants) {
        setResult(RESULT_OK, uri.getIntent())
        finish()
    }

}