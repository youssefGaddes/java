package tn.esprit.gestionzoo.entities;

public class Animal {
    private final String family;
    private String name;
    private int age;
    private final boolean isMammal;

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = (family == null) ? "" : family;
        this.name = (name == null) ? "" : name;
        // store age as given; validation on add will be handled by Zoo
        this.age = age;
        this.isMammal = isMammal;
    }

    // Default constructor needed for subclass default constructors
    public Animal() {
        this.family = "";
        this.name = "";
        this.age = 0;
        this.isMammal = false;
    }

    public String getFamily() { return family; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public boolean isMammal() { return isMammal; }

    public void setAge(int age) {
        if (age < 0) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Animal: family='" + family + "', name='" + name + "', age=" + age + ", isMammal=" + isMammal + "";
    }
}
