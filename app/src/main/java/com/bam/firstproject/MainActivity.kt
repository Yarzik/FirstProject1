package com.bam.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bam.firstproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        if (LoginUserRepository.loginUser == null){
//            val intent = Intent (this, AuthActivity::class.java)
//            startActivity(intent)
//        }
        if (intent != null) {
            val value = intent.getStringExtra(DATE)
            binding.textView5.text = value

        }
        binding.button.setOnClickListener {
            val text = binding.emailText.text.toString()

            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "*/*"
                putExtra(Intent.EXTRA_SUBJECT, "Первое письмо")
                putExtra(Intent.EXTRA_TEXT, text)
            }
            if (intent.resolveActivity(packageManager) != null){
                startActivity(Intent.createChooser(intent, "Select"))
            }
            else {
                Toast.makeText(this,"Нету", Toast.LENGTH_LONG).show()
            }

        }
    }
}