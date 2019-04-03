package com.example.firebaseauth;

public class Dataupload {
    String book;
    String author;
    String library;
    String description;
    String floor;
    int amount;
    int shelf;
    String searchKey;

    public Dataupload(){

    }
    public Dataupload(String book,String searchKey, String author, String library, String description, String floor, int amount, int shelf ) {
        this.book = book;
        this.searchKey=searchKey;
        this.author = author;
        this.library = library;
        this.description = description;
        this.floor = floor;
        this.amount = amount;
        this.shelf = shelf;
    }

//    public String getName() {
//        return book;
//    }
//    public  String getSearchKey(){
//        return  searchKey;
//    }
//    public  void setSearchKey(){
//        this.searchKey=searchKey;
//    }
//    public void setName(String book) {
//        this.book = book;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getLibrary() {
//        return library;
//    }
//
//    public void setLibrary(String library) {
//        this.library = library;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public String getFloor() {
//        return floor;
//    }
//
//    public void setFloor(String floor) {
//        this.floor = floor;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public int getShelf() {
//        return shelf;
//    }
//
//    public void setShelf(int shelf) {
//        this.shelf = shelf;
//    }
}
