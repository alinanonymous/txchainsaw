public class Player {
    public static int health = 100;
    public Room position;
    private Item[] inventory = new Item[2];

    public void setLoc(Room room) {
        position = room;
    }

}