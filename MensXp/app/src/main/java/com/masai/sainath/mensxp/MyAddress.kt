package com.masai.sainath.mensxp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_my_address.*

class MyAddress : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_address)
        AddAdress.setOnClickListener {
            intent = Intent(this,EditAddress::class.java)
            startActivity(intent)
            finish()
        }

    }
}