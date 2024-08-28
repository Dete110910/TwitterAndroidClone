package com.example.twitterclone.rv_activity.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet

class RVAdapterTweet (private val tweets: List<Tweet>): RecyclerView.Adapter<TweetViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TweetViewHolder {
        val tweetView = LayoutInflater.from(parent.context)
            .inflate(R.layout.tweet, parent, false)
        return TweetViewHolder(tweetView)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        holder.render(tweets[position])
    }

    override fun getItemCount(): Int = tweets.size
}