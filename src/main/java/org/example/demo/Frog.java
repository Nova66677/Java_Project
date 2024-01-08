/**
 * Définition de la classe Frog, qui servira à notre écosystème.
 * Nous y trouverons 3 constructeurs : 
 *  - Le premier prend 3 arguments : name (String), l'age en annee (double) ainsi que la vitesse de la langue (int)
 *  - Le deuxième prend 1 argument : name (String) et fixe l'age à 5 mois ainsi que la tongueSpeed à 5.
 *  - Le troisième prend 3 arguments : name (String), l'age en mois (int) ainsi que la vitesse de la langue (int)
 * 
 * Nous avons ensuite deux fonctions grow() : 
 *  - Une qui prend un parametre nbMonths (int) qui fera vieillir notre Frog de nbMonths mois
 *  - Une qui ne prend pas de paramètres et qui fera toujours vieillir notre Frog de 1 mois.
 * 
 * Nous avons la méthode eat(Fly fly) qui tente de manger l'objet mouche et qui fera vieillir la Frog 
 * Nous avons la méthode toString qui décrit l'état de la Frog selon son âge et donc si elle est 
 * dans le stade Froglet ou non. 
 * 
 * @author Chopin Eliott, Maisani Cyril, Deriu-Peraldi Joseph
 * @version 1.0
 */
package org.example.demo;


/**
 * Classe représentant un objet Frog
 */
public class Frog extends Animal {
	
	private double tongueSpeed;
    private boolean isFroglet;     // Booléen sur son état de froglet
    public static String species; // Son espèce
    private int portee;

    // definition des constructeurs 
    /**
     * Constructeur pour créer une grenouille avec un nom, un âge en années et une vitesse de la langue.
     * @param name Le nom de la grenouille (String).
     * @param ageInYears L'âge de la grenouille en années (double).
     * @param tongueSpeed La vitesse de la langue de la grenouille (int).
     */
    

    public Frog(String name, double ageInYears ,double tongueSpeed){ // Si 3 parametres spécifiées, alors on les assignes aux attributs
        this(name, 5, 0, 0, 50, (int)(12*ageInYears) , 10, tongueSpeed);
    }
    
    
    /**
     * Constructeur pour créer une grenouille avec un nom et des valeurs par défaut pour l'âge et la vitesse de la langue.
     * @param name Le nom de la grenouille (String).
     */
    public Frog(String name){
        this(name, 5, 0, 0, 50, 5, 10, 4); // Si 1 seule parametre spécifié (le nom), alors on assigne par défault 5 en age et en vitesse de langue . On place la Frog en (0,0)
    }
    
    
    /**
     * Constructeur pour créer une grenouille avec un nom, un âge en mois et une vitesse de la langue.
     * @param name Le nom de la grenouille (String).
     * @param age L'âge de la grenouille en mois (int).
     * @param tongueSpeed La vitesse de la langue de la grenouille (int).
     */
    public Frog(String name, double speed, int x, int y, int lifespanM, int ageM, int portee, double tongueSpeed) { // Si 3 parametres spécifiés avec un age en entier, on assigne les paramètres avec une conditions sur la vitesse de la langue
        super(name, speed, x, y, lifespanM, ageM);
        this.setPortee(portee);
        this.setAge(ageM); // Utilisation d'un setters afin de modifier isFroglet lorsque que this.age est modifie
        if (this.tongueSpeed < 5){
            this.tongueSpeed = tongueSpeed;
        } else {
            System.out.println("Tongue speed must be greater than or equal to 5 ! Setting age to 5...");
            this.setAge(5);
        }
        Frog.species = "Rare Pepe";
    }

    
    // Getters definiton

    /**
     * Obtient la vitesse de la langue de la grenouille.
     * @return La vitesse de la langue de la grenouille (double).
     */
    public double getTongueSpeed(){
        return this.tongueSpeed;
    }
    
    
    /**
     * Vérifie si la grenouille est dans l'état de froglet.
     * @return true si la grenouille est dans l'état de froglet, sinon false (boolean).
     */
    public boolean getisFroglet(){
        return this.isFroglet;
    }
    
    
    /**
     * Obtient l'espèce de la grenouille.
     * @return L'espèce de la grenouille (String).
     */
    public String getSpecies(){
        return species;
    }
    
    
    /**
     * Obtient la portée de la grenouille.
     * @return La portée de la grenouille (String).
     */
    public int getPortee() {
    	return this.portee;
    }

