package com.example.happybirthday.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GeofenceListScreen(
    modifier: Modifier = Modifier,
    onAddGeofence: () -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onAddGeofence() },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(Icons.Default.Search, contentDescription = "Search")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // TextField for entering geofence name or details
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Enter Geofence Info") },
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(16.dp))

            // Show what the user entered
            Text(text = "You entered: $text")
            TextField(
                value = text,
                onValueChange = {
                    text = it
                },
                label = { Text("Enter Geofence Info") },
                modifier = Modifier.fillMaxWidth()
            )


            Spacer(modifier = Modifier.height(16.dp))

            // Show what the user entered
            Text(text = "You entered: $text")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun GeofenceListScreenPreview() {
    GeofenceListScreen()
}