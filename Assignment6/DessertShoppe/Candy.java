package Assignment6.DessertShoppe;

public class Candy extends DessertItem {

    private double weight;
    private int price;

    public Candy(String name, double weight, int price) {

        super(name);
        this.weight = weight;
        this.price = price;
    }

    public int getCost() {

        int cost = (int)Math.round(price * weight);
        return cost;
    }

    public double getWeight() {

        return weight;
    }

    public int getPrice() {

        return price;
    }
}
