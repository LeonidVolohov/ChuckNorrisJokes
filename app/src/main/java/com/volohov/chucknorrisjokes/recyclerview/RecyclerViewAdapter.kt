package com.volohov.chucknorrisjokes.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.volohov.chucknorrisjokes.R

class RecyclerViewAdapter(private val jokesList: List<String>):
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var textViewJoke: TextView? = null

        init {
            textViewJoke = itemView.findViewById(R.id.recycler_item_joke)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewJoke?.text = jokesList.get(position)
    }

    override fun getItemCount(): Int {
        return jokesList.size
    }
}