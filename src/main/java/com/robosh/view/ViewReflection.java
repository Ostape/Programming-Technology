package com.robosh.view;

import com.robosh.entity.Fraction;

import java.lang.reflect.Constructor;
import java.util.List;

public class ViewReflection {
    public void showConsturcors(Constructor<?>[] constructors) {
        System.out.println("Constructors:");
        for (Constructor c : constructors) {
            System.out.println(c);
        }
    }

    public void isPublicClass(boolean b) {
        System.out.println("class is public: " + b);
    }

    public void isPrivateClass(boolean b) {
        System.out.println("class is private: " + b);
    }

    public void showResultWithAnnotationInvoke(List<Fraction> list) {
        for (Fraction a : list) {
            System.out.println(a);
        }
    }
}
