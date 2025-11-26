import java.util.Map;

public class Main {
	public static void main(String[] args) {
		// Gestion des employés
		SocieteArrayList societe = new SocieteArrayList();

		Employe e1 = new Employe(3, "Ben", "Ali", "Comptabilite", 2);
		Employe e2 = new Employe(1, "Zied", "Sami", "Informatique", 3);
		Employe e3 = new Employe(2, "Ben", "Noor", "Informatique", 1);
		Employe e4 = new Employe(4, "Amina", "Khaled", "RH", 2);

		societe.ajouterEmploye(e1);
		societe.ajouterEmploye(e2);
		societe.ajouterEmploye(e3);
		societe.ajouterEmploye(e4);

		System.out.println("Liste initiale :");
		societe.displayEmploye();

		// Recherche, tri et affichage
		System.out.println("\nRecherche nom='Ben' : " + societe.rechercherEmploye("Ben"));

		System.out.println("\nTri par id :");
		societe.trierEmployeParId();
		societe.displayEmploye();

		System.out.println("\nTri par nom, département et grade :");
		societe.trierEmployeParNomDépartementEtGrade();
		societe.displayEmploye();

		System.out.println("\nSuppression de e3 :");
		societe.supprimerEmploye(e3);
		societe.displayEmploye();

		// --- Affectation Employé -> Département (Map) ---
		System.out.println("\n--- Affectation HashMap demo ---");
		Departement d1 = new Departement(1, "Informatique", 10);
		Departement d2 = new Departement(2, "Comptabilite", 5);
		Departement d3 = new Departement(3, "RH", 3);

		AffectationHashMap aff = new AffectationHashMap();

		// Affectations initiales
		aff.ajouterEmployeDepartement(e1, d1);
		aff.ajouterEmployeDepartement(e2, d1);
		aff.ajouterEmployeDepartement(e3, d2);

		System.out.println("Affectations actuelles :");
		aff.afficherEmployesEtDepartements();

		// Ré-affecter e1 à un autre département (remplace la précédente affectation)
		System.out.println("\nRé-affectation de e1 vers 'Comptabilite' (remplace la valeur précédente) :");
		aff.ajouterEmployeDepartement(e1, d2);
		aff.afficherEmployesEtDepartements();
		System.out.println("Observation : la dernière affectation remplace l'ancienne pour la même clé (Employe).\n");

		// Supprimer un employé (par clé)
		System.out.println("Suppression de e2 (par employé) :");
		aff.supprimerEmploye(e2);
		aff.afficherEmployesEtDepartements();

		// Supprimer un employé seulement si il est dans un département donné
		System.out.println("\nRé-affectation de e2 à 'RH' puis suppression conditionnelle :");
		aff.ajouterEmployeDepartement(e2, d3);
		aff.afficherEmployesEtDepartements();
		System.out.println("Suppression de e2 uniquement si département = d3 :");
		aff.supprimerEmployeEtDepartement(e2, d3);
		aff.afficherEmployesEtDepartements();

		// Afficher listes séparées
		System.out.println("\nListe des employés affectés :");
		aff.afficherEmployes();

		System.out.println("\nListe des départements associés :");
		aff.afficherDepartements();

		// Recherches sur la map
		System.out.println("\nRechercher employé e1 dans la map : " + aff.rechercherEmploye(e1));
		System.out.println("Rechercher département d1 dans la map : " + aff.rechercherDepartement(d1));

		// Tri via TreeMap (par id d'employé)
		System.out.println("\nTri de la map selon l'identifiant des employés (TreeMap) :");
		for (Map.Entry<Employe, Departement> entry : aff.trierMap().entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
