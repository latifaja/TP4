import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // 1. Créer un HashMap pour stocker les notes des étudiants
        Map<String, Double> notes = new HashMap<>();

        // 2. Insérer des notes des étudiants
        notes.put("Alice", 15.5);
        notes.put("Bob", 18.0);
        notes.put("Charlie", 14.0);
        notes.put("David", 20.0);
        notes.put("Eve", 16.5);

        // Afficher la liste des notes après insertion
        System.out.println("Liste des notes après insertion:");
        afficherNotes(notes);

        // 3. Augmenter la note d'un étudiant (par exemple Bob)
        String etudiantAModifier = "Bob";
        if (notes.containsKey(etudiantAModifier)) {
            double nouvelleNote = notes.get(etudiantAModifier) + 2.0; // Augmenter la note de 2
            notes.put(etudiantAModifier, nouvelleNote);
            System.out.println("\nNote après augmentation de " + etudiantAModifier + ": " + nouvelleNote);
        }
        afficherNotes(notes);

        // 4. Supprimer la note d'un étudiant (par exemple Alice)
        String etudiantASupprimer = "Alice";
        if (notes.containsKey(etudiantASupprimer)) {
            notes.remove(etudiantASupprimer);
            System.out.println("\nNote de " + etudiantASupprimer + " supprimée.");
        }
        afficherNotes(notes);

        // 5. Afficher la taille du map
        System.out.println("\nLa taille du map est : " + notes.size());

        // 6. Afficher la note moyenne, max et min
        double somme = 0.0;
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        for (double note : notes.values()) {
            somme += note;
            if (note > max) max = note;
            if (note < min) min = note;
        }

        double moyenne = somme / notes.size();
        System.out.println("\nMoyenne des notes : " + moyenne);
        System.out.println("Note maximale : " + max);
        System.out.println("Note minimale : " + min);

        // 7. Vérifier s'il y a une note égale à 20
        boolean existeNote20 = notes.containsValue(20.0);
        System.out.println("\nY a-t-il une note égale à 20 ? " + (existeNote20 ? "Oui" : "Non"));

        // Afficher la liste des notes après toutes les opérations
        System.out.println("\nListe des notes après toutes les opérations:");
        afficherNotes(notes);
    }

    // Méthode pour afficher les notes des étudiants
    private static void afficherNotes(Map<String, Double> notes) {
        notes.forEach((nom, note) -> System.out.println(nom + ": " + note));
    }
}
