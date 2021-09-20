package com.company;

import com.github.freva.asciitable.AsciiTable;

import java.util.Scanner;

public class Game {

    public static int playerChosenTurn;
    public static String playerTurn;

    public static void showAvailableMoves(String[] turns, int[] availableTurns){
        for (int i = 1; i <= turns.length; i++)
            System.out.println(i + " - " + turns[i - 1]);

        System.out.println("0 - EXIT");
        System.out.println("? - HELP");

        Scanner in = new Scanner(System.in);

        System.out.print("Enter your turn: ");
        playerTurn = in.next();
        if (playerTurn.equals("0")) System.exit(0);
        if (playerTurn.equals("?")){

            String[] headers; // объявление массива
            String[][] body = new String[turns.length][turns.length + 1];
            headers = new String[turns.length + 1];

            headers[0] = "USER->";

            for (int i = 0; i < turns.length; i++) {  //идём по строкам
                for (int j = 0; j < turns.length ; j++) {//идём по столбцам
                    body[i][j + 1] = Winner.checkWinner(i,j,turns.length);
                }
            }
            for (int i = 1; i <= turns.length; i++)
            {
                headers[i] = turns[i - 1];
            }
            for (int i = 0; i < turns.length; i++)
            {
                body[i][0]= turns[i];
            }
            System.out.println(AsciiTable.getTable(headers, body));
        }
        else {
            playerChosenTurn = Integer.parseInt(playerTurn);
        }
    }

    public static int makeGame(String[] turns, int turnOfPC){
        int turnsSize = turns.length;

        int[] availableTurns; // объявление массива
        availableTurns = new int[turnsSize];

        System.out.println("Available moves:");
        for (int i = 0; i < turns.length; i++){
            availableTurns[i] = i + 1;
        }

        showAvailableMoves(turns, availableTurns);
         boolean call = false;

        for (int i = 0; i < turns.length; i++){
            if (playerChosenTurn == availableTurns[i]) {
                call = true;
                break;
            }
        }

        while (!call) {
            showAvailableMoves(turns, availableTurns);
            for (int i = 0; i < turns.length; i++){
                if (playerChosenTurn == availableTurns[i]) {
                    call = true;
                }
            }
        }

     return Winner.getWinner(availableTurns, playerChosenTurn, turnOfPC);
    }
}
