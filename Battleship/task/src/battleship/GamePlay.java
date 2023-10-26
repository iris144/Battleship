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



    public void gamePlay(Battlefield battlefield){
        while (true) {
            System.out.println();
            System.out.println("Take a shot!");
            System.out.println();
            String playerInput = scanner.nextLine();
            System.out.println();
            Coordinate playerCoordinate = new Coordinate(playerInput);
            if (playerCoordinate.row < 0 || playerCoordinate.column < 0 ||
                    playerCoordinate.row > 9 || playerCoordinate.column > 9) {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }


            battlefield.takeShot(playerCoordinate);
            battlefield.displayFogField();
            System.out.println();
            battlefield.message(playerCoordinate);
            System.out.println();
            battlefield.displayField();
        }
    }


}