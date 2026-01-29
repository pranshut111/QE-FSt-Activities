package com.example;

public class Acticity5 {
    public static void main(String[] args) throws InterruptedException {
        Plane plane = new Plane(10);
        plane.onBoard("Pranshu");
        plane.onBoard("Millind");

        System.out.println(plane.takeOff());

        System.out.println(plane.getPassengers());

        Thread.sleep(5000);
        plane.land();
        System.out.println(plane.getLastTimeLanded());

    }
}
