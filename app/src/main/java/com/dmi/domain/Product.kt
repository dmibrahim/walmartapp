package com.dmi.domain

import java.io.Serializable

data class Product(
    val productTitle: String,
    val price: String,
    val productColor: String,
    val productImage: Int,
    val id: Long,
    val description: String,
) : Serializable