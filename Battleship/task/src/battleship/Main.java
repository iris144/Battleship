package battleship;


public class Main {

    public static void main(String[] args) {

        GamePlay gamePlay = new GamePlay();

        // Show your field for player 1!
        // this is your object. First you refer to your class, name and then constructor inside class.
        System.out.println("Player 1, place your ships on the game field");
        System.out.println();
        Battlefield battlefield = new Battlefield();
        battlefield.displayField();

        // Player 1: Place your ships!
        PlacementOfShips placementOfShips = new PlacementOfShips();
        placementOfShips.placeShips(battlefield);
        System.out.println();
        gamePlay.promptEnterKey();



        // Show your field for player 2!
        System.out.println("Player 2, place your ships on the game field");
        System.out.println();
        Battlefield battlefield2 = new Battlefield();
        battlefield2.displayField();

        //Player 2: Place your ships!
        PlacementOfShips placementOfShips2 = new PlacementOfShips();
        placementOfShips2.placeShips(battlefield2);
        System.out.println();
        gamePlay.promptEnterKey();

        // Let's play!
        //gamePlay.gameMessage(battlefield);
        gamePlay.gamePlay(battlefield, battlefield2);
    }
}


