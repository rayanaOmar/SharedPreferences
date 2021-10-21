package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var secondBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView = findViewById(R.id.textView)
        secondBtn = findViewById(R.id.secondBtn)

        val pri = intent.extras?.get("name")
        val pri2 = intent.extras?.get("age")
        textView.text = "$pri $pri2"

        val sharedPreference = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        secondBtn.setOnClickListener {
            val name = sharedPreference.getString("name", "")
            val age = sharedPreference.getString("age","")
            Toast.makeText(applicationContext, "$name $age", Toast.LENGTH_LONG).show()
        }
    }

    private fun SharedPreferences.getInt(s: String, s1: String) {

    }
}