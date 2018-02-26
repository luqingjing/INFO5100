package Assignment6.DessertShoppe;

public class Sundae extends IceCream {

    private String toppingName;
    private int toppingCost;

    public Sundae(String name, int cost, String toppingName, int toppingCost) {

        super(name,cost);
        this.toppingName = toppingName;
        this.toppingCost = toppingCost;
    }

    @Override
    public int getCost() {
        return (super.getCost() + toppingCost);
    }

    public String getToppingName() {
        return toppingName;
    }
}
