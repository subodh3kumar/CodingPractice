package dev.workshop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class CustomAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Hello {
        String value();
    }
    @Hello("duke")
    public void world() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        String value = CustomAnnotation.class.getMethod("world")
                .getAnnotation(Hello.class)
                .value();
        System.out.println("value: " + value);
    }
}
