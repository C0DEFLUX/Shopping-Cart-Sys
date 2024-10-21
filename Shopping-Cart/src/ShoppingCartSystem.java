import java.util.ArrayList;
import java.util.List;

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

    //Calc the total price item with discount
    public double getTotalPrice()
    {
        double effectivePrice = price * (1 - discount / 100);
        return effectivePrice * quantity;
    }

    @Override
    //Format the list
    public String toString()
    {
        //Format the list using the .format() function.
        return String.format("Item: %s, Price: %.2f, Quantity: %d, Discount: %.2f%%", name, price, quantity, discount);
    }
}

class ShoppingCart
{
    //List capable of holding multiple Item objects.
    private List<Item> cart;

    //Constructor
    public ShoppingCart()
    {
        //Dynamic array to avoid shifting items in a standard array
        cart = new ArrayList<>();
    }

    //METHOD 1 - Add item with name and price
    public void addItem(String name, double price)
    {
        addItem(name, price, 1, 0);
    }

    //METHOD 2 - Add item with name, price, quantity
    public void addItem(String name, double price, int quantity)
    {
        addItem(name, price, quantity, 0);
    }

    //METHOD 3 - Add item with name, price, quantity, discount
    public void addItem(String name, double price, int quantity, double discount)
    {
        //Make newItem class
        Item newItem = new Item(name, price, quantity, discount);
        //Add the items to it
        cart.add(newItem);
        //Print the added item
        System.out.println("Item added: " + newItem);
    }

    //View cart method
    public void viewCart() {
        //Check if cart is empty then exit method
        if (cart.isEmpty()) {
            System.out.println("The cart is empty.");
            return;
        }
        //If cart has items print them
        System.out.println("Items in your cart:");
        for (Item item : cart)
        {
            System.out.println(item);
        }
    }

    //Calc the total price item with discount
    public double calculateTotal()
    {
        //Init variable
        double total = 0;
        //Go thru cart
        for (Item item : cart)
        {
            //Add up everything
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
        //Adding items using different overloaded methods

        //METHOD 1
        cart.addItem("BMW", 30000);
        //METHOD 2
        cart.addItem("Mercedes-Benz", 35000, 10);
        //METHOD 3
        cart.addItem("Audi", 20000, 5, 50);

        //Show cart
        cart.viewCart();

        //Set a total in a variable
        double total = cart.calculateTotal();
        //Print the total
        System.out.printf("Total cost: $%.2f\n", total);
    }
}
