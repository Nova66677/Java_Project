package org.example.demo;
/**
 * Classe représentant un objet mouche
 */
public class Fly extends Animal{
	
    private double mass;
    
    /**
     * Constructeur pour créer une mouche avec une masse et une vitesse spécifiées.
     * @param mass La masse de la mouche (double).
     * @param speed La vitesse de la mouche (double).
     */
    public Fly(String name, double speed, int x, int y, int lifespan, int age, double mass) {
        // Si mass et speed sont precises, on assigne les valeurs aux attributs de Fly
    	super(name, speed, x, y , lifespan, age);
        this.mass = mass;
    }
    
    
    /**
     * Constructeur pour créer une mouche avec une masse spécifiée et une vitesse par défaut.
     * @param mass La masse de la mouche (double).
     */
    public Fly(double mass) {
        // Si seule la masse est précisée alors on assigne 10 par default à speed
        this("Cyril", 4, 0, 0, 15, 5, mass);
    }
    
    public Fly(double mass, double speed) {
    	// Si les coordonnées ne sont pas renseignées alors on les assigne à (0,0)
    	this("Cyril", speed, 0, 0, 15, 5, mass);
    }
    
    
    /**
     * Constructeur pour créer une mouche avec des valeurs par défaut pour la masse et la vitesse.
     */
    public Fly(){
        // Si rien n'est précisé, on assigne 5 à la masse et 10 à speed
        this("Cyril", 4, 0, 0, 15, 5, 1);
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
     * Modifie la masse de la mouche.
     * @param newMass La nouvelle masse de la mouche (double).
     */
    public void setMass(double newMass) {
        this.mass = newMass;
    }


    // Method definition
    /**
     * Renvoie une chaîne de caractères décrivant l'état de la mouche.
     * @return Description de l'état de la mouche (String).
     */
    public String toString(){

        // On affiche l'etat de la Fly selon la valeur de sa masse

        if (this.mass == 0){
            return "I am dead but I used to be a fly with a speed of " + Double.toString(this.getSpeed())+". I am at position (" + this.getX() + ", " + this.getY()+").";
        } else {
            return "I am a speedy fly with "+Double.toString(this.getSpeed()) + " speed and " + Double.toString(this.mass)+ " mass"+". I am at position (" + this.getX() + ", " + this.getY()+").";
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
            double speed = this.getSpeed();
            if (this.mass<20){
            	this.setSpeed(++speed);
            } else {
                this.setSpeed(speed - 0.5);
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
