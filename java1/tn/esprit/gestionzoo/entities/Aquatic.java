package tn.esprit.gestionzoo.entities;

public abstract class Aquatic extends Animal {
    private final String habitat;

    public Aquatic() {
        super();
        this.habitat = "";
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = (habitat == null) ? "" : habitat;
    }

    public String getHabitat() { return habitat; }

    // force subclasses to implement swim()
    public abstract void swim();

    @Override
    public String toString() {
        return "Aquatic{" + "family='" + getFamily() + "', name='" + getName() + "', age=" + getAge() + ", habitat='" + habitat + "'}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Aquatic)) return false;
        Aquatic other = (Aquatic) o;
        // equal if same name, age and habitat
        return getAge() == other.getAge()
                && ((getName() == null && other.getName() == null) || (getName() != null && getName().equals(other.getName())))
                && ((getHabitat() == null && other.getHabitat() == null) || (getHabitat() != null && getHabitat().equals(other.getHabitat())));
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (getName() == null ? 0 : getName().hashCode());
        result = 31 * result + getAge();
        result = 31 * result + (getHabitat() == null ? 0 : getHabitat().hashCode());
        return result;
    }
}
