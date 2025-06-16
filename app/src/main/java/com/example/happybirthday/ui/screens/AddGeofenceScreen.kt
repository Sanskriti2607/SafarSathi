@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.happybirthday.ui.screens

import com.example.happybirthday.model.GeofenceData
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.RadioButton
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun AddGeofenceScreen(
    onSave: (GeofenceData) -> Unit = {}
) {
    var stationName by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var radius by remember { mutableStateOf("") }
    var geofenceName by remember { mutableStateOf("") }
    var selectedAlertType by remember { mutableStateOf("Alarm") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Geofence") }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = stationName,
                onValueChange = { stationName = it },
                label = { Text("Station Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Latitude") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Longitude") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = radius,
                onValueChange = { radius = it },
                label = { Text("Radius (meters)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = geofenceName,
                onValueChange = { geofenceName = it },
                label = { Text("Geofence Name") },
                modifier = Modifier.fillMaxWidth()
            )

            Text("Select Alert Type", style = MaterialTheme.typography.bodyLarge)

            Row(verticalAlignment = Alignment.CenterVertically) {
                listOf("Alarm", "Vibrate", "Notification").forEach { type ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        RadioButton(
                            selected = selectedAlertType == type,
                            onClick = { selectedAlertType = type }
                        )
                        Text(text = type)
                    }
                }
            }

            Button(
                onClick = {
                    if (
                        stationName.isNotBlank() &&
                        latitude.isNotBlank() &&
                        longitude.isNotBlank() &&
                        radius.isNotBlank() &&
                        geofenceName.isNotBlank()
                    ) {
                        val data = GeofenceData(
                            stationName = stationName,
                            latitude = latitude.toDoubleOrNull() ?: 0.0,
                            longitude = longitude.toDoubleOrNull() ?: 0.0,
                            radius = radius.toFloatOrNull() ?: 100f,
                            geofenceName = geofenceName,
                            alertType = selectedAlertType
                        )
                        onSave(data)
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Geofence")
            }
        }
    }
}



@Preview
@Composable
private fun AddGeofenceScreenPreview() {
    AddGeofenceScreen()
}