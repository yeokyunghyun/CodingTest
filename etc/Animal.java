package etc;

public class Animal {
    protected String name;
    private String species;

    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    private String getName() {
        return name;
    }

    private String getSpecies() {
        return species;
    }
}
