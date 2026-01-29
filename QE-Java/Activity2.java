package com.example;

public class Activity2 {
    public static void main(String[] args) {
        int[] arr = { 10, 77, 10, 54, -11, 10, -10, 10 };
        int sum = 0;
        for (int num : arr) {
            if (Math.abs(num) == 10) {
                sum += num;
            }
        }
        if (sum == 30) {
            System.out.println("TRUE");
        } else {
           System.out.println("False");
        }

    }
}
