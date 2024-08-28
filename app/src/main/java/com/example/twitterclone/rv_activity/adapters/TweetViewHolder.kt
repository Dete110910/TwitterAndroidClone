package com.example.twitterclone.rv_activity.adapters

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet
import com.example.twitterclone.utils.showToast

class TweetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val view = view

    fun render(tweet: Tweet) {
        view.findViewById<TextView>(R.id.tvUserName).text = tweet.userName
        view.findViewById<TextView>(R.id.tvUser).text = tweet.user
        view.findViewById<TextView>(R.id.tvPostTime).text = tweet.postTime
        view.findViewById<TextView>(R.id.tvTextTweet).text = tweet.text

        view.findViewById<ImageButton>(R.id.ibComment).setOnClickListener {
            view.context.showToast("Funcionalidad de comentarios aún no implementada")
        }

        view.findViewById<ImageButton>(R.id.ibRetweet).setOnClickListener {
            view.context.showToast("Publicación retuiteada")
        }

        view.findViewById<ImageButton>(R.id.ibLike).setOnClickListener {
            view.context.showToast("Al usuario ${tweet.userName} le gustó este post publicado hace ${tweet.postTime}")
        }

        view.findViewById<ImageButton>(R.id.ibStatistics).setOnClickListener {
            view.context.showToast("Funcionalidad de estadísticas aún no implementada")
        }

        view.findViewById<ImageButton>(R.id.ibShare).setOnClickListener {
            view.context.showToast("Funcionalidad de compartir aún no implementada")
        }
    }
}