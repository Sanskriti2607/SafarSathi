package com.example.happybirthday.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StationInfoScreen(modifier: Modifier = Modifier) {
    Text(" Station Info Searches")

}
data class StationData(
    val name: String,
    val code: String,
    val platforms: Int,
    val facilities: List<String>,
    val arrivalExample: String,
    val departureExample: String
)

fun getDummyStationInfo(code: String): StationData {
    return StationData(
        name = "New Delhi",
        code = "NDLS",
        platforms = 16,
        facilities = listOf("Wi-Fi", "Waiting Room", "Cloak Room", "Food Court"),
        arrivalExample = "Rajdhani Express - 06:20 AM",
        departureExample = "Shatabdi Express - 06:55 AM"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StationInfoScreen(
    savedStations: List<String>,
    onSave: (List<String>) -> Unit,
    onViewSaved: () -> Unit
) {
    var stationCode by rememberSaveable { mutableStateOf("") }
    var stationInfo by remember { mutableStateOf<StationData?>(null) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Station Info") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = stationCode,
                onValueChange = { stationCode = it.uppercase() },
                label = { Text("Enter Station Code (e.g., NDLS)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (stationCode.isNotBlank()) {
                        stationInfo = getDummyStationInfo(stationCode)
                    }
                },
                enabled = stationCode.isNotBlank()
            ) {
                Text("🔍 Search")
            }

            stationInfo?.let { info ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Station: ${info.name} (${info.code})", fontWeight = FontWeight.Bold)
                        Text("Platforms: ${info.platforms}")
                        Text("Next Arrival: ${info.arrivalExample}")
                        Text("Next Departure: ${info.departureExample}")
                    }
                }

                Spacer(Modifier.height(12.dp))

                Button(
                    onClick = {
                        if (!savedStations.contains(info.code)) {
                            onSave(savedStations + info.code)
                        }
                    }
                ) {
                    Text("❤️ Save Station")
                }
            }

            Spacer(Modifier.height(12.dp))

            Button(onClick = onViewSaved) {
                Text("📂 View Saved Stations")
            }
        }
    }
}

@Preview
@Composable
private fun StationInfoScreenPreview() {
    StationInfoScreen()
}