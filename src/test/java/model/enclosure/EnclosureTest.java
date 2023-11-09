package model.enclosure;

import model.creature.Kraken;
import model.creature.Unicorn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnclosureTest {
    @Test
    void addCreatureIntoEnclosure() throws Exception {
        Unicorn u1 = new Unicorn("a",true,1,1,1);
        Enclosure e1 = new Enclosure("enclosure 1",10,1);
        e1.addCreature(u1);
        assertEquals(e1.getNbCurrentCreature(),1);
    }
    @Test
    void cannotAddMoreCreatureThanMax() throws Exception {
        Kraken k1 = new Kraken("a",true,1,1,1);
        Kraken k2 = new Kraken("a",true,1,1,1);
        Aquarium a1 = new Aquarium("aquarium 1", 10,1,10,10);
        a1.addCreature(k1);
        a1.addCreature(k2);
        assertEquals(a1.getNbCurrentCreature(),1);
    }
}