    // Setter definition
    
    
    /**
     * Modifie l'âge de la grenouille, ainsi que l'état de Froglet.
     * @param newAge Le nouvel âge de la grenouille en mois (int).
     */
    public void setAge(int newAge) {
        super.setAge(newAge);
        if (this.getAge() < 7 && this.getAge() > 1) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }
    }
    
    
    /**
     * Modifie la vitesse de la langue de la grenouille.
     * @param newSpeed La nouvelle vitesse de la langue de la grenouille (double).
     */
    public void setTongueSpeed(double newSpeed){
        this.tongueSpeed = newSpeed;
    }
    
    
    /**
     * Modifie l'état de froglet de la grenouille.
     * @param bool Le nouvel état de froglet de la grenouille (boolean).
     */
    public void setIsFroglet(boolean bool){
        this.isFroglet = bool;
    }
    
    
    /**
     * Modifie l'espèce de la grenouille.
     * @param newSpecies La nouvelle espèce de la grenouille (String).
     */
    public void setSpecies(String newSpecie){
        species = newSpecie;
    }
    
    /**
     * Modifie la portée de la grenouille.
     * @param portee La nouvelle portée de la grenouille (String).
     */
    public void setPortee(int portee) {
    	this.portee = portee;
    }
    
    // Method definition

    /**
     * Fait grandir la grenouille en fonction du nombre de mois spécifié.
     * Modifie la vitesse de la langue en fonction de son âge.
     * Il faut aussi baisser la portée de la Frog au fur et a mesure qu'elle vieillit
     * @param nbMonths Le nombre de mois pour faire vieillir la grenouille (int).
     */
    public void grow(int nbMonths) {
        for (int i=0; i<nbMonths; i++){ // On met à jour les caractéristiques de la frog à pour chaque mois
        	int age = this.getAge();
            if (age < 12){ // Si l'age est en dessous de 12 mois alors on incremente de 1 la vitesse de la langue
                this.tongueSpeed++;
                this.setAge(++age);

            } else if (age >=30 && this.tongueSpeed >=5) { // Si elle a moins de 30 mois et que sa vitesse de langue est inférieure à 5, on la décrémente de 1
                this.tongueSpeed--;
                this.setAge(age);

            } else { // On incrémente juste son age de 1 mois
                this.setAge(++age);
            }
            if ((age % 10) == 0) {  // On diminue la portée d'une unité tous les 10 ans
            	this.setPortee(this.getPortee()-1);
            }
        }
    }
    
    
/*
 * On appelle la methode grow en passant un 1 mois en paramètre
 */
    public void grow(){
        this.grow(1);
    }
    
    
    /**
     * Fait manger une mouche à la grenouille.
     * @param fly La mouche à manger (Fly).
     */
    public boolean eat(Fly fly) {
        if (!fly.isDead()) {
            // Si la fly est toujours vivante

            if (this.tongueSpeed > fly.getSpeed() && fly.getMass() >= 0.5*this.getAge()){ // Si la fly est attrapée
                this.grow(); // On gagne un mois
                fly.setMass(0); // On tue la mouche
                return true;

            } else { // Si la mouche n'est pas attrapée, elle grossit de 1 unité
                fly.grow(1);
            }
        }
        return false;
        // Si la fly est morte alors il ne passe rien 
    }    
    
    /**
     * Renvoie une chaîne de caractères décrivant l'état de la grenouille.
     * @return Description de l'état de la grenouille (String).
     */
    public String toString(){

        if (this.isFroglet) {
            return "My name is " + this.getName() + " and I am a rare Froglet ! I am " + this.getAge() + " months old and my tongue has a speed of " + this.tongueSpeed + "." + "I am in position (" + this.getX() + ", " + this.getY()+") !";
        } else {
            return "My name is " + this.getName() + " and I'm a rare frog. I'm "+ this.getAge() +" months old and my tongue has a speed of " + this.tongueSpeed + "."+ "I am in position (" + this.getX() + ", " + this.getY()+") !";
        }
    }

}
