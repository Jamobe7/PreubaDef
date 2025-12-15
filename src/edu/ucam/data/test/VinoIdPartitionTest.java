package edu.ucam.data.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ucam.data.Vino;

public class VinoIdPartitionTest {

    private Vino vino;

    @Before
    public void setUp() {
        vino = new Vino(1, 2020, "Prueba", 3);
    }

    @Test
    public void testIdPositivo() {
        vino.setId(5);
        assertTrue(vino.getId() > 0);
    }

    @Test
    public void testIdCeroEsperadoFallo() {
        vino.setId(0);
        // Imaginamos que NO debería ser 0, forzamos un fallo adrede
        assertTrue("El id no debería ser 0", vino.getId() > 0);
    }
}
