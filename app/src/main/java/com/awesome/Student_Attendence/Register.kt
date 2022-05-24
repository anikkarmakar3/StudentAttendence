package com.awesome.Student_Attendence

import android.Manifest.permission.CAMERA
import android.Manifest.permission_group.CAMERA
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.Manifest;
import android.graphics.Bitmap
import android.provider.MediaStore
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.awesome.Student_Attendence.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*


class Register : AppCompatActivity(),AdapterView.OnItemSelectedListener {
    lateinit var reg_name:EditText
    lateinit var reg_phone:EditText
    lateinit var reg_email:EditText
    lateinit var reg_address:EditText
    lateinit var batch_name:TextView
    lateinit var reg_password:EditText
    lateinit var binding: ActivityRegisterBinding
    lateinit var got_image:ImageView
    var listofbatch= arrayOf("HTML","CSS","PHP","WORDPRESS","ANDROID","SQUARESPACE")
    var CAMERA_REQUEST:Int = 1888
    lateinit var database: DatabaseReference
    lateinit var auth: FirebaseAuth
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        auth=FirebaseAuth.getInstance()

        reg_name=findViewById(R.id.reg_name)
        reg_phone=findViewById(R.id.reg_phone)
        reg_email=findViewById(R.id.reg_Email)
        reg_address=findViewById(R.id.reg_Address)
        batch_name=findViewById(R.id.reg_Batch)
        reg_password=findViewById(R.id.reg_password)

        binding.batchSpin.onItemSelectedListener = this
        val adpter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,listofbatch)
        adpter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.batchSpin.adapter=adpter

        binding.takeImage.isEnabled=false
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.CAMERA)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),100)

        }
        else{
            binding.takeImage.isEnabled = true
        }

        binding.takeImage.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,200)
        }

        button2.setOnClickListener {
            val intent=Intent(this,Studentlogin::class.java)
            startActivity(intent)
        }

        binding.stuRegister.setOnClickListener {
            val reg_name=reg_name.text.toString()
            val reg_phone=reg_phone.text.toString()
            val reg_email=reg_email.text.toString()
            val reg_address=reg_address.text.toString()
            val batch_name=batch_name.text.toString()
            val reg_password=reg_password.text.toString()

            database=FirebaseDatabase.getInstance().getReference("Student")
            val student= Student(reg_name,reg_phone,reg_email,reg_password,reg_address,batch_name)
            database.child(reg_phone).setValue(student).addOnSuccessListener {
//                binding.regName.setText("")
//                binding.regPhone.setText("")
//                binding.regBatch.setText("")
//                binding.regEmail.setText("")
//                binding.regAddress.setText("")
                Toast.makeText(applicationContext,"Succesfully Register",Toast.LENGTH_LONG).show()
            }.addOnFailureListener {
                Toast.makeText(applicationContext,"SomeThing Went Wrong",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode==200){
            if (resultCode == RESULT_OK){
                val pic : Bitmap? = data?.getParcelableExtra<Bitmap>("data")
                binding.gotImage.setImageBitmap(pic)
            }
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode==100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            binding.takeImage.isEnabled=true
        }
    }



    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        binding.regBatch.text=listofbatch[p2]
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        Toast.makeText(applicationContext, "please choose anybatch", Toast.LENGTH_LONG).show()
    }


}