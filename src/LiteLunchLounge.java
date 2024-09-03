import java.util.Scanner;// Import Scanner library to get user input for ordering process

public class LiteLunchLounge {

    // This method prints the menu of the Lite Lunch Lounge
    static void printMenu(){
        System.out.println("\nMenu\n"); // Print the header for the menu
        // Print the menu items and their prices in a formatted string
        System.out.println("""
                           1. Coffee                                    RM 1.80
                           2. Soft drink                                RM 2.00
                           3. Dessert                                   RM 3.50
                           4. Starter                                   RM 4.00
                           5. Main Course                               RM 8.00
                           6. Main Course + Dessert                     RM 11.00
                           7. Main Course + Starter                     RM 11.50
                           8. Combo (Main Course + Starter + Dessert)   RM 15.00
                           """);
    }
    
    // This method prompts the user to enter their order index and validates the input
    static int getOrderIndex(Scanner scanner){
        int index = -1; // Initialize the index to an invalid value
        System.out.print("What will be your order? (1-8): "); // Prompt the user for input
        index = scanner.nextInt(); // Read the user's input
        // Validate the input to ensure it is within the range of 1 to 8
        if(index < 1 || index > 8){
            System.out.println("Error"); // Print an error message if input is invalid
            return getOrderIndex(scanner); // Recursively prompt for a valid input
        }
        return index; // Return the valid index
    }

    // This method prompts the user to enter the number of sets and validates the input
    static int getNoOfItems(Scanner scanner){
        int no = 0; // Initialize the number of sets to 0
        System.out.print("Number of sets?: "); // Prompt the user for input
        no = scanner.nextInt(); // Read the user's input
        // Validate the input to ensure it is within the range of 0 to 99
        if (no < 1 || no > 99){
            System.out.println("Error"); // Print an error message if input is invalid
            return getNoOfItems(scanner); // Recursively prompt for a valid input
        }
        return no; // Return the valid number of sets
    }

    
    // This method returns the price of the selected menu item based on its index
    static double chooseCourse(int index){
        double price = 0; // Initialize the price to 0
        // Use a switch statement to determine the price based on the index
        price = switch(index){
            case 1 -> 1.8; // Price for Coffee
            case 2 -> 2; // Price for Soft drink
            case 3 -> 3.5; // Price for Dessert
            case 4 -> 4; // Price for Starter
            case 5 -> 8; // Price for Main Course
            case 6 -> 11; // Price for Main Course + Dessert
            case 7 -> 11.5; // Price for Main Course + Starter
            case 8 -> 15; // Price for Combo
            default -> -1; // Default case if the index is invalid
        };
        return price; // Return the determined price
    }


