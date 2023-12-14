public class Leatherface {
    public static Room leatherfacePos;
    public boolean isStunned = false;
    public long unstun = 0;
    public int leatherfaceMoves = 0;

    public void setLeatherfaceLoc(Room room) {
        leatherfacePos = room;
    }

    public void stun(int stunLength) {
        unstun = Main.getTime() + stunLength;
        this.isStunned = true;
        System.out.println("Leatherface stunned");
    }

    public boolean checkStun() {
        if (this.isStunned == true) {
            if (Main.getTime() <= unstun) {
                this.isStunned = false;
                System.out.println("Leatherface unstunned");
            }
        }
        return isStunned;
    }

    public void move() {
        if (!checkStun() && !(Player.position == leatherfacePos)) {
            int direction = (int)(Math.random() * 4);
            if (leatherfacePos.side[direction] != null) {
                System.out.println("Leatherface moved " + leatherfacePos.name);
                ++leatherfaceMoves;
                leatherfacePos.side[direction].enter(this);
            } else if (!(Player.position == leatherfacePos)) {
            } else {
                this.stun(15000);
            }
        }
    }
}