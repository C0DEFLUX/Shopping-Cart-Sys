import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item
{
    String name;
    double price;
    int quantity;
    double discount;

    //Constructor
    public Item(String name, double price, int quantity, double discount)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
    }

    //Calculate the total price with the discount
    public double getTotalPrice()
    {
        double effectivePrice = price * (1 - discount / 100);
        return effectivePrice * quantity;
    }

    @Override
    public String toString()
    {
        //Format the item list
        return String.format("Item: %s, Price: %.2f, Quantity: %d, Discount: %.2f%%", name, price, quantity, discount);
    }
}

class ShoppingCart
{
    private List<Item> cart;
    //Constructor
    public ShoppingCart()
    {
        cart = new ArrayList<>();
    }

    //METHOD 1 - Add item name and price
    public void addItem()
    {
        Scanner scanner = new Scanner(System.in);

        // Get item name and price from the user
        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        addItem(name, price, 1, 0);
    }

    //METHOD 2 - Add item name, price, and quantity
    public void addItemWithQuantity()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();

        addItem(name, price, quantity, 0);
    }

    //METHOD 3 - Add item name, price, quantity, and discount
    public void addItemWithDiscount()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();
        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter item quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter discount percentage: ");
        double discount = scanner.nextDouble();

        addItem(name, price, quantity, discount);
    }

    //Main method that accepts all variables
    public void addItem(String name, double price, int quantity, double discount)
    {
        Item newItem = new Item(name, price, quantity, discount);
        cart.add(newItem);
        System.out.println("Item added: " + newItem);
    }

    //View items in the cart
    public void viewCart()
    {
        //Check if cart is empty
        if (cart.isEmpty())
        {
            System.out.println("The cart is empty.");
            return;
        }

        //If cart is not empty print the items
        System.out.println("Items in your cart:");
        for (Item item : cart)
        {
            System.out.println(item);
        }
    }

    //Calc the total cost of the items in the cart
    public double calculateTotal()
    {
        //Init new variable
        double total = 0;
        //Loop through the item list and add up
        for (Item item : cart)
        {
            total += item.getTotalPrice();
        }
        //Return the value
        return total;
    }
}

public class ShoppingCartSystem
{
    public static void main(String[] args)
    {
        ShoppingCart cart = new ShoppingCart();
        Scanner sc = new Scanner(System.in);
        int choice;

        //Simple switch for selecting the programs options
        do {
            //Print the menu
            System.out.println("\nShopping Cart Menu:");
            System.out.println("1. Add item (name and price)");
            System.out.println("2. Add item (name, price, and quantity)");
            System.out.println("3. Add item (name, price, quantity, and discount)");
            System.out.println("4. View cart");
            System.out.println("5. Calculate total");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    cart.addItem();
                    break;
                case 2:
                    cart.addItemWithQuantity();
                    break;
                case 3:
                    cart.addItemWithDiscount();
                    break;
                case 4:
                    cart.viewCart();
                    break;
                case 5:
                    double total = cart.calculateTotal();
                    System.out.printf("Total cost: $%.2f\n", total);
                    break;
                case 6:
                    System.out.println("Exiting the Shopping Cart System.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while(choice != 6);
    }
}
