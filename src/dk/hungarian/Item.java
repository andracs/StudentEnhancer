package dk.hungarian;

public class Item implements Comparable {
    public String itemName;
    public ItemTypes itemType;

    public Item(String itemName, ItemTypes itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int compareTo(Object otherItem) {
        String thisItemStr = this.itemType.toString();
        Item i = (Item) otherItem;
        String otherItemStr = i.itemType.toString();
        return thisItemStr.compareTo(otherItemStr);
    }
}
