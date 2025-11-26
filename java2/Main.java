public class Main {
    public static void main(String[] args) {
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

        System.out.println("\nRecherche d'employés nom='Ben' : " + societe.rechercherEmploye("Ben"));
        System.out.println("Recherche de e2 (par objet) : " + societe.rechercherEmploye(e2));

        System.out.println("\nTri par id :");
        societe.trierEmployeParId();
        societe.displayEmploye();

        System.out.println("\nTri par nom, département et grade :");
        societe.trierEmployeParNomDépartementEtGrade();
        societe.displayEmploye();

        System.out.println("\nSuppression de e3 :");
        societe.supprimerEmploye(e3);
        societe.displayEmploye();
    }
}
