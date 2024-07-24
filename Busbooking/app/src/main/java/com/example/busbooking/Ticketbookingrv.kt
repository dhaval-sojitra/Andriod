package com.example.busbooking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Ticketbookingrv(var ticketbooking: ticketbooking,var arraylist: ArrayList<routerv>,var selectroute: Mydatabase) :
    RecyclerView.Adapter<Ticketbookingrv.myclass>() {
    class myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var rid: TextView
        lateinit var bid: TextView
        lateinit var from: TextView
        lateinit var to: TextView
        lateinit var date: TextView
        lateinit var time: TextView
        lateinit var price: TextView
        lateinit var layout: LinearLayout

        init {
            rid = itemView.findViewById(R.id.ltrid)
            bid = itemView.findViewById(R.id.ltbid)
            from = itemView.findViewById(R.id.ltfrom)
            to = itemView.findViewById(R.id.ltto)
            date = itemView.findViewById(R.id.ltdate)
            time = itemView.findViewById(R.id.lttime)
            price = itemView.findViewById(R.id.ltprice)
            layout = itemView.findViewById(R.id.bookingroutelayout)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myclass {
        var vv = LayoutInflater.from(ticketbooking).inflate(R.layout.bookingroutelayout, parent, false)
        return Ticketbookingrv.myclass(vv)
    }

    override fun onBindViewHolder(holder: myclass, position: Int) {
        holder.rid.text = arraylist[position].rrid.toString()
        holder.bid.text = arraylist[position].bid.toString()
        holder.from.text = arraylist[position].from
        holder.to.text = arraylist[position].to
        holder.date.text = arraylist[position].date
        holder.time.text = arraylist[position].time
        holder.price.text = arraylist[position].price.toString()



    }

    override fun getItemCount(): Int =arraylist.size


}
