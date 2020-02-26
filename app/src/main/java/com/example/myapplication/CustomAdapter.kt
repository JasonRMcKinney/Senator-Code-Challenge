package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Senator
import kotlinx.android.synthetic.main.list_item.view.*

class CustomAdapter(context: Context) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    var senators: List<Senator> = emptyList()
        set(value){
            field=value
            notifyDataSetChanged()
        }
    private val inflater: LayoutInflater
    init {
        inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = inflater.inflate(R.layout.list_item, parent, false)

        return CustomViewHolder(view)
    }

    override fun getItemCount() = senators.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(senators[position])
    }

    inner class CustomViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val firstName = view.txt_first_name
        private val lastName = view.txt_last_name
        private val description = view.txt_description

        fun bind(senator: Senator) {
            firstName.text = senator.person.firstname
            lastName.text = senator.person.lastname
            description.text = senator.description
        }

    }
}