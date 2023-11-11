package model.enclosure;

import model.creature.Kraken;
import model.creature.Phoenix;
import model.creature.Unicorn;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AbstractEnclosureTest {
    @Test
    void addCreatureIntoEnclosure() {
        Unicorn u1 = new Unicorn("a", true, 1, 1, 1);
        Enclosure e1 = new Enclosure("enclosure 1", 10, 1);
        e1.addCreature(u1);
        assertEquals(1, e1.getNbCurrentCreature());
    }

    @Test
    void cannotAddMoreCreatureThanMax() throws Exception {
        Kraken k1 = new Kraken("a", true, 1, 1, 1);
        Kraken k2 = new Kraken("a", true, 1, 1, 1);
        Aquarium a1 = new Aquarium("aquarium 1", 10, 1, 10, 10);
        a1.addCreature(k1);
        a1.addCreature(k2);
        assertEquals(1, a1.getNbCurrentCreature());
    }

    @Test
    void removeCreatureFromEnclosure() {
        Phoenix p1 = new Phoenix("a", true, 1, 1, 1);
        Aviary a1 = new Aviary("aviary 1", 10, 1, 1);
        a1.addCreature(p1);
        assertEquals(1, a1.getNbCurrentCreature());
        a1.removeCreature(p1);
        assertEquals(0,a1.getNbCurrentCreature());
    }

    @Test
    void cannotRemoveNonExistentCreature() {
        Phoenix p1 = new Phoenix("a", true, 1, 1, 1);
        Aviary a1 = new Aviary("aviary 1", 10, 1, 1);
        a1.removeCreature(p1);
        assertEquals(0, a1.getNbCurrentCreature());
    }
}
