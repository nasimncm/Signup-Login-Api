package com.example.turegunew.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.turegunew.R
import com.example.turegunew.models.UserProfile

class ProfileAdapter
    /*(
    val context: Context,
    val profileList: List<UserProfile>
): Adapter<ProfileAdapter.ProfileViewHolder>()*/ {/*


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.fragment_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        val data = profileList[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return profileList.size
    }

    class ProfileViewHolder(itemView: View): ViewHolder(itemView) {
        val profilePic = itemView.findViewById<ImageView>(R.id.userImg)
        val userFirstName = itemView.findViewById<TextView>(R.id.user_first_name)
        val userLastName = itemView.findViewById<TextView>(R.id.user_last_name)
        val userEmail = itemView.findViewById<TextView>(R.id.tv_email)
        val follower = itemView.findViewById<TextView>(R.id.follower)
        val language = itemView.findViewById<TextView>(R.id.tv_language)
        val currency = itemView.findViewById<TextView>(R.id.tv_curren_id)
        val measuring = itemView.findViewById<TextView>(R.id.tv_measuring_id)
        fun bind(model: UserProfile){

            userFirstName.text = model.firstName
            userLastName.text = model.lastName
            userEmail.text = model.email
            follower.text = model.followedAgents.toString()
            language.text = model.lang.code

        }

    }*/
}