package com.codingblocks.jsonparsing

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_row.view.*

class GithubUserAdapter(private val items: ArrayList<Item>) :
    RecyclerView.Adapter<GithubUserAdapter.GithubHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): GithubHolder {
        val li = LayoutInflater.from(viewGroup.context)
        val inflatedView = li.inflate(R.layout.item_row, viewGroup, false)
        return GithubHolder(inflatedView)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: GithubHolder, position: Int) {
        val currentItem = items[position]

        holder.itemView.tvLogin.text = currentItem.login
        holder.itemView.tvHtmlUrl.text = currentItem.htmlUrl

//        holder.itemView.setOnClickListener {
//
//        }

    }

    //In kotlin the constructor params can directly be passed to the super
    //class's constructor
    inner class GithubHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        init {

            //Prefer attaching listeners inside your ViewHolder instead of the onBind method
            itemView.setOnClickListener {
                val currentUser = items[adapterPosition]
                //Send this user's info to an intent and start a new activity
            }

        }
    }

}