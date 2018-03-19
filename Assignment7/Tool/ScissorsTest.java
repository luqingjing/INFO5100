package Assignment7.Tool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScissorsTest {

    @Test
    void fight() {

        Scissors s = new Scissors(5);
        assertEquals(true, s.fight(new Paper(7)));
        assertEquals(false, s.fight(new Rock(15)));
    }
}