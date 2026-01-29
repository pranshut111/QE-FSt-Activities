package com.example;

import java.time.LocalDateTime;
import java.util.*;

public class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private LocalDateTime lastTimeTookOf;
    private LocalDateTime lastTimeLanded;

    Plane(int maxPassengers) {
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }

    public void onBoard(String person) {
        passengers.add(person);
    }

    public LocalDateTime takeOff() {
        return LocalDateTime.now();
    }

    public void land() {
        lastTimeLanded = LocalDateTime.now();
        passengers.clear();
    }

    public LocalDateTime getLastTimeLanded() {
        return lastTimeLanded;
    }

    public List<String> getPassengers() {
        return passengers;
    }
}
