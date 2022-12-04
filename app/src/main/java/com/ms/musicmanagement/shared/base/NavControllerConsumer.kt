package com.ms.musicmanagement.shared.base

import androidx.navigation.NavController

interface NavControllerConsumer {
    fun updateNavController(navController: NavController)
}