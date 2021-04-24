package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ForestTest {

    @AfterEach
    public void tearDown() {
        LittleRedRidingHood.cake = 10;
        Forest.playersOfTheTale = new ArrayList<>(Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász")));
    }

    @Test
    void testLittleRedRidingHoodEat() {

        assertEquals(10, LittleRedRidingHood.cake);

        LittleRedRidingHood littleRedRidingHood = new LittleRedRidingHood("Piroska");
        littleRedRidingHood.eat();

        assertEquals(9, LittleRedRidingHood.cake);

        littleRedRidingHood.eat();

        assertEquals(8, LittleRedRidingHood.cake);
    }

    @Test
    void testWolfEat() {
        List<Forest> playersAtTheBeginningOfTheTale = Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász"));

        assertEquals(playersAtTheBeginningOfTheTale, Forest.playersOfTheTale);

        Wolf wolf = new Wolf("Farkas");
        wolf.eat();
        List<Forest> playersAfterWolfCame = Arrays.asList(new Wolf("Farkas"), new Hunter("Vadász"));

        assertEquals(playersAfterWolfCame, Forest.playersOfTheTale);
    }

    @Test
    void testGrandmaEat() {

        assertEquals(10, LittleRedRidingHood.cake);

        Grandma grandma = new Grandma("Nagymama");
        grandma.eat();

        assertEquals(8, LittleRedRidingHood.cake);
    }

    @Test
    void testHunterEat() {
        List<Forest> playersAtTheBeginningOfTheTale = Arrays.asList(new LittleRedRidingHood("Piroska"), new Wolf("Farkas"), new Grandma("Nagymama"), new Hunter("Vadász"));

        assertEquals(playersAtTheBeginningOfTheTale, Forest.playersOfTheTale);
        assertEquals(10, LittleRedRidingHood.cake);

        Wolf wolf = new Wolf("Farkas");
        wolf.eat();
        List<Forest> playersAfterWolfCame = Arrays.asList(new Wolf("Farkas"), new Hunter("Vadász"));

        assertEquals(playersAfterWolfCame, Forest.playersOfTheTale);

        Hunter hunter = new Hunter("Vadász");
        hunter.eat();
        List<Forest> playersAtTheEndOfTheTale = Arrays.asList(new Hunter("Vadász"), new LittleRedRidingHood("Piroska"), new Grandma("Nagymama"));

        assertEquals(playersAtTheEndOfTheTale, Forest.playersOfTheTale);
        assertEquals(7, LittleRedRidingHood.cake);
    }

}