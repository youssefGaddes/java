import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class AffectationHashMap {
    private final HashMap<Employe, Departement> affectations = new HashMap<>();

    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d);
    }

    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation.");
            return;
        }
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && Objects.equals(affectations.get(e), d)) {
            affectations.remove(e);
        }
    }

    public void afficherEmployes() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun employé affecté.");
            return;
        }
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    public void afficherDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun département associé.");
            return;
        }
        HashSet<Departement> deps = new HashSet<>(affectations.values());
        for (Departement d : deps) {
            System.out.println(d);
        }
    }

    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> sorted = new TreeMap<>(Comparator.comparingInt(Employe::getId));
        sorted.putAll(affectations);
        return sorted;
    }
}
