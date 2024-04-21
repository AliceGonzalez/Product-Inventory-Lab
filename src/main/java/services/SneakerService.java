package services;
import io.CSVUtility;
import models.Sneaker;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//We are going to lean on this class to create, read, update, and delete
public class SneakerService {
    private static int nextId = 1; //(1)
    private static ArrayList<Sneaker> inventory = new ArrayList<>(); //(2)

    private static String csvFile = "sneaker_inventory.csv";

    public SneakerService(){
        loadDataCSV();
    }

    public void loadDataCSV() {
        try(BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                Sneaker sneaker = new Sneaker(Integer.parseInt(data[0]), data[1],data[2], data[3], Integer.parseInt(data[4]), Integer.parseInt(data[5]), Float.parseFloat(data[6]));
                inventory.add(sneaker);
                nextId = Math.max(nextId, sneaker.getId() + 1);
            }
        } catch (IOException e) {
            System.out.println(("Error reading CSV file: "));
        }
    }

    public static void writeDataCSV(){
        try(FileWriter writer = new FileWriter(csvFile)) {
            for (Sneaker w : inventory) {
                List<String> list = new ArrayList<>();
                list.add(String.valueOf(w.getId()));
                list.add(w.getName());
                list.add(w.getBrand());
                list.add(w.getSport());
                list.add(String.valueOf((w.getQty())));
                list.add(String.valueOf((w.getPrice())));
                CSVUtility.writeLine(writer, list);
            }
        } catch (IOException e) {
            System.out.println("Error writing to CSV file: " + e.getMessage());
        }
    }

    public static Sneaker create(String name, String brand, String sport, int size, int qty, float price) {
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, qty, price);
        inventory.add(createdSneaker);
        writeDataCSV();
        return  createdSneaker;
    }

    //read
    public Sneaker findSneaker(int id){
        //should take an int and return an object with that id, if exists
        for(Sneaker sneaker : inventory){
            if (sneaker.getId() == id){
                return sneaker;
            }
        }
        return null;
    }


    //readAll
    public Sneaker[] findAll(){
        //should return a basic array copy of the array list
        return inventory.toArray(new Sneaker[inventory.size()]);
    }

    //delete
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
