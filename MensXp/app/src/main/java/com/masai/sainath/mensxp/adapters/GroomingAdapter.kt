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
import com.masai.sainath.mensxp.models.FragmentCategoryModel
import com.masai.sainath.mensxp.models.ProductModel
import com.masai.sainath.mensxp.ui.activity.ProductActivity
import com.masai.sainath.mensxp.ui.activity.ProductDetailsActivity

class GroomingAdapter(val context: Context, val listOfProducts: ArrayList<ProductModel>): RecyclerView.Adapter<GroomingAdapter.GroomingViewHolder>() {
    inner  class GroomingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val title=itemView.findViewById<TextView>(R.id.TxtTitle)
        val desc=itemView.findViewById<TextView>(R.id.TxtDesc)
        val price=itemView.findViewById<TextView>(R.id.TxtPrice)
        val imageView=itemView.findViewById<ImageView>(R.id.ImgProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroomingViewHolder {
        return GroomingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_productlist,parent,false))
    }

    override fun onBindViewHolder(holder: GroomingViewHolder, position: Int) {
        Glide.with(context).load(listOfProducts[position].imgurl).into(holder.imageView)
        holder.title.text=listOfProducts[position].title
        holder.desc.text=listOfProducts[position].desc
        holder.price.text= "Rs. ${ listOfProducts[position].price.toString()}"
        holder.itemView.setOnClickListener {
            val intent= Intent(context, ProductDetailsActivity::class.java)
            intent.putExtra("title",listOfProducts[position].title)
            intent.putExtra("imgurl",listOfProducts[position].imgurl)
            intent.putExtra("desc",listOfProducts[position].desc)
            intent.putExtra("quantity",listOfProducts[position].quantity)
            intent.putExtra("price",listOfProducts[position].price)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listOfProducts.size
    }
}