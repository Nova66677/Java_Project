package org.example.demo;

import org.example.demo.Animal;
import org.example.demo.Fly;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlyTest {

    private Fly fly;

    // Cette méthode est exécutée avant chaque test. Elle initialise l'objet fly.
    @BeforeEach
    void setUp() {
        // Création d'une mouche avec des valeurs initiales pour les tests
        fly = new Fly("Buzz", 1.5, 0, 0, 12, 1);
    }

    // Test pour vérifier que le constructeur initialise correctement l'objet
    @Test
    void constructorTest() {
        assertNotNull(fly);                     // Vérifie que l'objet fly n'est pas null
        assertEquals("Buzz", fly.getName());    // Vérifie que le nom est correctement initialisé
        assertEquals(1.5, fly.getSpeed());      // Vérifie que la vitesse est correctement initialisée
        assertEquals(0, fly.getX());            // Vérifie que la coordonnée x est correctement initialisée
        assertEquals(0, fly.getY());            // Vérifie que la coordonnée y est correctement initialisée
        assertEquals(12, fly.getLifespan());    // Vérifie que la durée de vie est correctement initialisée
        assertEquals(1, fly.getAge());          // Vérifie que l'âge est correctement initialisé
        assertFalse(fly.isDead());              // Vérifie que l'animal n'est pas mort à l'initialisation
    }

    // Test pour vérifier le bon fonctionnement de la méthode move
    @Test
    void testMove() {
        fly.move(5, 3);                 // Déplace la mouche
        assertEquals(5, fly.getX());    // Vérifie la nouvelle position x
        assertEquals(3, fly.getY());    // Vérifie la nouvelle position y
    }

    // Test pour vérifier le bon fonctionnement de la méthode gettingOlder
    @Test
    void testGettingOlder() {
        fly.gettingOlder(); // Vieillit la mouche de 1 mois
        assertEquals(2, fly.getAge()); // Vérifie le nouvel âge
        assertFalse(fly.isDead()); // Vérifie que la mouche n'est pas morte
    }

    // Test pour vérifier que la mouche meurt en vieillissant
    @Test
    void testAgeingUntilDeath() {
        for (int i = 0; i < 12; i++) {
            fly.gettingOlder(); // Vieillit la mouche jusqu'à sa mort
        }
        assertTrue(fly.isDead()); // Vérifie que la mouche est morte
    }

    // Test pour vérifier que la mouche ne se déplace pas après sa mort
    @Test
    void testMoveAfterDeath() {
        for (int i = 0; i < 12; i++) {
            fly.gettingOlder(); // Vieillit la mouche jusqu'à sa mort
        }
        fly.move(2, 2); // Tente de déplacer la mouche après sa mort
        // La position ne devrait pas changer après la mort
        assertEquals(0, fly.getX());
        assertEquals(0, fly.getY());
    }

    // Test pour vérifier le bon fonctionnement de la méthode getPosition
    @Test
    void testGetPosition() {
        fly.move(4, 5); // Déplace la mouche
        assertEquals("(4, 5", fly.getPosition()); // Vérifie la position retournée
    }

    // Test pour vérifier le bon fonctionnement de la méthode toString
    @Test
    void testToString() {
        String expectedDescription = "I am a speedy fly with 1.5 speed and 1 mass. I am at position (0, 0).";
        assertEquals(expectedDescription, fly.toString()); // Vérifie la chaîne retournée
    }

}
