package com.masai.sainath.mensxp.mvvm

import androidx.lifecycle.LiveData

  class ProductRepo(val productDao: ProductDao) {

    fun getProducts(): LiveData<List<ProductEntity>>{
        return productDao.getMoney()
    }

    fun insertProduct(productEntity: ProductEntity){
        productDao.saveProduct(productEntity)
    }
    fun deleteProduct(productEntity: ProductEntity){
        productDao.Delete(productEntity)
    }
}