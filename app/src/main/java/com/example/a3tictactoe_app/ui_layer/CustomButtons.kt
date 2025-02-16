package com.example.a3tictactoe_app.ui_layer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a3tictactoe_app.checkWinner

@Composable
fun CustomButtons(){

    val board = remember {
        mutableStateOf(Array(3){ arrayOfNulls<String>(3) })
    }

    val currentPlayer= remember {
        mutableStateOf("X")
    }

    val winner = remember {
        mutableStateOf<String?>(null)
    }

    Box(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()){
        Column(modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            for(row in 0 ..2){
                Row (modifier = Modifier.padding(8.dp)){
                    for(col in 0 .. 2){
                        FloatingActionButton(
                            modifier = Modifier.size(90.dp),
                            shape = CircleShape,
                            contentColor = Color.Blue,
                            containerColor = MaterialTheme.colorScheme.surfaceContainer,

                            onClick = {
                                if(board.value[row][col] == null && winner.value == null){
                                    board.value[row][col]=currentPlayer.value
                                    currentPlayer.value=if (currentPlayer.value=="X")"0" else "X"
                                    winner.value= checkWinner(board.value)
                                }
                            },
                        ) {
                            Text(
                                text = board.value[row][col] ?: "",
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.Blue
                            )
                        }
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Text(
                    text = "Current Player is : ",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = currentPlayer.value,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Winner is ${if(winner.value==null)"Unknown" else winner.value}",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Blue
            )
        }
    }
}

