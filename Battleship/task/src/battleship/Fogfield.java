package battleship;

import java.util.Objects;

public class Fogfield {

    private final String[][] field;

    public Fogfield(){
        this.field = new String[10][10];
    }



    public static void fogfield() {


        Battlefield battlefield = new Battlefield();
        battlefield.displayField();
        System.out.println();

    }


    public void takeShot(Battlefield battlefield, Coordinate playerCoordinate) {

        for (int row = 0; row <= playerCoordinate.row; row++) {
            for (int column = 0; column <= playerCoordinate.column; column++) {
                field[row][column] = "~";
                if (Objects.equals(battlefield.field[row][column], "O")) {
                    battlefield.field[row][column] = "X";
                    System.out.println("You hit a ship!");
                    System.out.println();
                } else if (Objects.equals(battlefield.field[playerCoordinate.row][playerCoordinate.column], "~")) {
                    battlefield.field[row][column] = "M";
                    System.out.println("You missed!");
                    System.out.println();
                }

            }
        }
    }
}
