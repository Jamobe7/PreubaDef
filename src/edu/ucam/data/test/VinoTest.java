package edu.ucam.data.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.ucam.data.Vino;

public class VinoTest {

    private static Vino vinoStatic;
    private Vino vino1;
    private Vino vino2;

    // Se ejecuta UNA vez antes de todos los tests
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println(">> @BeforeClass");
        vinoStatic = new Vino(99, 2000, "PruebaStatic", 3);
    }

    // Se ejecuta UNA vez después de todos los tests
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println(">> @AfterClass");
        vinoStatic = null;
    }

    // Se ejecuta ANTES de cada test
    @Before
    public void setUp() {
        System.out.println(">> @Before");
        vino1 = new Vino(1, 2020, "Rioja", 5);
        vino2 = new Vino(2, 2019, "Navarra", 4);
    }

    // Se ejecuta DESPUÉS de cada test
    @After
    public void tearDown() {
        System.out.println(">> @After");
    }

    // ====== TESTS QUE ESPERAMOS QUE PASEN (ÉXITO) ======

    @Test
    public void testSetAndGetId() {
        vino1.setId(10);
        assertEquals(10, vino1.getId());                // 1) assertEquals OK
    }

    @Test
    public void testNombreNotNull() {
        assertNotNull(vino1.getNombre());               // 2) assertNotNull OK
    }

    @Test
    public void testValoracionTrueFalse() {
        vino1.setValoracion(4);
        assertTrue(vino1.getValoracion() >= 0 &&
                   vino1.getValoracion() <= 5);         // 3) assertTrue OK
        assertFalse(vino1.getValoracion() < 0);         // 4) assertFalse OK
    }

    @Test
    public void testSameAndNotSame() {
        Vino mismo = vino1;
        assertSame(mismo, vino1);                       // 5) assertSame OK
        assertNotSame(vino1, vino2);                    // 6) assertNotSame OK
    }

    @Test
    public void testArrayEquals() {
        int[] esperados = {1, 2, 3};
        int[] reales    = {1, 2, 3};
        assertArrayEquals(esperados, reales);           // 7) assertArrayEquals OK
    }

    @Test
    public void testNull() {
        Vino vinoNull = null;
        assertNull(vinoNull);                           // 8) assertNull OK
    }

    // ====== TESTS DISEÑADOS PARA FALLAR (FALLO) ======

//    @Test
//    public void testEqualsFalla() {
//        // Espera 999 pero realmente el id es 1
//        assertEquals(999, vino1.getId());               // fallo
//    }
//
//    @Test
//    public void testNullFalla() {
//        // nombre NO es nulo, así que esto fallará
//        assertNull(vino1.getNombre());                  // fallo
//    }
//
//    @Test
//    public void testSameFalla() {
//        // vino1 y vino2 son objetos distintos
//        assertSame(vino1, vino2);                       // fallo
//    }
//
//    @Test
//    public void testArrayEqualsFalla() {
//        int[] esperados = {1, 2};
//        int[] reales    = {1, 2, 3};
//        assertArrayEquals(esperados, reales);           // fallo
//    }
}
