package com.example;

public class Activity3 {
    public static void main(String[] args) {
        double seconds = 1000000000;

        double EarthSeconds = 31557600;
        double MercurySeconds = 0.2488467;
        double VenuesSeconds = 6.61519726;
        double MarsSecond = 1.8888158;
        double JupiterSecond = 11.862615;
        double UranusSeconds = 84.016846;
        double NeptuneSeconds = 164.79132;

        double years = seconds / EarthSeconds;

        System.out.println("Age on Earth : " + (years));
        System.out.println("Age on Mercury : " + (years / MercurySeconds));
        System.out.println("Age on venus : " + (years / VenuesSeconds));
        System.out.println("Age on Mars : " + (years / MarsSecond));
        System.out.println("Age on Jupiter : " + (years / JupiterSecond));
        System.out.println("Age on Uranus : " + (years / UranusSeconds));
        System.out.println("Age on Neptune : " + (years / NeptuneSeconds));

    }
}
