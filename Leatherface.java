public class Leatherface {
    public static Room leatherfacePos;
    public static boolean isStunned = false;
    public static int stunTime = 30000;

    public void setLeatherfaceLoc(Room room) {
        leatherfacePos = room;
    }

    public static void move() {
        int direction = (int)(Math.random() * 4);
    }

}