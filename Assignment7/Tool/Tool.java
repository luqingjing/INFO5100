package Assignment7.Tool;

public class Tool {

    protected int strength;
    protected char type;

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

class Rock extends Tool {

    public Rock(int strength) {
        this.strength = strength;
        this.type = 'r';
    }

    public boolean fight(Tool t) {

        double factor = 1;
        if (t.getClass() == Scissors.class)
            factor *= 2;
        if (t.getClass() == Paper.class)
            factor /= 2;
        return this.strength * factor > t.strength;
    }

}

class Paper extends Tool {

    public Paper(int strength) {
        this.strength = strength;
        this.type = 'p';
    }

    public boolean fight(Tool t) {

        double factor = 1;
        if (t.getClass() == Rock.class)
            factor *= 2;
        if (t.getClass() == Scissors.class)
            factor /= 2;
        return this.strength * factor > t.strength;
    }
}

class Scissors extends Tool {

    public Scissors(int strength) {
        this.strength = strength;
        this.type = 's';
    }

    public boolean fight(Tool t) {

        double factor = 1;
        if (t.getClass() == Paper.class)
            factor *= 2;
        if (t.getClass() == Rock.class)
            factor /= 2;
        return this.strength * factor > t.strength;
    }
}

class RockPaperScissorsGame {

    public static void main(String args[]) {

        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+
                p.fight(s) );
        System.out.println(p.fight(r) + " , "+
                r.fight(p) );
        System.out.println(r.fight(s) + " , "+
                s.fight(r) );
    }
}
