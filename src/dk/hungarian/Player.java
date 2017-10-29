package dk.hungarian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    public List<Item> taske = new ArrayList();
    private String name;
    private int positionX;
    private int positionY;

    public Player() {
        name = "";
        positionX = 0;
        positionY = 0;
    }

    public Player(String name) {
        this.name = name;
        positionX = 0;
        positionY = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String move(String retning) {
        String svarTilBruger = "";
        switch (retning) {
            case "op":
                if (positionY > 0) {
                    --positionY;
                } else {
                    svarTilBruger = "Du prøver, men kan ikke gå " + retning + " fra X" + positionX + "Y" + positionY + ".";
                }
                break;
            case "ned":
                if (positionY < 9) {
                    ++positionY;
                } else {
                    svarTilBruger = "Du prøver, men kan ikke gå " + retning + " fra X" + positionX + "Y" + positionY + ".";
                }
                break;
            case "venstre":
                if (positionX > 0) {
                    --positionX;
                } else {
                    svarTilBruger = "Du prøver, men kan ikke gå " + retning + " fra X" + positionX + "Y" + positionY + ".";
                }
                break;
            case "højre":
                if (positionX < 9) {
                    ++positionX;
                } else {
                    svarTilBruger = "Du prøver, men kan ikke gå " + retning + " fra X" + positionX + "Y" + positionY + ".";
                }
                break;
        }
        if (svarTilBruger == "") {
            svarTilBruger = "Du går " + retning + ", og ender på X" + positionX + "Y" + positionY;
        }
        System.out.println(svarTilBruger);
        return svarTilBruger;
    }

    public String grave() {

        Tile tile = Kort.visTile(positionX, positionY);
        // Debug
        if (tile.gravForSkat() == null)
            System.out.println("Graver, finder ikke noget. ");
        else {
            System.out.println("Graver og finder en " + tile.gravForSkat().itemType);
            taske.add(tile.gravForSkat());
            tile.removeSkat();
        }
        return "Brugeren graver";
    }

    public void visTaske() {

        System.out.println("Tasken indeholder");

        Collections.sort(taske);

        // System.out.println(taske);
        for(Item item : taske) {
            System.out.println(item.itemType);  // Will invoke overrided `toString()` method
        }

    }


}
