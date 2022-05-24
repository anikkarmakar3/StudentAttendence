package com.awesome.Student_Attendence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth

class Verify : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)
        auth=FirebaseAuth.getInstance()

        val storedVerificationId=intent.getStringExtra("storedVerificationId")

//        Reference
        val verify=findViewById<Button>(R.id.verifyBtn)
        val otpGiven=findViewById<EditText>(R.id.id_otp)
    }
}