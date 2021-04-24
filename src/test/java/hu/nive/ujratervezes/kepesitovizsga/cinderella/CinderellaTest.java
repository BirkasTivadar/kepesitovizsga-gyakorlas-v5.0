package hu.nive.ujratervezes.kepesitovizsga.cinderella;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CinderellaTest {

    private Cinderella cinderella;

    @BeforeEach
    public void setUp() {
        cinderella = new Cinderella();
        cinderella.readFromFile();
    }

    @Test
    void readFromFile() {
        assertEquals(12, cinderella.getNumbers()[1]);
        assertEquals(22, cinderella.getNumbers()[3]);
    }

    @Test
    void getMax() {
        Object[] expected = cinderella.getMax();

        assertEquals("Hamupipőke", expected[0]);
        assertEquals(32, expected[1]);
    }

}