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

class GameActivity :

    ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AthenaCrisisTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AthenaCrisisView(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

