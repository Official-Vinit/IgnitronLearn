package com.example.ignitronlearn.pages

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ignitronlearn.homepage.DisasterDetails
import com.example.ignitronlearn.homepage.HomeUI

@Composable
fun Home(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = "HomeUI",builder = {
        composable("HomeUI") {
            HomeUI(navController)
        }
        composable(route = "DisasterDetails/{nameResId}/{todo}/{todoImage}/{helpline}/{newsLink}",arguments = listOf(
            navArgument("nameResId") { type = NavType.IntType },
            navArgument("todo") { type = NavType.IntType },
            navArgument("todoImage") { type = NavType.IntType },
            navArgument("helpline") { type = NavType.IntType },
            navArgument("newsLink") { type = NavType.IntType }
        )) {
                backStackEntry ->
            val nameResId = backStackEntry.arguments?.getInt("nameResId")
            val todo = backStackEntry.arguments?.getInt("todo")
            val todoImage = backStackEntry.arguments?.getInt("todoImage")
            val helpline = backStackEntry.arguments?.getInt("helpline")
            val newsLink = backStackEntry.arguments?.getInt("newsLink")
            DisasterDetails(nameResId,todo,todoImage, helpline,newsLink)
        }
    })
}