package com.masai.sainath.mensxp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.masai.sainath.mensxp.databinding.ActivityProductDetailsBinding
import com.masai.sainath.mensxp.mvvm.ProductDao
import com.masai.sainath.mensxp.mvvm.ProductEntity
import com.masai.sainath.mensxp.mvvm.ProductRoomdb
import kotlinx.android.synthetic.main.activity_product_details.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductDetailsActivity : AppCompatActivity() {

    lateinit var roomDb : ProductRoomdb

    lateinit var productDao: ProductDao

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
        ImgUrl.text=imgUrl

        roomDb = ProductRoomdb.getDatabase(this)
        productDao= roomDb.getProductDao()


        BtnAddToCart.setOnClickListener {

        }
        BtnBuyNow.setOnClickListener {
            val title = tvTitle.text.toString()
            val desc = TvDesc.text.toString()
            val imgurl = ImgUrl.text.toString()
            val price = TvPrice.text.toString()



            val productEntity = ProductEntity(title, desc,imgurl,price )

            CoroutineScope(Dispatchers.IO).launch {
                productDao.saveProduct(productEntity)
            }


                var intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
                finish()


        }



    }
}