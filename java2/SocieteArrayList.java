import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe> {
    private final List<Employe> employes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe t) {
        employes.add(t);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : employes) {
            if (e.getNom() != null && e.getNom().equals(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe t) {
        return employes.contains(t);
    }

    @Override
    public void supprimerEmploye(Employe t) {
        employes.remove(t);
    }

    @Override
    public void displayEmploye() {
        if (employes.isEmpty()) {
            System.out.println("Aucun employé.");
            return;
        }
        for (Employe e : employes) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(employes);
    }

    @Override
    public void trierEmployeParNomDépartementEtGrade() {
        Collections.sort(employes, Comparator.comparing(Employe::getNom, Comparator.nullsFirst(String::compareTo))
                .thenComparing(Employe::getNomDepartement, Comparator.nullsFirst(String::compareTo))
                .thenComparingInt(Employe::getGrade));
    }
}
