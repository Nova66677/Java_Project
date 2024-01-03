package MyPackage;
/**
 * Classe représentant un étang où des grenouilles et des mouches interagissent.
 */
public class Pond {
	
    /**
     * Méthode principale représentant le fonctionnement de l'étang avec des grenouilles et des mouches.
     * @param args Les arguments en ligne de commande (String[]).
     */
    public static void main(String[] args){

        // On définit nos 4 frogs 
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog pierre = new Frog("Pierre", 5, 20);

        //Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        //Fly fly3 = new Fly(10, 5);

        Frog.species = "1331 Frogs";

        System.out.println(peepo.toString());

        peepo.eat(fly2);

        System.out.println(fly2.toString());

        peepo.grow(8);

        peepo.eat(fly2);

        System.out.println(fly2.toString());
        System.out.println(peepo.toString());
        System.out.println(pierre.toString());

        peepaw.grow(4);

        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}