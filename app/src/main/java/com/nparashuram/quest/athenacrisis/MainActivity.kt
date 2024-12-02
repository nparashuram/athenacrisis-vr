package com.nparashuram.quest.athenacrisis

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import com.nparashuram.quest.athenacrisis.ui.theme.AthenaCrisisTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val activity = this
        setContent {
            AthenaCrisisTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Button(onClick = {
                            val immersiveIntent =
                                Intent(activity, ImmersiveActivity::class.java).apply {
                                    action = Intent.ACTION_MAIN
                                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                }
                            startActivity(immersiveIntent)
                        }) {
                            Text(text = "Go Immersive")
                        }
                        AthenaCrisisView(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

