import java.util.*;

public class Room {

    public String desc;
    public String desc2;
    public boolean beenEntered = false;
    public ArrayList<Item> roomItems = new ArrayList<Item>();
    public ArrayList<String> roomThings = new ArrayList<String>();
    public ArrayList<String> thingDescs = new ArrayList<String>();
    public Room[] side = new Room[4];

    public void setDesc(String description) {
        desc = description;
    }

    public void setDesc2(String description) {
        desc2 = description;
    }

    public void setSide(Enum.Direction direction, Room room) {
        int direct = direction.direct;
        side[direct] = room;
    }

    public String getThingDesc(String thing) {
        if (roomThings.contains(thing)) {
            String thingDesc = thingDescs.get(roomThings.indexOf(thing));
            return thingDesc;
        } else {
            Main.type("That isn't here.\n", 10);
        }
        return null;
    }

    public void addItem(Item item) {
        roomItems.add(item);
    }

    public void removeItem(Item item) {
        roomItems.remove(item);
    }

    public void enter(Player p) {
        p.setLoc(this); // i think this maybe works??
        if (beenEntered == false) {
            Main.type(desc, 25);
            beenEntered = true;
        } else {
            Main.type(desc2, 10);
        }
    }

    public void exit(Enum.Direction direction, Player p) {
        int direct = direction.direct;
        side[direct].enter(p);
    }

    public boolean hasLeatherface() {
        boolean hasLeatherface;
        if (Leatherface.leatherfacePos.equals(this)) { // this better work
            hasLeatherface = true;
        } else {
            hasLeatherface = false;
        }
        return hasLeatherface;
    }
}