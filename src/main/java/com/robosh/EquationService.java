package com.robosh;

public class EquationService {
    private EquationConstants equationConstants;

    public EquationService(EquationConstants equationConstants) {
        this.equationConstants = equationConstants;
    }

    public double[] getEquationSolution() {
        double a = equationConstants.getA();
        double b = equationConstants.getB();
        double c = equationConstants.getC();

        double discriminant = b * b - 4 * a * c;
        if(a == 0){
            throw new RuntimeException("Not quadratic equation");
        }

        if (discriminant < 0){
            throw new RuntimeException("No roots in this quadratic equation");
        }
        return calculateRoots(a, b, discriminant);
    }

    private double[] calculateRoots(double a, double b, double discriminant) {
        if (discriminant == 0) {
            double x = -b / (2*a);
            return new double[]{x};
        }
        double x1 = (-b + Math.sqrt(discriminant))/(2*a);
        double x2 = (-b - Math.sqrt(discriminant))/(2*a);
        return new double[]{x1, x2};
    }

    public void setEquationConstants(EquationConstants equationConstants) {
        this.equationConstants = equationConstants;
    }
}
