public class Leatherface {
    public static Room leatherfacePos;
    public static boolean isStunned = false;

    public void setLeatherfaceLoc(Room room) {
        leatherfacePos = room;
    }

    public void move() {
        int direction = (int)(Math.random() * 4 - 1);
        this.leatherfacePos.side[direction].enter(this);
    }

    public static void stun(int duration) {
        if (!isStunned) {
            try {
                Thread.sleep(duration);
            } catch (Exception e) {}
        }
    }

}