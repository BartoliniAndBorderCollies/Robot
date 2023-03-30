import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


//TODO:1. jak klikasz 5 to pojawia sie komunikat:
//         "Robot has been unplugged from the charger."
//    Ale on nie był podłączony, to jak może być odłączony?
//     2. samo posiadanie ładowarki powoduje, że robot się ładuje.
//   3. klikniecie 4 czyli plug in the robot nie zwraca zadnej wiadomosci, ani czy ładuje, ani czy jest on wlaczony.
//
//



    public static void main(String[] args) {

        Robot robocop = new Robot("Robocopy");
        Charger charger = new Charger();
        Utilities utility = new Utilities();

        Scanner scan = new Scanner(System.in);
        int response = 0;
        int turn = 0;
        String command;
        boolean repeat = true;

        do {
            turn++;

            System.out.println("                                                              Turn: " + turn);

            utility.showMenu();
            robocop.energyCheck();

            try {
                response = scan.nextInt();

            } catch (InputMismatchException e) {
                System.out.println("Number must be an integer.");
                System.out.println();

            }
            scan.nextLine();

            switch (response) {
                case 1 -> robocop.robotOn();
                case 2 -> robocop.robotOff();
                case 3 -> charger.createCharger();
                case 4 -> {
                    charger.setRobot(robocop);
                    charger.chargeRobot(robocop);
                }
                case 5 -> robocop.unplugRobot();
                case 6 -> {

                    System.out.println("""
                            To move the robot you must type the following commands:
                            Left foot,
                            Right foot,
                            Left hand,
                            Right hand,
                            Jump,
                            Go back
                            """);

                    command = scan.nextLine();
                    if (command.equalsIgnoreCase("Go back")) {
                        System.out.println("Returning to main menu.");
                    } else {
                        robocop.moveRobot(command);
                    }
                }
                case 7 -> {
                    utility.setCharger(charger);
                    utility.setRobot(robocop);
                    utility.skipTheTurn(robocop);
                }
                case 8 -> {
                    System.out.println("Application is closing.");
                    repeat = false;
                }
            }
        } while (repeat);
    }
}

