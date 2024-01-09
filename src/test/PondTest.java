package org.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class PondTest {

    private ArrayList<Frog> frogArray;
    private ArrayList<Fly> flyArray;

    @BeforeEach
    void setUp() {
        // Initialiser avec un nombre fixe de grenouilles et de mouches pour la cohérence du test
        frogArray = Pond.generateFrog(5, Pond.taille_x, Pond.taille_y);
        flyArray = Pond.generateFly(5, Pond.taille_x, Pond.taille_y);
    }

    // Test pour la génération de grenouilles
    @Test
    void testGenerateFrog() {
        assertEquals(5, frogArray.size()); // Assurer que 5 grenouilles sont générées
        assertNotNull(frogArray.get(0)); // Assurer qu'une grenouille est bien créée
    }

    // Test pour la génération de mouches
    @Test
    void testGenerateFly() {
        assertEquals(5, flyArray.size()); // Assurer que 5 mouches sont générées
        assertNotNull(flyArray.get(0)); // Assurer qu'une mouche est bien créée
    }

    // Test pour la méthode de distance
    @Test
    void testDistance() {
        Frog frog = frogArray.get(0);
        Fly fly = flyArray.get(0);
        double distance = Pond.distance(frog, fly);
        assertTrue(distance >= 0); // La distance doit toujours être positive
    }

    // Test pour la méthode move_all
    @Test
    void testMoveAll() {
        Frog frogBeforeMove = frogArray.get(0);
        int initialX = frogBeforeMove.getX();
        int initialY = frogBeforeMove.getY();

        Pond.move_all(1, frogArray, flyArray);

        Frog frogAfterMove = frogArray.get(0);
        // Vérifier si au moins une des coordonnées a changé après le déplacement
        assertTrue(frogAfterMove.getX() != initialX || frogAfterMove.getY() != initialY);
    }

}
