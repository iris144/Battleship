package battleship;

public class Battlefield {

    // this is your property.
    final char[][] field;
    private final char wave = '~';
    private final char ship = 'O';
    private final char miss = 'M';
    private final char hit = 'X';


    // this is my constructor. You define your play field here.
    public Battlefield() {
        this.field = new char[10][10];

        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field.length; column++) {
                field[row][column] = wave;
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


    public void displayFogField() {
        System.out.println("  1 2 3 4 5 6 7 8 9 10");
        String rowLabels = "ABCDEFGHIJ";
        for (int row = 0; row < field.length; row++) {
            System.out.print(rowLabels.charAt(row) + " ");
            for (int column = 0; column < field.length; column++) {
                char cell = field[row][column] == ship ? wave : field[row][column];
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


    public void placeShip(Coordinate startCoordinate, Coordinate endCoordinate) {
        for (int row = startCoordinate.row; row <= endCoordinate.row; row++) {
            for (int column = startCoordinate.column; column <= endCoordinate.column; column++) {
                field[row][column] = ship;
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
                boolean shipBelow = field[nextRow][column] == ship;
                boolean shipAbove = field[previousRow][column] == ship;
                boolean shipBefore = field[row][previousColumn] == ship;
                boolean shipAfter = field[row][nextColumn] == ship;
                if (shipBelow || shipAbove || shipBefore || shipAfter) {
                    return true;
                }
            }
        }
        return false;
    }


    public void takeShot(Coordinate shotCoordinate) {
        if (field[shotCoordinate.row][shotCoordinate.column] == wave) {
            field[shotCoordinate.row][shotCoordinate.column] = miss;
        } else if(field[shotCoordinate.row][shotCoordinate.column] == ship) {
            field[shotCoordinate.row][shotCoordinate.column] = hit;
        }

    }


    public void message(Coordinate shotCoordinate) {
        if (endGame()) {
            System.out.println("You sank the last ship. You won. Congratulations!");
        }else if (sinkShip(shotCoordinate)) {
            System.out.println("You sank a ship! Specify a new target:");
        } else if (field[shotCoordinate.row][shotCoordinate.column] == miss) {
            System.out.println("You missed!");
        } else if (field[shotCoordinate.row][shotCoordinate.column] == hit) {
            System.out.println("You hit a ship!");

        }
    }

    public boolean sinkShip(Coordinate shotCoordinate) {


        for (int i = shotCoordinate.row + 1; i < 10; i++) {
            if (field[i][shotCoordinate.column] == wave || field[i][shotCoordinate.column] == miss) break;
            else if (field[i][shotCoordinate.column] == ship) {
                return false;
            }
        }

        for (int i = shotCoordinate.row - 1; i > 0; i--) {
            if (field[i][shotCoordinate.column] == wave || field[i][shotCoordinate.column] == miss) break;
            else if (field[i][shotCoordinate.column] == ship) {
                return false;
            }
        }

        for (int i = shotCoordinate.column + 1; i < 10; i++) {
            if (field[shotCoordinate.row][i] == wave || field[shotCoordinate.row][i] == miss) break;
            else if (field[shotCoordinate.row][i] == ship) {
                return false;
            }
        }

        for (int i = shotCoordinate.column - 1; i > 0; i--) {
            if (field[shotCoordinate.row][i] == wave || field[shotCoordinate.row][i] == miss) break;
            else if (field[shotCoordinate.row][i] == ship) {
                return false;
            }
        }
        return true;
    }


    public boolean endGame() {
        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field.length; column++) {
                if(field[row][column] == ship){
                    return false;
                }
            }
        }
        return true;
    }
}









