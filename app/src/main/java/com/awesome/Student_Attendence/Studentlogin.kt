package com.awesome.Student_Attendence

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_studentlogin.*


class Studentlogin : AppCompatActivity() {
    lateinit var username:EditText
    lateinit var password:EditText

    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    lateinit var register_btn:Button
    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_studentlogin)
        username=findViewById(R.id.username)
        password=findViewById(R.id.userpassword)


        loginBtn.setOnClickListener {
            val username=username.text.toString()
            val password=password.text.toString()
            if (username.isEmpty()){
                Toast.makeText(applicationContext,"Please Put Data",Toast.LENGTH_SHORT).show()
            }
            else{
                database= FirebaseDatabase.getInstance().getReference("Student")
                val getuser=database.child("Phone")
//                database.child("phone").get().addOnSuccessListener {
////                    if (it.exists()){
////                        val userphone:String = it.child("password").value.toString()
////                        Log.d("SU","Data Succesfully get in $userphone")
////                    }
////                    else{
////                        Toast.makeText(applicationContext,"data is not coming",Toast.LENGTH_SHORT).show()
////                    }
//                    val username=it.hasChild("password").toString()
//                    Toast.makeText(applicationContext,"data is coming $username",Toast.LENGTH_SHORT).show()
//                }.addOnFailureListener {
//                    Toast.makeText(applicationContext,"Something Goes Wrong",Toast.LENGTH_SHORT).show()
//                }
            }
        }
    }

    fun btn_register(view: View) {
        val intent= Intent(this,Register::class.java)
        startActivity(intent)
    }
}