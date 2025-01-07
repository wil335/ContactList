package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class contactListAdapter:
    ListAdapter<Contact, contactListAdapter.ContactViewHolder>(ContactDiffUtils()) {
        class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            private val tvName = view.findViewById<TextView>(R.id.tv_name)
            private val tvPhone = view.findViewById<TextView>(R.id.tv_phone)
            private val image = view.findViewById<ImageView>(R.id.imageView)
            fun bind(contact: Contact){
                tvName.text= contact.name
                tvPhone.text = contact.phone
                image.setImageResource(contact.icon)
            }
        }
    class ContactDiffUtils: DiffUtil.ItemCallback<Contact>(){
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(view)

    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
      holder.bind(contact)
    }
}