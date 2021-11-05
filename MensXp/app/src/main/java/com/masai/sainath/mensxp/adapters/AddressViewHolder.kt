package com.masai.sainath.mensxp.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.mensxp.roomdata.AddressEntity
import kotlinx.android.synthetic.main.item_address.view.*

class AddressViewHolder(itemView: View,val listner : OnRowItemClicked) : RecyclerView.ViewHolder(itemView) {

    fun setData(addressEntity: AddressEntity){

        itemView.apply {

            Tvname.text = addressEntity.name
            Address1.text = addressEntity.address1
            Address2.text = addressEntity.address2
            Address3.text = addressEntity.address3
            Address4.text = addressEntity.address4
            Tvemail.text = addressEntity.email
            phNo.text = addressEntity.mobile

            etEdit.setOnClickListener {

                listner.onEditButtonClicked(addressEntity)
            }
            etDelete.setOnClickListener {

                listner.onDeleteButtonClicked(addressEntity)
            }


        }
    }
}