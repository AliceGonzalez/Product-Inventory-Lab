package models;

public class Whiskey {
    private int id;
    private String name;
    private String brand;
    private String type;
    private int qty;
    private float price;

    //Constructor
    public Whiskey(){}

    public Whiskey(int id, String name, String brand, String type, int qty, float price){
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.type = type;
        this.qty = qty;
        this.price = price;
    }

    public Whiskey(int i, String name, String brand, String type, int size, int qty, float price) {
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public String getBrand(){
        return brand;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }

    public void setQty(int qty){
        this.qty = qty;
    }

    public int getQty(){
        return qty;
    }
    public void setPrice(float price){
        this.price = price;
    }

    public float getPrice(){
        return price;
    }
}
