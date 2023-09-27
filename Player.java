import java.util.*;

public class Player {
    public static int health = 100;
    public Room position;
    private Item[] inventory = new Item[1];
    private int itemCount = 0;

    public void setLoc(Room room) {
        position = room;
    }

    public void take(Player player, Item item) {
        ArrayList<Item> itemArray = new ArrayList<Item>();
        itemArray = player.position.roomItems;
        List<Item> invlist = Arrays.asList(inventory);
        if (itemArray.contains(item)) {
            if (player.itemCount < 2) {
                itemArray.remove(item);
                invlist.add(item);
                player.itemCount++;
            } else {
                Main.type("Inventory full.\n", 10);
            }
        } else {
            Main.type("That item is not in this room.\n", 10);
        }

        player.inventory = invlist.toArray(inventory);
        Main.type("Took " + item.name + ".", 10);
    }
}