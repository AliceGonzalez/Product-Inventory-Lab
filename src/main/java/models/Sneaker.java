package models;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private int size;
    private int qty;
    private float price;

    public Sneaker(int id, String name, String brand, String sport, int qty, float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.qty = qty;
        this.price = price;
    }

    public Sneaker(int i, String name, String brand, String sport, int size, int qty, float price) {
    }

    public Sneaker() {

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }
    public String getBrand() {
        return brand;
    }

    public void  setSport(String sport){
        this.sport = sport;
    }
    public String getSport() {
        return sport;
    }
    public void setQty(int qty){
        this.qty = qty;
    }
    public int getQty() {
        return qty;
    }
    public void setPrice(float price){
        this.price = price;
    }
    public float getPrice() {
        return price;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }
}
