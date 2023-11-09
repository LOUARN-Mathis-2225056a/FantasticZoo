package model.creature;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InterfaceTest {
    @Test
    public void InterfaceTest(){
        Mermaid m1 = new Mermaid("Mermaid",false,100,115,10);
        assertEquals(m1.creatureSwim(), "Mermaid is swimming !");
        Dragon d1 = new Dragon("Dragon",false,100000,500,20);
        assertEquals(d1.creatureRun(), "Dragon is running !");
        assertEquals(d1.creatureSwim(), "Dragon is swimming !");
        assertEquals(d1.creatureFly(), "Dragon is flying !");
    }
}
