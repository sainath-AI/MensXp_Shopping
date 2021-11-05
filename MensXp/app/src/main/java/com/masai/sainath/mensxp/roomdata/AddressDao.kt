package com.masai.sainath.mensxp.roomdata

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMoney(addressEntity: AddressEntity)

    @Query("Select * from address_table")
    fun getMoney(): LiveData<List<AddressEntity>>

    @Update()
    fun Update(addressEntity: AddressEntity)

    @Delete()
    fun Delete(addressEntity: AddressEntity)
}