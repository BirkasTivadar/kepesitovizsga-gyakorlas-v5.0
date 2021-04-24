package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.stream.Collectors;

public class Wolf extends Forest {

    public Wolf(String name) {
        super(name);
    }

    @Override
    void eat() {
        playersEated = playersOfTheTale.stream().filter(e -> e instanceof LittleRedRidingHood || e instanceof Grandma).collect(Collectors.toList());
        playersOfTheTale = playersOfTheTale.stream().filter(e -> !(e instanceof LittleRedRidingHood || e instanceof Grandma)).collect(Collectors.toList());
    }
}
