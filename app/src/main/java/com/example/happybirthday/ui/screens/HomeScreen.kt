package com.example.happybirthday.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier,onAddGeofence:()->Unit={}) {
    var itemSelected by remember { mutableIntStateOf(0) }
    Scaffold(bottomBar = {
        BottomAppBar {
            NavigationBarItem(
                label = {Text("Geofences")},
                selected = itemSelected == 0,
                onClick = {
                    itemSelected = 0
                },
                icon = {
                    Icon(
                        painter = painterResource(R.drawable.baseline_list_24),
                        contentDescription = "List"
                    )
                })
            NavigationBarItem( label = {Text("Station Info")},selected = itemSelected == 1, onClick = { itemSelected = 1 }, icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_list_24),
                    contentDescription = "List"
                )
            })
            NavigationBarItem(label =  {Text("Recent Searches")}, selected = itemSelected == 2, onClick = { itemSelected = 2 }, icon = {
                Icon(
                    painter = painterResource(R.drawable.baseline_list_24),
                    contentDescription = "List"
                )
            })
        }
    }) { padding ->
        when (itemSelected) {
            0 -> GeofenceListScreen(modifier = Modifier.padding(padding), onAddGeofence = {
                onAddGeofence()
            })
            1 -> StationInfoScreen(modifier = Modifier.padding(padding))
            2 -> RecentSearchesScreen(modifier = Modifier.padding(padding))
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}