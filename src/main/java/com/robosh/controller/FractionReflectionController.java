package com.robosh.controller;

import com.robosh.PerformOperation;
import com.robosh.entity.Fraction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class FractionReflectionController {
    private Fraction fraction;
    private Fraction fraction2;

    public FractionReflectionController(Fraction fraction, Fraction fraction2) {
        this.fraction = fraction;
        this.fraction2 = fraction2;
    }

    public Constructor<?>[] getConstructors() {
        Class<? extends Fraction> aClass = fraction.getClass();
        return aClass.getConstructors();
    }

    public boolean isPublicClass() {
        return Modifier.isPublic(getModifiers(fraction));
    }

    public boolean isPrivateClass() {
        return Modifier.isPrivate(getModifiers(fraction));
    }

    private int getModifiers(Object object) {
        Class aClass = object.getClass();
        return aClass.getModifiers();
    }

    public List<Fraction> invokeMethodWithAnnotation() {
        Class<?> superclass = this.fraction.getClass().getSuperclass();
        List<Fraction> resultMethods = new ArrayList<>();
        for (Method method : superclass.getMethods()) {
            if (method.isAnnotationPresent(PerformOperation.class)) {
                Fraction invoke = null;
                try {
                    invoke = (Fraction) method.invoke(this.fraction,fraction2);
                    resultMethods.add(invoke);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMethods;
    }
}
