package com.dmi.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dmi.domain.User
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        registerButton.setOnClickListener{register()}
    }
    fun register() {
       val valid = validateInputs()
        if(valid){
            val fname = fnameEdt.text.toString()
            val lname = lnameEdt.text.toString()
            val email = emailEdt.text.toString()
            val password = passwordEdt.text.toString()
            var user: User = User(fname,lname,email,password)
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user",user)
            Toast.makeText(this, "Successfully registered user",Toast.LENGTH_LONG).show()
            startActivity(intent)
        }

    }

    private fun validateInputs(): Boolean {
        if(fnameEdt.text.isEmpty() || lnameEdt.text.isEmpty()
            || emailEdt.text.isEmpty() || passwordEdt.text.isEmpty()){
            Toast.makeText(this, "Please enter all required information",Toast.LENGTH_LONG).show()
            return  false
        }
        return  true
    }
}