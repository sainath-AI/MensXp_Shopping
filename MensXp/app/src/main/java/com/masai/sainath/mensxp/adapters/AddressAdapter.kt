package com.masai.sainath.mensxp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.roomdata.AddressEntity

class AddressAdapter(private val dataHolder: MutableList<AddressEntity>,val listner : OnRowItemClicked) : RecyclerView.Adapter<AddressViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressViewHolder {

        val view  = LayoutInflater.from(parent.context).inflate(R.layout.item_address,parent,false)

        return AddressViewHolder(view,listner)

    }

    override fun onBindViewHolder(holder: AddressViewHolder, position: Int) {
        var model = dataHolder[position]

        holder.setData(model)

    }

    override fun getItemCount(): Int {
        return dataHolder.size
    }
}