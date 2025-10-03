package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class ZooManagment {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo("My Zoo", "Paris");
        System.out.println("Zoo créé : " + myZoo.getName() + ", ville : " + myZoo.getCity() + ", nombre de cages : " + Zoo.NBR_CAGES);

        Animal lion = new Animal("Felidae", "Lion", 5, true);
        boolean addedLion = myZoo.addAnimal(lion);
        System.out.println("Ajout du lion : " + (addedLion ? "succès" : "échec"));

        Animal lionCopy = new Animal("Felidae", "Lion", 5, true);
        boolean addedLionCopy = myZoo.addAnimal(lionCopy);
        System.out.println("Ajout du lion identique : " + (addedLionCopy ? "succès" : "échec (déjà présent)"));

        for (int i = 0; i < Zoo.NBR_CAGES - 2; i++) {
            Animal a = new Animal("TestFamily", "Animal" + i, i, true);
            boolean added = myZoo.addAnimal(a);
            if (!added) {
                System.out.println("Ajout de Animal" + i + " : échec (zoo plein)");
            }
        }
        System.out.println("Le zoo est-il plein ? " + (myZoo.isZooFull() ? "Oui" : "Non"));

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
        zooA.addAnimal(new Animal("Canidae", "Loup", 4, true));
        zooA.addAnimal(new Animal("Ursidae", "Ours", 7, true));
        zooB.addAnimal(new Animal("Felidae", "Tigre", 6, true));
        Zoo plusGrandZoo = Zoo.comparerZoo(zooA, zooB);
        System.out.println("\nLe zoo avec le plus d'animaux est : " + plusGrandZoo.getName() + " (" + plusGrandZoo.getCity() + ")");
    }
}
