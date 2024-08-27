package com.example.twitterclone.rv_activity.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.Tweet
import com.example.twitterclone.rv_activity.RecyclerViewActivity

class RVAdapterTweet (private val tweets: List<Tweet>): RecyclerView.Adapter<RVAdapterTweet.TweetViewHolder>() {

    class TweetViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvUserName = view.findViewById<TextView>(R.id.tvUserName)
        val tvName = view.findViewById<TextView>(R.id.tvUser)
        val tvPostTime = view.findViewById<TextView>(R.id.tvPostTime)
        val tvText = view.findViewById<TextView>(R.id.tvTextTweet)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RVAdapterTweet.PostViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RVAdapterTweet.PostViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}