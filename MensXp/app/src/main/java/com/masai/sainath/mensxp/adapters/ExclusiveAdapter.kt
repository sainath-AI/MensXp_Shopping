package com.masai.sainath.mensxp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.models.BrandModel
import com.masai.sainath.mensxp.models.ExclusiveModel

class ExclusiveAdapter(val context: Context, val listofExclusives: ArrayList<ExclusiveModel>): RecyclerView.Adapter<ExclusiveAdapter.ExclusiveViewHolder>() {
    inner  class ExclusiveViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageView=itemView.findViewById<ImageView>(R.id.ImgExclusive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExclusiveViewHolder {
        return ExclusiveViewHolder(LayoutInflater.from(context).inflate(R.layout.item_exclusive,parent,false))
    }

    override fun onBindViewHolder(holder: ExclusiveViewHolder, position: Int) {
        Glide.with(context).load(listofExclusives[position].link).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return listofExclusives.size
    }
}