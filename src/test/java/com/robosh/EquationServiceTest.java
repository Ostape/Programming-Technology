package com.robosh;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquationServiceTest {

    private EquationService equationService;
    private EquationConstants equationConstants;
    private double delta = 0.000001;

    @Test(expected = RuntimeException.class)
    public void shouldThrowRuntimeExceptionWhenDiscriminantLessZero() {
        equationConstants = new EquationConstants(3, -3, 3);
        equationService = new EquationService(equationConstants);
        equationService.getEquationSolution();
    }

    @Test
    public void shouldReturnOneCorrectRoot() {
        equationConstants = new EquationConstants(1, -10, 25);
        equationService = new EquationService(equationConstants);
        double[] equationSolution = equationService.getEquationSolution();
        double expectedRoot = 5;
        double actualRoot = equationSolution[0];
        assertEquals(expectedRoot, actualRoot, delta);
    }

    @Test
    public void shouldReturnCorrectRoots() {
        equationConstants = new EquationConstants(6, -5, -6);
        equationService = new EquationService(equationConstants);
        double[] equationSolution = equationService.getEquationSolution();
        double expectedFirstRoot = 1.5;
        double expectedSecondRoot = -2/3.0;
        double actualFirstRoot = equationSolution[0];
        double actualSecondRoot = equationSolution[1];
        assertEquals(expectedFirstRoot, actualFirstRoot, delta);
        assertEquals(expectedSecondRoot, actualSecondRoot, delta);
    }
}
