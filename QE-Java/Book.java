package com.example;

abstract class Book {
    public String tittle;

    abstract void setTittle(String tittle);

    abstract String getTittle();
}

class MyBook extends Book {
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getTittle() {
        return tittle;
    }

    public static void main(String[] args) {
        MyBook newNovel = new MyBook();
        newNovel.setTittle("Partner");
        System.out.println(newNovel.getTittle());

    }
}
