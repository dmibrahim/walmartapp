package com.dmi.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dmi.activity.databinding.ActivityElectronicsDetailBinding
import com.dmi.domain.Product


class ElectronicsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityElectronicsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectronicsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val product: Product? = intent.getSerializableExtra("product") as Product?
        product?.productImage?.let { binding.detailProductImage.setBackgroundResource(it) }
        binding.detailProductTitle.text = product?.productTitle
        binding.detailProductColor.text = "Color: ${product?.productColor}"
        binding.detailProductNumber.text = "Walmart #: ${product?.id.toString()}"
        binding.detailProductDescription.text = "Item Description:\n${product?.description}"
    }

}