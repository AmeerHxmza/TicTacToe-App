package com.example.a3tictactoe_app

import android.os.Bundle
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.app.ComponentActivity
import com.example.a3tictactoe_app.ui.theme._3TicTacToe_AppTheme
import com.example.a3tictactoe_app.ui_layer.TicTac


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _3TicTacToe_AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TicTac(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
