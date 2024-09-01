package com.example.twitterclone.rv_activity.viewModel

import com.example.twitterclone.data.Tweet

data class ActivityFollowingUIState (
    val tweets: List<Tweet> = emptyList()
)