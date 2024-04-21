package services;
import java.util.List;
import java.io.*;

import io.CSVUtility;
import models.Whiskey;
import java.util.ArrayList;

public class WhiskeyService {
    private static ArrayList<Whiskey> inventory = new ArrayList<>();
    private static int nextId = 1;
    private static String csvFile = "whiskey_inventory.csv";

    public WhiskeyService(){
        loadDataCSV();
    }

    public void loadDataCSV() {
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Whiskey whiskey = new Whiskey(Integer.parseInt(data[0]), data[1],data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Float.parseFloat(data[6]));
                inventory.add(whiskey);
                nextId = Math.max(nextId, whiskey.getId() + 1);
            }
        } catch (IOException e) {
            System.out.println(("Error reading CSV file: "));
        }
    }

    public static void writeDataCSV(){
        try(FileWriter writer = new FileWriter(csvFile)) {
            for (Whiskey w : inventory) {
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(w.getId()));
                list.add(w.getName());
                list.add(w.getBrand());
                list.add(w.getType());
                list.add(String.valueOf((w.getQty())));
                list.add(String.valueOf((w.getPrice())));
                CSVUtility.writeLine(writer, list);
            }
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }




    public static Whiskey create(String name, String brand, String type, int size, int qty, float price) {
        Whiskey createdWhiskey = new Whiskey(nextId++, name, brand, type, size, qty, price);
        inventory.add(createdWhiskey);
        writeDataCSV();
        return  createdWhiskey;
    }

    //read
    public Whiskey findSneaker(int id){
        for(Whiskey whiskey : inventory){
            if (whiskey.getId() == id){
                return whiskey;
            }
        }
        return null;
    }

    public Whiskey[] findAll(){

        return inventory.toArray(new Whiskey[inventory.size()]);
    }

    public boolean delete(int id){
        boolean isDeleted = false;
        for (int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getId() == id)
                inventory.remove(i);
            isDeleted = true;
            i--;
            writeDataCSV();
        }
        return false;
    }
}
