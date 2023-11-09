package model.creature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatureTest {
    Creature cr1 = new Creature("cr1",true,100,100,100,false,100,1);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void eat() {
        cr1.setHunger(50);
        cr1.eat();
        if (cr1.getHunger() != 60){
            fail("CR1 did not gain 10 food points");
        }
        cr1.setHunger(100);
        cr1.eat();
        if (cr1.getHunger() > 100){
            fail("CR1 at more than 100% food");
        }
    }

    @Test
    void emitSound() {
    }

    @Test
    void heal() {
        cr1.setHealth(100);
        cr1.heal();
        if (cr1.getHealth() > 100){
            fail("CR1 has more than 100% health");
        }
        cr1.setHealth(90);
        cr1.heal();
        if (cr1.getHealth() != 100){
            fail("CR1 did not gain 10 health points");
        }

    }

    @Test
    void wake() {
        cr1.setSleep(true);
        cr1.wake();
        if (cr1.isSleep()){
            fail("CR1 should not sleep");
        }
        cr1.setSleep(false);
        cr1.wake();
        if (cr1.isSleep()){
            fail("CR1 should not sleep");
        }
    }

    @Test
    void sleep() {
        cr1.setSleep(true);
        cr1.sleep();
        if (!cr1.isSleep()){
            fail("CR1 should sleep");
        }
        cr1.setSleep(false);
        cr1.sleep();
        if (!cr1.isSleep()){
            fail("CR1 should sleep");
        }
    }
}