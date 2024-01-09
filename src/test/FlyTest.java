import org.example.demo.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlyTest {

    private Fly fly;

    @BeforeEach
    void setUp() {
        fly = new Fly("Buzz", 5.0, 0, 0, 12, 1, 2.0);
    }

    // Test du premier constructeur
    @Test
    void constructorTest1() {
        Fly fly1 = new Fly("Fly1", 4.5, 0, 0, 15, 3, 1.5);
        assertEquals("Fly1", fly1.getName());
        assertEquals(4.5, fly1.getSpeed());
        assertEquals(1.5, fly1.getMass());
    }

    // Test du deuxième constructeur
    @Test
    void constructorTest2() {
        Fly fly2 = new Fly(2.0);
        assertEquals("Cyril", fly2.getName());
        assertEquals(4.0, fly2.getSpeed());
        assertEquals(2.0, fly2.getMass());
    }

    // Test du troisième constructeur
    @Test
    void constructorTest3() {
        Fly fly3 = new Fly();
        assertEquals("Cyril", fly3.getName());
        assertEquals(4.0, fly3.getSpeed());
        assertEquals(1.0, fly3.getMass());
    }

    // Test pour la méthode setMass et getMass
    @Test
    void testSetAndGetMass() {
        fly.setMass(3.5);
        assertEquals(3.5, fly.getMass());
    }

    // Test pour la méthode grow
    @Test
    void testGrow() {
        fly.grow(5);
        assertEquals(7.0, fly.getMass()); // La masse devrait augmenter de 5 unités
    }

    // Test pour la méthode isDead
    @Test
    void testIsDead() {
        assertFalse(fly.isDead()); // La mouche ne devrait pas être morte initialement
        fly.setMass(0); // Mise à jour de la masse à 0
        assertTrue(fly.isDead()); // La mouche devrait être considérée comme morte
    }

    // Test pour la méthode toString
    @Test
    void testToString() {
        String expected = "I am a speedy fly with 5.0 speed and 2.0 mass. I am at position (0, 0).";
        assertEquals(expected, fly.toString());
    }

}
