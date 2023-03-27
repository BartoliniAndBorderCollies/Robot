import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Robot robocop = new Robot();
        Scanner scan = new Scanner(System.in);
        int response;
        String userCommand = "";
        boolean repeat = true;

        do {

            robocop.showMenu();
            robocop.energyCheck();//TODO: dlaczego nie pojawia sie status baterii po drugim jumpie

            try {

                response = scan.nextInt();

                switch (response) {
                    case 1 -> robocop.robotOn();
                    case 2 -> robocop.robotOff();
                    case 3 -> robocop.chargeRobot();
                    case 4 -> {

                        System.out.println("""
                                To move the robot you must type the following commands:
                                LeftFoot,
                                RightFoot,
                                LeftHand,
                                RightHand,
                                Jump,
                                Exit
                                """);
                        robocop.moveRobot(userCommand);

                        userCommand = scan.next();

                        if (userCommand.equalsIgnoreCase("LeftFoot")) {
                            robocop.moveRobot("Left foot");
                        } else if (userCommand.equalsIgnoreCase("RightFoot")) {
                            robocop.moveRobot("Right foot");
                        } else if (userCommand.equalsIgnoreCase("LeftHand")) {
                            robocop.moveRobot("Left hand");
                        } else if (userCommand.equalsIgnoreCase("RightHand")) {
                            robocop.moveRobot("Right hand");
                        } else if (userCommand.equalsIgnoreCase("Jump")) {
                            robocop.moveRobot("Jump");
                        } else if (userCommand.equalsIgnoreCase("Exit")) {
                            repeat = false; //TODO: jak zrobić, żeby zrobił go back to showMenu();
                        } else {
                            System.out.println("Unknown command.");
                        }
                    }
                    case 5  -> repeat = false; //TODO: nie wiem jak dodać tutaj komunikat.


                }
            } catch (InputMismatchException e) {
                System.out.println("Number must be an integer.");
                System.out.println("");
                scan.nextLine();
            }
        } while (repeat);
    }
}