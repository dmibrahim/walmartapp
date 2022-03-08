package com.dmi.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dmi.domain.User
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var userList= arrayListOf<User>(
         User("Dennis","Ibrahim","dibrahim@miu.edu","password"),
         User("Melon","Tadesse","mtadesse@miu.edu","password"),
         User("Eric","Ayalla","eayalla@miu.edu","password"),
        User("Rogath","John","rjohn@miu.edu","password")
    )
    val users= ArrayList<User>(userList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = getIntent()
        val user = intent.getSerializableExtra("user") as? User
        if(user !=null)
           users.add(user)
        loginButton.setOnClickListener{login()}
        createAccountButton.setOnClickListener{createAccount()}
        forgetpasswordTxt.setOnClickListener { forgetPassword() }
    }

 private fun login(){
     if(usernameEdt.text.isEmpty() || passwordEdt.text.isEmpty()){
         if(usernameEdt.text.isEmpty()){
             usernameEdt.requestFocus()
         }
         else{
             passwordEdt.requestFocus()
         }
         Toast.makeText(this, "Please enter all required informatiom", Toast.LENGTH_LONG).show()
         return
     }
     //Check if username exists
     val user = users.find { info -> info.getUserName().equals(usernameEdt.text.toString(), true)
             && info.getpassword().equals(passwordEdt.text.toString(),true) }
     if(user !=null){
     val intent = Intent(this, ShoppingCategoryActivity::class.java)
         intent.putExtra("username",user.getUserName())
       startActivity(intent)
     }
     else{
         Toast.makeText(this,"Invalid username or password", Toast.LENGTH_LONG).show()
     }
 }
fun createAccount(){
    val intent = Intent(this, RegisterActivity::class.java)
    startActivity(intent)
}
 fun forgetPassword(){
     if(usernameEdt.text.isEmpty()){
         usernameEdt.requestFocus()
         Toast.makeText(this, "Please enter your username", Toast.LENGTH_LONG).show()
         return
     }
     val intent = Intent();
     intent.action = Intent.ACTION_SEND
     val recipient = usernameEdt.text.toString()
     val userInfo = users.filter { info -> info.getUserName().equals(usernameEdt.text.toString(), true)}
     val subject = "Forget password requested"
     val password = userInfo[0]?.getpassword()
     var content = "Please find below your account information:\n"
     content += "Username: $recipient\n"
     content += "Password: ${password.toString()}\n"
     var uri = Uri.parse(recipient)
     intent.data =uri


     intent.putExtra(Intent.EXTRA_SUBJECT, subject)
     intent.putExtra(Intent.EXTRA_TEXT, content)
     intent.type = "text/plain"


     if(intent.resolveActivity(packageManager) !=null){
         startActivity(intent)
     }


 }
}