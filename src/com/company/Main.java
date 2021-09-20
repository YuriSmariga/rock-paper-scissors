package com.company;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        int turnOfPC = 0;
        String [] test_array = {"111" , "222", "333", "444", "555"};
        Verification.checkParameters(args);
        HMAC compMovement = new HMAC(args);
        int sizeOfTurns = args.length;
        String PCTurn = args[compMovement.getCompMove()];

        System.out.println("HMAC: " + compMovement.generateHMAC(args));

        for (int i = 0; i < args.length; i++){
            if (PCTurn.equals(args[i]))
                turnOfPC = i + 1;
        }
        int status = Game.makeGame(args, turnOfPC);

        System.out.println("===================PLAYER'S MOVES===================");
        System.out.println("PC:         " + PCTurn);
        System.out.println("Player:     " + args[Game.playerChosenTurn - 1]);
        System.out.println("HMAC key:   " + compMovement.getKeyHex());

        switch (status){
            case (1):
                System.out.println("=====================PLAYER WIN====================");
                break;

            case (0):
                System.out.println("=======================DRAW========================");
                break;

                case (-1):
                    System.out.println("===================COMPUTER WIN====================");
                    break;
        }


    }


}
