package hu.nive.ujratervezes.kepesitovizsga.cinderella;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cinderella {

    private int[] numbers = new int[5];

    public int[] getNumbers() {
        return numbers;
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Cinderella.class.getResourceAsStream("/cinderella/cinderella.txt")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                countWords(line);
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private void countWords(String line) {
        for (String s : line.split(" ")) {
            if (s.contains("Hamupipőke")) {
                numbers[0]++;
            }
            if (s.toLowerCase().contains("galamb")) {
                numbers[1]++;
            }
            if (s.toLowerCase().contains("királyfi")) {
                numbers[2]++;
            }
            if (s.toLowerCase().contains("mostoha")) {
                numbers[3]++;
            }
            if (s.toLowerCase().contains("cipő")) {
                numbers[4]++;
            }
        }
    }

    public Object[] getMax() {
        String[] temp = {"Hamupipőke", "galamb", "királyfi", "mostoha", "cipő"};
        int max = numbers[0];
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        Object[] result = {temp[maxIndex], numbers[maxIndex]};
        return result;
    }
}
