package MyPackage;
/**
 * Classe représentant un objet mouche
 */
public class Fly {
	
    private double mass;
    private double speed;
    private int x; //Position selon X
    private int y; // Position selon Y
    
    
    /**
     * Constructeur pour créer une mouche avec une masse et une vitesse spécifiées.
     * @param mass La masse de la mouche (double).
     * @param speed La vitesse de la mouche (double).
     */
    public Fly(double mass, double speed, int x, int y) {
        // Si mass et speed sont precises, on assigne les valeurs aux attributs de Fly
        this.mass = mass;
        this.speed = speed;
        this.setX(x);
        this.setY(y);
    }
    
    
    /**
     * Constructeur pour créer une mouche avec une masse spécifiée et une vitesse par défaut.
     * @param mass La masse de la mouche (double).
     */
    public Fly(double mass) {
        // Si seule la masse est précisée alors on assigne 10 par default à speed
        this(mass, 10, 0, 0);
    }
    
    public Fly(double mass, double speed) {
    	this.mass = mass;
        this.speed = speed;
    }
    
    /**
     * Constructeur pour créer une mouche avec des valeurs par défaut pour la masse et la vitesse.
     */
    public Fly(){
        // Si rien n'est précisé, on assigne 5 à la masse et 10 à speed
        this(5, 10, 0, 0);
    }

    // Getters definiton
    
    /**
     * Obtient la masse de la mouche.
     * @return La masse de la mouche (double).
     */
    public double getMass() {
        return this.mass;
    } 
    
    
    /**
     * Obtient la vitesse de la mouche.
     * @return La vitesse de la mouche (double).
     */
    public double getSpeed(){
        return this.speed;
    }
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }

    
    // Setters definiton
    /**
     * Modifie la vitesse de la mouche.
     * @param newSpeed La nouvelle vitesse de la mouche (double).
     */
    public void setSpeed(double newSpeed){
        this.speed = newSpeed;
    }
    
    
    /**
     * Modifie la masse de la mouche.
     * @param newMass La nouvelle masse de la mouche (double).
     */
    public void setMass(double newMass) {
        this.mass = newMass;
    }
    
    public void setX(int x) {
    	this.x = x;
    }
    
    public void setY(int y) {
    	this.y = y;
    }


    // Method definition
    /**
     * Renvoie une chaîne de caractères décrivant l'état de la mouche.
     * @return Description de l'état de la mouche (String).
     */
    public String toString(){

        // On affiche l'etat de la Fly selon la valeur de sa masse

        if (this.mass == 0){
            return "I am dead but I used to be a fly with a speed of " + Double.toString(this.speed)+". I am at position (" + this.getX() + ", " + this.getY()+").";
        } else {
            return "I am a speedy fly with "+Double.toString(this.speed) + " speed and " + Double.toString(this.mass)+ " mass"+". I am at position (" + this.getX() + ", " + this.getY()+").";
        }
    }
    
    
    /**
     * Fait grossir la mouche en augmentant sa masse et en ajustant sa vitesse en conséquence.
     * @param addMass La quantité à ajouter à la masse de la mouche (int).
     */
    public void grow(int addMass) {

        // On fait grossir la mouche de addMass unité de masse, on modifier la vitesse selon sa masse.

        for (int i=0; i<addMass; i++){
            this.mass++;
            if (this.mass<20){
                this.speed++;
            } else {
                this.speed = this.speed - 0.5;
            }
        }
    }
    
    
    /**
     * Vérifie si la mouche est morte.
     * @return true si la mouche est morte, sinon false (boolean).
     */
    public boolean isDead() {
        // On verifie la valeur de la masse de la Fly, si elle vaut 0 alors elle est considérée comme morte
        if (mass == 0) {
            return true;
        } else {
            return false;
        }
    }
}