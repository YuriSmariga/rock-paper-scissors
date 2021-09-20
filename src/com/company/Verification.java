package com.company;

public class Verification {

    public static void checkParameters(String[] turns){
        if (turns.length  == 0) {
            System.out.println("====================ERROR==================== ");
            System.out.println("There are no any parameters");
            System.out.println("================RULES OF INPUT=============== ");
            System.out.println("Quantity: >=3 | odd | not duplicate parameters ");
            System.out.println("Example of correct input: 1 2 3 4 5 ");
            System.exit(0);
        } else if (turns.length % 2 == 0) {
            System.out.println("====================ERROR==================== ");
            System.out.println("The number of parameters must be odd");
            System.out.println("================RULES OF INPUT=============== ");
            System.out.println("Quantity: >=3 | odd | not duplicate parameters ");
            System.out.println("Example of correct input: 1 2 3 4 5 ");
            System.exit(0);
        }
        if (turns.length < 3) {
            System.out.println("====================ERROR==================== ");
            System.out.println("The number of parameters must be greater than or equal to 3");
            System.out.println("================RULES OF INPUT=============== ");
            System.out.println("Quantity: >=3 | odd | not duplicate parameters ");
            System.out.println("Example of correct input: 1 2 3 4 5 ");
            System.exit(0);
        }

        for (int i = 0; i < turns.length; i++){
            for (int j = i + 1; j < turns.length; j++)
            {
                if (turns[i].equals(turns[j])) {
                    System.out.println("====================ERROR==================== ");
                    System.out.println("There should be no duplicate parameters");
                    System.out.println("================RULES OF INPUT=============== ");
                    System.out.println("Quantity: >=3 | odd | not duplicate parameters ");
                    System.out.println("Example of correct input: 1 2 3 4 5 ");
                    System.exit(0);
                }
            }
        }
    }
}
