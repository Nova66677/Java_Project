package MyPackage;


/**
 * Classe abstraite représentant un animal générique.
 */
abstract public class Animal {
	
	private String name;
	private int age;
	private double speed; 
	private int x;
	private int y;
	private int lifespan;
	private boolean dead;
	
	
    /**
     * Constructeur pour initialiser les propriétés de l'animal.
     *
     * @param name     Le nom de l'animal (String).
     * @param speed    La vitesse de l'animal (double).
     * @param x        La coordonnée x de l'animal (int).
     * @param y        La coordonnée y de l'animal (int).
     * @param lifespan La durée de vie de l'animal (int).
     * @param age      L'âge actuel de l'animal (int).
     */
	public Animal(String name, double speed, int x, int y, int lifespan, int age ) {
		
		this.name = name;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.lifespan = lifespan;
		this.age = age;
		this.dead = false;
	}
	
	
    /**
     * Obtient le nom de l'Animal
     * @return Le nom de l'Animal(String).
     */
	public String getName() {
		return this.name;
	}
	
	
	 /**
     * Obtient l'âge de l'Animal en mois.
     * @return L'âge de l'Animal en mois (int).
     */
	public int getAge() {
		return age;
	}
	
	
    /**
     * Modifie l'âge de l'animal.
     *
     * @param age Le nouvel âge de l'animal en mois (int).
     */
	public void setAge(int age) {
		this.age = age;
		if (this.getAge() == this.lifespan) {
			this.dead = true;
		}
	}
	
	
    /**
     * Obtient la vitesse de la mouche.
     * @return La vitesse de la mouche (double).
     */
	public double getSpeed() {
		return speed;
	}
	
	
    // Setters definiton
    /**
     * Modifie la vitesse de l'Animal.
     * @param newSpeed La nouvelle vitesse de l'Animal (double).
     */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
    /**
     * Obtient la coordonnée x de l'animal.
     *
     * @return La coordonnée x de l'animal (int).
     */
	public int getX() {
		return x;
	}
	
	
    /**
     * Modifie la coordonnée x de l'animal.
     *
     * @param x La nouvelle coordonnée x de l'animal (int).
     */
	public void setX(int x) {
		this.x = x;
	}
	
	
    /**
     * Obtient la coordonnée y de l'animal.
     *
     * @return La coordonnée y de l'animal (int).
     */
	public int getY() {
		return this.y;
	}
	
	
    /**
     * Modifie la coordonnée y de l'animal.
     *
     * @param y La nouvelle coordonnée y de l'animal (int).
     */
	public void setY(int y) {
		this.y = y;
	}
	
	
    /**
     * Obtient la durée de vie de l'animal.
     *
     * @return La durée de vie de l'animal (int).
     */
	public int getLifespan() {
		return lifespan;
	}

	
	// Definition des méthodes 
	
    /**
     * Déplace l'animal selon les coordonnées fournies.
     *
     * @param nbX Le déplacement en x (int).
     * @param nbY Le déplacement en y (int).
     */
	public void move(int nbX, int nbY) {
		if (!this.isDead()) { 
			this.setX(this.getX() + nbX);
			this.setY(this.getY() + nbY);
		}
	}
	
	public void gettingOlder() {
		this.setAge(this.getAge()+1);
	}
	
    /**
     * Vérifie si l'animal est mort en comparant son âge à sa durée de vie.
     *
     * @return true si l'animal est mort, sinon false (boolean).
     */
	public boolean isDead() {
		if (this.lifespan <= this.age) {
			this.dead = true;
		}
		return this.dead;
	}
	
	public String getPosition() {
		return "("+ Integer.toString(this.getX()) + ", " + Integer.toString(this.getY());
 	}
	
	
    /**
     * Méthode abstraite pour décrire l'état de l'animal.
     *
     * @return Description de l'état de l'animal (String).
     */
	abstract public String toString(); // Méthode abstraite
	
}
