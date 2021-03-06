package hu.nive.ujratervezes.kepesitovizsga.snowwhite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnowWhiteTest {


    private List<Dwarf> sevenDwarfs;
    private SnowWhite snowWhite;

    @BeforeEach
    public void setUp() {
        sevenDwarfs = new ArrayList<>();
        sevenDwarfs.add(new Dwarf("Szende", 256));
        sevenDwarfs.add(new Dwarf("Szundi", 387));
        sevenDwarfs.add(new Dwarf("Morgó", 198));
        sevenDwarfs.add(new Dwarf("Hapci", 741));
        sevenDwarfs.add(new Dwarf("Tudor", 392));
        sevenDwarfs.add(new Dwarf("Vidor", 276));
        sevenDwarfs.add(new Dwarf("Kuka", 538));

        snowWhite = new SnowWhite(sevenDwarfs);
    }

    @Test
    void testGetSevenDwarfs() {
        List<Dwarf> expected = snowWhite.getSevenDwarfs();

        assertEquals(expected, sevenDwarfs);

        expected.add(new Dwarf("Sunyi", 654));

        assertNotEquals(expected, sevenDwarfs);
    }

    @Test
    void testGetSevenDwarfsOrderedByNames() {
        List<Dwarf> expected = snowWhite.getSevenDwarfsOrderedByNames();

        assertEquals("Hapci", expected.get(0).getName());
        assertEquals(392, expected.get(5).getAge());
    }

    @Test
    void testGetSevenDwarfsOrderedByAges() {
        List<Dwarf> expected = snowWhite.getSevenDwarfsOrderedByAges();

        assertEquals("Vidor", expected.get(2).getName());
        assertEquals(538, expected.get(5).getAge());
    }
}