import java.util.Map;

public class MainClean {
    public static void main(String[] args) {
        // Gestion des employés
        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(3, "Ben", "Ali", "Comptabilite", 2);
        Employe e2 = new Employe(1, "Zied", "Sami", "Informatique", 3);
        Employe e3 = new Employe(2, "Ben", "Noor", "Informatique", 1);

        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);

        System.out.println("Liste initiale :");
        societe.displayEmploye();

        // Affectations (Map)
        System.out.println("\n--- Affectation HashMap demo ---");
        Departement d1 = new Departement(1, "Informatique", 10);
        Departement d2 = new Departement(2, "Comptabilite", 5);

        AffectationHashMap aff = new AffectationHashMap();
        aff.ajouterEmployeDepartement(e1, d1);
        aff.ajouterEmployeDepartement(e2, d1);
        aff.ajouterEmployeDepartement(e3, d2);

        System.out.println("Affectations actuelles :");
        aff.afficherEmployesEtDepartements();

        System.out.println("\nRé-affectation de e1 vers 'Comptabilite' (remplace la valeur précédente) :");
        aff.ajouterEmployeDepartement(e1, d2);
        aff.afficherEmployesEtDepartements();

        System.out.println("\nTri de la map selon l'identifiant des employés (TreeMap) :");
        for (Map.Entry<Employe, Departement> entry : aff.trierMap().entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
