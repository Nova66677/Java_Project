import org.example.demo.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FrogTest {

    private Frog frog;
    private Fly fly;

    @BeforeEach
    void setUp() {
        frog = new Frog("Peepaw", 1.0, 0, 0, 50, 12, 10, 6);
        fly = new Fly("Buzz", 1.5, 0, 0, 12, 1, 7);
    }

    // Test du premier constructeur
    @Test
    void constructorTest1() {
        Frog frog1 = new Frog("Froggy", 2, 5);
        assertEquals("Froggy", frog1.getName());
        assertEquals(24, frog1.getAge()); // 2 ans en mois
        assertEquals(5, frog1.getTongueSpeed());
    }

    // Test du deuxième constructeur
    @Test
    void constructorTest2() {
        Frog frog2 = new Frog("Tiny");
        assertEquals("Tiny", frog2.getName());
        assertEquals(5, frog2.getAge()); // Age par défaut
        assertEquals(4, frog2.getTongueSpeed()); // Vitesse de langue par défaut
    }

    // Test du troisième constructeur
    @Test
    void constructorTest3() {
        Frog frog3 = new Frog("Jumpy", 3.0, 0, 0, 50, 6, 10, 7);
        assertEquals("Jumpy", frog3.getName());
        assertEquals(6, frog3.getAge());
        assertEquals(7, frog3.getTongueSpeed());
    }

    // Test pour la méthode grow(int nbMonths)
    @Test
    void testGrowWithMonths() {
        frog.grow(5);
        assertEquals(17, frog.getAge()); // L'âge devrait augmenter de 5 mois
    }

    // Test pour la méthode grow sans paramètres
    @Test
    void testGrowWithoutParams() {
        frog.grow();
        assertEquals(13, frog.getAge()); // L'âge devrait augmenter de 1 mois
    }

    // Test pour la méthode eat
    @Test
    void testEat() {

        assertTrue(frog.eat(fly));
        assertEquals(13, frog.getAge()); // L'âge devrait augmenter après avoir mangé la mouche
        assertTrue(fly.isDead()); // La mouche devrait être morte après avoir été mangée
    }

    // Test pour la méthode toString
    @Test
    void testToString() {
        String expected = "My name is Peepaw and I'm a rare frog. I'm 12 months old and my tongue has a speed of 6.0.I am in position (0, 0) !";
        assertEquals(expected, frog.toString());
    }

}
