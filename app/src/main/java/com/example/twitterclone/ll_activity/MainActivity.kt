package com.example.twitterclone.ll_activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet
import com.example.twitterclone.rv_activity.RecyclerViewActivity
import com.example.twitterclone.utils.showToast

class MainActivity : AppCompatActivity() {

    private lateinit var llPosts: LinearLayout
    private val postList = arrayListOf<Tweet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        initViews()
        fillPostsList()
        showPosts()
    }

    private fun showPosts() {
        postList.forEach{
            tweet ->

            val postView = layoutInflater.inflate(R.layout.tweet, null)

            val tvUserName = postView.findViewById<TextView>(R.id.tvUserName)
            tvUserName.text = tweet.userName

            val tvName = postView.findViewById<TextView>(R.id.tvUser)
            tvName.text = tweet.user

            val tvPostTime = postView.findViewById<TextView>(R.id.tvPostTime)
            tvPostTime.text = tweet.postTime

            val tvText = postView.findViewById<TextView>(R.id.tvTextTweet)
            tvText.text = tweet.text

            setListeners(postView, tweet)

            llPosts.addView(postView)
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

    private fun fillPostsList() {
        for (i in 0 until 20) {
            postList.add(Tweet("@calleblr", "Val", "${i}h", "Mi primer tweet número: $i"))
        }
    }

    private fun initViews() {
        llPosts = findViewById(R.id.llPosts)
        findViewById<Button>(R.id.btnFollowing).setOnClickListener{
            startActivity(Intent(this, RecyclerViewActivity::class.java))
        }
    }
}