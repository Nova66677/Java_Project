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
package MyPackage;
/**
 * Classe représentant un objet Frog
 */
public class Frog {
    private String name; // Le nom de la frog
    private int age; // son age 
    private double tongueSpeed; // vitesse de la langue
    private boolean isFroglet; // booleen sur son etat de froglet
    public static String species; // son espèce
    private int x; //Position selon X
    private int y; // Position selon Y
    private int portee;

    // definition des constructeurs 
    /**
     * Constructeur pour créer une grenouille avec un nom, un âge en années et une vitesse de la langue.
     * @param name Le nom de la grenouille (String).
     * @param ageInYears L'âge de la grenouille en années (double).
     * @param tongueSpeed La vitesse de la langue de la grenouille (int).
     */
    public Frog(String name, double ageInYears ,double tongueSpeed){ // Si 3 parametres spécifiées, alors on les assignes aux attributs
        this(name, (int)(12*ageInYears) , tongueSpeed, 0, 0, 5);
    }
    
    
    /**
     * Constructeur pour créer une grenouille avec un nom et des valeurs par défaut pour l'âge et la vitesse de la langue.
     * @param name Le nom de la grenouille (String).
     */
    public Frog(String name){
        this(name, 5, 5, 0, 0, 5); // Si 1 seule parametre spécifié (le nom), alors on assigne par défault 5 en age et en vitesse de langue . On place la Frog en (0,0)
    }
    
    
    /**
     * Constructeur pour créer une grenouille avec un nom, un âge en mois et une vitesse de la langue.
     * @param name Le nom de la grenouille (String).
     * @param age L'âge de la grenouille en mois (int).
     * @param tongueSpeed La vitesse de la langue de la grenouille (int).
     */
    public Frog(String name, int age ,double tongueSpeed, int x, int y, int portee) { // Si 3 parametres spécifiés avec un age en entier, on assigne les paramètres avec une conditions sur la vitesse de la langue
        this.name = name;
        this.setPortee(portee);
        this.setX(x);
        this.setY(y);
        this.setAge(age); // Utilisation d'un setters afin de modifier isFroglet lorsque que this.age est modifie
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
     * Obtient le nom de la grenouille.
     * @return Le nom de la grenouille (String).
     */
    public String getName() { 
        return this.name;
    }
    
    
    /**
     * Obtient l'âge de la grenouille en mois.
     * @return L'âge de la grenouille en mois (int).
     */
    public int getAge(){
        return this.age;
    }
    
    
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
    
    public int getX() {
    	return this.x;
    }
    
    public int getY() {
    	return this.y;
    }
    
    public int getPortee() {
    	return this.portee;
    }

    // Setter definition
    
    /**
     * Modifie le nom de la grenouille.
     * @param newName Le nouveau nom de la grenouille (String).
     */
    public void setName(String newName){
        this.name = newName;
    } 
    
    
    /**
     * Modifie l'âge de la grenouille.
     * @param newAge Le nouvel âge de la grenouille en mois (int).
     */
    public void setAge(int newAge) {
        this.age = newAge;
        if (this.age < 7 && this.age > 1) {
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
    
    public void setX(int x) {
    	this.x = x;
    }
    
    public void setY(int y) {
    	this.y = y;
    }

    public void setPortee(int portee) {
    	this.portee = portee;
    }
    // Method definition

    /**
     * Fait grandir la grenouille en fonction du nombre de mois spécifié.
     * Modifie la vitesse de la langue en fonction de son âge.
     * @param nbMonths Le nombre de mois pour faire vieillir la grenouille (int).
     */
    public void grow(int nbMonths) {
        for (int i=0; i<nbMonths; i++){ // On met à jour les caractéristiques de la frog à pour chaque mois

            if (this.age < 12){ // Si l'age est en dessous de 12 mois alors on incremente de 1 la vitesse de la langue
                this.tongueSpeed++;
                this.setAge(++this.age);

            } else if (this.age >=30 && this.tongueSpeed >=5) { // Si elle a moins de 30 mois et que sa vitesse de langue est inférieure à 5, on la décrémente de 1
                this.tongueSpeed--;
                this.setAge(++this.age);

            } else { // On incrémente juste son age de 1 mois
                this.setAge(++this.age);
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
    
    
    public void eat(Fly fly) {
        if (!fly.isDead()) {
            // Si la fly est toujours vivante

            if (this.tongueSpeed > fly.getSpeed() && fly.getMass() >= 0.5*this.age){ // Si la fly est attrapée
                this.grow(); // On gagne un mois
                fly.setMass(0); // On tue la mouche

            } else { // Si la mouche n'est pas attrapée, elle grossit de 1 unité
                fly.grow(1);
            }
        }
        // Si la fly est morte alors il ne passe rien 
    }
    
    public void move(int x, int y) {
    	this.setX(this.getX() + x);
    	this.setY(this.getY() + y);
    }
    
    
    /**
     * Renvoie une chaîne de caractères décrivant l'état de la grenouille.
     * @return Description de l'état de la grenouille (String).
     */
    public String toString(){

        if (this.isFroglet) {
            return "My name is " + this.name + " and I am a rare Froglet ! I am " + this.age + " months old and my tongue has a speed of " + this.tongueSpeed + "." + "I am in position (" + this.getX() + ", " + this.getY()+") !";
        } else {
            return "My name is " + this.name + " and I'm a rare frog. I'm "+ this.age +" months old and my tongue has a speed of " + this.tongueSpeed + "."+ "I am in position (" + this.getX() + ", " + this.getY()+") !";
        }
    }

}