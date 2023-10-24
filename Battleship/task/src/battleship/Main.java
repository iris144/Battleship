package battleship;

import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // this is your object. First you refer to your class, name and then constructor inside class.
        Battlefield battlefield = new Battlefield();
        battlefield.displayField();

        // your list of ships that are available to use.
        Battleship[] ships = new Battleship[]{
                new Battleship(ShipType.AIRCRAFT_CARRIER),
                new Battleship(ShipType.BATTLESHIP),
                new Battleship(ShipType.SUBMARINE),
                new Battleship(ShipType.CRUISER),
                new Battleship(ShipType.DESTROYER)
        };

        // asking where to place coordinates
        for (int i = 0; i < ships.length; i++) {
            Battleship currentShip = ships[i];
            System.out.println();
            System.out.printf("Enter the coordinates of the %s (%d cells) :", currentShip.name, currentShip.length);
            System.out.println();
            String userInput = scanner.nextLine();
            System.out.println();
            // get the coordinates that user puts in and split that into 2 and put it in your string [].
            String[] userCoordinates = userInput.split(" ");

            //refer to your coordinate class to get your coordinates
            Coordinate firstCoordinate = new Coordinate(userCoordinates[0]);
            Coordinate lastCoordinate = new Coordinate(userCoordinates[1]);

            var startCoordinate = firstCoordinate.row <= lastCoordinate.row && firstCoordinate.column <= lastCoordinate.column ? firstCoordinate : lastCoordinate;
            var endCoordinate = firstCoordinate.row >= lastCoordinate.row && firstCoordinate.column >= lastCoordinate.column ? firstCoordinate : lastCoordinate;

            // find out if the length of your ships is the same as your coordinates.
            int lengthInput = 0;
            int biggestRow = Math.max(startCoordinate.row, endCoordinate.row);
            int biggestColumn = Math.max(startCoordinate.column, endCoordinate.column);
            int smallestRow = Math.min(startCoordinate.row, endCoordinate.row);
            int smallestColumn = Math.min(startCoordinate.column, endCoordinate.column);

            if (biggestRow == smallestRow) {
                lengthInput = (biggestColumn - (smallestColumn - 1));
            } else if (biggestColumn == smallestColumn) {
                lengthInput = (biggestRow - (smallestRow - 1));
            }
            // find out if your coordinates are places diagonal or not (so row/row has to be the same or
            // column/column has te be the same
            if (startCoordinate.row != endCoordinate.row && startCoordinate.column != endCoordinate.column) {
                i--;
                System.out.println("Error! Wrong ship location! Try again");
                continue;
            } else if (startCoordinate.row < 0 || endCoordinate.row < 0 || startCoordinate.column < 0 ||
                    endCoordinate.column < 0 || startCoordinate.row > 9 || endCoordinate.row > 9 ||
                    startCoordinate.column > 9 || endCoordinate.column > 9) {
                i--;
                System.out.println("Error! Wrong ship location! Try again");
                continue;
            } else if (currentShip.length != lengthInput) {
                i--;
                System.out.printf("Error! Wrong length of the %s! Try again:", currentShip.name);
                continue;
                // write down if it's too close to another.
            } else if (battlefield.touchShip(startCoordinate, endCoordinate)) {
                i--;
                System.out.println("Error! You placed it too close to another one. Try again:");
                continue;
            }
            battlefield.placeShip(startCoordinate, endCoordinate);
            battlefield.displayField();
        }


        // The game has started. Let's play
        System.out.println();
        System.out.println("The game starts!");
        System.out.println();
        Fogfield fogfield = new Fogfield();
        Fogfield.fogfield();


        for (int j = 0; j <= 1; j++) {
            System.out.println();
            System.out.println("Take a shot!");
            System.out.println();
            String playerInput = scanner.nextLine();
            System.out.println();
            Coordinate playerCoordinate = new Coordinate(playerInput);
            if (playerCoordinate.row < 0 || playerCoordinate.column < 0 ||
                    playerCoordinate.row > 9 || playerCoordinate.column > 9) {
                j--;
                System.out.println("Error! You entered the wrong coordinates! Try again:");
                continue;
            }

            fogfield.takeShot(battlefield, playerCoordinate);
            Fogfield.fogfield();
            battlefield.takeShot(playerCoordinate);
            battlefield.displayField();
        }





    }
}


