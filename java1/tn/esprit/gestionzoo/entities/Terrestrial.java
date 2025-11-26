package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal implements Omnivore<Food> {
    private int nbrLegs;

    public Terrestrial() {
        super();
        this.nbrLegs = 0;
    }

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() { return nbrLegs; }
    public void setNbrLegs(int nbrLegs) { this.nbrLegs = nbrLegs; }

    @Override
    public String toString() {
        return "Terrestrial{" + "family='" + getFamily() + "', name='" + getName() + "', age=" + getAge() + ", nbrLegs=" + nbrLegs + "}";
    }

    @Override
    public void eatMeat(Food meat) {
        String who = (getName() == null || getName().isEmpty()) ? "A terrestrial animal" : getName();
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(who + " eats meat (" + meat + ").");
        } else {
            System.out.println(who + " won't eat meat when offered: " + meat + ".");
        }
    }

    @Override
    public void eatPlant(Food plant) {
        String who = (getName() == null || getName().isEmpty()) ? "A terrestrial animal" : getName();
        if (plant == Food.PLANT || plant == Food.BOTH) {
            System.out.println(who + " eats plants (" + plant + ").");
        } else {
            System.out.println(who + " won't eat plants when offered: " + plant + ".");
        }
    }

    @Override
    public void eatPlantAndMeet(Food food) {
        String who = (getName() == null || getName().isEmpty()) ? "A terrestrial animal" : getName();
        switch (food) {
            case BOTH:
                System.out.println(who + " eats both plant and meat (" + food + ").");
                break;
            case MEAT:
                eatMeat(food);
                break;
            case PLANT:
                eatPlant(food);
                break;
            default:
                System.out.println(who + " doesn't recognize this food: " + food);
        }
    }
}
