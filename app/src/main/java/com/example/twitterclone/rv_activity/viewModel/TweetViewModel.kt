package com.example.twitterclone.rv_activity.viewModel

import androidx.lifecycle.ViewModel
import com.example.twitterclone.R
import com.example.twitterclone.data.Tweet
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TweetViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ActivityFollowingUIState())
    val uiState:  StateFlow<ActivityFollowingUIState> = _uiState.asStateFlow()

    fun addTweet(tweet: Tweet){
        val tweets = _uiState.value.tweets.toMutableList()
        tweets.add(tweet)
        _uiState.value = _uiState.value.copy(tweets = tweets)
    }

    fun getTweets() : List<Tweet>{
        return _uiState.value.tweets
    }

    fun deleteRandomTweet(){
        val tweets = _uiState.value.tweets.toMutableList()
        if(tweets.isNotEmpty()){
          tweets.removeAt((tweets.indices).random())
            _uiState.value = _uiState.value.copy(tweets = tweets)
        }
    }

    fun modifyRandomTweet(){
        val tweets = _uiState.value.tweets.toMutableList()
        if(tweets.isNotEmpty()){
            val indexTweetToModify = tweets.indices.random()

            val newUser = "@ModifiedUser"
            val newUserName = "ModifiedUserName"
            val newPosTime = "126h"
            val newText = "This tweet was modified"
            val newTweet = Tweet(newUser, newUserName, newPosTime, newText, R.drawable.img_new_user)

            tweets[indexTweetToModify] = newTweet

            _uiState.value = _uiState.value.copy(tweets = tweets)
        }
    }
}