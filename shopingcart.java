import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class shopingcart {
    private ArrayList<Item> items = new ArrayList<>();
    public void addItem(int itemNo, String name, double price, int quantity) {
        Item newItem = new Item(itemNo, name, price, quantity);
        items.add(newItem);
        System.out.println("Item " + name + " added to the shopping cart.");
    }

    public void showAllItems() {
        if (items.isEmpty()) {
            System.out.println("Shopping cart is empty.");
        } else {
            System.out.println("All Items in the Shopping Cart:");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    public void deleteItem(int itemNo) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getItemNo() == itemNo) {
                iterator.remove();
                System.out.println("Item with item number " + itemNo + " deleted from the shopping cart.");
                return;
            }
        }
        System.out.println("Item with item number " + itemNo + " not found in the shopping cart.");
    }

    public static void main(String[] args) {
        shopingcart cart = new shopingcart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Item");
            System.out.println("2. Show All Items");
            System.out.println("3. Delete Item");
            System.out.println("4. Order Now");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter item number: ");
                    int itemNo = scanner.nextInt();
                    System.out.print("Enter item name: ");
                    String name = scanner.next();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter item quantity: ");
                    int quantity = scanner.nextInt();
                    cart.addItem(itemNo, name, price, quantity);
                    break;
                case 2:
                    cart.showAllItems();
                    break;
                case 3:
                    System.out.print("Enter item number to delete: ");
                    int itemToDelete = scanner.nextInt();
                    cart.deleteItem(itemToDelete);
                    break;
                case 4:
                    System.out.println("Order placed successfully. Thank you for shopping!");
                    scanner.close();
                    return;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
    }
}

class Item {
    private int itemNo;
    private String name;
    private double price;
    private int quantity;

    public Item(int itemNo, String name, double price, int quantity) {
        this.itemNo = itemNo;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItemNo() {
        return itemNo;
    }

    @Override
    public String toString() {
        return "Item No: " + itemNo + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;
    }
}



// Explation:-
// Item Class:

// Represents an item with attributes such as item number, name, price, and quantity.
// ShoppingCart Class:

// Manages a list of Item objects using an ArrayList.
// Provides methods to add items, show all items, and delete items from the shopping cart.
// Includes a menu-driven program in the main method, allowing users to interact with the shopping cart by choosing options.
// Continues running until the user decides to place an order or exit.
// Menu-Driven Program:

// Options include adding items, showing all items, deleting items, placing an order, and exiting the program.
// Utilizes a Scanner for user input.
// Usage of ArrayList:

// The ArrayList<Item> items is used to store and manage the items in the shopping cart dynamically.
// Run-Time Interaction:

// Users can add items by providing details, view the current items in the cart, delete items by specifying their item number, place an order, or exit the program.