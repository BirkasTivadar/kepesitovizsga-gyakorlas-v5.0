package hu.nive.ujratervezes.kepesitovizsga.snowwhite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SnowWhite {


    private List<Dwarf> sevenDwarfs;

    public SnowWhite(List<Dwarf> sevenDwarfs) {
        this.sevenDwarfs = new ArrayList<>(sevenDwarfs);
    }

    public List<Dwarf> getSevenDwarfs() {
        return new ArrayList<>(sevenDwarfs);
    }


    public List<Dwarf> getSevenDwarfsOrderedByNames() {
        List<Dwarf> result = new ArrayList<>(sevenDwarfs);
        Collections.sort(result, Comparator.comparing(Dwarf::getName));
        return result;
    }

    public List<Dwarf> getSevenDwarfsOrderedByAges() {
        List<Dwarf> result = new ArrayList<>(sevenDwarfs);
        Collections.sort(result, Comparator.comparing(Dwarf::getAge));
        return result;
    }
}
