package com.masai.sainath.mensxp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.models.ExclusiveModel
import com.masai.sainath.mensxp.models.FashionModel

class FashionAdapter(val context: Context, val listOfFashion: ArrayList<FashionModel>): RecyclerView.Adapter<FashionAdapter.FashionViewHolder>() {
    inner  class FashionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val name=itemView.findViewById<TextView>(R.id.typeFashion)

        val imageView=itemView.findViewById<ImageView>(R.id.ImgFashion)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FashionViewHolder {
        return FashionViewHolder(LayoutInflater.from(context).inflate(R.layout.item_fashion,parent,false))
    }

    override fun onBindViewHolder(holder: FashionViewHolder, position: Int) {
        Glide.with(context).load(listOfFashion[position].link).into(holder.imageView)
        holder.name.text=listOfFashion[position].type

    }

    override fun getItemCount(): Int {
        return listOfFashion.size
    }
}