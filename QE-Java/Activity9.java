package com.example;

import java.util.*;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("Pranshu");
        myList.add("Akash");
        myList.add("Millind");
        myList.add("Ritik");
        myList.add("Kuldip");

        System.out.println();

        for (String name : myList) {
            System.out.println(name);
        }

        System.out.println();
        System.out.println("Get the third name from the list : " + myList.get(2));

        System.out.println("Does Millind is present in then list? : " + myList.contains("Millind"));

        System.out.println("The size of the list : " + myList.size());

        myList.remove("Kuldip");

        System.out.println("After removing a name from tehh list : " + myList.size());

    }
}
