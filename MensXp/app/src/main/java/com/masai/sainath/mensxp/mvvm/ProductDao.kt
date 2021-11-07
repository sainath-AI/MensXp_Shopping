package com.masai.sainath.mensxp.mvvm

import androidx.lifecycle.LiveData
import androidx.room.*
import com.masai.sainath.mensxp.roomdata.AddressEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveProduct(productEntity: ProductEntity)

    @Query("Select * from product_table")
    fun getMoney(): LiveData<List<ProductEntity>>

    @Update()
    fun Update(productEntity: ProductEntity)

    @Delete()
    fun Delete(productEntity: ProductEntity)
}