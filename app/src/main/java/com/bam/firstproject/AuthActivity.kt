package com.bam.firstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bam.firstproject.databinding.ActivityAuthBinding
import com.bam.firstproject.databinding.ActivityMainBinding
import java.util.Date

class AuthActivity : AppCompatActivity() {

    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.loginBtn.setOnClickListener {

            val emailText = binding.editTextEmailAddress.text.toString()
            val passText = binding.editTextPassword.text.toString()

            LoginUserRepository.login(emailText, passText)

            if (LoginUserRepository.loginUser == null) {
                showToast("User not found")
            }
            else {
                val intent = Intent (this, MainActivity::class.java)
                val date = Date().toString()
                intent.putExtra(DATE, date)
                startActivity(intent)

            }
        }
    }

    private fun showToast(text: String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }



}