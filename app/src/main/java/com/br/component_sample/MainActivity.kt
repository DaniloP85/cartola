package com.br.component_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditTextCustom>(R.id.username)
        val password = findViewById<EditTextCustom>(R.id.password)

//        username.setLocalTheme(1)
//        password.setLocalTheme(2)

    }
}