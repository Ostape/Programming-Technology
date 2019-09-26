package com.robosh;

import com.robosh.controller.FractionReflectionController;
import com.robosh.entity.Fraction;
import com.robosh.entity.NumberWithFraction;
import com.robosh.view.ViewReflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainRunner {

    public static void main(String[] args) {
        Fraction fraction = Fraction.builder()
                .numerator(34)
                .denominator(44)
                .build();

        NumberWithFraction numberWithFraction = new NumberWithFraction(83, 5, 2);
        ViewReflection viewReflection = new ViewReflection();
        FractionReflectionController controller = new FractionReflectionController(numberWithFraction, fraction);
        viewReflection.showConsturcors(controller.getConstructors());
        viewReflection.isPrivateClass(controller.isPrivateClass());
        viewReflection.isPublicClass(controller.isPublicClass());
        viewReflection.showResultWithAnnotationInvoke(controller.invokeMethodWithAnnotation());
    }


}
