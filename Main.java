import java.util.*;

class Main {
    public static String choice;
    public static Scanner input = new Scanner(System.in);

    public static void type(String text, int speed) {
        int i;

        for (i = 0; i < text.length(); i++) {
            System.out.printf("%c", text.charAt(i));
            try {
                Thread.sleep(speed);
                if (text.charAt(i) == '.' || text.charAt(i) == '!' || text.charAt(i) == '?') {
                    Thread.sleep(300);
                }
                if (text.charAt(i) == ',') {
                    Thread.sleep(150);
                }
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {

        Room spawn = new Room();
        Room r1 = new Room();
        spawn.setSide(Enum.Direction.NORTH, r1);
        System.out.println("\u001b[2J");
        type(Content.instructions, 25);
        type("\t\tThe Texas Chain Saw Massacre.\n", 50);
        displayInstructions();
        
        while (true) {
            // print context for current decision
            type("What would you like to do?\n\n", 10);
            String userIn = input.nextLine();
            String[] split = userIn.split(" ", 2);
            switch(split[0].toLowerCase()) {
                case("n"):
                case("north"):
                    type("Moving North.\n\n", 10);
                break;
                case("e"):
                case("east"):
                    type("Moving East.\n\n", 10);
                break;
                case("s"):
                case("south"):
                    type("Moving South.\n\n", 10);
                break;
                case("w"):
                case("west"):
                    type("Moving West.\n\n", 10);
                break;
                case("use"):
                    switch(split[1].toLowerCase()) {
                        case("bone"):
                            type("Using bone.\n\n", 10);
                        break;
                        case("bandage"):
                        case("health"):
                            type("Using health.\n\n", 10);
                        break;
                        default:
                            type("Not an item.\n\n", 10);
                        break;
                    }
                break;
            }
            
            // switch(userIn.toLowerCase()) {
            //     case(""):
            // }
            // print list of options for current decision

            // read user input

            // update decision state for next iteration

        }
    }

    private static void displayInstructions() {
        choice = "instructions";
        while (choice == "instructions") {
            
            type("\nWelcome. Would you like instructions? y/n\n", 10);
            String userIn = input.next();

            try {
                switch (userIn.toLowerCase()) {
                    default:
                        type("Invalid input.\n", 10);
                    break;
                    case("y"):
                    case("yes"):
                        type(Content.instructions, 10);
                        choice = "normal";
                    break;
                    case("n"):
                    case("no"):
                        choice = "normal";
                    break;
                }
            } catch (Exception e) {
                type("Invalid input.\n", 10);
            }
        }
    }
}