package hu.nive.ujratervezes.kepesitovizsga.sleepingbeauty;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SleepingBeautyTest {

    @Test
    public void countCharacters() {
        Map<Character, Integer> letters = new SleepingBeauty().countCharacters("sleepingbeauty.txt");

        assertEquals(32, letters.size());
        assertEquals(113, letters.get('f'));
        assertEquals(522, letters.get('o'));
        assertEquals(30, letters.get('ú'));
        assertNull(letters.get('.'));
        assertNull(letters.get('1'));
    }

}