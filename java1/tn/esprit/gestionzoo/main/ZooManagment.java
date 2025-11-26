package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Aquatic;
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Terrestrial;
import tn.esprit.gestionzoo.entities.Zoo;

public class ZooManagment {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("My Zoo", "Paris");
        System.out.println("Zoo créé : " + myZoo.getName() + ", ville : " + myZoo.getCity() + ", nombre de cages : " + Zoo.NBR_CAGES);

        Animal lion = new Animal("Felidae", "Lion", 5, true);
        try {
            myZoo.addAnimal(lion);
            System.out.println("Ajout du lion : succès");
        } catch (tn.esprit.gestionzoo.entities.ZooFullException e) {
            System.out.println("Ajout du lion : échec (zoo plein)");
        } catch (tn.esprit.gestionzoo.entities.InvalidAgeException e) {
            System.out.println("Ajout du lion : échec (âge invalide)");
        }
        System.out.println("Nombre d'animaux dans le zoo : " + myZoo.getAnimalCount());

        Animal lionCopy = new Animal("Felidae", "Lion", 5, true);
        try {
            myZoo.addAnimal(lionCopy);
            System.out.println("Ajout du lion identique : succès (déjà présent traité)");
        } catch (tn.esprit.gestionzoo.entities.ZooFullException e) {
            System.out.println("Ajout du lion identique : échec (zoo plein)");
        } catch (tn.esprit.gestionzoo.entities.InvalidAgeException e) {
            System.out.println("Ajout du lion identique : échec (âge invalide)");
        }
        System.out.println("Nombre d'animaux dans le zoo : " + myZoo.getAnimalCount());

        for (int i = 0; i < Zoo.NBR_CAGES - 2; i++) {
            Animal a = new Animal("TestFamily", "Animal" + i, i, true);
            try {
                myZoo.addAnimal(a);
                System.out.println("Ajout de Animal" + i + " : succès");
            } catch (tn.esprit.gestionzoo.entities.ZooFullException e) {
                System.out.println("Ajout de Animal" + i + " : échec (zoo plein)");
            } catch (tn.esprit.gestionzoo.entities.InvalidAgeException e) {
                System.out.println("Ajout de Animal" + i + " : échec (âge invalide)");
            }
            System.out.println("Nombre d'animaux dans le zoo : " + myZoo.getAnimalCount());
        }

        System.out.println("\nAffichage des animaux du zoo :");
        myZoo.displayAnimals();

        int indexLion = myZoo.searchAnimal(lion);
        System.out.println("\nRecherche du lion dans le zoo, index : " + indexLion);

        boolean removed = myZoo.removeAnimal(lion);
        System.out.println("Suppression du lion : " + (removed ? "succès" : "échec"));
        System.out.println("\nAnimaux après suppression :");
        myZoo.displayAnimals();

        System.out.println("\nAffichage via displayZoo():");
        myZoo.displayZoo();

        System.out.println("\nAffichage direct avec System.out.println(myZoo):");
        System.out.println(myZoo);
        System.out.println("Affichage direct avec System.out.println(myZoo.toString()):");
        System.out.println(myZoo.toString());

        System.out.println("\nAffichage direct avec System.out.println(lion):");
        System.out.println(lion);
        System.out.println("Affichage direct avec System.out.println(lion.toString()):");
        System.out.println(lion.toString());

        Zoo zooA = new Zoo("Zoo A", "Lyon");
        Zoo zooB = new Zoo("Zoo B", "Marseille");
        try {
            zooA.addAnimal(new Animal("Canidae", "Loup", 4, true));
        } catch (tn.esprit.gestionzoo.entities.ZooFullException | tn.esprit.gestionzoo.entities.InvalidAgeException e) {
            System.out.println("Erreur ajout Loup: " + e.getMessage());
        }
        try {
            zooA.addAnimal(new Animal("Ursidae", "Ours", 7, true));
        } catch (tn.esprit.gestionzoo.entities.ZooFullException | tn.esprit.gestionzoo.entities.InvalidAgeException e) {
            System.out.println("Erreur ajout Ours: " + e.getMessage());
        }
        try {
            zooB.addAnimal(new Animal("Felidae", "Tigre", 6, true));
        } catch (tn.esprit.gestionzoo.entities.ZooFullException | tn.esprit.gestionzoo.entities.InvalidAgeException e) {
            System.out.println("Erreur ajout Tigre: " + e.getMessage());
        }
        Zoo plusGrandZoo = Zoo.comparerZoo(zooA, zooB);
        System.out.println("\nLe zoo avec le plus d'animaux est : " + plusGrandZoo.getName() + " (" + plusGrandZoo.getCity() + ")");
    // --- Instructions 20-24: create instances of Aquatic/Terrestrial and subclasses
    // Default instances
    Terrestrial terrestrialDefault = new Terrestrial();
    Dolphin dolphinDefault = new Dolphin();
    Penguin penguinDefault = new Penguin();

    // Parameterized instances (Aquatic is abstract, use concrete subclasses)
    Terrestrial terrestrial = new Terrestrial("Insecta", "Ant", 1, false, 6);
    Dolphin dolphin = new Dolphin("Mammalia", "Flipper", 8, true, "Sea", 12.5f);
    Penguin penguin = new Penguin("Aves", "Pingu", 4, false, "Antarctica", 30.0f);

    // Add aquatic animals to zoo (addAquaticAnimal returns boolean)
    boolean ok;
    ok = myZoo.addAquaticAnimal(dolphin);
    System.out.println("Ajout dolphin : " + (ok ? "succès" : "échec"));
    System.out.println("Nombre d'animaux aquatiques : " + myZoo.getAquaticCount());
    ok = myZoo.addAquaticAnimal(penguin);
    System.out.println("Ajout penguin : " + (ok ? "succès" : "échec"));
    System.out.println("Nombre d'animaux aquatiques : " + myZoo.getAquaticCount());
    ok = myZoo.addAquaticAnimal(dolphinDefault);
    System.out.println("Ajout dolphinDefault : " + (ok ? "succès" : "échec"));
    System.out.println("Nombre d'animaux aquatiques : " + myZoo.getAquaticCount());
    ok = myZoo.addAquaticAnimal(penguinDefault);
    System.out.println("Ajout penguinDefault : " + (ok ? "succès" : "échec"));
    System.out.println("Nombre d'animaux aquatiques : " + myZoo.getAquaticCount());

    // Print objects
    System.out.println("\nInstances créées :");
    System.out.println(terrestrialDefault);
    System.out.println(dolphinDefault);
    System.out.println(penguinDefault);
    System.out.println(terrestrial);
    System.out.println(dolphin);
    System.out.println(penguin);

        // Call swim() on all aquatic animals stored in the zoo
        System.out.println("\nAppel de swim() pour tous les animaux aquatiques du zoo :");
        for (Aquatic a : myZoo.getAquaticAnimals()) {
            if (a != null) a.swim();
        }

        // Display max penguin swimming depth and counts by type
        float maxDepth = myZoo.maxPenguinSwimmingDepth();
        System.out.println("\nProfondeur maximale des pingouins : " + maxDepth);
        myZoo.displayNumberOfAquaticsByType();
    }
}
