package Assignment6.DessertShoppe;

public class Cookie extends DessertItem {

    private int number;
    private int price;

    public Cookie(String name, int number, int price) {

        super(name);
        this.number = number;
        this.price = price;
    }

    public int getCost() {

        int cost = (int)Math.round(number * price / 12);
        return cost;
    }

    public int getNumber() {

        return number;
    }

    public int getPrice() {

        return price;
    }
}
