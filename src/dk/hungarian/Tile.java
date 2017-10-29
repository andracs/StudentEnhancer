package dk.hungarian;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

public class Tile {
    private int x;
    private int y;
    private String beskrivelse;
    private Item skat;

    public Tile(int x, int y, String beskrivelse) {
        this.x = x;
        this.y = y;
        this.beskrivelse = beskrivelse;

        int erDerSkat= (int) Math.floor(Math.random() * 3);
        if (erDerSkat==0) {
            int randomItemType = (int) Math.floor(Math.random() * 3);
            this.skat = new Item(ItemTypes.values()[randomItemType].toString(), ItemTypes.values()[randomItemType]);
            // DEBUG
            // System.out.println("Generated " + skat.itemType);
        }
        else {
            // DEBUG
            // System.out.println("No skat");
        }
    }

    public Tile() {
    }

    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                ", beskrivelse='" + beskrivelse + '\'' +
                '}';
    }

    public Boolean erDerSkat() {
        Boolean erDerSkat;
        erDerSkat = (this.skat == null) ? false : true;
        return erDerSkat;

    }
    public void removeSkat(){
        skat = null;
    }

    public Item gravForSkat() {
        return skat;
    }



}
