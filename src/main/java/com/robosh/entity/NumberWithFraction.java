package com.robosh.entity;

import lombok.Data;

@Data
public class NumberWithFraction extends Fraction {
    private int intNumber;

    public NumberWithFraction() {
    }

    public NumberWithFraction(int numerator, int denominator, int intNumber) {
        super(numerator, denominator);
        this.intNumber = intNumber;
    }

    @Override
    public String toString() {
        return intNumber + "," + numerator + "/" + denominator;
    }
}
