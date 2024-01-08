package org.example.demo;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;
import java.util.ArrayList;


/**
 * Classe représentant un étang où des grenouilles et des mouches interagissent.
 */
public class Pond {
	
	// On définit la taille de notre étang
	private static int taille_x = 1000;
	private static int taille_y = 667;

	
	
	/*
	 * Déroulement de la simulation :
	 * les mouches se déplacent à chaque pas de temps
	 * Les grenouilles se déplacent tous les 20 pas de temps si elle n'ont rien mangé,
	 * ou dès qu'elle ont attrapé une mouche
	 * 
	 * A chaque pas de temps, toutes les grenouilles regardent les mouches à leur portée et tentent de les attraper
	 * Si une grenouille attrape une mouche, elle ne s'occupe plus des autres pendant 20 pas de temps.
	 * 
	 */
	
	
	
    /**
     * Crée une grenouille avec des caractéristiques aléatoires.
     * 
     * @param nbFrog    Le numéro de la grenouille (int).
     * @param limite_x  La limite en x pour la position aléatoire (int).
     * @param limite_y  La limite en y pour la position aléatoire (int).
     * @return La grenouille créée avec des caractéristiques aléatoires (Frog).
     */
	public static Frog createFrog(int nbFrog, int limite_x, int limite_y) {
		int speed = 3;
    	int limInfPortee = 1;
    	int limSupPortee = 5;
    	int limInfAge = 1;
    	int limSupAge = 5;
    	int limInfTS = 2;
    	int limSupTS = 5;
    	int Lifespan = 12; // En réalité, c'est en moyenne 12 semaines mais on va dire 12 mois sinon la simulation sera trop court
    	int x = ThreadLocalRandom.current().nextInt(0, limite_x + 1);
		int y = ThreadLocalRandom.current().nextInt(0, limite_y + 1);
		int age = ThreadLocalRandom.current().nextInt(limInfAge, limSupAge + 1);
		int portee = ThreadLocalRandom.current().nextInt(limInfPortee, limSupPortee + 1);
		int tongueSpeed = ThreadLocalRandom.current().nextInt(limInfTS, limSupTS + 1);
		Frog frog = new Frog(Integer.toString(nbFrog), speed, x, y, Lifespan, age, portee, tongueSpeed);
		
		return frog;
	}
	
	
    /**
     * Génère une liste de grenouilles avec des caractéristiques aléatoires.
     * 
     * @param nbFrog    Le nombre de grenouilles à générer (int).
     * @param limite_x  La limite en x pour la position aléatoire (int).
     * @param limite_y  La limite en y pour la position aléatoire (int).
     * @return La liste des grenouilles générées (ArrayList<Frog>).
     */
	public static ArrayList<Frog> generateFrog(int nbFrog, int limite_x, int limite_y) {
		ArrayList<Frog> array_frog = new ArrayList<>();
		for (int i=0; i<nbFrog; i++) {
			array_frog.add(createFrog(i, limite_x, limite_y));
		}
		return array_frog;
	}
	
	
    /**
     * Crée une mouche avec des caractéristiques aléatoires.
     * 
     * @param nbFly     Le numéro de la mouche (int).
     * @param limite_x  La limite en x pour la position aléatoire (int).
     * @param limite_y  La limite en y pour la position aléatoire (int).
     * @return La mouche créée avec des caractéristiques aléatoires (Fly).
     */
	public static Fly createFly(int nbFly, int limite_x, int limite_y) {
		
		int speed = 2; // Une mouche est moins rapide qu'une grenouille 
    	int limInfAge = 1;
    	int limSupAge = 5;
    	int Lifespan = 10; // En réalité, c'est en moyenne 12 semaines mais on va dire 12 mois sinon la simulation sera trop court
    	int x = ThreadLocalRandom.current().nextInt(0, limite_x + 1);
		int y = ThreadLocalRandom.current().nextInt(0, limite_y + 1);
		int age = ThreadLocalRandom.current().nextInt(limInfAge, limSupAge + 1);
		int mass = 1;
		Fly fly = new Fly(Integer.toString(nbFly), speed, x, y, Lifespan, age, mass);
		
		return fly;
	}
	
	
    /**
     * Génère une liste de mouches avec des caractéristiques aléatoires.
     * 
     * @param nbFly     Le nombre de mouches à générer (int).
     * @param limite_x  La limite en x pour la position aléatoire (int).
     * @param limite_y  La limite en y pour la position aléatoire (int).
     * @return La liste des mouches générées (ArrayList<Fly>).
     */
	public static ArrayList<Fly> generateFly(int nbFly, int limite_x, int limite_y) {
		ArrayList<Fly> array_fly = new ArrayList<>();
		for (int i=0; i<nbFly; i++) {
			array_fly.add(createFly(i, limite_x, limite_y));
		}
		return array_fly;
	}
	
	
    /**
     * Calcule la distance entre une grenouille et une mouche.
     * 
     * @param frog La grenouille (Frog).
     * @param fly  La mouche (Fly).
     * @return La distance entre la grenouille et la mouche (double).
     */
	public static double distance(Frog frog, Fly fly) {
		int xFly = fly.getX();
		int yFly = fly.getY();
		int xFrog = frog.getX();
		int yFrog = frog.getY();
		
		double d = Math.sqrt(Math.pow(xFly - xFrog, 2) + Math.pow(yFrog - yFly, 2));
		return d;
	}
	
	
    /**
     * Déplace toutes les grenouilles et toutes les mouches pour un certain nombre de tours.
     * 
     * @param nbTour      Le nombre de tours de déplacement (int).
     * @param Frog_array  La liste des grenouilles (ArrayList<Frog>).
     * @param Fly_array   La liste des mouches (ArrayList<Fly>).
     */
	public static void move_all(int nbTour, ArrayList<Frog> Frog_array, ArrayList<Fly> Fly_array) {
		int dx, dy;     // Déplacement des Frogs lors de ce tour
		int min = -1;  // Ces deux variables servent pour le deplacement des mouches
		int max = 1;
		for (int i=0; i<nbTour; i++) {
	    	for (int j=0; j<Frog_array.size(); j++) {
	    		Frog frog = Frog_array.get(j);
	    		dx = ThreadLocalRandom.current().nextInt(-(int)frog.getSpeed(), (int)frog.getSpeed() + 1) * 10;
	    		dy = ThreadLocalRandom.current().nextInt(-(int)frog.getSpeed(), (int)frog.getSpeed() + 1) * 10;
	    		int frog_x = frog.getX();
	    		int frog_y = frog.getY();
	    		int new_coordX = frog_x + dx;
	    		int new_coordY = frog_y + dy;
	    		if ((new_coordX >= -taille_x && new_coordX <= taille_x) && (new_coordY >= -taille_y && new_coordY <= taille_y )) {
	    			frog.move(dx, dy);
	    		}
	    	}
	    	
	    	// Et maintenant, on déplace les mouches
	    	for (int k=0; k<Fly_array.size(); k++) {
	    		Fly fly = Fly_array.get(k);
	    		dx = ThreadLocalRandom.current().nextInt(min, max + 1) * 10;
	    		dy = ThreadLocalRandom.current().nextInt(min, max + 1) * 10;
	    		int fly_x = fly.getX();
	    		int fly_y = fly.getY();
	    		int new_coordX = fly_x + dx;
	    		int new_coordY = fly_y + dy;
	    		if ((new_coordX >= -taille_x && new_coordX <= taille_x) && (new_coordY >= -taille_y && new_coordY <= taille_y )) {
	    			fly.move(dx, dy);
	    		}
	    	}
	    }
	}
	
