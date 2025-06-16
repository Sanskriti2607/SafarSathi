package com.example.happybirthday.ui.screens

import android.os.CountDownTimer
import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.happybirthday.GreetingText

@Composable
fun SplashScreen(modifier: Modifier = Modifier,onSplashDone:()->Unit={}) {
    GreetingText("Rail Buddy","emma",modifier)
    object :CountDownTimer(2500L,1000L){
        override fun onTick(millisUntilFinished: Long) {

        }

        override fun onFinish() {
           onSplashDone()
        }

    }.start()
}

@Preview
@Composable
private fun SplashScreenPreview() {
    SplashScreen()
}