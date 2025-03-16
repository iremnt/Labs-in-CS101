/**
 * G: Green 
 * P: Purple 
 * Y: Yellow 
 * B: Black 
 * R: Red 
 * C: Change color 
 * deck consists of 44 cards, each player starts with 7, 
 * one card placed openly -> "top card"
 * rule_1 is use same color or same number or change color card
 * rule_2 is use the first card that can be used for top card.
 * !!! We use strings in this lab bc it is strictky avoided to use other data structures or variable types
 * -VARIBLES-
 * deckNumbers and deckColors are for unshuffled deck numbers and colors, colors are for creating deck colors.
 * shuffledNumbers and shuffledColors are for demonstrating the shuffled deck at first and showing not used cards
 * shuffledDeck is just for shuffle the deck at first it is used in order not to use one card twice while shuffling
 * player1Num and player1Color is for player 1's cards at that time same for player 2
 * topCard is the card placed openly or the card recently played. if the last card is change color then topCard would
 be the color first letter and 'C' for change color
 * randomNumber is for shuffling deck, turn is for hold whose turn
 * scores are for if the endgame nobodys' deck but shuffled deck run out of cards then game would determine who won from
 looking at sum of the cards numbers of each players has
 * */

import java.util.Random;

// Lab 05, Q1, Drawing A Bar Chart, Gülser İrem AÇIKGÖZ, 20.03.2025 

