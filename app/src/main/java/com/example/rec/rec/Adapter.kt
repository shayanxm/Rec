package com.example.rec.rec

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rec.R
import org.w3c.dom.Text

class Adapter(val mList: ArrayList<Product>) : RecyclerView.Adapter<Adapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName = view.findViewById<TextView>(R.id.item_titel)
        val textPrice = view.findViewById<TextView>(R.id.item_date)
        val itemDesciption = view.findViewById<TextView>(R.id.item_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_of_rec, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = mList[position]
        holder.textName.setText(currentItem.name)
        holder.textPrice.setText(currentItem.price)
        holder.itemDesciption.setText(currentItem.descreption)
    }
}