public class Player {
    public static int health = 100;
    public Room position;
    private Item[] inventory = new Item[2];

    public void setLoc(Room room) {
        position = room;
    }

    private void take(Player player) {
        Item[] itemArray = new Item[player.position.roomItems.size()];
        itemArray = player.position.roomItems.toArray(itemArray);

        do {
            
        } while(true);
    }

}