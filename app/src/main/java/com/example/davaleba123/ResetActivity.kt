package com.example.davaleba123

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetActivity : AppCompatActivity() {
    private lateinit var edittexttextpassword1: TextView
    private lateinit var button1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset)
        init()
        registerListeners()
    }

    private fun init(){
        edittexttextpassword1 = findViewById(R.id.edittexttextpassword1)
        button1 = findViewById(R.id.button1)
    }
    private fun registerListeners() {
        button1.setOnClickListener {
            val newpass = edittexttextpassword1.text.toString()
            if (newpass.isEmpty() || newpass.length < 7) {
                Toast.makeText(this, "Incorrect new password!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newpass)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Success!", Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                }
        }
    }
}