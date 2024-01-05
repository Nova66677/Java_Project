package MyPackage;

abstract public class Animal {
	
	private String name;
	private int age;
	private double speed; 
	private int x;
	private int y;
	private int lifespan;
	private int health;
	private boolean dead;
	
	public Animal(String name, double speed, int x, int y, int lifespan, int age, int health ) {
		this.name = name;
		this.speed = speed;
		this.x = x;
		this.y = y;
		this.lifespan = lifespan;
		this.age = age;
		this.dead = false;
		this.health = health;
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
	public void setAge(int age) {
		this.age = age;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getLifespan() {
		return lifespan;
	}

	
	// Definition des méthodes 
	
	public void move(int nbX, int nbY) {
		this.setX(this.getX() + nbX);
		this.setY(this.getY() + nbY);
	}
	
	public boolean isDead() {
		if (this.lifespan < this.age || this.health <= 0) {
			this.dead = true;
		}
		return this.dead;
	}
	
	public String toString(); // Méthode abstraite
	
}
