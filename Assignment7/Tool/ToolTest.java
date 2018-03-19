package Assignment7.Tool;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ToolTest {

    @Test
    void setStrength() {

        Tool r = new Rock(5);
        assertEquals(5, r.strength);
        r.setStrength(4);
        assertEquals(4, r.strength);
    }
}