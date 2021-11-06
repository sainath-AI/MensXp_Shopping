package com.masai.sainath.mensxp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.adapters.GroomingAdapter
import com.masai.sainath.mensxp.databinding.ActivityProductBinding
import com.masai.sainath.mensxp.databinding.ActivityProductListBinding
import com.masai.sainath.mensxp.models.ProductModel

class ProductListActivity : AppCompatActivity() {
    lateinit var binding: ActivityProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseFirestore.getInstance()
        val uid= intent.getStringExtra("uid")

        database.collection("BrandSpotLight").document(uid!!).collection("Products")
            .addSnapshotListener { value, error ->
                val listofProducts = arrayListOf<ProductModel>()

                val data = value?.toObjects(ProductModel::class.java)
                listofProducts.addAll(data!!)


                binding.RevProductsList.layoutManager= GridLayoutManager(this,2)
                binding.RevProductsList.adapter= GroomingAdapter(this,listofProducts)
            }
   }
}