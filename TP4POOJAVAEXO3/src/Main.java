import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // 1. Créer deux HashSets pour les groupes A et B
        Set<String> groupeA = new HashSet<>();
        Set<String> groupeB = new HashSet<>();

        // 2. Ajouter des noms des étudiants à chaque HashSet
        groupeA.add("Alice");
        groupeA.add("Bob");
        groupeA.add("Charlie");
        groupeA.add("David");

        groupeB.add("Charlie");
        groupeB.add("David");
        groupeB.add("Eve");
        groupeB.add("Frank");

        // Afficher les groupes
        System.out.println("Groupe A : " + groupeA);
        System.out.println("Groupe B : " + groupeB);

        // 3. Afficher l'intersection des deux HashSets
        Set<String> intersection = new HashSet<>(groupeA);
        intersection.retainAll(groupeB); // Conserve uniquement les éléments communs
        System.out.println("\nIntersection des groupes A et B : " + intersection);

        // 4. Afficher l'union des deux HashSets
        Set<String> union = new HashSet<>(groupeA);
        union.addAll(groupeB); // Ajoute tous les éléments du groupeB dans groupeA
        System.out.println("\nUnion des groupes A et B : " + union);
    }
}
