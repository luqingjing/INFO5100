package Assignment6.DessertShoppe;

public class Checkout {

    private DessertItem[] items;
    private int numberOfItems = 0;

    public Checkout() { //Creates a Checkout instance with an empty list of DessertItem's

        items = new DessertItem[100];
    }

    public int numberOfItems() { //Returns the number of DessertItem's in the list

        return numberOfItems;
    }

    public void enterItem(DessertItem item) { //A DessertItem is added to the end of the list of items

        items[numberOfItems] = item;
        numberOfItems++;
    }

    public void clear() { //Clears the Checkout to begin checking out a new set of items

        items = new DessertItem[100];
        numberOfItems = 0;
    }

    public int totalCost() { //Returns total cost of items in cents (without tax)

        int cost = 0;
        for(int i = 0; i < numberOfItems; i++) {

            cost += items[i].getCost();
        }
        return cost;
    }

    public int totalTax() { //Returns total tax on items in cents

        return (int)Math.round(totalCost() * DessertShoppe.TAX_RATE / 100);
    }

    @Override
    public String toString() { //Returns a String representing a receipt for the current list of items

        String s = "";

        int width = DessertShoppe.MAX_ITEM_NAME_SIZE + DessertShoppe.COST_WIDTH;
        String leftColumn = "%-" + DessertShoppe.MAX_ITEM_NAME_SIZE + "s"; //"%-25s"
        String rightColumn = "%" + DessertShoppe.COST_WIDTH + "s"; //"%6s"

        String storeName = DessertShoppe.STORE_NAME;
        String dashes = "";
        for (int i = 0; i < storeName.length(); i++) {

            dashes += "-";
        }

        String space = "%" + ((width - storeName.length()) / 2 + 1) + "s"; //%(some int)s"
        s += String.format("%n%n" + space + "%s%n" + space + "%s%n%n", "", storeName, "", dashes);

        for (int i = 0; i < numberOfItems; i++) {

            String itemName = items[i].getName();
            String itemCost = DessertShoppe.cents2dollarsAndCents(items[i].getCost());

            if (items[i] instanceof Candy) {

                double candyWeight = ((Candy)items[i]).getWeight();
                String candyPrice = DessertShoppe.cents2dollarsAndCents(((Candy)items[i]).getPrice());
                s += String.format("%.2f lbs. @ %s /lb.%n",candyWeight,candyPrice);
            }

            if (items[i] instanceof Cookie) {

                int cookieNumber = ((Cookie)items[i]).getNumber();
                String cookiePrice = DessertShoppe.cents2dollarsAndCents(((Cookie)items[i]).getPrice());
                s += String.format("%d @ %s /dz.%n",cookieNumber,cookiePrice);
            }

            if (items[i] instanceof Sundae){
                String toppingName = ((Sundae)items[i]).getToppingName();
                s += String.format("%s Sundae with%n",toppingName);
            }

            s += String.format(leftColumn + rightColumn + "%n", itemName, itemCost);
        }

        s += String.format("%n" + leftColumn + rightColumn + "%n", "Tax", DessertShoppe.cents2dollarsAndCents(totalTax()));
        s += String.format(leftColumn + rightColumn + "%n%n", "Total Cost", DessertShoppe.cents2dollarsAndCents(totalCost() + totalTax()));
        return s;
    }
}
