package com.example.a3tictactoe_app

fun checkWinner(board:Array<Array<String?>>): String ? {

    for (row in 0..2) {
        if (board[row][0] != null && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return board[row][0]
        }
    }
    for (col in 0 .. 2){
        if (board[0][col] != null && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return board[0][col]
        }
    }

    if (board[0][0]!=null && board[0][0]==board[1][1] && board[1][1]==board[2][2]){
        return board[0][0]
    }

    if(board[0][2]!=null && board[0][2] == board[1][1] && board[1][1]==board[2][0]){

    }
    return null
}