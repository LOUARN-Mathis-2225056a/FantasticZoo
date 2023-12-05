package model.enclosure;

import model.creature.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EnclosureTest {
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

    @Test
    void cannotAddDifferentCreaturesTypeInSameEnclosure(){
        Nymph n1 = new Nymph("nymp1",true,1,1,1);
        Lycanthrope l1 = new Lycanthrope("lycanthrope1",true,1,1,1);
        Enclosure e1 = new Enclosure("enclosure",10,5);
        e1.addCreature(n1);
        e1.addCreature(l1);
        assertEquals(1,e1.getNbCurrentCreature());
    }
    @Test
    void cannotAddNonCompatibleCreaturesTypeInEnclosure(){
        Nymph n1 = new Nymph("nymp1",true,1,1,1);
        Aquarium a1 = new Aquarium("aquarium 1",1,10,10,10);
        a1.addCreature(n1);
        assertEquals(0,a1.getNbCurrentCreature());
    }
    @Test
    void animalTypeSetToNullWhenNoMoreCreaturesAreIn(){
        Nymph n1 = new Nymph("nymp1",true,1,1,1);
        Enclosure e1 = new Enclosure("enclosure",10,5);
        e1.addCreature(n1);
        assertEquals(Nymph.class,e1.getAnimalType());
        e1.removeCreature(n1);
        assertEquals(null,e1.getAnimalType());
    }
}
