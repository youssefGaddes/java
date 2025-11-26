package tn.esprit.gestionzoo.entities;

public class Zoo {
    private final Animal[] animals;
    private final String name;
    private final String city;
    public static final int NBR_CAGES = 25;
    private int animalCount;
    // aquatic animals collection (up to 10)
    private final Aquatic[] aquaticAnimals = new Aquatic[10];
    private int aquaticCount = 0;

    public Zoo(String name, String city) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "ZooSansNom";
        } else {
            this.name = name;
        }
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
        this.animalCount = 0;
    }

    public String getName() { return name; }
    public String getCity() { return city; }
    public Animal[] getAnimals() { return animals; }
    public int getAnimalCount() { return animalCount; }
    public Aquatic[] getAquaticAnimals() { return aquaticAnimals; }
    public int getAquaticCount() { return aquaticCount; }

    public boolean addAnimal(Animal animal) {
        for (Animal animal1 : animals) {
            if (animal1 != null && animal1.getName().equals(animal.getName())) {
                return false;
            }
        }
        if (isZooFull()) {
            return false;
        }
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                animalCount++;
                return true;
            }
        }
        return false;
    }

    public boolean addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) return false;
        // check uniqueness based on Aquatic.equals
        for (Aquatic existing : aquaticAnimals) {
            if (existing != null && existing.equals(aquatic)) {
                return false;
            }
        }
        // check capacity
        if (aquaticCount >= aquaticAnimals.length) return false;
        for (int i = 0; i < aquaticAnimals.length; i++) {
            if (aquaticAnimals[i] == null) {
                aquaticAnimals[i] = aquatic;
                aquaticCount++;
                return true;
            }
        }
        return false;
    }

    public float maxPenguinSwimmingDepth() {
        float max = 0f;
        for (Aquatic a : aquaticAnimals) {
            if (a instanceof Penguin) {
                Penguin p = (Penguin) a;
                if (p.getSwimmingDepth() > max) max = p.getSwimmingDepth();
            }
        }
        return max;
    }

    public void displayNumberOfAquaticsByType() {
        int dolphins = 0, penguins = 0;
        for (Aquatic a : aquaticAnimals) {
            if (a instanceof Dolphin) dolphins++;
            else if (a instanceof Penguin) penguins++;
        }
        System.out.println("Dolphins: " + dolphins + ", Penguins: " + penguins);
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }

    public boolean removeAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                animals[i] = null;
                animalCount--;
                return true;
            }
        }
        return false;
    }

    public int searchAnimal(Animal animal) {
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].getName().equals(animal.getName())) {
                return i;
            }
        }
        return -1;
    }

    public void displayAnimals() {
        System.out.println("Animaux du zoo :");
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                System.out.println("  [" + i + "] " + animals[i]);
            }
        }
    }

    public void displayZoo() {
        System.out.println("Nom du zoo : " + getName());
        System.out.println("Ville : " + getCity());
        System.out.println("Nombre de cages : " + NBR_CAGES);
    }

    @Override
    public String toString() {
        return "Zoo: name='" + getName() + "', city='" + getCity() + "', nbrCages=" + NBR_CAGES + "";
    }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        int count1 = 0, count2 = 0;
        for (Animal a : z1.animals) {
            if (a != null) count1++;
        }
        for (Animal a : z2.animals) {
            if (a != null) count2++;
        }
        return (count1 >= count2) ? z1 : z2;
    }
}
