package com.example.pradeshadvkotlin.ui.order.pastorders

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pradeshadvkotlin.R
import com.example.pradeshadvkotlin.model.response.transaction.Data
import com.example.pradeshadvkotlin.utils.Helpers.convertLongToTime
import com.example.pradeshadvkotlin.utils.Helpers.formatPrice
import kotlinx.android.synthetic.main.item_pastorders.view.*

class PastordersAdapter (
    private val listData : List<Data>,
    private val itemAdapterCallback : ItemAdapterCallback,
) : RecyclerView.Adapter<PastordersAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_pastorders, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(listData[position], itemAdapterCallback)
    }

    override fun getItemCount(): Int {
      return listData.size
    }

    class ViewHolder (itemView:View) : RecyclerView.ViewHolder(itemView) {
        fun bind(data : Data, itemAdapterCallback: ItemAdapterCallback) {
            itemView.apply {
                tvTitle.text = data.produk.name
                tvPrice.formatPrice(data.produk.price.toString())
                tvDate.text = data.produk.createdAt.convertLongToTime("MMM dd, HH.mm")

                Glide.with(context)
                    .load(data.produk.picturePath)
                    .into(ivPoster);

                if (data.status.equals("CANCELLED",true)){
                    tvCancelled.visibility = View.VISIBLE
                }


                itemView.setOnClickListener { itemAdapterCallback.onClick(it, data) }
            }
        }
    }
    interface ItemAdapterCallback {
        fun onClick(v: View, data:Data)
    }

}