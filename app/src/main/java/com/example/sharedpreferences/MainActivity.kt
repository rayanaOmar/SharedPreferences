package com.example.sharedpreferences

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var ageEditText: EditText
    lateinit var sharingBtn: Button
    lateinit var saveBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.editText1)
        ageEditText = findViewById(R.id.editText2)
        sharingBtn = findViewById(R.id.button1)
        saveBtn = findViewById(R.id.button2)



        sharingBtn.setOnClickListener {
            val userEnter1 = nameEditText.text.toString()
            val userEnter2 = ageEditText.text.toString().toInt()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("name",userEnter1)
            intent.putExtra("age", userEnter2)
            startActivity(intent)
        }
        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        var forSave = sharedPreference.edit()
        saveBtn.setOnClickListener {
            val userEnter1 = nameEditText.text.toString()
            val userEnter2 = ageEditText.text.toString()
            forSave.putString("name",userEnter1)
            forSave.putString("age", userEnter2)
            forSave.apply()
            Toast.makeText(applicationContext,"Data is SAVED!", Toast.LENGTH_LONG).show()
        }
    }
}