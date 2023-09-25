import java.util.*;

//https://www.cs.colostate.edu/~bieman/CS314/DesignStudios/DS1/AdventureCode.pdf

class Main {
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
        System.out.println("\u001b[2J");
        type("\u001b[HIt is Autumn of 1972. \nTragedy strikes 19 year old Rose Taylor on a drive home with her boyfriend,\n22 year old Johnny Sawyer. After being abandoned at a gas station by her \nfalse lover, a relaxing night on the town would become a nightmare that was\nall too real.\n      The worst things she could have imagined do not compare to the horrors\nshe would experience during the events of this night and the subsequent days.\nThe case of Rose Taylor's misfortunate suffering and anguish would be\ndocumented as yet another story of the bizarre crimes that were part of:\n\n",
                25);
        type("\t\tThe Texas Chain Saw Massacre.\n", 50);
        Scanner input = new Scanner(System.in);
        while (true) {
            // print context for current decision

            // print list of options for current decision

            // read user input

            // update decision state for next iteration

        }
    }
}