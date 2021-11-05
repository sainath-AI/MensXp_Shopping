package com.masai.sainath.mensxp.ui.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.masai.sainath.mensxp.R

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )


        val textView: TextView=findViewById(R.id.TxtMensXp)
        val slideAnimation= AnimationUtils.loadAnimation(this, R.anim.slide_side)
        textView.startAnimation(slideAnimation)




        Handler().postDelayed({


          val sharedPreferences= getSharedPreferences(LoginActivity1.PREFS_NAME,0)
            val hasLoggedIn = sharedPreferences.getBoolean("hasLoggedIn",false)

            if(hasLoggedIn){
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                val intent = Intent(this, LoginActivity1::class.java)
                startActivity(intent)
                finish()
            }

        }, 3000) // 3000 is the delayed time in milliseconds.
    }
}