public class Enum {
    public enum direction {

        NORTH(1), EAST(2), SOUTH(3), WEST(4);

        private final int direct;

        direction(int direct) {
            this.direct = direct;
        }
    }
}