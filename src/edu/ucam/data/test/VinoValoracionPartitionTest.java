package edu.ucam.data.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import edu.ucam.data.Vino;

public class VinoValoracionPartitionTest {

    private Vino vino;

    @Before
    public void setUp() {
        vino = new Vino(1, 2020, "Rioja", 3);
    }

    @Test
    public void testValoracionEnRango() {
        vino.setValoracion(4);
        assertTrue(vino.getValoracion() >= 0 && vino.getValoracion() <= 5);
    }

//    @Test
//    public void testValoracionFueraDeRangoEsperadoFallo() {
//        vino.setValoracion(10);
//        assertTrue("Debería estar entre 0 y 5",
//                   vino.getValoracion() >= 0 && vino.getValoracion() <= 5);
//    }
}
