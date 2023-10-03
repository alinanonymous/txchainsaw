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
        type("\u001b[HIt is Autumn of 1972. \n" +
                "Tragedy strikes 19 year old Rose Taylor on a drive home with her boyfriend,\n" +
                "22 year old Johnny Sawyer. After being abandoned at a gas station by her \n" +
                "false lover, a relaxing night on the town would become a nightmare that was\n" +
                "all too real.\n\tThe worst things she could have imagined do not compare to the horrors\n" +
                "she would experience during the events of this night and the subsequent days.\n" +
                "The case of Rose Taylor's misfortunate suffering and anguish would be\n" +
                "documented as yet another story of the bizarre crimes that were part of:\n\n",
                1);
        type("\t\tThe Texas Chain Saw Massacre.\n", 1);
        displayInstructions();
        
        while (true) {
            // print context for current decision

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
                        type("ok", 1);
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