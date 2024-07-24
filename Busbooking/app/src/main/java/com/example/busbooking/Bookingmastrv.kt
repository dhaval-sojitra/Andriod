package com.example.busbooking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Bookingmastrv(var bookingmast: bookingmast,var arrylist: ArrayList<Bookingmastdataclass>,var bookingdb: Mydatabase) :
    RecyclerView.Adapter<Bookingmastrv.Myclass>() {
    class Myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var name: TextView
        lateinit var rid: TextView
        lateinit var from: TextView
        lateinit var to: TextView
        lateinit var date: TextView
        lateinit var seatno: TextView
        lateinit var phone: TextView
        lateinit var layout: LinearLayout

        init {
            name = itemView.findViewById(R.id.ltname)
            rid = itemView.findViewById(R.id.ltrid)
            from = itemView.findViewById(R.id.ltfrom)
            to = itemView.findViewById(R.id.ltto)
            date = itemView.findViewById(R.id.ltdate)
            seatno = itemView.findViewById(R.id.ltseatno)
            phone = itemView.findViewById(R.id.ltphon)
            layout = itemView.findViewById(R.id.trackticketlayout)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        var vv = LayoutInflater.from(bookingmast).inflate(R.layout.trackticketlayout, parent, false)
        return Bookingmastrv.Myclass(vv)
    }
    override fun getItemCount(): Int = arrylist.size
    override fun onBindViewHolder(holder: Myclass, position: Int) {
        holder.name.text = arrylist[position].name
        holder.rid.text = arrylist[position].ridd.toString()
        holder.from.text = arrylist[position].from
        holder.to.text = arrylist[position].to
        holder.date.text = arrylist[position].date
        holder.seatno.text = arrylist[position].sno.toString()
        holder.phone.text = arrylist[position].phonee



    }

}

