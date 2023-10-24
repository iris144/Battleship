package battleship;

import java.util.Objects;

public class Battlefield {

    // this is your property.
   final String[][] field;

    // this is my constructor. You define your play field here.
    public Battlefield() {
        this.field = new String[10][10];

        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field.length; column++) {
                field[row][column] = "~";
            }
        }
    }

    // let's print out the play field here.

    public void displayField() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        String rowLabels = "ABCDEFGHIJ";
        for (int row = 0; row < field.length; row++) {
            System.out.print(rowLabels.charAt(row) + " ");
            for (int column = 0; column < field.length; column++) {
                System.out.print(field[row][column] + " ");
            }
            System.out.println();
        }
    }

    public void placeShip(Coordinate startCoordinate, Coordinate endCoordinate) {


        for (int row = startCoordinate.row; row <= endCoordinate.row; row++) {
            for (int column = startCoordinate.column; column <= endCoordinate.column; column++) {
                field[row][column] = "O";
            }
        }

    }


    public boolean touchShip(Coordinate startCoordinate, Coordinate endCoordinate) {
        for (int row = startCoordinate.row; row <= endCoordinate.row; row++) {
            int nextRow = Math.min(row + 1, 9);
            int previousRow = Math.max(row - 1, 0);
            for (int column = startCoordinate.column; column <= endCoordinate.column; column++) {
                int nextColumn = Math.min(column + 1, 9);
                int previousColumn = Math.max(column - 1, 0);
                boolean shipBelow = field[nextRow][column] == "O";
                boolean shipAbove = field[previousRow][column] == "O";
                boolean shipBefore = field[row][previousColumn] == "O";
                boolean shipAfter = field[row][nextColumn] == "O";
                if (shipBelow || shipAbove || shipBefore || shipAfter) {
                    return true;
                }

            }
        }
        return false;
    }



    public void takeShot(Coordinate playerCoordinate) {

        for (int row = 0; row <= playerCoordinate.row; row++) {
            for (int column = 0; column <= playerCoordinate.column; column++) {
                if (Objects.equals(field[playerCoordinate.row][playerCoordinate.column], "O")) {
                    field[row][column] = "X";
                } else if (Objects.equals(field[playerCoordinate.row][playerCoordinate.column], "~")) {
                    field[row][column] = "M";
                }
            }
        }
    }





}









