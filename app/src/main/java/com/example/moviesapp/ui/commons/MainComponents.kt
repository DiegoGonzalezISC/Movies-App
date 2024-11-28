package com.example.moviesapp.ui.commons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoviesTopAppBar() {
    TopAppBar(title = {
        Text(text = "Movies App")
    })
}

@Composable
fun MoviesBottomBar() {
    NavigationBar {
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorites")
        })
        NavigationBarItem(selected = false, onClick = { /*TODO*/ }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Account")
        })
    }
}