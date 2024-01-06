package MyPackage;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;


/**
 * Classe représentant un étang où des grenouilles et des mouches interagissent.
 */
public class Pond {
	
	// On définit la taille de notre étang
	private static int taille_x = 505;
	private static int taille_y = 550;

	
	
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
	
	
	public static double distance(Frog frog, Fly fly) {
		int xFly = fly.getX();
		int yFly = fly.getY();
		int xFrog = frog.getX();
		int yFrog = frog.getY();
		
		double d = Math.sqrt((xFly - xFrog)^2 + (yFrog - yFly)^2);
		return d;
	}
	
	public static void move_all(int nbTour, ArrayList<Frog> Frog_array, ArrayList<Fly> Fly_array) {
		int dx, dy;
		int min = -1;
		int max = 1;
		for (int i=0; i<10000; i++) {
	    	for (int j=0; j<Frog_array.size(); j++) {
	    		Frog frog = Frog_array.get(j);
	    		dx = ThreadLocalRandom.current().nextInt(min, max + 1);
	    		dy = ThreadLocalRandom.current().nextInt(min, max + 1);
	    		
	    		frog.move(dx, dy);
	    	}
	    	
	    	// Et maintenant, on déplace les mouches
	    	for (int k=0; k<Fly_array.size(); k++) {
	    		Fly fly = Fly_array.get(k);
	    		dx = ThreadLocalRandom.current().nextInt(min, max + 1);
	    		dy = ThreadLocalRandom.current().nextInt(min, max + 1);
	    		int fly_x = fly.getX();
	    		int fly_y = fly.getY();
	    		int new_coordX = fly_x + dx;
	    		int new_coordY = fly_y + dy;
	    		if ((new_coordX > -taille_x || new_coordX < taille_x) && (new_coordY > -taille_y || new_coordY < taille_y )) {
	    			fly.move(dx, dy);
	    		}
	    	}
	    }
	}
	
	public static void main(String[] args) {
		
		// On créé nos Grenouilles ainsi que nos mouches
		
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 20);
        Frog peepaw = new Frog("Peepaw", 4.6, 20);
        Frog pierre = new Frog("Pierre", 5, 20);
        
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(10, 5);
        Fly fly4 = new Fly(10, 5);
        Fly fly5 = new Fly(10, 5);
        Fly fly6 = new Fly(10, 5);
        Fly fly7 = new Fly(10, 5);
        
        // On définit deux arrays dynamiques afin de stocker nos mouches et nos grenouilles
        
        ArrayList<Frog> Frog_array = new ArrayList<>();
        ArrayList<Fly> Fly_array = new ArrayList<>();
        
        Frog_array.add(pierre);
        Frog_array.add(peepaw);
        Frog_array.add(pepe);
        Frog_array.add(peepo);
        
        Fly_array.add(fly1);
        Fly_array.add(fly2);
        Fly_array.add(fly3);
        Fly_array.add(fly4);
        Fly_array.add(fly5);
        Fly_array.add(fly6);
        Fly_array.add(fly7);
        
        Frog.species = "1331 Frogs";
        
        // Initialisation 
        System.out.println("<---- Bienvenue dans l'étang !---->");
        int tour = 0;
        boolean res = false; // On init à une valeure quelconque
        double d;
        
        // ON disperse un peu tout le monde sur 100 déplacements
        
        Pond.move_all(10000, Frog_array, Fly_array);
        
        while (tour < 30) {
        	System.out.println("iter "+tour);
        	// On déplace les grenouilles
        	Pond.move_all(1, Frog_array, Fly_array);
        	
        	// Chaque grenouille doit déterminer les mouches à sa porter
        	
        	for (int i=0; i<Frog_array.size(); i++) {
        		Frog frog = Frog_array.get(i);
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
        	tour++;
        }
	}
}
