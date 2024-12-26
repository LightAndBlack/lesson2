package com.aston.javabase.class_types;

public interface InterfaceClass {

    default void printHello() {
        System.out.println("Hello");
    }
    static void printHelloFromStaticMethod() {
        System.out.println("Hello from static method");
    }

    static String argToUpperCase(String arg) {
        return arg.toUpperCase();
    }
}
