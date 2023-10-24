package battleship;

public class Coordinate {

    int row;
    int column;


    public Coordinate(String coordinate) {
        // now split (A1) to A and 1
        String Letter = coordinate.substring(0, 1);
        String Number = coordinate.substring(1);
        // now lets transform them into readable array integers.
        row = Letter.charAt(0) - 'A';
        column = Integer.parseInt(Number) - 1;

    }
}
