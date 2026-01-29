package com.example;

// import com.example.Car;

public class Activity1 {

    public static void main(String[] args) {
        Car c1 = new Car();

        // Call Car class method
        c1.color = "black";
        c1.make = 2014;
        c1.transmission = "Manual";

        c1.displayCharacteristics();
        c1.accelerate();
        c1.brake();
    }
}
