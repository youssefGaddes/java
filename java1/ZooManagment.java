

class Animal {
	private String family;
	String name;
	private int age;
	private boolean isMammal;

	public Animal(String family, String name, int age, boolean isMammal) {
		this.family = family;
		this.name = name;
		setAge(age);
		this.isMammal = isMammal;
		this.name = name;
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

class Zoo {
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
	public boolean isZooFull() {
		return animalCount >= NBR_CAGES;
	}
	public boolean removeAnimal(Animal animal) {
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] != null && animals[i].name.equals(animal.name)) {
				animals[i] = null;
				animalCount--;
				return true;
			}
		}
		return false;
	}
	public int searchAnimal(Animal animal) {
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] != null && animals[i].name.equals(animal.name)) {
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
	private Animal[] animals;
	private String name;
	private String city;
	public static final int NBR_CAGES = 25;

	public Zoo(String name, String city) {
		if (name == null || name.trim().isEmpty()) {
			this.name = "ZooSansNom";
		} else {
			this.name = name;
		}
		this.city = city;
		this.animals = new Animal[NBR_CAGES]; // max 25 animaux
		this.animalCount = 0;
	}

	private int animalCount;

	public String getName() { return name; }
	public String getCity() { return city; }
	public Animal[] getAnimals() { return animals; }
	public int getAnimalCount() { return animalCount; }

	public boolean addAnimal(Animal animal) {
		// Vérifier unicité
		for (int i = 0; i < animals.length; i++) {
			if (animals[i] != null && animals[i].name.equals(animal.name)) {
				return false; // animal déjà présent
			}
		}
		// Vérifier capacité avec isZooFull
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
	public void displayZoo() {
		System.out.println("Nom du zoo : " + getName());
		System.out.println("Ville : " + getCity());
		System.out.println("Nombre de cages : " + NBR_CAGES);
	}

	@Override
	public String toString() {
		return "Zoo: name='" + getName() + "', city='" + getCity() + "', nbrCages=" + NBR_CAGES + "";
	}
}






public class ZooManagment {
	public static void main(String[] args) {
		// Création du zoo principal
		Zoo myZoo = new Zoo("My Zoo", "Paris");
	System.out.println("Zoo créé : " + myZoo.getName() + ", ville : " + myZoo.getCity() + ", nombre de cages : " + Zoo.NBR_CAGES);

		// Ajout d'un animal unique
		Animal lion = new Animal("Felidae", "Lion", 5, true);
		boolean addedLion = myZoo.addAnimal(lion);
		System.out.println("Ajout du lion : " + (addedLion ? "succès" : "échec"));

		// Ajout d'un animal identique (doit échouer)
		Animal lionCopy = new Animal("Felidae", "Lion", 5, true);
		boolean addedLionCopy = myZoo.addAnimal(lionCopy);
		System.out.println("Ajout du lion identique : " + (addedLionCopy ? "succès" : "échec (déjà présent)"));

		// Ajout d'autres animaux jusqu'à dépassement
		for (int i = 0; i < Zoo.NBR_CAGES - 2; i++) {
			Animal a = new Animal("TestFamily", "Animal" + i, i, true);
			boolean added = myZoo.addAnimal(a);
			if (!added) {
				System.out.println("Ajout de Animal" + i + " : échec (zoo plein)");
			}
		}
		System.out.println("Le zoo est-il plein ? " + (myZoo.isZooFull() ? "Oui" : "Non"));

		// Affichage des animaux du zoo
		System.out.println("\nAffichage des animaux du zoo :");
		myZoo.displayAnimals();

		// Recherche d'un animal
		int indexLion = myZoo.searchAnimal(lion);
		System.out.println("\nRecherche du lion dans le zoo, index : " + indexLion);

		// Suppression d'un animal
		boolean removed = myZoo.removeAnimal(lion);
		System.out.println("Suppression du lion : " + (removed ? "succès" : "échec"));
		System.out.println("\nAnimaux après suppression :");
		myZoo.displayAnimals();

		// Affichage via displayZoo()
		System.out.println("\nAffichage via displayZoo():");
		myZoo.displayZoo();

		// Affichage direct
		System.out.println("\nAffichage direct avec System.out.println(myZoo):");
		System.out.println(myZoo);
		System.out.println("Affichage direct avec System.out.println(myZoo.toString()):");
		System.out.println(myZoo.toString());

		// Affichage direct pour Animal
		System.out.println("\nAffichage direct avec System.out.println(lion):");
		System.out.println(lion);
		System.out.println("Affichage direct avec System.out.println(lion.toString()):");
		System.out.println(lion.toString());

		// Exemple de comparaison de deux zoos
		Zoo zooA = new Zoo("Zoo A", "Lyon");
		Zoo zooB = new Zoo("Zoo B", "Marseille");
		zooA.addAnimal(new Animal("Canidae", "Loup", 4, true));
		zooA.addAnimal(new Animal("Ursidae", "Ours", 7, true));
		zooB.addAnimal(new Animal("Felidae", "Tigre", 6, true));
		Zoo plusGrandZoo = Zoo.comparerZoo(zooA, zooB);
	System.out.println("\nLe zoo avec le plus d'animaux est : " + plusGrandZoo.getName() + " (" + plusGrandZoo.getCity() + ")");
	}
// ...existing code...
}
