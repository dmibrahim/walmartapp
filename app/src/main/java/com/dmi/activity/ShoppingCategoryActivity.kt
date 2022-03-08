package com.dmi.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        val intent= getIntent()
        val username = intent.getStringExtra("username")
        welcomeMsg.text = "Welcome "+ username
    }
}