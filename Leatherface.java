public class Leatherface {
    public static Room leatherfacePos;
    public boolean isStunned = false;
    public long unstun = 0;

    public void setLeatherfaceLoc(Room room) {
        leatherfacePos = room;
    }

    public void stun(int stunLength) {
        unstun = Main.getTime() + stunLength;
        this.isStunned = true;
    }

    public boolean checkStun() {
        if (this.isStunned == true) {
            if (System.currentTimeMillis() <= unstun) {
                this.isStunned = false;
            }
        }
        return isStunned;
    }

    public void move() {
        int direction = (int)(Math.random() * 4);
        if (leatherfacePos.side[direction] != null) {
            leatherfacePos.side[direction].enter(this);
        } else {
            
        }
    }

}