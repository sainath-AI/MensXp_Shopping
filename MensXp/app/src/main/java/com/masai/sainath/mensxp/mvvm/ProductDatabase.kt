package com.masai.sainath.mensxp.mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ProductEntity::class],version = 1)
abstract class ProductRoomdb : RoomDatabase()  {

    abstract fun getProductDao() : ProductDao

    companion object {

        private  var INSTANCE : ProductRoomdb?=null


        fun getDatabase(context : Context) : ProductRoomdb{


            if(INSTANCE == null){

                val builder = Room.databaseBuilder(
                    context.applicationContext,ProductRoomdb::class.java,
                    "product_db")

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()

                return INSTANCE!!
            }else{

                return INSTANCE!!
            }


        }
    }
}