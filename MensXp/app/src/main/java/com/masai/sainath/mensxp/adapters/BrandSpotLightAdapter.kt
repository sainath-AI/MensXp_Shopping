package com.masai.sainath.mensxp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.models.BrandModel
import com.masai.sainath.mensxp.ui.activity.ProductActivity
import com.masai.sainath.mensxp.ui.activity.ProductListActivity
import de.hdodenhof.circleimageview.CircleImageView

class BrandSpotLightAdapter(val context: Context,val listofBrands: ArrayList<BrandModel>): RecyclerView.Adapter<BrandSpotLightAdapter.BranViewHolder>() {
  inner  class BranViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

      val imageView=itemView.findViewById<ImageView>(R.id.ImgbrandSpot)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BranViewHolder {
        return BranViewHolder(LayoutInflater.from(context).inflate(R.layout.item_brandspots,parent,false))
    }

    override fun onBindViewHolder(holder: BranViewHolder, position: Int) {
        Glide.with(context).load(listofBrands[position].link).into(holder.imageView)

        holder.itemView.setOnClickListener {
            val intent= Intent(context, ProductListActivity::class.java)
            intent.putExtra("uid",listofBrands[position].id)
            intent.putExtra("link",listofBrands[position].link)
            context.startActivity(intent)
        }

           }

    override fun getItemCount(): Int {
return listofBrands.size
    }
}