import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<String> myArrList = new ArrayList<>();
        String menuChoice, addToList;
        int deleteFromList;
        boolean done = false;
        int index = 0;

        do {
            System.out.println("Current list: ");
            index = 0;
            for (int i = 0; i < myArrList.size(); i++) {
                System.out.println("Index " + index + ": " + myArrList.get(i));
                index++;
            }
            System.out.println();   // adding a space for clarity

            System.out.println("A - Add an item to the list");  // menu for user
            System.out.println("D - Delete an item from the list");
            System.out.println("P - Print the list");
            System.out.println("Q - Quit the program");
            menuChoice = SafeInput.getRegExString(in, "Enter your choice [A, D, P, Q]: ", "^[AaDdPpQq]$");
            System.out.println();

            menuChoice = menuChoice.toUpperCase();  // upper case so switch case is easier

            switch (menuChoice) {
                case "A":       // adding to list
                    addToList = SafeInput.getNonZeroLenString(in, "Add your item to the list: ");
                    myArrList.add(addToList);
                    System.out.println("Added to the list!");

                    System.out.println();   // adding a space for clarity
                    break;
                case "D":   // deleting from list
                    if (myArrList.size() == 0) {
                        System.out.println("The list is already empty!");
                        System.out.println();
                        break;
                    }
                    else {
                        deleteFromList = SafeInput.geRangedInt(in, "Which index would you like to delete ", 0, myArrList.size() - 1);
                        myArrList.remove(deleteFromList);
                        System.out.println("Index removed!");
                    }

                    System.out.println();   // adding a space for clarity
                    break;
                case "P":   // printing list
                    index = 0;
                    for (int i = 0; i < myArrList.size(); i++) {
                        System.out.println("Index " + index + ": " + myArrList.get(i));
                        index++;
                    }

                    System.out.println();   // adding a space for clarity
                    break;
                case "Q":   // quitting the program
                    done = SafeInput.getYNConfirm(in, "Are you sure you would like to quit? [Y/N]: ");

                    if (done){
                        System.out.println("Quitting successfully");
                        System.exit(0);
                    }

                    System.out.println();   // adding a space for clarity
                    break;
            }
        } while (!done);
    }
}