/*
 * Copyright (c) 2017. András Ács / acsandras@gmail.com
 *
 * StudentEnhancer, et tekstbaseret spil for brug på datamatikeruddannelsen på EASJ Næstved
 * 
 */

package dk.hungarian;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Kort kortet = Kort.skabKortet();
        Player player = new Player("András");

        System.out.println("************************************************************");
        System.out.println("Studentenhancer er spillet, hvor DAT-studerende udvikler sig");
        System.out.println("************************************************************");

        if (player.getName().equals("")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Skriv dit navn: ");
            player.setName(scanner.next());
        }
        System.out.println("Du befinder dig i enhancer-spillet, " + player.getName());


        // DEBUG
        // Test.movement();
        // System.exit(1);

        boolean keepPlaying = true;

        Scanner scanner = new Scanner(System.in);

        // Main loop
        while (keepPlaying) {
            System.out.println("Hvad vil du foretage dig? (op, ned, venstre, højre, se, grave, slut) ");
            String kommandoFraBruger = scanner.next();
            String svarTilBruger = "";
            switch (kommandoFraBruger) {
                case "op":
                case "ned":
                case "højre":
                case "venstre":
                    player.move(kommandoFraBruger);
                    svarTilBruger = "";
                    break;
                case "grav":
                    player.grave();
                    svarTilBruger = "";
                    break;
                case "slut":
                    keepPlaying = false;
                    svarTilBruger = "Tak for denne gang. Dit spil gemmes (når programmøren har fået implementeret gem funktion.)";
                    break;
                default:
                    svarTilBruger = "Kan ikke forstå kommandoen \\\"\" + kommandoFraBruger + \"\\\", desværre.";
            }
            if (svarTilBruger!="") System.out.println(svarTilBruger);

        }

    }
}
