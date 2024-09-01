package com.example.twitterclone.rv_activity.adapters

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet
import com.example.twitterclone.databinding.TweetBinding
import com.example.twitterclone.utils.showToast

class TweetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val view = view
    val binding = TweetBinding.bind(view)

    fun render(tweet: Tweet) {
        binding.tvUserName.text = tweet.userName
        binding.tvUser.text = tweet.user
        binding.tvPostTime.text = tweet.postTime
        binding.tvTextTweet.text = tweet.text
        binding.ivProfilePicture.setImageResource(tweet.photo)

        binding.ibComment.setOnClickListener {
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