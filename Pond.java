package MyPackage;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;


/**
 * Classe représentant un étang où des grenouilles et des mouches interagissent.
 */
public class Pond {
	
	// On définit la taille de notre étang
	private int taille_x = 10;
	private int taille_y = 10;
	
	
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
	
	public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 20);
        Frog peepaw = new Frog("Peepaw", 4.6, 20);
        Frog pierre = new Frog("Pierre", 5, 20);
        
        Fly fly1 = new Fly(1, 3);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(10, 5);
        
        ArrayList<Frog> Frog_array = new ArrayList<>();
        ArrayList<Fly> Fly_array = new ArrayList<>();
        
        Frog_array.add(pierre);
        Frog_array.add(peepaw);
        Frog_array.add(pepe);
        Frog_array.add(peepo);
        
        Fly_array.add(fly1);
        Fly_array.add(fly2);
        Fly_array.add(fly3);
        
        Frog.species = "1331 Frogs";
        
        // Initialisation 
        System.out.println("<---- Bienvenue dans l'étang !---->");
        int tour = 0;
        int dx, dy;
        int min = -1;
        int max = 1;
        boolean res = false; // On init à une valeure quelconque
        double d;
        while (tour < 50) {
        	System.out.println("iter "+tour);
        	// On déplace les grenouilles
        	for (int i=0; i<Frog_array.size(); i++) {
        		Frog frog = Frog_array.get(i);
        		dx = ThreadLocalRandom.current().nextInt(min, max + 1);
        		dy = ThreadLocalRandom.current().nextInt(min, max + 1);
        		
        		frog.move(dx, dy);
        	}
        	
        	// Et maintenant, on déplace les mouches
        	for (int i=0; i<Fly_array.size(); i++) {
        		Fly fly = Fly_array.get(i);
        		dx = ThreadLocalRandom.current().nextInt(min, max + 1);
        		dy = ThreadLocalRandom.current().nextInt(min, max + 1);
        		
        		fly.move(dx, dy);
        	}
        	
        	// Chaque grenouille doit déterminer les mouches à sa porter
        	
        	for (int i=0; i<Frog_array.size(); i++) {
        		Frog frog = Frog_array.get(i);
        		for (int j=0; i<Fly_array.size(); i++) {
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
