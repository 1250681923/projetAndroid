package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.models.Librarie

class ListLibrariesAdapter(
    items: List<Librarie>
) : RecyclerView.Adapter<ListLibrariesAdapter.ViewHolder>(){
    private val mLibrarie: List<Librarie> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.librarie_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val librarieid: TextView
        val librarieName: TextView
        val librarieDiscrip : TextView

        init {
            // Enable click on item
            librarieid= view.findViewById(R.id.libid)
            librarieName = view.findViewById(R.id.name)
            librarieDiscrip = view.findViewById(R.id.discription)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val library:Librarie = mLibrarie[position]
        holder.librarieid.text= library.id.toString()
        holder.librarieName.text =library.librairie_name
        holder.librarieDiscrip.text = library.librairie_description
    }

    override fun getItemCount(): Int {
        return mLibrarie.size
    }


}
