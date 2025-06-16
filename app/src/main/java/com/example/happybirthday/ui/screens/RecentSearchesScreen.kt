package com.example.happybirthday.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.GreetingText

@Composable
fun RecentSearchesScreen(modifier: Modifier = Modifier) {
    Text(" Recent Searches Screen")


}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RecentSearchesScreenPreview() {
    RecentSearchesScreen()
}