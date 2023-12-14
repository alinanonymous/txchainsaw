import java.util.*;

class Main {
    public static String context;
    public static Scanner input = new Scanner(System.in);
    public static Player Rose = new Player();
    public static final Enum.Direction NORTH = Enum.Direction.NORTH;
    public static final Enum.Direction SOUTH = Enum.Direction.SOUTH;
    public static final Enum.Direction EAST = Enum.Direction.EAST;
    public static final Enum.Direction WEST = Enum.Direction.WEST;
    public static boolean lMoveOnce = false;

    public static void type(String text, int speed) {

        for (int i = 0; i < text.length(); i++) {
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
        Room spawn = new Room("Spawn");
        spawn.name = "spawn";
        spawn.setDesc(Content.start);
        spawn.setDesc2(Content.start2);
        spawn.roomThings.add(0, "hat");
        spawn.thingDescs.add(0, "It's a hat. You pick it up and place it back down.");
        Room coldCorridor = new Room("Cold Corridor");
        coldCorridor.setDesc("test\n");
        coldCorridor.setDesc2("test2\n");
        Room coldRoom = new Room("Cold Room");
        coldRoom.setDesc("It cold in here brrr\n");
        coldRoom.setDesc2("brrr still cold\n");
        Room lair = new Room("Lair");
        lair.setDesc("its very red here\n");
        lair.setDesc2("there used to be a chainsaw murderer here\n");
        Room lairCorridor = new Room("Lair Corridor");
        lairCorridor.setDesc("wow lair corridor");
        lairCorridor.setDesc2("corridor of the lair");
        Room storage = new Room("Storage");
        storage.setDesc("lotsa boxes here\n");
        storage.setDesc2("storage\n");
        Room westTunnels = new Room("West Tunnels");
        westTunnels.setDesc("Long tunnel on the West");
        westTunnels.setDesc2("big tunnel big big tunnel\n");
        Room boilerRoom = new Room("Boiler Room");
        boilerRoom.setDesc("boiling boiling\n");
        boilerRoom.setDesc2("its the boiler room\n");
        Room northTunnels = new Room("North Tunnels");
        northTunnels.setDesc("tunnels at the north\n");
        northTunnels.setDesc2("tunnels up north bro\n");
        Room bedroom = new Room("Bedroom");
        bedroom.setDesc("its the bedroom\n");
        bedroom.setDesc2("honk shoo\n");
        Room kennel = new Room("Kennel");
        kennel.setDesc("kennel\n");
        kennel.setDesc2("kennel room yahoo\n");
        Room northCell = new Room("North Cell");
        northCell.setDesc("It's like the south cell but north!\n");
        northCell.setDesc2("Yup! still north cell\n");
        Room bloodBathroom = new Room("Blood Bathroom");
        bloodBathroom.setDesc("blood bath room? what\n");
        bloodBathroom.setDesc2("you need a bathroom for blood?\n");
        Room eastTunnels = new Room("East Tunnels");
        eastTunnels.setDesc("east tunnels\n");
        eastTunnels.setDesc2("mmmhmm east tunnel\n");
        Room rearBasement = new Room("Rear Basement");
        rearBasement.setDesc("butt basement lol\n");
        rearBasement.setDesc2("rear basement");
        Room sideGardenTunnels = new Room("Side Garden Tunnels");
        sideGardenTunnels.setDesc("side garden tunnels");
        sideGardenTunnels.setDesc2(context);
        Room fuseboxTunnel = new Room("Fusebox Tunnel");
        fuseboxTunnel.setDesc("tunnel with the basement exit");
        fuseboxTunnel.setDesc2("fusebox tunnel");
        Leatherface leatherface = new Leatherface();
        leatherface.setLeatherfaceLoc(lair);

        spawn.addItem(bone);
        spawn.setSide(NORTH, coldCorridor);
        spawn.setSide(WEST, westTunnels);
        coldCorridor.addItem(health);
        coldCorridor.setSide(NORTH, coldRoom);
        coldCorridor.setSide(SOUTH, spawn);
        coldCorridor.setSide(EAST, storage);
        coldCorridor.setSide(WEST, westTunnels);
        coldRoom.setSide(NORTH, lair);
        coldRoom.setSide(SOUTH, coldCorridor);
        coldRoom.setSide(EAST, storage);
        lair.setSide(NORTH, lairCorridor);
        lair.setSide(SOUTH, coldRoom);
        lair.setSide(EAST, rearBasement);
        lair.setSide(WEST, boilerRoom);
        lairCorridor.setSide(NORTH, northCell);
        lairCorridor.setSide(SOUTH, lair);
        lairCorridor.setSide(EAST, bloodBathroom);
        lairCorridor.setSide(WEST, bedroom);
        storage.setSide(NORTH, rearBasement);
        storage.setSide(SOUTH, sideGardenTunnels);
        storage.setSide(EAST, fuseboxTunnel);
        storage.setSide(WEST, coldRoom);
        westTunnels.setSide(NORTH, boilerRoom);
        westTunnels.setSide(SOUTH, spawn);
        westTunnels.setSide(EAST, coldCorridor);
        boilerRoom.setSide(NORTH, northTunnels);
        boilerRoom.setSide(SOUTH, westTunnels);
        boilerRoom.setSide(EAST, bedroom);
        northTunnels.setSide(NORTH, northCell);
        northTunnels.setSide(SOUTH, kennel);
        northTunnels.setSide(EAST, bedroom);
        northTunnels.setSide(WEST, boilerRoom);
        bedroom.setSide(NORTH, northTunnels);
        bedroom.setSide(SOUTH, lairCorridor);
        bedroom.setSide(EAST, kennel);
        bedroom.setSide(WEST, boilerRoom);
        kennel.setSide(NORTH, northTunnels);
        kennel.setSide(EAST, northCell);
        kennel.setSide(WEST, bedroom);
        kennel.setSide(SOUTH, lairCorridor);
        northCell.setSide(NORTH, northTunnels);
        northCell.setSide(SOUTH, bloodBathroom);
        northCell.setSide(EAST, bloodBathroom);
        northCell.setSide(WEST, kennel);
        bloodBathroom.setSide(EAST, eastTunnels);
        bloodBathroom.setSide(SOUTH, rearBasement);
        bloodBathroom.setSide(WEST, lairCorridor);
        eastTunnels.setSide(WEST, bloodBathroom);
        eastTunnels.setSide(SOUTH, fuseboxTunnel);
        rearBasement.setSide(NORTH, bloodBathroom);
        rearBasement.setSide(SOUTH, storage);
        rearBasement.setSide(EAST, eastTunnels);
        rearBasement.setSide(WEST, lair);
        sideGardenTunnels.setSide(NORTH, storage);
        sideGardenTunnels.setSide(WEST, coldCorridor);
        fuseboxTunnel.setSide(NORTH, eastTunnels);
        fuseboxTunnel.setSide(WEST, storage);

        Rose.setLoc(spawn);
        spawn.beenEntered = true;
        
        System.out.println("\u001b[2J");
        type(Content.introduction, 1);
        type("\t\tThe Texas Chain Saw Massacre.\n", 50);
        displayInstructions();

        type(Content.start, 1);
        boolean alive = true;

        while (alive) {
            // print context for current decision
            leatherface.checkStun();
            leatherface.move();
            if (!(Rose.getLoc().hasLeatherface())) {
                type("\nWhat would you like to do?\n\n", 10);
                String[] choice = getInput();
                switch (choice[0].toLowerCase()) {
                    case "go":
                        move(choice);
                        break;
                    case "take":
                        switch (choice[1]) {
                            default:
                                type("That item is not in this room.\n", 10);
                                break;
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
                                Rose.useItem(bone, leatherface);
                                break;
                            case "health":
                            case "bandage":
                                Rose.useItem(health, leatherface);
                                break;
                        }
                        break;
                    case "look":
                        type(Rose.getLoc().desc2, 10);
                        break;
                    case "exam":
                        try {
                            type(Rose.getLoc().getThingDesc(choice[1]), 10);
                        } catch (Exception e) {}
                        break;
                }
            } else {
                type("\nLeatherface. You are in danger. Make your next choice wisely.\n\n", 20);
                String[] choice = getInput();
                switch(choice[0]) {
                    case "go":
                        if ((int)Math.random() * 10 == 1) {
                            move(choice);
                        } else {
                            type("Ouch!", 1);
                            Player.health -= 50;
                        }
                        break;
                    case "fight":
                        break;
                    default:
                        type("GAME OVER", 1);
                        alive = false;
                        break;
                }
            }
            
            if (leatherface.leatherfaceMoves == 1 && lMoveOnce == false) {
                type(Content.leatherfaceMove, 10);
                lMoveOnce = true;
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
                Rose.go(NORTH);
                break;
            case ("e"):
            case ("east"):
                type("Moving East.\n\n", 10);
                Rose.go(EAST);
                break;
            case ("s"):
            case ("south"):
                type("Moving South.\n\n", 10);
                Rose.go(SOUTH);
                break;
            case ("w"):
            case ("west"):
                type("Moving West.\n\n", 10);
                Rose.go(WEST);
                break;
        }
    }

    public static String[] getInput() {
        String userIn = input.nextLine();
        String[] split = userIn.split(" ", 2);
        if (split.length != 1 && split[1].equals(null)) {
            split[1].equals(" ");
        }
        return split;
    }

    public static long getTime() {
        return System.currentTimeMillis();
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