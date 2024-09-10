package com.example.ignitronlearn.pages

import androidx.compose.runtime.Composable

import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ChatBot(){
    val chatViewModel: ChatViewModel = viewModel()
    ChatPage(chatViewModel)
}