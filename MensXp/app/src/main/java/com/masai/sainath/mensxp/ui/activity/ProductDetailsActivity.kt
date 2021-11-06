package com.masai.sainath.mensxp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.databinding.ActivityProductDetailsBinding
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.android.synthetic.main.fragment_you.*

class ProductDetailsActivity : AppCompatActivity() {


    lateinit var binding: ActivityProductDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imgUrl=intent.getStringExtra("imgurl")
        val title=intent.getStringExtra("title")
        val desc=intent.getStringExtra("desc")
        val price=intent.getIntExtra("price",0)
        val quantity=intent.getStringExtra("quantity")


        Glide.with(this).load(imgUrl).into(ImgProductDetails)
        tvTitle.text=title
        TvDesc.text=desc
        TvPrice.text= "Rs. ${price.toString()}"


    }
}