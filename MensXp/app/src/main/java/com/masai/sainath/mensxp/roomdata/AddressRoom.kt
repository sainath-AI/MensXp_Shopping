package com.masai.sainath.mensxp.roomdata

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AddressEntity::class],version = 1)
abstract class Roomdb : RoomDatabase()  {

    abstract fun getMoneyDao() : AddressDao

    companion object {

        private  var INSTANCE : Roomdb?=null


        fun getDatabase(context : Context) : Roomdb{


            if(INSTANCE == null){

                val builder = Room.databaseBuilder(
                    context.applicationContext,Roomdb::class.java,
                    "address_db")

                builder.fallbackToDestructiveMigration()
                INSTANCE = builder.build()

                return INSTANCE!!
            }else{

                return INSTANCE!!
            }


        }
    }
}