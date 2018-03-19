package Assignment7.Tool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaperTest {

    @Test
    void fight() {

        Paper p = new Paper(7);
        assertEquals(false, p.fight(new Rock(15)));
        assertEquals(false, p.fight(new Scissors(5)));
    }
}