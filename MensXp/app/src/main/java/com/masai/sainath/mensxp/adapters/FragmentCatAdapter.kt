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
import com.masai.sainath.mensxp.models.FashionModel
import com.masai.sainath.mensxp.models.FragmentCategoryModel

class FragmentCatAdapter(val context: Context, val listOfFragCat: ArrayList<FragmentCategoryModel>): RecyclerView.Adapter<FragmentCatAdapter.FragmentCatViewHolder>() {
    inner  class FragmentCatViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val name=itemView.findViewById<TextView>(R.id.TxtType)
        val desc=itemView.findViewById<TextView>(R.id.Txtdesc)

        val imageView=itemView.findViewById<ImageView>(R.id.ImgFragCat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentCatViewHolder {
        return FragmentCatViewHolder(LayoutInflater.from(context).inflate(R.layout.item_frag_category,parent,false))
    }

    override fun onBindViewHolder(holder: FragmentCatViewHolder, position: Int) {
        Glide.with(context).load(listOfFragCat[position].link).into(holder.imageView)
        holder.name.text=listOfFragCat[position].type
        holder.desc.text=listOfFragCat[position].desc

    }

    override fun getItemCount(): Int {
        return listOfFragCat.size
    }
}