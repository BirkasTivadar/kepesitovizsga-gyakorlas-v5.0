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

            fileProcess(result, reader);

        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
        return result;
    }

    private void fileProcess(Map<Character, Integer> result, BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine()) != null) {
            for (char c : line.toLowerCase().toCharArray()) {
                countCharacter(result, c);
            }
        }
    }

    private void countCharacter(Map<Character, Integer> result, char c) {
        if (Character.isLetter(c)) {
            if (!result.containsKey(c)) {
                result.put(c, 0);
            }
            result.put(c, result.get(c) + 1);
        }
    }

}
