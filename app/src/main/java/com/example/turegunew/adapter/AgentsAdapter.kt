package com.example.turegunew.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.turegunew.R
import com.example.turegunew.models.AgentsUser

class AgentsAdapter(
    val context: Context, val agentsList: List<AgentsUser>): Adapter<AgentsAdapter.AgentsViewHolder>() {
    class AgentsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val profilePic = itemView.findViewById<ImageView>(R.id.iv_company)
        val company_name = itemView.findViewById<TextView>(R.id.tv_companyName)
        val type_prop = itemView.findViewById<TextView>(R.id.tv_properties)
        val propertiesForRent = itemView.findViewById<TextView>(R.id.appCompatTextView)
        val propertiesForSale = itemView.findViewById<TextView>(R.id.appCompatTextView1)
        val weSpeak = itemView.findViewById<TextView>(R.id.tv_weSpeak)
        fun bind(model: AgentsUser, context: Context){

            Glide.with(context).load(model.profilePic.url).into(profilePic)
            company_name.text = model.parent.company.name
            type_prop.text = model.parent.company.type
            propertiesForRent.text = model.parent.company.saleInfo.propertiesForRent.toString()
            propertiesForSale.text = model.parent.company.saleInfo.propertiesForSale.toString()
            weSpeak.text = model.agent.languages

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AgentsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.agents_item, parent, false)
        return AgentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AgentsViewHolder, position: Int) {
        val data = agentsList[position]
        holder.bind(data, context)
    }

    override fun getItemCount(): Int {
        return agentsList.size
    }
}