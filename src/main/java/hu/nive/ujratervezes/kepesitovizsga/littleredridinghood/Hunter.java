package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.stream.Collectors;

public class Hunter extends Forest {

    public Hunter(String name) {
        super(name);
    }

    @Override
    void eat() {
        playersOfTheTale = playersOfTheTale.stream().filter(e -> !(e instanceof Wolf)).collect(Collectors.toList());
        playersOfTheTale.addAll(playersEated);
        LittleRedRidingHood.cake -= 3;
    }
}
