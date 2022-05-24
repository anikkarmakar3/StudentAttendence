package com.awesome.Student_Attendence

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

class Student_dashboard : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_dashboard)
        auth=FirebaseAuth.getInstance()
    }

}