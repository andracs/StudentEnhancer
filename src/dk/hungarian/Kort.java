package dk.hungarian;

// public Customer getCustomer(String id) throws DataAccessException {
public class Kort {
    static Tile[][] tiles = new Tile[10][10];
    private static Kort verdensKortet = null;

    private Kort() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Tile t = new Tile(x, y, "Du er på skolen.");
                tiles[x][y] = t;
            }

        }
    }

    /* Singleton pattern */
    public static Kort skabKortet() {
        if (verdensKortet == null) {
            verdensKortet = new Kort();
        }
        return verdensKortet;
    }

    public static Tile visTile(int x, int y) {
        return tiles[x][y];
    }

    public static void visKort() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                Tile t = tiles[x][y];
                // System.out.print("X"+x+"Y"+y + " ");
                if (t.gravForSkat() == null) {
                    System.out.print(" .");
                } else {
                    if (t.gravForSkat().itemType == ItemTypes.EKSAMENSBOOSTER) System.out.print(" E");
                    if (t.gravForSkat().itemType == ItemTypes.LÆRINGSBOOSTER) System.out.print(" L");
                    if (t.gravForSkat().itemType == ItemTypes.SWAG) System.out.print(" S");
                }


            }
            // DEBUG
            System.out.println("");
        }
    }
}
