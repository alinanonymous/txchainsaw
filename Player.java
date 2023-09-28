import java.util.*;

public class Player {
    public static int health = 100;
    public Room position;
    private Item[] inventory = new Item[2];
    private int itemCount = 0;

    public void setLoc(Room room) {
        position = room;
    }

    public void take(Item item) {
        
        if (position.roomItems.contains(item)) {
            if (itemCount < 2) {
                inventory[itemCount] = item;
                position.roomItems.remove(item);
                itemCount++;
                Main.type("Took " + item.name + ".", 10);
            } else {
                Main.type("Inventory full.\n", 10);
            }
        } else {
            Main.type("That item is not in this room.\n", 10);
        }
    }

    public void useItem(Item item) {

        for (int i = 0; i < itemCount; i++) {
            if (item == inventory[i]) {
                item.use(item.name);
                break;
            } else {
                Main.type("You don't have that item.", 10);
            }
        }
    }
}