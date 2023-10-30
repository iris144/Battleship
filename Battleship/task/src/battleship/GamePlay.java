package battleship;

import java.util.Scanner;
public class GamePlay {

    public static Scanner scanner = new Scanner(System.in);

    public void gameMessage(Battlefield battlefield) {

        // The game has started. Let's play
        System.out.println();
        System.out.println("The game starts!");
        System.out.println();
        battlefield.displayFogField();
        System.out.println();
    }


    public void player1 (Battlefield battlefield, Battlefield battlefield2) {
        System.out.println();
        battlefield2.displayFogField();
        System.out.println("---------------------");
        battlefield.displayField();
        System.out.println();
        System.out.println("Player 1, it's your turn:");
        System.out.println();
        String playerInput = scanner.nextLine();
        System.out.println();
        Coordinate playerCoordinate = new Coordinate(playerInput);
        if (playerCoordinate.row < 0 || playerCoordinate.column < 0 ||
                playerCoordinate.row > 9 || playerCoordinate.column > 9) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }


        battlefield2.takeShot(playerCoordinate);
        battlefield2.message(playerCoordinate);
        promptEnterKey();
        // battlefield.displayFogField();
        //System.out.println("---------------------");
        //battlefield.displayField();
        //System.out.println();
        //battlefield.displayField();

    }

    public void player2 (Battlefield battlefield2, Battlefield battlefield) {
        System.out.println();
        battlefield.displayFogField(); // Should show your own hits/misses on the battlefield of Player 1
        System.out.println("---------------------");
        battlefield2.displayField(); // Should show the hits/misses from Player 1
        System.out.println();
        System.out.println("Player 2, it's your turn:");
        System.out.println();
        String playerInput = scanner.nextLine();
        System.out.println();
        Coordinate playerCoordinate = new Coordinate(playerInput);
        if (playerCoordinate.row < 0 || playerCoordinate.column < 0 ||
                playerCoordinate.row > 9 || playerCoordinate.column > 9) {
            System.out.println("Error! You entered the wrong coordinates! Try again:");
        }


        battlefield.takeShot(playerCoordinate); // Shoot at Player 1 battlefield
        battlefield.message(playerCoordinate);
        //battlefield2.displayFogField();
        promptEnterKey();
        //System.out.println("---------------------");
        //battlefield2.displayField();
        //System.out.println();
        //battlefield2.displayField();

    }

    public void gamePlay(Battlefield battlefield, Battlefield battlefield2){
        while (!battlefield.endGame()) {
            player1(battlefield, battlefield2);
            player2(battlefield2, battlefield);
        }
    }
    public void promptEnterKey(){
        System.out.println("Press Enter and pass the move to another player");
        System.out.println("...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

}