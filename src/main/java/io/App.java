package io;


import services.SneakerService;
import services.WhiskeyService;

public class App {

    //(1)
    private SneakerService sneakerService = new SneakerService();
    private WhiskeyService whiskeyService = new WhiskeyService();

    public static void main(String... args){
        App application = new App();
        application.init();
    }


    public void init(){
        Console.printWelcome();
        Console.mainMenuSelector();
    }
}
