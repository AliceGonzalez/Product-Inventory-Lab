import io.Console;
import services.SneakerService;

import java.util.Scanner;

public class App {

    //(1)
    private SneakerService sneakerService = new SneakerService();

    public static void main(String... args){
        App application = new App(); //(2)
        application.init(); //(3)
    }



    public void init(){
        //(4)calls method to take user input and iterface with services
        Console.printWelcome();
        Console.mainMenuSelector();
    }


}
