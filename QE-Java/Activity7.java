package com.example;

public class Activity7 {

    public static void main(String[] args) {

        Bicycle bike = new Bicycle(3, 0, 25);

        System.out.println(bike.bicycleDesc());

        bike.speedUp(20);
        bike.applyBrake(5);
    }
}
