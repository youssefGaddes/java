package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic {
    private final float swimmingDepth;

    public Penguin() {
        super();
        this.swimmingDepth = 0f;
    }

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() { return swimmingDepth; }
    @Override
    public String toString() {
        return "Penguin{" + "family='" + getFamily() + "', name='" + getName() + "', age=" + getAge() + ", habitat='" + getHabitat() + "', swimmingDepth=" + swimmingDepth + "}";
    }
    @Override
    public void swim() {
        System.out.println("This penguin is swimming.");
    }
}