public class Lab5_Q2 {
    public static void main(String[] args) {
        String deckNumbers = "", deckColors = "", color = "RGPY";
        String shuffledNumbers = "", shuffledColors = "";
        String shuffledDeck = ",";
        String player1Num, player1Color, player2Num, player2Color, topCard;
        int randomNumber, turn = 1, score1 = 0, score2 = 0;

        System.out.println("Starting the game!");
        //creating deck numbers and colors
        for (int i = 0; i < 4; i++){//i for color
            for (int j = 0; j < 10; j++){//j for numbers
                deckNumbers += j + "";
                deckColors += color.charAt(i);
            }
        }
        deckNumbers += "CCCC";
        deckColors += "BBBB";
        System.out.println("\nThe initial deck:");
        System.out.printf("%-8s%s %s\n%-8s%s %s\n","numbers ", ":", deckNumbers, "colors ", ":", deckColors);
        
        //shuffle deck
        for (int i = 0; i < 44; i++){
            Random rand = new Random();
            randomNumber = rand.nextInt(44);
            while (shuffledDeck.contains("," + randomNumber + ",")){
                randomNumber = rand.nextInt(44);
            }//select a random number until its not in the deck
            shuffledNumbers += deckNumbers.charAt(randomNumber);
            shuffledColors += deckColors.charAt(randomNumber);
            shuffledDeck += randomNumber + ",";
        }

        System.out.println("\nShuffled deck:");
        System.out.printf("%-8s%s %s\n%-8s%s %s\n","numbers ", ":", shuffledNumbers, "colors ", ":", shuffledColors);

        //giving cards and renew deck after distrubute them 
        player1Num = shuffledNumbers.substring(0,7);
        player1Color = shuffledColors.substring(0,7);
        player2Num = shuffledNumbers.substring(7,14);
        player2Color = shuffledColors.substring(7,14);
        shuffledColors = shuffledColors.substring(14);
        shuffledNumbers = shuffledNumbers.substring(14);

        System.out.println("\nDealing the initial cards: ");
        System.out.printf("%-16s%s %s\n%-16s%s %s\n%-16s%s %s\n%-16s%s %s\n", 
        "Player1 numbers", ":", player1Num, 
        "Player1 colors", ":", player1Color, 
        "Player2 numbers", ":", player2Num, 
        "Player2 Colors", ":", player2Color);
        System.out.println("Deck after dealing player cards:");
        System.out.printf("%-8s%s %s\n%-8s%s %s\n","numbers ", ":", shuffledNumbers, "colors ", ":", shuffledColors);

        //if top card is change color card then 
        while(shuffledColors.charAt(0) == 'B'){
            shuffledColors = shuffledColors.substring(1) + shuffledColors.charAt(0);
            shuffledNumbers = shuffledNumbers.substring(1) + shuffledNumbers.charAt(0);
        }
        topCard = shuffledColors.charAt(0) + "" + shuffledNumbers.charAt(0);
        shuffledColors = shuffledColors.substring(1);
        shuffledNumbers = shuffledNumbers.substring(1); 

        System.out.println("Top card: " + topCard + "\n" );

        while (!((player1Color.length() == 0) || (player2Color.length() == 0) || (shuffledColors.length() == 0))){//till game ends
            if (turn == 1){
                System.out.println("Player1's turn");
                int i = 0;
                while(turn == 1 && i < player1Color.length()){
                    if (player1Color.charAt(i) == topCard.charAt(0) ||
                    player1Num.charAt(i) == topCard.charAt(1)){
                        topCard = player1Color.charAt(i) + "" + player1Num.charAt(i);
                        player1Color = player1Color.substring(0, i) + player1Color.substring(i + 1);
                        player1Num = player1Num.substring(0, i) + player1Num.substring(i + 1);
                        turn = 2;
                    }
                    else if (player1Color.charAt(i) == 'B'){
                        int j = 0;
                        while(j < player1Color.length() && player1Color.charAt(j) != 'B'){
                            j++;
                        }
                        player1Color = player1Color.substring(0, i) + player1Color.substring(i + 1);
                        player1Num = player1Num.substring(0, i) + player1Num.substring(i + 1);
                        topCard = player1Color.charAt(j) + "C";
                        turn = 2;
                    }
                    i++;
                }
                if (turn == 1){
                    if (shuffledColors.charAt(0) == topCard.charAt(0) ||
                    shuffledNumbers.charAt(0) == topCard.charAt(1)){
                        topCard = shuffledColors.charAt(0) + "" + shuffledNumbers.charAt(0);
                    }
                    else if (shuffledColors.charAt(0) == 'B'){
                        int j = 0;
                        while(j < player1Color.length() && player1Color.charAt(j) != 'B'){
                            j++;
                        }
                        topCard = player1Color.charAt(0) + "C";
                    }
                    else {
                        System.out.println("Current player has no card to play, drawing one from the deck.");
                        player1Color += shuffledColors.charAt(0);
                        player1Num += shuffledNumbers.charAt(0);
                    }
                    shuffledColors = shuffledColors.substring(1);
                    shuffledNumbers = shuffledNumbers.substring(1);
                    turn = 2;
                }
                System.out.printf("%-16s%s %s\n%-16s%s %s\n%-16s%s %s\n%-16s%s %s\n", 
                "Player1 numbers", ":", player1Num, 
                "Player1 colors", ":", player1Color, 
                "Player2 numbers", ":", player2Num, 
                "Player2 Colors", ":", player2Color);
                System.out.println("Deck after this round:");
                System.out.printf("%-8s%s %s\n%-8s%s %s\n","numbers ", ":", shuffledNumbers, "colors ", ":", shuffledColors);
                System.out.println("Top card: " + topCard + "\n");
            }
            else if ((turn == 2) && !(player1Color.length() == 0 || player2Color.length() == 0 || shuffledColors.length() == 0)){
                System.out.println("Player2's turn");
                int i = 0;
                while(turn == 2 && i < player2Color.length()){
                    if (player2Color.charAt(i) == topCard.charAt(0) ||
                    player2Num.charAt(i) == topCard.charAt(1)){
                        topCard = player2Color.charAt(i) + "" + player2Num.charAt(i);
                        player2Color = player2Color.substring(0, i) + player2Color.substring(i + 1);
                        player2Num = player2Num.substring(0, i) + player2Num.substring(i + 1);
                        turn = 1;
                    }
                    else if (player2Color.charAt(i) == 'B'){
                        int j = 0;
                        while(j < player2Color.length() && player2Color.charAt(j) != 'B'){
                            j++;
                        }
                        player2Color = player2Color.substring(0, i) + player2Color.substring(i + 1);
                        player2Num = player2Num.substring(0, i) + player2Num.substring(i + 1);
                        topCard = player2Color.charAt(j) + "C";
                        turn = 1;
                    }
                    i++;
                }
                if (turn == 2){
                    if (shuffledColors.charAt(0) == topCard.charAt(0) ||
                    shuffledNumbers.charAt(0) == topCard.charAt(1)){
                        topCard = shuffledColors.charAt(0) + "" + shuffledNumbers.charAt(0);
                    }
                    else if (shuffledColors.charAt(0) == 'B'){
                        int j = 0;
                        while(j < player1Color.length() && player1Color.charAt(j) != 'B'){
                            j++;
                        }
                        topCard = player1Color.charAt(0) + "C";
                    }
                    else {
                        System.out.println("Current player has no card to play, drawing one from the deck.");
                        player2Color += shuffledColors.charAt(0);
                        player2Num += shuffledNumbers.charAt(0);
                    }
                    shuffledColors = shuffledColors.substring(1);
                    shuffledNumbers = shuffledNumbers.substring(1);
                    turn = 1;
                }
                System.out.printf("%-16s%s %s\n%-16s%s %s\n%-16s%s %s\n%-16s%s %s\n", 
                "Player1 numbers", ":", player1Num, 
                "Player1 colors", ":", player1Color, 
                "Player2 numbers", ":", player2Num, 
                "Player2 Colors", ":", player2Color);
                System.out.println("Deck after this round:");
                System.out.printf("%-8s%s %s\n%-8s%s %s\n","numbers ", ":", shuffledNumbers, "colors ", ":", shuffledColors);
                System.out.println("Top card: " + topCard + "\n");
            }
            if (player1Color.length() == 0)
                System.out.println("player 1 won!");
            else if (player2Color.length() == 0)
                System.out.println("player 2 won!");
            else if (shuffledColors.length() == 0){
                player1Num = player1Num.replaceAll("C", "");
                player2Num = player2Num.replaceAll("C", "");
                for (int i = 0; i < player1Num.length(); i++){
                    score1 += (int) player1Num.charAt(i);
                }
                for (int i = 0; i < player2Num.length(); i++){
                    score2 += (int) player2Num.charAt(i);
                }
                if (score1 > score2)
                    System.out.println("player 1 won!");
                else if (score2 > score1)
                    System.out.println("player 2 won!");
            }
        }
    }
}
