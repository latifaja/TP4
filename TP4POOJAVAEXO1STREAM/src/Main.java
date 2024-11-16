import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        List<String> mots = Arrays.asList("apple", "banana", "grape", "kiwi", "orange", "melon");

        // 1. Filtrer les mots qui contiennent la lettre "a".
        List<String> motsAvecA = mots.stream()
                .filter(mot -> mot.contains("a"))
                .collect(Collectors.toList());
        System.out.println("Mots contenant la lettre 'a' : " + motsAvecA);

        // 2. Filtrer les mots avec longueur supérieure à 3 et inverser chaque mot.
        List<String> motsLongsInverses = mots.stream()
                .filter(mot -> mot.length() > 3)
                .map(mot -> new StringBuilder(mot).reverse().toString())
                .collect(Collectors.toList());
        System.out.println("Mots avec longueur > 3 et inversés : " + motsLongsInverses);

        // 3. Filtrer les mots qui contiennent "e" et aplatir chaque mot en liste de caractères.
        List<Character> caracteres = mots.stream()
                .filter(mot -> mot.contains("e"))
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Liste aplatie des caractères des mots contenant 'e' : " + caracteres);

        // 4. Transformer chaque mot en majuscules.
        List<String> motsMajuscules = mots.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Mots en majuscules : " + motsMajuscules);

        // 5. Convertir chaque mot en sa longueur.
        List<Integer> longueurs = mots.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println("Longueur de chaque mot : " + longueurs);

        // 6. Transformer chaque mot en liste de ses caractères, puis aplatir toutes les listes.
        List<Character> tousCaracteres = mots.stream()
                .flatMap(mot -> mot.chars().mapToObj(c -> (char) c))
                .collect(Collectors.toList());
        System.out.println("Liste aplatie de tous les caractères : " + tousCaracteres);

        // 7. Transformer chaque mot en "Nom - Index".
        List<String> motsAvecIndex = IntStream.range(0, mots.size())
                .mapToObj(i -> mots.get(i) + " - " + i)
                .collect(Collectors.toList());
        System.out.println("Mots avec index : " + motsAvecIndex);
    }
}
