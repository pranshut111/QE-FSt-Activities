package com.example;

public class Bicycle {

    // Fields (data)
    int gears;
    int currentSpeed;
    int seatHeight;

    // Constants
    static final int TYRES = 2;
    static final int MAX_SPEED = 100;

    // Constructor
    public Bicycle(int gears, int currentSpeed, int seatHeight) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
        this.seatHeight = seatHeight;
    }

    // Methods
    public void speedUp(int increment) {
        currentSpeed += increment;
        System.out.println("Speed increased. Current speed: " + currentSpeed);
    }

    public void applyBrake(int decrement) {
        currentSpeed -= decrement;
        System.out.println("Brake applied. Current speed: " + currentSpeed);
    }

    public String bicycleDesc() {
        return "BICYCLE DETAILS\n"
                + "Gears: " + gears + "\n"
                + "Current Speed: " + currentSpeed + "\n"
                + "Seat Height: " + seatHeight + "\n"
                + "Tyres: " + TYRES + "\n"
                + "Max Speed: " + MAX_SPEED;
    }

    // Main method
    public static void main(String[] args) {

        Bicycle bike = new Bicycle(3, 0, 25);

        System.out.println(bike.bicycleDesc());

        bike.speedUp(20);
        bike.applyBrake(5);
    }
}
