public class MainDepartement {
    public static void main(String[] args) {
        DepartementHashSet gestion = new DepartementHashSet();

        Departement d1 = new Departement(2, "Informatique", 10);
        Departement d2 = new Departement(1, "Comptabilite", 5);
        Departement d3 = new Departement(3, "RH", 3);

        gestion.ajouterDepartement(d1);
        gestion.ajouterDepartement(d2);
        gestion.ajouterDepartement(d3);

        System.out.println("Liste départements (HashSet) :");
        gestion.displayDepartement();

        System.out.println("\nRecherche nom='Informatique' : " + gestion.rechercherDepartement("Informatique"));
        System.out.println("Recherche d2 (par objet) : " + gestion.rechercherDepartement(d2));

        System.out.println("\nTri par id (TreeSet) :");
        for (Departement d : gestion.trierDepartementById()) {
            System.out.println(d);
        }

        System.out.println("\nSuppression de d2 :");
        gestion.supprimerDepartement(d2);
        gestion.displayDepartement();
    }
}
