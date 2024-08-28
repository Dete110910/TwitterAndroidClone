package com.example.twitterclone.rv_activity.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet

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
    ): TweetViewHolder {
        val tweetView = LayoutInflater.from(parent.context)
            .inflate(R.layout.tweet, parent, false)
        return TweetViewHolder(tweetView)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        holder.tvUserName.text = tweets[position].userName
        holder.tvName.text = tweets[position].user
        holder.tvPostTime.text = tweets[position].postTime
        holder.tvText.text = tweets[position].text
    }

    override fun getItemCount(): Int = tweets.size
}