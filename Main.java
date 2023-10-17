import java.util.*;

class Main {
    public static String context;
    public static Scanner input = new Scanner(System.in);
    public static Player Rose = new Player();

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
        Item health = new Item("health", "test", "You apply the bandage.");
        Item bone = new Item("bone", "test", Content.boneUse);
        Room spawn = new Room();
        spawn.setDesc(Content.start);
        spawn.setDesc2(Content.start2);
        Room r1 = new Room();
        r1.setDesc("test\n");
        r1.setDesc2("test2\n");

        spawn.addItem(health);
        spawn.setSide(Enum.Direction.NORTH, r1);
        r1.addItem(bone);
        r1.setSide(Enum.Direction.SOUTH, spawn);
        Rose.setLoc(spawn);
        Leatherface.setLeatherfaceLoc(r1);

        System.out.println("\u001b[2J");
        type(Content.introduction, 1);
        type("\t\tThe Texas Chain Saw Massacre.\n", 50);
        displayInstructions();

        while (true) {
            // print context for current decision

            type("\nWhat would you like to do?\n\n", 10);
            String[] choice = getInput();
            switch (choice[0].toLowerCase()) {
                case "go":
                    move(choice);
                    break;
                case "take":
                    switch (choice[1]) {
                        case "bone":
                        case "shard":
                            Rose.take(bone);
                            break;
                        case "health":
                        case "bandage":
                            Rose.take(health);
                            break;
                    }
                    break;
                case "item":
                    switch (choice[1]) {
                        case "bone":
                        case "shard":
                            Rose.useItem(bone);
                            break;
                        case "health":
                        case "bandage":
                            Rose.useItem(health);
                            break;
                    }
                    break;
            }

            // print list of options for current decision

            // read user input

            // update decision state for next iteration

        }
    }

    public static void move(String[] choice) {
        switch (choice[1].toLowerCase()) {
            case ("n"):
            case ("north"):
                type("Moving North.\n\n", 10);
                Rose.go(Enum.Direction.NORTH);
                break;
            case ("e"):
            case ("east"):
                type("Moving East.\n\n", 10);
                Rose.go(Enum.Direction.EAST);
                break;
            case ("s"):
            case ("south"):
                type("Moving South.\n\n", 10);
                Rose.go(Enum.Direction.SOUTH);
                break;
            case ("w"):
            case ("west"):
                type("Moving West.\n\n", 10);
                Rose.go(Enum.Direction.WEST);
                break;
        }
    }

    public static String[] getInput() {
        String userIn = input.nextLine();
        String[] split = userIn.split(" ", 2);
        return split;
    }

    private static void displayInstructions() {
        context = "instructions";
        while (context == "instructions") {

            type("\nWelcome. Would you like instructions? y/n\n", 10);
            String[] userIn = getInput();

            try {
                switch (userIn[0].toLowerCase()) {
                    default:
                        type("Invalid input.\n", 10);
                        break;
                    case ("y"):
                    case ("yes"):
                        type(Content.instructions, 10);
                        context = "normal";
                        break;
                    case ("n"):
                    case ("no"):
                        context = "normal";
                        break;
                }
            } catch (Exception e) {
                type("Invalid input.\n", 10);
            }
        }
    }
}