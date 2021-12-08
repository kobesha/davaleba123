package com.example.davaleba123

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var edittextemailaddress1: EditText
    private lateinit var edittexttextpassword1: EditText
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerListeners()
    }

    private fun init() {
        edittextemailaddress1 = findViewById(R.id.edittexttextemailaddress1)
        edittexttextpassword1= findViewById(R.id.edittexttextpassword1)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

    }

    private fun registerListeners() {
        button1.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        button3.setOnClickListener {
            startActivity(Intent(this, ForgotpasswordActivity::class.java))
        }
        button2.setOnClickListener {
            val email = edittextemailaddress1.text.toString()
            val password = edittexttextpassword1.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty~!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        gotoProfile()
                    } else {
                        Toast.makeText(this, "error!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

    }

    private fun gotoProfile() {
        startActivity(Intent(this, ProfileActivity::class.java))
        finish()

    }
}
