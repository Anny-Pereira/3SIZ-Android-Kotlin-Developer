package com.example.dragonballapp.presentation.navigation

object AppRoutes {
    const val DRAGONBALL_LIST = "dragonball_list"
    const val DRAGONBALL_SEARCH = "dragonball_search"
    const val DRAGONBALL_DETAIL = "dragonball_detail/{dragonballNumber}"

    fun dragonBallDetail(dragonBallNumber: Int): String {
        return "dragonball_detail/$dragonBallNumber"
    }
}