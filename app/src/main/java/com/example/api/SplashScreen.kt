package com.example.api

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navigateToCharacters: () -> Unit) {
    // Show splash screen for a few seconds and navigate to CharactersScreen
    LaunchedEffect(Unit) {
        delay(2000)
        navigateToCharacters()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "API APP")
    }
}