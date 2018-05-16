package pl.com.company.gameOfWar;

import java.util.ArrayList;

public class Portal {

    private ArrayList<String> location;
    private String name;

    public void setLocation(ArrayList<String> location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String check(String move) {
        String result = "Aww, missed!";

        int index = location.indexOf(move);

        if (index >= 0) {
            location.remove(index);

            if (location.isEmpty()) {
                result = "Portal shut down!";
                System.out.println("You've managed to shut down " + name + " : ( ");
            } else {
                result = "That's a hit! Keep going!";
            }
        }
        return result;
    }
}