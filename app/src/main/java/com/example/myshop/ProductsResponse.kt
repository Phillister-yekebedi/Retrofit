package com.example.myshop

import android.media.audiofx.DynamicsProcessing.Limiter

data class ProductsResponse(
    var products: List<Product>,
    var total: Int,
    var skip:Int,
    var limit: Int,
)
