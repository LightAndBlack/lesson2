package com.aston.javabase.class_types;

import java.util.*;

public class PointAccess implements InterfaceClass {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        List<String> list = new ArrayList<>();

        list.add("1");
        Iterator<String> iterator = list.iterator();

//        AbstractClass abstractClass = new AbstractClass() {
//            @Override
//            public String getName() {
//                return "";
//            }
//        };

        System.out.println(AbstractClass.getClassName());

        TopLevelClass topLevelClass = new TopLevelClass();
        topLevelClass.printHello();

        TopLevelClass2 topLevelClass2 = new TopLevelClass2();
        topLevelClass2.printHello();

        InterfaceClass.printHelloFromStaticMethod();

        System.out.println(InterfaceClass.argToUpperCase("hello"));
    }
}
