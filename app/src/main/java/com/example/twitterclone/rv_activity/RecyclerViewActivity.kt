package com.example.twitterclone.rv_activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.Tweet

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvTweets: RecyclerView
    private val tweetLists = arrayListOf<Tweet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initViews()
    }

    private fun initViews() {
        rvTweets = findViewById(R.id.rv_tweets)
        rvTweets.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RV
        }

    }
}