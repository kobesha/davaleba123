package com.example.davaleba123


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var edittexttextemailaddress1: EditText
    private lateinit var edittexttextpassword1: EditText
    private lateinit var edittexttextpassword2: EditText
    private lateinit var button1: Button
    private var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        registerListeners()
    }

    private fun init() {
        edittexttextemailaddress1 = findViewById(R.id.edittexttextemailaddress1)
        edittexttextpassword1 = findViewById(R.id.edittexttextpassword1)
        edittexttextpassword2 = findViewById(R.id.edittexttextpassword2)

        button1 = findViewById(R.id.button5)
    }

    private fun registerListeners() {
        button1.setOnClickListener {
            val email = edittexttextemailaddress1.text.toString()
            val password = edittexttextpassword1.text.toString()
            val password2 = edittexttextpassword2.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Empty~!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password == password2 && password.length > 9 && password.contains("[0-9]".toRegex()) && password.contains("[a-z]".toRegex()) && email.matches(emailPattern.toRegex()) ){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }
    }
}




