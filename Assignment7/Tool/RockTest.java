package Assignment7.Tool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RockTest {

    @Test
    void fight() {

        Rock r = new Rock(15);
        assertEquals(true,r.fight(new Scissors(5)));
        assertEquals(true,r.fight(new Paper(7)));
    }
}