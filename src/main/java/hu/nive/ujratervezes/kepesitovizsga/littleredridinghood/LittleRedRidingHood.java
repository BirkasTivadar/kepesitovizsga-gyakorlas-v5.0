package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

public class LittleRedRidingHood extends Forest {

    public static int cake = 10;

    public LittleRedRidingHood(String name) {
        super(name);
    }

    @Override
    void eat() {
        cake--;
    }
}
