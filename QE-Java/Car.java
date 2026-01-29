package com.example;

public class Car {
    public String color;
    public String transmission;
    public int make;
    public int tyres;
    public int doors;

    public Car() {
        this.tyres = 4;
        this.doors = 4;
    }

    public void displayCharacteristics() {
        System.out.print(
                "Car Characteristics :\n Color : " + color + "\n transmission : " + transmission + "\n make : " + make
                        + "\n tyres : " + tyres + "\n doors : " + doors + "\n");
    }

    public void accelerate() {
        System.out.println("Car is moving forward");
    }

    public void brake() {
        System.out.println("Car is stopped");
    }
}