	public static void main(String[] args) {
		
		// On créé nos Grenouilles ainsi que nos mouches
	
        
        // On définit deux arrays dynamiques afin de stocker nos mouches et nos grenouilles
        
        ArrayList<Frog> Frog_array = new ArrayList<>();
        ArrayList<Fly> Fly_array = new ArrayList<>();
        
        // On créé deux autres tableaux pour y stocker des les mouches et les grenouilles mortes 
        ArrayList<Frog> Dead_Frog_array = new ArrayList<>();
        ArrayList<Fly> Dead_Fly_array = new ArrayList<>();
        
        
        int nb_frog = 0;
        int nb_fly = 0;
        Scanner myInput = new Scanner(System.in);  // On créé notre input
        // Initialisation 
        while (nb_frog == 0 && nb_fly == 0) {
	        try {
		        System.out.println("<---- Bienvenue dans l'étang !---->");
		        System.out.println("Please enter the desired number of frogs : ");
		        
		        
		        nb_frog = Integer.valueOf(myInput.nextLine());
		        System.out.println("Please enter the desired number of fly : ");
		        nb_fly = Integer.valueOf(myInput.nextLine());
	        } catch (NumberFormatException e) {
	        	System.out.println("Vous devez entrer un entier !");
	        }
        }
        Fly_array = Pond.generateFly(nb_fly, taille_y, taille_x);
        Frog_array = Pond.generateFrog(nb_frog, taille_y, taille_x);
        
        
        Frog.species = "1331 Frogs";
        
        int tour = 0;
        boolean res = false; // On init à une valeure quelconque
        double d;
        
        // ON disperse un peu tout le monde sur 100 déplacements
        
        Pond.move_all(10000, Frog_array, Fly_array);
        
        System.out.println("Enter 'start' to start the simulation");
        String test = myInput.nextLine();
        while (!test.equals("start")){
        	System.out.println("Enter 'start' to start the simulation");
            test = myInput.nextLine();
            System.out.println(test);
        }
        myInput.close(); // On ferme notre Scanner que l'on n'utilisera plus
        System.out.println("<--- Starting simulation--->");
        
        while (tour < 30) {
        	System.out.println("iter " + tour);
        	// On déplace les grenouilles
        	Pond.move_all(1, Frog_array, Fly_array);
        	
        	// Chaque grenouille doit déterminer les mouches à sa porter
        	
        	for (int i=0; i<Frog_array.size(); i++) {
        		Frog frog = Frog_array.get(i);
        		// System.out.println("Je suis Frog " + i + ", position " + frog.getPosition());
        		for (int j=0; j<Fly_array.size(); j++) {
        			Fly fly = Fly_array.get(j);
        			d = Pond.distance(frog, fly);
        			if (d < frog.getPortee()) {
        				res = frog.eat(fly);
        				if (res) {
        					System.out.println("Une mouche a été mangée");
        					break;
        				}
        			}
        		}
        	}
        	
        	// On vieillis nos Animaux avec leur méthode gettingOlder()
            for (int i=0; i<Frog_array.size(); i++) {
            	Frog frog = Frog_array.get(i);
            	frog.gettingOlder();
            	if (frog.isDead() && !Dead_Frog_array.contains(frog) ) {
            		Dead_Frog_array.add(frog);
            		System.out.println("Moi, " + frog.getName() + ", je viens de m'éteindre.");
            	}
            }
            for (int i=0; i<Fly_array.size(); i++) {
            	Fly fly = Fly_array.get(i);
            	fly.gettingOlder();
            	if (fly.isDead() && !Dead_Fly_array.contains(fly) ) {
            		Dead_Fly_array.add(fly);
            		System.out.println("Moi, " + fly.getName() + ", je viens de m'éteindre.");
            	}
            }
            
        	tour++; // On n'oublie pas d'incrémenter notre tour
        }
        
        // A la fin de la simulation, on affiche l'état de nos Animaux
        
        for (int i=0; i<Frog_array.size(); i++) {
        	Frog frog = Frog_array.get(i);
        	System.out.println(frog.toString());
        }
        for (int i=0; i<Fly_array.size(); i++) {
        	Fly fly = Fly_array.get(i);
        	System.out.println(fly.toString());
        }
	}
}
