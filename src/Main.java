import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> menu = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean confirmQuit = false;

        //loop for main operation
        do {
            String userChoice = SafeInput.getRegExString(in, "\nChoose an option [A-Add item to list, D-Delete item from list, P-Print list, Q-Quit program]: ", "[AaDdPpQq]");

            if (userChoice.equalsIgnoreCase("a")) {
                addListItem(in, menu);
                displayList(in, menu);
            } else if (userChoice.equalsIgnoreCase("d")) {
                deleteListItem(in, menu);
                displayList(in, menu);
            } else if (userChoice.equalsIgnoreCase("p")) {
                printList(menu);
            } else if (userChoice.equalsIgnoreCase("q")) {
                if (SafeInput.getYNConfirm(in, "Are you sure?")) {
                    confirmQuit = true;
                } else {
                    in.nextLine();
                }
            }
        } while (!confirmQuit);
    }

    //method for display of list
    private static void displayList(Scanner in, ArrayList menu) {
        System.out.println("List below:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    //methods for adding and deleting items from the list, as well as printing (displaying) the list
    public static void addListItem(Scanner in, ArrayList menu) {
        String addItem = SafeInput.getNonZeroLenString(in, "Input name of item to be added to list");
        menu.add(addItem);
    }

    public static void deleteListItem(Scanner in, ArrayList menu) {
        int deleteItem = SafeInput.getRangedInt(in, "Input item number to be deleted from list", 1, menu.size());
        menu.remove(deleteItem-1);
        in.nextLine();
    }

    public static void printList(ArrayList menu) {
        System.out.println("List below:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}