    // This method asks the user if they want to order another item or proceed to payment
    static boolean nextOrderOrPayment(Scanner scanner){
        String option; // Initialize a string to hold the user's response
        System.out.print("Do you want to order next item [Y/N]?: "); // Prompt the user for input
        option = scanner.next(); // Read the user's input
        // Check if the user's input is either 'Y' or 'N' (case insensitive)
        if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("n")){
            // Return true if the user wants to order another item, false otherwise
            return (!option.equalsIgnoreCase("n"));
        } else {
            System.out.println("Error"); // Print an error message if input is invalid
            return nextOrderOrPayment(scanner); // Recursively prompt for a valid input
        }
    }


    // This method prints the receipt of the user's order
    static void printReceipt(int totalNoSet1, int totalNoSet2, int totalNoSet3, int totalNoSet4, int totalNoSet5, int totalNoSet6, int totalNoSet7, int totalNoSet8, double totalPriceSet1, double totalPriceSet2, double totalPriceSet3, double totalPriceSet4, double totalPriceSet5, double totalPriceSet6, double totalPriceSet7, double totalPriceSet8, String nameSet1, String nameSet2, String nameSet3, String nameSet4, String nameSet5, String nameSet6, String nameSet7, String nameSet8){
        // Calculate the total price of all ordered items
        double totalPrice = totalPriceSet1 + totalPriceSet2 + totalPriceSet3 + totalPriceSet4 + totalPriceSet5 + totalPriceSet6 + totalPriceSet7 + totalPriceSet8;

        // Calculate the total number of free coffee and soft drinks based on the order
        int totalFreeCoffee = totalNoSet6 + totalNoSet8;
        int totalFreeSoftDrink = totalNoSet7 + totalNoSet8;

        // Print the receipt header
        System.out.println("\nReceipt:\n");
        System.out.print("Order\n---------------------------------------------------\n");

        // Print the ordered items and their prices if the quantity is greater than zero
        if (totalNoSet1 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet1 > 1 ? totalNoSet1 + " " : "") + nameSet1, totalPriceSet1);
        if (totalNoSet2 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet2 > 1 ? totalNoSet2 + " " : "") + nameSet2, totalPriceSet2);
        if (totalNoSet3 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet3 > 1 ? totalNoSet3 + " " : "") + nameSet3, totalPriceSet3);
        if (totalNoSet4 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet4 > 1 ? totalNoSet4 + " " : "") + nameSet4, totalPriceSet4);
        if (totalNoSet5 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet5 > 1 ? totalNoSet5 + " " : "") + nameSet5, totalPriceSet5);
        if (totalNoSet6 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet6 > 1 ? totalNoSet6 + " " : "") + nameSet6, totalPriceSet6);
        if (totalNoSet7 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet7 > 1 ? totalNoSet7 + " " : "") + nameSet7, totalPriceSet7);
        if (totalNoSet8 != 0)
            System.out.printf("%-40s RM %6.2f\n", (totalNoSet8 > 1 ? totalNoSet8 + " " : "") + nameSet8, totalPriceSet8);

        // Print the free items if applicable
        if (totalFreeCoffee > 0) 
            System.out.printf("* free %d coffee\n", totalFreeCoffee);
        if (totalFreeSoftDrink > 0)
            System.out.printf("* free %d soft drink\n", totalFreeSoftDrink);

        // Print the total price
        System.out.println("---------------------------------------------------");
        System.out.printf("%43s %6.2f\n", "RM", totalPrice);
        System.out.println("---------------------------------------------------");
    }


        public static void main(String[] args) {
        boolean orderNextItem = true; // Flag to control the ordering loop
        int index = 0; // Variable to hold the current order index
        int noOfItems = 0; // Variable to hold the number of items ordered
        double price = 0; // Variable to hold the price of the current order
        // Variables to keep track of the total number of each set ordered
        int totalNoSet1 = 0, totalNoSet2 = 0, totalNoSet3 = 0, totalNoSet4 = 0, totalNoSet5 = 0, totalNoSet6 = 0, totalNoSet7 = 0, totalNoSet8 = 0;
        // Variables to keep track of the total price of each set ordered
        double totalPriceSet1 = 0, totalPriceSet2 = 0, totalPriceSet3 = 0, totalPriceSet4 = 0, totalPriceSet5 = 0, totalPriceSet6 = 0, totalPriceSet7 = 0, totalPriceSet8 = 0;
        // Variables to store the names of the sets
        String nameSet1 = "Coffee", nameSet2 = "Soft Drink", nameSet3 = "Dessert", nameSet4 = "Starter", nameSet5 = "Main Course", nameSet6 = "Main Course + Dessert", nameSet7 = "Main Course + Starter", nameSet8 = "Combo";

        // Create a scanner object for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Lite Lunch Lounge!"); // Print welcome message
        do {
            printMenu(); // Display the menu
            index = getOrderIndex(scanner); // Get the user's order index
            noOfItems = getNoOfItems(scanner); // Get the number of sets ordered
            price = chooseCourse(index) * noOfItems; // Calculate the price for the current order

            // Update the total price and number of each set based on the user's order
            switch(index){
                case 1 -> totalPriceSet1 += price;
                case 2 -> totalPriceSet2 += price;
                case 3 -> totalPriceSet3 += price;
                case 4 -> totalPriceSet4 += price;
                case 5 -> totalPriceSet5 += price;
                case 6 -> totalPriceSet6 += price;
                case 7 -> totalPriceSet7 += price;
                case 8 -> totalPriceSet8 += price;
                default -> System.out.println("Error");
            };
            switch(index){
                case 1 -> totalNoSet1 += noOfItems;
                case 2 -> totalNoSet2 += noOfItems;
                case 3 -> totalNoSet3 += noOfItems;
                case 4 -> totalNoSet4 += noOfItems;
                case 5 -> totalNoSet5 += noOfItems;
                case 6 -> totalNoSet6 += noOfItems;
                case 7 -> totalNoSet7 += noOfItems;
                case 8 -> totalNoSet8 += noOfItems;
                default -> System.out.println("Error");
            };

            orderNextItem = nextOrderOrPayment(scanner); // Ask if the user wants to order another item or proceed to payment
        } while (orderNextItem == true); // Continue ordering if the user wants to

        // Print the receipt with the details of the order
        printReceipt(totalNoSet1, totalNoSet2, totalNoSet3, totalNoSet4, totalNoSet5, totalNoSet6, totalNoSet7, totalNoSet8, totalPriceSet1, totalPriceSet2, totalPriceSet3, totalPriceSet4, totalPriceSet5, totalPriceSet6, totalPriceSet7, totalPriceSet8, nameSet1, nameSet2, nameSet3, nameSet4, nameSet5, nameSet6, nameSet7, nameSet8);
    }
}
