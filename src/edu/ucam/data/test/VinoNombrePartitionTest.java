package edu.ucam.data.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ucam.data.Vino;

public class VinoNombrePartitionTest {

    private Vino vino;

    @Before
    public void setUp() {
        vino = new Vino(1, 2020, "Rioja", 3);
    }

    @Test
    public void testNombreNoVacio() {
        assertFalse(vino.getNombre().isEmpty());
    }

    @Test
    public void testNombreNullEsperadoFallo() {
        // Provocamos un fallo: esperamos que sea null y no lo es
        assertNull(vino.getNombre());
    }
}
