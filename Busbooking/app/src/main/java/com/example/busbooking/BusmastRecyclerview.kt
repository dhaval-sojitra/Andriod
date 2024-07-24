package com.example.busbooking

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BusmastRecyclerview(var busmast: busmast,var arrylist: ArrayList<Busmastdataclass>,var addbus: Mydatabase) :
    RecyclerView.Adapter<BusmastRecyclerview.Myclass>() {
    class Myclass(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var bid : TextView
        lateinit var date : TextView
        lateinit var model : TextView
        lateinit var seat : TextView
        lateinit var layout : LinearLayout

        init {
            bid = itemView.findViewById(R.id.lbid)
            date = itemView.findViewById(R.id.ldate)
            model = itemView.findViewById(R.id.lmodel)
            seat = itemView.findViewById(R.id.lseat)
            layout = itemView.findViewById(R.id.busmastlayout)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myclass {

        var vv = LayoutInflater.from(busmast).inflate(R.layout.busmastlayout,parent,false)
        return Myclass(vv)

    }
    override fun getItemCount(): Int= arrylist.size


    override fun onBindViewHolder(holder: Myclass, position: Int) {

        holder.bid.text = arrylist[position].bid.toString()
        holder.date.text = arrylist[position].bdate
        holder.model.text = arrylist[position].bmodel
        holder.seat.text = arrylist[position].bseat.toString()

        holder.layout.setOnClickListener{
            var dialog = AlertDialog.Builder(busmast)
            dialog.setTitle("Select Any Option")

            dialog.setPositiveButton("Update",DialogInterface.OnClickListener{dialog,which ->
                var intent = Intent(busmast,updatebusmast::class.java)
                intent.putExtra("bid",arrylist[position].bid)
                intent.putExtra("date",arrylist[position].bdate)
                intent.putExtra("model",arrylist[position].bmodel)
                intent.putExtra("seat",arrylist[position].bseat)

                busmast.startActivity(intent)
                busmast.finish()


            })
            dialog.setNegativeButton("Delete", DialogInterface.OnClickListener { dialog, which ->

                var id = arrylist[position].bid
                addbus.deletebus(id)
                arrylist.removeAt(position)
                notifyDataSetChanged()
            })

            dialog.show()

        }

    }


}
