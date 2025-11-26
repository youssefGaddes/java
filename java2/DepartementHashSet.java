import java.util.HashSet;
import java.util.TreeSet;

public class DepartementHashSet implements IDepartement<Departement> {
    private final HashSet<Departement> departements = new HashSet<>();

    @Override
    public void ajouterDepartement(Departement t) {
        departements.add(t);
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (Departement d : departements) {
            if (d.getNomDepartement() != null && d.getNomDepartement().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement t) {
        return departements.contains(t);
    }

    @Override
    public void supprimerDepartement(Departement t) {
        departements.remove(t);
    }

    @Override
    public void displayDepartement() {
        if (departements.isEmpty()) {
            System.out.println("Aucun département.");
            return;
        }
        for (Departement d : departements) {
            System.out.println(d);
        }
    }

    @Override
    public TreeSet<Departement> trierDepartementById() {
        TreeSet<Departement> sorted = new TreeSet<>();
        sorted.addAll(departements);
        return sorted;
    }
}
