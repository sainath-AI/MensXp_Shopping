package com.masai.sainath.mensxp.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.models.CatImgModel
import com.masai.sainath.mensxp.ui.activity.ProductActivity
import de.hdodenhof.circleimageview.CircleImageView

class CategoryImgAdapter( val context: Context, val listOfCategories: ArrayList<CatImgModel>) : RecyclerView.Adapter<CategoryImgAdapter.CategoryImgViewHolder>() {
   inner  class CategoryImgViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {

       val imageView=itemView.findViewById<CircleImageView>(R.id.CatImages)
       val name=itemView.findViewById<TextView>(R.id.typeCat)


   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryImgViewHolder {

       return CategoryImgViewHolder(LayoutInflater.from(context).inflate(R.layout.item_category_views,parent,false))

    }

    override fun onBindViewHolder(holder: CategoryImgViewHolder, position: Int) {
        Glide.with(context).load(listOfCategories[position].link).into(holder.imageView)
        holder.name.text=listOfCategories[position].type
        holder.itemView.setOnClickListener {
            val intent= Intent(context, ProductActivity::class.java)
            intent.putExtra("uid",listOfCategories[position].id)
            intent.putExtra("link",listOfCategories[position].link)
            intent.putExtra("type",listOfCategories[position].type)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listOfCategories.size
    }
}