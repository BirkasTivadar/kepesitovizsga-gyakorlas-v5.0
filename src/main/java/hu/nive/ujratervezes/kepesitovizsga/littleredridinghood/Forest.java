package hu.nive.ujratervezes.kepesitovizsga.littleredridinghood;

import java.util.List;
import java.util.Objects;

public abstract class Forest {

    private String name;

    public static List<Forest> playersOfTheTale;

    public static List<Forest> playersEated;

    Forest(String name) {
        this.name = name;
    }

    abstract void eat();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Forest forest = (Forest) o;
        return Objects.equals(name, forest.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
