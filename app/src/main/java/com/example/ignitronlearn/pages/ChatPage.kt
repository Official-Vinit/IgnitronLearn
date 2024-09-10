package com.example.ignitronlearn.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ChatPage(chatViewModel: ChatViewModel) {
        Column(
        ) {
            MessageList(messageList = chatViewModel.messageList, modifier = Modifier.weight(1f))
            MessageInput(onMessageSend = {
                chatViewModel.sendMessage(it)
            })
        }
    }
@Composable
fun MessageList(modifier: Modifier = Modifier, messageList: List<MessageModel>){
//    if (messageList.isEmpty()){
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ){
//            Text(text = "Start a conversation")
//        }
//    }else{
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ){
        items(messageList.reversed()){
            MessageCard(messageModel = it)
        }
    }
}

@Composable
fun MessageCard(messageModel: MessageModel) {
    val isModel = messageModel.role == "model"

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .align(if (isModel) Alignment.BottomStart else Alignment.BottomEnd)
                    .padding(
                        start = if (isModel) 16.dp else 80.dp,
                        end = if (isModel) 80.dp else 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    )
            ) {
                Card() {
                    Badge{
                        Text(if (isModel) "Crisis Aid" else "You")

                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    SelectionContainer {
                        Text(
                            text = messageModel.message,
                            modifier = Modifier.padding(8.dp),
                            fontWeight = FontWeight.W500,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MessageInput(onMessageSend: (String)->Unit){

    var message by remember {
        mutableStateOf("")
    }

    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        OutlinedTextField(
            modifier = Modifier.weight(1f),
            value = message,
            onValueChange = {message = it},

            )
        IconButton(onClick = {
            onMessageSend(message)
            message = ""
        }) {
            Icon(imageVector = Icons.AutoMirrored.Filled.Send, contentDescription = "Send Button" )
        }
    }
}