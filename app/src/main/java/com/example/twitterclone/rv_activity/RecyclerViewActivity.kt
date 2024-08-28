package com.example.twitterclone.rv_activity

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet
import com.example.twitterclone.rv_activity.adapters.RVAdapterTweet
import com.example.twitterclone.utils.showToast

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvTweets: RecyclerView
    private val tweetLists = arrayListOf<Tweet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        initViews()
        fillTweetList()

    }

    private fun initViews() {
        rvTweets = findViewById(R.id.rv_tweets)
        rvTweets.apply {
            layoutManager = LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = RVAdapterTweet(tweetLists)
        }

    }

    private fun fillTweetList() {
        for (i in 0 until 20) {
            tweetLists.add(Tweet("@calleblr", "Val", "${i}h", "Mi primer tweet número: $i"))
        }
    }

    private fun setListeners(postView: View, tweet: Tweet, ) {
        postView.findViewById<ImageButton>(R.id.ibComment).setOnClickListener{
            showToast("Funcionalidad de comentarios aún no implementada")
        }

        postView.findViewById<ImageButton>(R.id.ibRetweet).setOnClickListener{
            showToast("Publicación retuiteada")
        }

        postView.findViewById<ImageButton>(R.id.ibLike).setOnClickListener{
            showToast("Al usuario ${tweet.userName} le gustó este post publicado hace ${tweet.postTime}")
        }

        postView.findViewById<ImageButton>(R.id.ibStatistics).setOnClickListener{
            showToast("Funcionalidad de estadísticas aún no implementada")
        }

        postView.findViewById<ImageButton>(R.id.ibShare).setOnClickListener{
            showToast("Funcionalidad de compartir aún no implementada")
        }
    }
}