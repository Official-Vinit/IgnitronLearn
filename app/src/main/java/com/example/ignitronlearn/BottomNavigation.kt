package com.example.ignitronlearn

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.ignitronlearn.pages.ChatBot
import com.example.ignitronlearn.pages.Home
import com.example.ignitronlearn.pages.Weather


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigation(){

    val navItemList = listOf(
        NavItem("Home", R.drawable.baseline_home_24, R.drawable.outline_home_24),
        NavItem("Weather", R.drawable.baseline_location_on_24, R.drawable.outline_location_on_24),
        NavItem("Bot", R.drawable.baseline_chat_bubble_24, R.drawable.baseline_chat_bubble_outline_24)
    )

    var selectedIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Ignitron Learn")
            })
        },
        bottomBar = {
            NavigationBar {
                navItemList.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = { selectedIndex = index },
                        icon = {
//                            BadgedBox(badge = {
//                                if (index == 2){
//                                    Badge {
//                                        Text(text = "99+")
//                                    }
//                                }
                                if (selectedIndex == index){
                                    Icon(painter = painterResource(id =item.selectedIcon ), contentDescription = item.label)
                                } else {
                                    Icon(painter = painterResource(id =item.unselectedIcon ), contentDescription = item.label)
                                }
                        },
                        label = {
                            Text(text = item.label)
                        }
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            ContentScreen(selectedIndex)
        }
    }
}

@Composable
fun ContentScreen( selectedIndex: Int){
    when(selectedIndex) {
        0 -> Home()
        1 -> Weather()
        2 -> ChatBot()
    }
}