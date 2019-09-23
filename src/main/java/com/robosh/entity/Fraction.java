package com.robosh.entity;

import com.robosh.PerformOperation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Fraction {
    protected int numerator; //чисельник
    protected int denominator; // знаменник

    public Fraction() {
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @PerformOperation
    public Fraction sumFractions(Fraction fraction) {
        int numeratorNew = numerator * fraction.denominator + fraction.numerator * denominator;
        int denominatorNew = fraction.denominator * denominator;
        return createNewReductionFraction(numeratorNew, denominatorNew);
    }

    @PerformOperation
    public Fraction minusFractions(Fraction fraction) {
        int numeratorNew = numerator * fraction.denominator - fraction.numerator * denominator;
        int denominatorNew = fraction.denominator * denominator;
        return createNewReductionFraction(numeratorNew, denominatorNew);
    }

    private Fraction createNewReductionFraction(int numeratorNew, int denominatorNew) {
        int gcd = gcd(Math.abs(numeratorNew), Math.abs(denominatorNew));
        if (gcd != 1) {
            numeratorNew /= gcd;
            denominatorNew /= gcd;
        }
        return new Fraction(numeratorNew, denominatorNew);
    }

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        if (a >= b) {
            return gcd(a % b, b);
        }
        return gcd(a, b % a);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
