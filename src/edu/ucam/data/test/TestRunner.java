package edu.ucam.data.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(
            VinoTest.class,
            VinoIdPartitionTest.class,
            VinoNombrePartitionTest.class,
            VinoValoracionPartitionTest.class
        );

        System.out.println("===== FALLOS =====");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println("¿Todo correcto? " + result.wasSuccessful());
        System.out.println("Total tests: " + result.getRunCount());
        System.out.println("Fallos: " + result.getFailureCount());
    }
}
