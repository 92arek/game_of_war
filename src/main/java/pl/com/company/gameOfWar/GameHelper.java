package pl.com.company.gameOfWar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper {

    private static final String alphabet = "abcdefg";
    private int length = 7;
    private int boardSize = 49;
    private int[] board = new int[boardSize];
    private int numberOfPortals = 0;

    public String getInputData(String message) {
        String inputData = null;
        System.out.println(message + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputData = is.readLine();
            if (inputData.length() == 0)
                return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputData.toLowerCase();
    }

    public ArrayList placePortal(int portalSize) {
        ArrayList<String> takenFields = new ArrayList<>();
        String help;
        int[] coordinates = new int[portalSize];
        int tries = 0;
        boolean success = false;
        int location = 0;

        numberOfPortals++;
        int incr = 1;
        if ((numberOfPortals % 2) == 1) {
            incr = length;
        }

        while (!success & tries++ < 200) {
            location = (int) (Math.random() * boardSize);
            int x = 0;
            success = true;
            while (success && x < portalSize) {
                if (board[location] == 0) {
                    coordinates[x++] = location;
                    location += incr;
                    if (location >= boardSize) {
                        success = false;
                    }
                    if (x > 0 & (location % length == 0)) {
                        success = false;
                    }
                } else {
                    success = false;
                }
            }
        }

        int x = 0;
        int line;
        int column;

        while (x < portalSize) {
            board[coordinates[x]] = 1;
            line = (coordinates[x]) / length;
            column = coordinates[x] % length;
            help = String.valueOf(alphabet.charAt(column));
            takenFields.add(help.concat(Integer.toString(line)));
            x++;
        }
        return takenFields;
    }
}
