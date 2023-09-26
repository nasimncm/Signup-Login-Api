package com.example.turegunew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.turegunew.databinding.ActivitySplashBinding
import com.example.turegunew.utils.TokenManager
import javax.inject.Inject

class Splash : AppCompatActivity() {
    @Inject
    lateinit var tokenManager: TokenManager
    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_splash)

        tokenManager = TokenManager(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if (tokenManager.getToken() != null){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, Language::class.java)
                startActivity(intent)
                finish()
            }

        }, 5000)
    }
}