package com.example;

public class Main1 {
    public static void main(String[] args) {
        try {
            exceptionTest("Will print to console");
            exceptionTest("");
        } catch (CoustomException e) {
            System.out.println("There is Exception Message : " + e.getMessage());
        }

    }

    public static void exceptionTest(String str) throws CoustomException {
        if (str == null || str.isEmpty()) {
            throw new CoustomException("String is Empty");
        }

        System.out.println(str);
    }
}
