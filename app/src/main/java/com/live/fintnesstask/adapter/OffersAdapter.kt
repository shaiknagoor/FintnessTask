package com.live.fintnesstask.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.live.fintnesstask.R
import com.live.fintnesstask.models.Cupon
import kotlinx.android.synthetic.main.offers_row.view.*

class OffersAdapter:RecyclerView.Adapter<OffersAdapter.MyHolder>() {
val differCallBack=object : DiffUtil.ItemCallback<Cupon>() {
    override fun areItemsTheSame(oldItem: Cupon, newItem: Cupon): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Cupon, newItem: Cupon): Boolean {
   //    TODO("Not yet implemented")
        return oldItem==newItem

    }


  }
    val differ= AsyncListDiffer(this,differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.offers_row,parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val coupon=differ.currentList.get(position)
        holder.itemView.apply {
            title_offer.text=coupon.title
            des_offer.text=coupon.description
            price_offer.text=coupon.price

        }
    }

    override fun getItemCount(): Int {
     return differ.currentList.size
    }
  inner  class MyHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    }

}