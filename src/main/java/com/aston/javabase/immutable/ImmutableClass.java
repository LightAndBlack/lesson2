package com.aston.javabase.immutable;

import java.util.HashMap;
import java.util.Map;

public final class ImmutableClass {

    private final String field;
    private final Map<String, String> fieldMap;

    public ImmutableClass(String field, Map<String, String> fieldMap) {
        this.field = field;
//        this.fieldMap = fieldMap;
        Map<String, String> deepCopy = new HashMap<>();
        for (String key : fieldMap.keySet()) {
            deepCopy.put(key, fieldMap.get(key));
        }
        this.fieldMap = deepCopy;
    }

    public String getField() {
        return field;
    }

    public Map<String, String> getFieldMap() {
        Map<String, String> deepCopy = new HashMap<>();
        for (String key : fieldMap.keySet()) {
            deepCopy.put(key, fieldMap.get(key));
        }
        return deepCopy;
    }
}
