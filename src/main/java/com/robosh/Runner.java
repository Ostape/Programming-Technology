package com.robosh;


import java.math.BigDecimal;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;

import static com.robosh.CrazyLambdas.*;

public class Runner {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = helloSupplier();
        System.out.println(stringSupplier.get());

        System.out.println(isEmptyPredicate().test("jj"));

        System.out.println(toDollarStringFunction().apply(new BigDecimal(2)));

        System.out.println(stringToIntConverter().applyAsInt("12"));

        Supplier<IntUnaryOperator> intUnaryOperatorSupplier = nMultiplyFunctionSupplier(5);
        System.out.println(intUnaryOperatorSupplier.get().applyAsInt(8));
    }
}
