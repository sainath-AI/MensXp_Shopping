package com.masai.sainath.mensxp.adapters

import com.masai.sainath.mensxp.roomdata.AddressEntity


interface OnRowItemClicked {

    fun onEditButtonClicked(addressEntity: AddressEntity)
     fun onDeleteButtonClicked(addressEntity: AddressEntity)

}