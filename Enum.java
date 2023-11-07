public class Enum {
    public enum Direction {

        NORTH(0), EAST(1), SOUTH(2), WEST(3);

        public final int direct;

        Direction(int direct) {
            this.direct = direct;
        }
    }
}