public class Player {
    public static int health = 100;
    public static Room position;
    public Item[] inventory = new Item[2];
    public int itemCount = 0;

    public void setLoc(Room room) {
        position = room;
    }

    public Room getLoc() {
        return position;
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

    public void go(Enum.Direction direction) {
        if (position.side[direction.direct] == null) {
            Main.type("\nYou cannot move that way!\n", 10);
        } else {
            position.exit(direction, this);
        }
    }

    public void useItem(Item item, Leatherface l) {

        for (int i = 0; i < itemCount; i++) {
            if (item == inventory[i]) {
                item.use(item, l);
                itemCount--;
                break;
            } else {
                Main.type("You don't have that item.", 10);
            }
        }
    }
}