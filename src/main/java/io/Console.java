package io;

import services.SneakerService;
import services.WhiskeyService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    //Create instances to call methods in each class
    private SneakerService sneakerService = new SneakerService();
    private WhiskeyService whiskeyService = new WhiskeyService();

    public static void printWelcome(){
        System.out.println(ANSI_GREEN +
                "      **************************************************\n" +
                "      ***                 Welcome                    ***\n" +
                "      ***                    to                      ***\n" +
                "      ***          ZipCode Inventory Manager         ***\n" +
                "      ***             by Alice Gonzalez              ***\n" +
                "      **************************************************\n" + ANSI_RESET
        );
    }

    public static void printMenu(){
        System.out.println(ANSI_BLUE+ " 1 - New Product       2 - Existing Products    3 - Update Products \n " +
                "4 - Delete Product    5 - Get Reports          6 - Exit Inventory\n\n" +ANSI_RESET + ANSI_RED+
                "Enter you choice (1 - 6) : " + ANSI_RESET
        );
    }

    public int getInput(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    valid = true;
                }else {
                    System.out.println("Please enter a number between" + min + " and " + max);
                }
            }else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); //Clear buffer
            }
        }
        return choice;
    }
    public static void mainMenuSelector() {
        Scanner scanner = new Scanner(System.in);

        while (true){
            printMenu();
            try{
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        createProduct(scanner);
                        break;
                    case 2:
                        displayProducts(scanner);
                        break;
                    case 3:
                        updateProduct(scanner);
                        break;
                    case 4:
                        deleteProduct(scanner);
                        break;
                    case 5:
                        generateReport(scanner);
                        break;
                    case 6:
                        System.out.println("Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice, please enter 1 - 6...");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid response. Please enter a number. ");
                scanner.next();
            }
        }
    }

    private static void createProduct(Scanner scanner) {
        try{
            System.out.println("Enter product type sneaker or whiskey: ");
            String productType = scanner.next();
            System.out.println("Enter name: ");
            String name = scanner.next();
            System.out.println("Enter brand: ");
            String brand = scanner.next();
            System.out.println("Enter sport for sneaker or type for whiskey: ");
            String sportOrType = scanner.next();
            System.out.println("Enter size: ");
            int size = scanner.nextInt();
            System.out.println("Enter quantity: ");
            int qty = scanner.nextInt();
            System.out.println("Enter price: ");
            float price = scanner.nextFloat();

            if(productType.equalsIgnoreCase("sneaker")){
                SneakerService.create(name, brand, sportOrType, size, qty, price);
            } else if (productType.equalsIgnoreCase("whiskey")){
                WhiskeyService.create(name, brand , sportOrType , size, qty, price);
            } else{
                System.out.println("Invalid product type.");
            }
        }catch(InputMismatchException ime){
            System.out.println("Invalid input type. Please enter the correct data type for size, quantity, and price.");
            scanner.nextLine();
        }catch (Exception e) {
            System.out.println("An error ocurred: " + e.getMessage());
        }finally {

        }
    }

    private static void displayProducts(Scanner scanner) {

    }

    private static void updateProduct(Scanner scanner) {

    }

    private static void deleteProduct(Scanner scanner) {
    }

    private static void generateReport(Scanner scanner) {
    }
}
