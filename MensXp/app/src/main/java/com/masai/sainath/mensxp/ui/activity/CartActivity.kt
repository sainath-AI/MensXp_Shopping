package com.masai.sainath.mensxp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.adapters.AddressAdapter
import com.masai.sainath.mensxp.adapters.CartAdapter
import com.masai.sainath.mensxp.adapters.OnItemClicked
import com.masai.sainath.mensxp.models.ProductModel
import com.masai.sainath.mensxp.mvvm.ProductDao
import com.masai.sainath.mensxp.mvvm.ProductEntity
import com.masai.sainath.mensxp.mvvm.ProductRoomdb
import com.masai.sainath.mensxp.roomdata.AddressDao
import com.masai.sainath.mensxp.roomdata.Roomdb
import kotlinx.android.synthetic.main.activity_cart.*
import kotlinx.android.synthetic.main.activity_my_address.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CartActivity : AppCompatActivity(),OnItemClicked {

    val listOfProducts = ArrayList<ProductEntity>()
    lateinit var adapter: CartAdapter

    lateinit var roomDb : ProductRoomdb
    lateinit var productDao: ProductDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)




        roomDb = ProductRoomdb.getDatabase(this)
        productDao= roomDb.getProductDao()

        adapter = CartAdapter(this, listOfProducts,this)
        RevCart.layoutManager = LinearLayoutManager(this)
        RevCart.adapter=adapter

        productDao.getMoney().observe(this, androidx.lifecycle.Observer {
          if(it.isNotEmpty()){
              RevCart.visibility=View.VISIBLE
              BtnContinue.visibility=View.VISIBLE
          }else{
              RevCart.visibility=View.INVISIBLE
              BtnContinue.visibility=View.INVISIBLE
          }
            val data = it

            listOfProducts.clear()
            listOfProducts.addAll(data)
            adapter.notifyDataSetChanged()

        })



    }

    override fun onDeleteButtonClicked(productEntity: ProductEntity) {
        CoroutineScope(Dispatchers.IO).launch{
            productDao.Delete(productEntity)
        }
    }
}