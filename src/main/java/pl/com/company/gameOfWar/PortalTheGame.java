package pl.com.company.gameOfWar;

import java.util.ArrayList;

public class PortalTheGame {

    private GameHelper helper = new GameHelper();
    private ArrayList<Portal> portals = new ArrayList<>();
    int numberOfMoves = 0;

    public void readyGame() {
        Portal first = new Portal();
        Portal second = new Portal();
        Portal third = new Portal();
        first.setName("msn.com");
        second.setName("google.com");
        third.setName("facebook.com");

        portals.add(first);
        portals.add(second);
        portals.add(third);

        System.out.println("Yoy have to shut down 3 puny web portals:");
        System.out.println("msn.com, google.com and facebook.com");
        System.out.println("Try to do it using as little moves as possible. Good luck!");


        for (Portal portal : portals) {
            ArrayList<String> newLocation = helper.placePortal(3);
            portal.setLocation(newLocation);
        }
    }

    private void startGame() {
        while (!portals.isEmpty()) {
            String theMove = helper.getInputData("Enter location:");
            checkMove(theMove);
        }
        endGame();
    }

    private void checkMove(String move) {
        numberOfMoves++;
        String result = "Aww, missed!";

        for (Portal toCheck : portals) {
            result = toCheck.check(move);
            if (result.equals("That's a hit! Keep going!")) {
                break;
            }
            if (result.equals("Portal shut down!")) {
                portals.remove(toCheck);
                break;
            }
        }
        System.out.println(result);
    }

    private void endGame() {
        System.out.println("You've shut down all those annoying portals!");

        if (numberOfMoves <= 18) {
            System.out.println("You've made only " + numberOfMoves + " moves! Someone going places, eh?");
        } else {
            System.out.println("Still, it took you too long! You've made " + numberOfMoves + " moves! Pathetic!");
        }
    }

    public static void main(String[] args) {
        PortalTheGame theGame = new PortalTheGame();
        theGame.readyGame();
        theGame.startGame();
    }
}
