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
import com.masai.sainath.mensxp.models.ProductModel
import com.masai.sainath.mensxp.mvvm.ProductEntity
import com.masai.sainath.mensxp.roomdata.AddressEntity


class CartAdapter(val context: Context, val listofProducts: ArrayList<ProductEntity>,val listner: OnItemClicked): RecyclerView.Adapter<CartAdapter.CartViewHolder>() {
    inner  class CartViewHolder(itemView: View, listner: OnItemClicked): RecyclerView.ViewHolder(itemView) {

        val imageView=itemView.findViewById<ImageView>(R.id.ImgCart)
        val title=itemView.findViewById<TextView>(R.id.cartTitle)
        val desc=itemView.findViewById<TextView>(R.id.cartDesc)
        val price=itemView.findViewById<TextView>(R.id.CartPrice)
        val delete=itemView.findViewById<ImageView>(R.id.ImgDelete)
      //  val quantity=itemView.findViewById<TextView>(R.id.TvCounter)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        return CartViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cart,parent,false),listner)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        Glide.with(context).load(listofProducts[position].imgurl).into(holder.imageView)
        holder.title.text=listofProducts[position].title
        holder.desc.text=listofProducts[position].desc
        holder.price.text= "Rs. ${ listofProducts[position].price.toString()}"
     //   holder.quantity.text= "Rs. ${ listofProducts[position].quantity.toString()}"
        holder.delete.setOnClickListener {
            listner.onDeleteButtonClicked(listofProducts[position])
        }

    }

    override fun getItemCount(): Int {
        return listofProducts.size
    }
}