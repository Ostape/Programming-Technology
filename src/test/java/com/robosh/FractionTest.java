package com.robosh;

import com.robosh.entity.Fraction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {

    private Fraction fraction1;
    private Fraction fraction2;

    @Before
    public void init(){
        fraction1 = Fraction.builder()
                .numerator(-3)
                .denominator(-7)
                .build();

        fraction2 = Fraction.builder()
                .numerator(-9)
                .denominator(-4)
                .build();
    }

    @Test
    public void shouldReturnCorrectResultWhenSumFractions() {
        Fraction expectedFraction = Fraction.builder()
                .numerator(75)
                .denominator(28)
                .build();

        Fraction actualFraction = fraction1.sumFractions(fraction2);
        assertEquals(expectedFraction, actualFraction);
    }

    @Test
    public void shouldReturnCorrectResultWhenMinusFractions(){
        Fraction expectedFraction = Fraction.builder()
                .numerator(-51)
                .denominator(28)
                .build();

        Fraction actualFraction = fraction1.minusFractions(fraction2);
        assertEquals(expectedFraction, actualFraction);
    }
}