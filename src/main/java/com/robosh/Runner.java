package com.robosh;

import java.util.Scanner;

public class Runner {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Runner runner = new Runner();
        EquationConstants constants = new EquationConstants();
        System.out.println("ax^2 + bx + c = 0");
        System.out.println("Input constants: a, b, c");

        constants.setA(runner.getConstant());
        constants.setB(runner.getConstant());
        constants.setC(runner.getConstant());
        EquationService equationService = new EquationService(constants);
        runner.showRoots(equationService);
    }

    private double getConstant() {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private void showRoots(EquationService equationService) {
        try {
            double[] equationSolution = equationService.getEquationSolution();
            for (double k : equationSolution) {
                System.out.println(k);
            }
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
