package com.example.twitterclone.rv_activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet
import com.example.twitterclone.databinding.ActivityRecyclerViewBinding
import com.example.twitterclone.rv_activity.adapters.AdapterTweet
import com.example.twitterclone.rv_activity.viewModel.TweetViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RecyclerViewActivity : AppCompatActivity() {


    private lateinit var binding: ActivityRecyclerViewBinding
    private val tweetViewModel: TweetViewModel by viewModels()

    private lateinit var adapterTweet: AdapterTweet

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        setListeners()
        observeViewModel()
    }

    private fun observeViewModel() {
        tweetViewModel.uiState.onEach { state ->
            adapterTweet.submitList(state.tweets)
        }.launchIn(lifecycleScope)
    }

    private fun setListeners() {
        with(binding) {
            btnGetPosts.setOnClickListener {
                if (tweetViewModel.uiState.value.tweets.isEmpty()) fillTweetList()
                else { tweetViewModel.getTweets() }
            }

            btnDeletePosts.setOnClickListener {
                tweetViewModel.deleteRandomTweet()
            }

            btnModifyPosts.setOnClickListener {
                tweetViewModel.modifyRandomTweet()
            }
        }
    }

    private fun initViews() {
        val rvTweets = binding.rvTweets
        adapterTweet = AdapterTweet(tweetViewModel.uiState.value.tweets)
        rvTweets.apply {
            layoutManager =
                LinearLayoutManager(this@RecyclerViewActivity, LinearLayoutManager.VERTICAL, false)
            adapter = adapterTweet
        }
    }

    private fun fillTweetList() {
        for (i in 0 until 5) {
            tweetViewModel
                .addTweet(Tweet("@calleblr", "Val", "${i}h", "Mi primer tweet número: $i"))
        }
    }
}