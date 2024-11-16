import java.util.*;
import java.util.stream.*;

public class Main {
    static class Employe {
        String nom;
        String departement;
        double salaire;

        public Employe(String nom, String departement, double salaire) {
            this.nom = nom;
            this.departement = departement;
            this.salaire = salaire;
        }

        @Override
        public String toString() {
            return nom + " (" + departement + ") - Salaire: " + salaire;
        }

        public String getNom() {
            return nom;
        }

        public double getSalaire() {
            return salaire;
        }
    }

    public static void main(String[] args) {
        List<Employe> employes = Arrays.asList(
                new Employe("Ahmad", "Informatique", 4500),
                new Employe("Badr", "Marketing", 3500),
                new Employe("haytam", "Informatique", 5500),
                new Employe("Driss", "Ressources humaines", 4000),
                new Employe("Eliass", "Marketing", 3800)
        );

        // 1. Utiliser mapToDouble et sum pour calculer la somme totale des salaires.
        double totalSalaire = employes.stream()
                .mapToDouble(Employe::getSalaire)
                .sum();
        System.out.println("Somme totale des salaires : " + totalSalaire);

        // 2. Utiliser sorted pour trier la liste des employés par ordre alphabétique du nom.
        List<Employe> employesTries = employes.stream()
                .sorted(Comparator.comparing(Employe::getNom))
                .collect(Collectors.toList());
        System.out.println("\nListe triée des employés :");
        employesTries.forEach(System.out::println);

        // 3. Utiliser min pour trouver l'employé avec le salaire le plus bas.
        Employe employeMin = employes.stream()
                .min(Comparator.comparingDouble(Employe::getSalaire))
                .orElseThrow(() -> new NoSuchElementException("Aucun employé trouvé"));
        System.out.println("\nEmployé avec le salaire le plus bas : " + employeMin);

        // 4. Utiliser filter pour obtenir la liste des employés ayant un salaire supérieur à 4000.
        List<Employe> employesFiltres = employes.stream()
                .filter(e -> e.getSalaire() > 4000)
                .collect(Collectors.toList());
        System.out.println("\nEmployés ayant un salaire > 4000 :");
        employesFiltres.forEach(System.out::println);

        // 5. Utiliser reduce pour trouver l'employé avec le salaire le plus élevé.
        Employe employeMax = employes.stream()
                .reduce((e1, e2) -> e1.getSalaire() > e2.getSalaire() ? e1 : e2)
                .orElseThrow(() -> new NoSuchElementException("Aucun employé trouvé"));
        System.out.println("\nEmployé avec le salaire le plus élevé : " + employeMax);

        // 6. Utiliser reduce pour concaténer les noms de tous les employés.
        String nomsConcates = employes.stream()
                .map(Employe::getNom)
                .reduce((nom1, nom2) -> nom1 + ", " + nom2)
                .orElse("Aucun employé");
        System.out.println("\nNoms des employés concaténés : " + nomsConcates);
    }
}
