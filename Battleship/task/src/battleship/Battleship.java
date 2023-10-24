package battleship;

public class Battleship {


    // property
    String name;
    int length;

    public Battleship(String name){
        this.name = name;

        switch (name) {
            case ShipType.AIRCRAFT_CARRIER -> length = 5;
            case ShipType.BATTLESHIP -> length = 4;
            case ShipType.SUBMARINE, ShipType.CRUISER -> length = 3;
            case ShipType.DESTROYER -> length = 2;

        }
    }
}
