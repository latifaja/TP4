import java.util.ArrayList;
import java.util.Scanner;

public class GestionProduitsApp {
    public static void main(String[] args) {
        ArrayList<Produit> prods = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Ajout initial de produits
        prods.add(new Produit(1, "Table", 100));
        prods.add(new Produit(2, "Chaise", 200));
        prods.add(new Produit(3, "Lampe", 300));
        prods.add(new Produit(4, "Bureau", 400));
        prods.add(new Produit(5, "Canapé", 500));

        // Suppression
        System.out.print("\nEntrez l'ID du produit à supprimer : ");
        int idToRemove = scanner.nextInt();
        boolean removed = prods.removeIf(p -> p.getId() == idToRemove);
        if (removed) {
            System.out.println("Produit supprimé.");
        } else {
            System.out.println("Aucun produit trouvé avec cet ID.");
        }

        // Affichage des produits
        afficherProduits(prods);

        // Modification
        System.out.print("\nEntrez l'ID du produit à modifier : ");
        int idMod = scanner.nextInt();
        scanner.nextLine();
        boolean produitModifie = false;
        for (Produit p : prods) {
            if (p.getId() == idMod) {
                System.out.print("\nEntrez le nouveau nom du produit : ");
                String nouveauNom = scanner.nextLine();
                System.out.print("\nEntrez le nouveau prix du produit : ");
                double nouveauPrix = scanner.nextDouble();
                p.setNom(nouveauNom);
                p.setPrix(nouveauPrix);
                produitModifie = true;
                System.out.println("Produit modifié.");
                break;
            }
        }
        if (!produitModifie) {
            System.out.println("Aucun produit trouvé avec cet ID.");
        }

        // Affichage des produits
        afficherProduits(prods);

        // Recherche
        scanner.nextLine(); // Consommer la ligne restante
        System.out.print("\nEntrez le nom du produit à rechercher : ");
        String nomRecherche = scanner.nextLine();
        boolean produitTrouve = false;
        for (Produit p : prods) {
            if (p.getNom().toLowerCase().contains(nomRecherche.toLowerCase())) {
                System.out.println("Produit trouvé : " + p);
                produitTrouve = true;
            }
        }
        if (!produitTrouve) {
            System.out.println("Aucun produit trouvé avec le nom donné.");
        }

        scanner.close();
    }

    // Méthode pour afficher les produits
    private static void afficherProduits(ArrayList<Produit> produits) {
        System.out.println("\nListe des produits :");
        produits.forEach(System.out::println);
    }
}
