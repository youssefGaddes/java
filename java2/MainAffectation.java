public class MainAffectation {
    public static void main(String[] args) {
        System.out.println("--- Affectation HashMap demo (fichier dédié) ---");

        Employe e1 = new Employe(3, "Ben", "Ali", "Comptabilite", 2);
        Employe e2 = new Employe(1, "Zied", "Sami", "Informatique", 3);
        Employe e3 = new Employe(2, "Ben", "Noor", "Informatique", 1);

        Departement d1 = new Departement(1, "Informatique", 10);
        Departement d2 = new Departement(2, "Comptabilite", 5);

        AffectationHashMap aff = new AffectationHashMap();

        aff.ajouterEmployeDepartement(e1, d1);
        aff.ajouterEmployeDepartement(e2, d1);
        aff.ajouterEmployeDepartement(e3, d2);

        // Ré-affecter e1 à un autre département (remplace l'ancienne valeur)
        aff.ajouterEmployeDepartement(e1, d2);

        System.out.println("Affichages (employé -> département) :");
        aff.afficherEmployesEtDepartements();

        System.out.println("\nObservation : la seconde affectation de e1 remplace la première car la clé (employé) est unique dans la map.");

        System.out.println("\nTri via TreeMap :");
        aff.trierMap().forEach((emp, dep) -> System.out.println(emp + " -> " + dep));
    }
}
