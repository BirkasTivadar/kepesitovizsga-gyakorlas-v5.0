package hu.nive.ujratervezes.kepesitovizsga.sleepingbeauty;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SleepingBeauty {

    public Map<Character, Integer> countCharacters(String s) {
        Map<Character, Integer> result = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                SleepingBeauty.class.getResourceAsStream("/" + s)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (char c : line.toLowerCase().toCharArray()) {
                    if (Character.isLetter(c)) {
                        if (!result.containsKey(c)) {
                            result.put(c, 0);
                        }
                        result.put(c, result.get(c) + 1);
                    }
                }
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }


    public static void main(String[] args) {
        SleepingBeauty sleepingBeauty = new SleepingBeauty();

        String s = "hello, bibi Őrült hülye";
        Map<Character, Integer> letters = sleepingBeauty.countCharacters(s);
        System.out.println(letters);

    }
}
