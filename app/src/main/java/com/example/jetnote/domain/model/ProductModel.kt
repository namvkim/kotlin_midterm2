package com.example.jetnote.domain.model

import android.media.Image

data class ProductModel(
    val id: Int, // This value is used for new notes
    val title: String,
    val img: Int,
    var checked:Boolean = false
)
