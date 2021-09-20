package com.company;

public class Winner {

    public static String checkWinner(int x, int y, int movesCount){
        int c = movesCount / 2;
        if (x == y) return "draw";
        if ((x <= c && y > x && y <= x + c) || (x > c && (y > x || y < x -c )))
            return "lose";
            else return  "win";
    }

    public static int getWinner(int[] turns, int checkedPlayerTurn, int turnOfPC) {
        int status = 2;
        int sizeOfConditions = turns.length;
        int delta = (sizeOfConditions - 1) / 2;
        int[] winCondition; // объявление массива
        winCondition = new int[delta];

        for (int i = 0; i < delta; i++) {
            if (checkedPlayerTurn + i + 1 > sizeOfConditions)
                winCondition[i] = checkedPlayerTurn + i + 1 - sizeOfConditions;
            else winCondition[i] = checkedPlayerTurn + i + 1;
        }

        boolean playerWin = false;

        for (int i = 0; i < winCondition.length; i++) {
            if ((turnOfPC == winCondition[i]) && turnOfPC != checkedPlayerTurn) {
                playerWin = true;
                status = 1;
                break;
            }
        }
        if (turnOfPC == checkedPlayerTurn) {
            status = 0;
        }
        else  if (!playerWin){
            status = -1;
        }

        return status;
    }
}
