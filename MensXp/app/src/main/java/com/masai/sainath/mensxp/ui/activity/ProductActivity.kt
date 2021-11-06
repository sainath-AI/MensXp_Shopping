package com.masai.sainath.mensxp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.adapters.GroomingAdapter
import com.masai.sainath.mensxp.databinding.ActivityProductBinding
import com.masai.sainath.mensxp.models.ProductModel

class ProductActivity : AppCompatActivity() {


    private lateinit var binding : ActivityProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseFirestore.getInstance()
        val uid= intent.getStringExtra("uid")
        val type=intent.getStringExtra("type")



        database.collection("Categories").document(uid!!).collection("Grooming")
            .addSnapshotListener { value, error ->
                val listofProducts = arrayListOf<ProductModel>()

                val data = value?.toObjects(ProductModel::class.java)
                listofProducts.addAll(data!!)

                binding.txtProductCategory.text=type.toString()

                binding.RevProductsList.layoutManager= GridLayoutManager(this,2)
                binding.RevProductsList.adapter=GroomingAdapter(this,listofProducts)
            }





    }
}