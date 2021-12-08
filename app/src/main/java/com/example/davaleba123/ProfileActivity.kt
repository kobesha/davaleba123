package com.example.davaleba123


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {
    private lateinit var textview1 : TextView
    private lateinit var button1 :Button
    private lateinit var button2 :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        init()
        registerListeners()
        textview1.text = FirebaseAuth.getInstance().currentUser?.uid

    }
    private fun init(){
        button1 = findViewById(R.id.button1)
        button2= findViewById(R.id.button2)
        textview1 = findViewById(R.id.textview1)
    }
    private fun registerListeners(){
        button1.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
        button2.setOnClickListener {
            startActivity(Intent(this, ResetActivity::class.java))

        }
    }
}