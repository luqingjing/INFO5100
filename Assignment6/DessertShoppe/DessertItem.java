package Assignment6.DessertShoppe;

public abstract class DessertItem {

    protected String name;

    public DessertItem() { //Null constructor for DessertItem class

    }

    public DessertItem (String name) { //Initializes DessertItem data

        if (name.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE)
            this.name = name;
        else
            this.name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
    }

    public final String getName() { //Returns name of DessertItem

        return name;
    }

    public abstract int getCost(); //Returns cost of DessertItem
}
