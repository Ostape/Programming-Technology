package com.robosh;

import com.robosh.entity.Fraction;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MainRunner {
    private static NumberWithFraction numberWithFraction;

    public static void main(String[] args) {
        Fraction fraction = Fraction.builder()
                .numerator(34)
                .denominator(44)
                .build();

        numberWithFraction = new NumberWithFraction(83, 5, 2);
        showConstructors();
        showClassModificator();
        invokeMethodWithAnnotation(fraction);
    }

    public static void showConstructors() {
        Class<? extends NumberWithFraction> aClass = numberWithFraction.getClass();
        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println("Constructors: ");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }

    public static void showClassModificator() {
        int modifiers = getModifiers(numberWithFraction);
        System.out.println("is private: " + Modifier.isPrivate(modifiers));
        System.out.println("is protected: " + Modifier.isProtected(modifiers));
        System.out.println("is public: " + Modifier.isPublic(modifiers));
    }

    public static int getModifiers(Object object) {
        Class aClass = object.getClass();
        return aClass.getModifiers();
    }

    public static void invokeMethodWithAnnotation(Fraction fraction) {
        Class<?> superclass = numberWithFraction.getClass().getSuperclass();
        for (Method method : superclass.getMethods()) {
            if (method.isAnnotationPresent(PerformOperation.class)) {
                System.out.println(method);
                Object invoke = null;
                try {
                    invoke = method.invoke(numberWithFraction,fraction);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
                System.out.println(invoke);
            }
        }
    }
}
