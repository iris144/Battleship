package battleship;

public class Main {

    public static void main(String[] args) {
        // Show your field!
        // this is your object. First you refer to your class, name and then constructor inside class.
        Battlefield battlefield = new Battlefield();
        battlefield.displayField();

        // Place your ships!
        PlacementOfShips placementOfShips = new PlacementOfShips();

        placementOfShips.placeShips(battlefield);

        // Let's play!
        GamePlay gamePlay = new GamePlay();
        gamePlay.gameMessage(battlefield);
        gamePlay.gamePlay(battlefield);
    }
}


