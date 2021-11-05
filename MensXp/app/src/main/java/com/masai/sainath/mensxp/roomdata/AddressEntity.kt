package com.masai.sainath.mensxp.roomdata

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table")
data class AddressEntity(@ColumnInfo(name = "name") var name : String,
                       @ColumnInfo(name = "address1") var address1: String,
                       @ColumnInfo(name = "address2")  var address2 : String,
                       @ColumnInfo(name = "address3")  var address3 : String,
                       @ColumnInfo(name = "address4")  var address4 : String,
                       @ColumnInfo(name = "email")  var email : String,
                       @ColumnInfo(name = "mobile")  var mobile : String



                       )
{
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") var id : Int? = null
}