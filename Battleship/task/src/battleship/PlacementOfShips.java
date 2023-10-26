package battleship;

import java.util.Scanner;

public class PlacementOfShips {

    public static Scanner scanner = new Scanner(System.in);
    // Remember to put isTesting back to false when checking
    final static boolean isTesting = true;
    final static String[] testInput = new String[] {
            "F3 F7",
            "A1 D1",
            "A8 A10",
            "H1 J1",
            "J9 J10"
    };


    public void placeShips(Battlefield battlefield) {

        ShipType[] shipArray = new ShipType[]{
                ShipType.AIRCRAFT_CARRIER,
                ShipType.BATTLESHIP,
                ShipType.SUBMARINE,
                ShipType.CRUISER,
                ShipType.DESTROYER
        };
        // asking where to place coordinates
        for (int i = 0; i < shipArray.length; i++) {
            ShipType currentShip = shipArray[i];
            System.out.println();
            System.out.printf("Enter the coordinates of the %s (%d cells) :", currentShip.getName(), currentShip.getLength());
            System.out.println();

            // Just to make testing for yourself easier
            String userInput;
            if (isTesting) {
                userInput = testInput[i];
            } else {
                userInput = scanner.nextLine();
            }
            System.out.println();


            // get the coordinates that user puts in and split that into 2 and put it in your string [].
            String[] userCoordinates = userInput.split(" ");

            //refer to your coordinate class to get your coordinates
            Coordinate firstCoordinate = new Coordinate(userCoordinates[0]);
            Coordinate lastCoordinate = new Coordinate(userCoordinates[1]);

            // find out if the length of your ships is the same as your coordinates.
            Coordinate startCoordinate = firstCoordinate.row <= lastCoordinate.row && firstCoordinate.column <= lastCoordinate.column ? firstCoordinate : lastCoordinate;
            Coordinate endCoordinate = firstCoordinate.row >= lastCoordinate.row && firstCoordinate.column >= lastCoordinate.column ? firstCoordinate : lastCoordinate;

            int lengthInput = 0;
            if (endCoordinate.row == startCoordinate.row) {
                lengthInput = (endCoordinate.column - (startCoordinate.column - 1));
            } else if (endCoordinate.column == startCoordinate.column) {
                lengthInput = (endCoordinate.row - (startCoordinate.row - 1));
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
            } else if (currentShip.getLength() != lengthInput) {
                i--;
                System.out.printf("Error! Wrong length of the %s! Try again:", currentShip.getName());
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
    }
}
