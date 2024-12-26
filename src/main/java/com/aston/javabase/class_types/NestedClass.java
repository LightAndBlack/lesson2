package com.aston.javabase.class_types;

public class NestedClass {

    private String field;
    private MemberInnerClass memberInnerClass;
    private EnumClass enumClass;

    class MemberInnerClass {
        private String fieldMemberInnerClass;
    }

    enum EnumClass{
        FIRST,
        SECOND,
        THIRD
    }











    static class StaticNestedClass {


    }
}

//{
//    "field": "test",
//    "memberInnerClass": {
//        "fieldMemberInnerClass":"test inner"
//    },
//        "enumClass":"enum value"
//}
