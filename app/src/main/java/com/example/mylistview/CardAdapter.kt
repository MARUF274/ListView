package com.example.mylistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView


class CardAdapter internal constructor(private val context: Context): BaseAdapter(){
    internal var cards = arrayListOf<Card>()
    override fun getView(position: Int, view: View?,viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_card, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView as View)
        val card = getItem(position) as Card
        viewHolder.bind(card)
        return itemView
    }
    private inner class ViewHolder internal constructor(view: View){
        private val txtName: TextView = view.findViewById(R.id.txt_name)
        private val txtDescription: TextView = view.findViewById(R.id.txt_description)
        private val imgPhoto: CircleImageView = view.findViewById(R.id.img_photo)

        internal fun bind(card: Card){
            txtName.text = card.name
            txtDescription.text = card.description
            imgPhoto.setImageResource(card.photo)
        }
    }


    override fun getItem(i: Int): Any {
        return cards[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return cards.size
    }
}