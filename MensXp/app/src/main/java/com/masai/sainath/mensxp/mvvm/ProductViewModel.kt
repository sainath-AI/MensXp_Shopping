package com.masai.sainath.mensxp.mvvm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

 class ProductViewModel(application: Application): AndroidViewModel(application){

     private val repo: ProductRepo

    init {
        val dao=ProductRoomdb.getDatabase(application)!!.getProductDao()
        repo=ProductRepo(dao)
    }
    fun AddProduct(productEntity: ProductEntity){
        repo.insertProduct(productEntity)
    }
    fun getProduct(): LiveData<List<ProductEntity>> =repo.getProducts()

    fun deleteProduct(productEntity: ProductEntity){
        repo.deleteProduct(productEntity)
    }
}