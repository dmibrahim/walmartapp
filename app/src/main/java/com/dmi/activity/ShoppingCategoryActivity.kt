package com.dmi.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.dmi.domain.User
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)
        val intent= getIntent()
        val username = intent.getStringExtra("username")
        welcome_message.text = "Welcome: $username"
        foodCategory.setOnClickListener { handleOnFoodClick() }
        beautyCategory.setOnClickListener { handleOnBeautyClick() }
        clothesCategory.setOnClickListener { handleOnClothesClick() }
        electronicCategory.setOnClickListener { handleOnElectClick() }
    }

    private fun handleOnElectClick() {
        startActivity(Intent(this, ElectronicsCategoryActivity::class.java))
    }
    private fun handleOnClothesClick() {
        Toast.makeText(applicationContext,"Clothing department", Toast.LENGTH_LONG).show()
    }
    private fun handleOnBeautyClick() {
        Toast.makeText(applicationContext,"Beauty Department", Toast.LENGTH_LONG).show()
    }
    private fun handleOnFoodClick() {
        Toast.makeText(applicationContext,"Food Department", Toast.LENGTH_LONG).show()
    }
}