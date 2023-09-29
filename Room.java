import java.util.*;

public class Room {

    public String desc;
    public String desc2;
    public boolean beenEntered = false;
    public ArrayList<Item> roomItems = new ArrayList<Item>();

    public void setDesc(String description) {
        description = desc;
    }

    public void setDesc2(String description) {
        description = desc2;
    }

    public void addItem(Item item) {
        roomItems.add(item);
    }

    public void removeItem(Item item) {
        roomItems.remove(item);
    }

    void enter(Player p) {
        p.setLoc(this); // i think this maybe works??
        if (beenEntered == false) {
            beenEntered = true;
        }
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