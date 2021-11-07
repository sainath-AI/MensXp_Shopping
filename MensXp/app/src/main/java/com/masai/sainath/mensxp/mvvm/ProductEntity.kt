package com.masai.sainath.mensxp.mvvm

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Product_table")
data class ProductEntity(@ColumnInfo(name = "title") var title: String,
                         @ColumnInfo(name = "desc") var desc: String,
                         @ColumnInfo(name = "imgurl") var imgurl: String,
                         @ColumnInfo(name = "price") var price: String
                        // @ColumnInfo(name = "quantity")  var quantity : Int




)
{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id : Int? = null
}