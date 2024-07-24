package com.example.busbooking

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RoutemastRecyclerview(
    var routmast: routmast,
    var arrylist: ArrayList<Routemastdataclass>,
    var addroute: Mydatabase
) :
    RecyclerView.Adapter<RoutemastRecyclerview.Myclass>() {
    class Myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var rid: TextView
        lateinit var bid: TextView
        lateinit var from: TextView
        lateinit var to: TextView
        lateinit var date: TextView
        lateinit var time: TextView
        lateinit var price: TextView
        lateinit var layout: LinearLayout

        init {
            rid = itemView.findViewById(R.id.lrrid)
            bid = itemView.findViewById(R.id.lrbid)
            from = itemView.findViewById(R.id.lrfrom)
            to = itemView.findViewById(R.id.lrto)
            date = itemView.findViewById(R.id.lrdate)
            time = itemView.findViewById(R.id.lrtime)
            price = itemView.findViewById(R.id.lrprice)
            layout = itemView.findViewById(R.id.routemastlayout)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {
        var vv = LayoutInflater.from(routmast).inflate(R.layout.routemastlayout, parent, false)
        return RoutemastRecyclerview.Myclass(vv)
    }

    override fun onBindViewHolder(holder: Myclass, position: Int) {
        holder.rid.text = arrylist[position].rrid.toString()
        holder.bid.text = arrylist[position].bid.toString()
        holder.from.text = arrylist[position].from
        holder.to.text = arrylist[position].to
        holder.date.text = arrylist[position].date
        holder.time.text = arrylist[position].time
        holder.price.text = arrylist[position].price.toString()

        holder.layout.setOnClickListener{
            var dialog = AlertDialog.Builder(routmast)
            dialog.setTitle("Select Any Option")

            dialog.setPositiveButton("Update", DialogInterface.OnClickListener{ dialog, which ->

                var intent = Intent(routmast,updateroute::class.java)
                intent.putExtra("rid",arrylist[position].rrid)
                intent.putExtra("bid",arrylist[position].bid)
                intent.putExtra("from",arrylist[position].from)
                intent.putExtra("to",arrylist[position].to)
                intent.putExtra("date",arrylist[position].date)
                intent.putExtra("time",arrylist[position].time)
                intent.putExtra("price",arrylist[position].price)
                routmast.startActivity(intent)
                routmast.finish()



            })
            dialog.setNegativeButton("Delete", DialogInterface.OnClickListener { dialog, which ->

                var id = arrylist[position].rrid
                addroute.deleteroute(id)
                arrylist.removeAt(position)
                notifyDataSetChanged()
            })

            dialog.show()

        }


    }

    override fun getItemCount(): Int = arrylist.size
}


