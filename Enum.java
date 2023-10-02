public class Enum {
    public enum Direction {

        NORTH(1), EAST(2), SOUTH(3), WEST(4);

        public final int direct;

        Direction(int direct) {
            this.direct = direct;
        }
    }
}