package com.example.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.openWebPage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW,Uri.parse("https://google.com"))
            startActivity(intent)
        }
        binding.openPhoneCall.setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:0123456789"))
            startActivity(intent)

        }
        binding.openCamera.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        binding.textShareButton.setOnClickListener{
            val text = binding.editText.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT,text)
            startActivity(Intent.createChooser(intent,"Share using"))
        }

    }
}