import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Robot robocop = new Robot();
        Scanner scan = new Scanner(System.in);
        int response = 0;
        String userCommand = "";
        boolean repeat = true;

        do {

            robocop.showMenu();
            robocop.energyCheck();

            try {
                response = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Number must be an integer.");
                System.out.println("");
                scan.nextLine();
            }

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
                            GoBack
                            """);
                    robocop.moveRobot(userCommand);

                    userCommand = scan.next();

                    switch (userCommand.toLowerCase()) {

                        case "leftfoot" -> robocop.moveRobot("Left foot");
                        case "rightfoot" -> robocop.moveRobot("Right foot");
                        case "lefthand" -> robocop.moveRobot("Left hand");
                        case "righthand" -> robocop.moveRobot("Right hand");
                        case "jump" -> robocop.moveRobot("Jump2");
                        case "goback" ->
                                System.out.println("""
                                    Going back to menu.
                                                                
                                    """);
                        default -> System.out.println("Unknown command.");
                    }
                }
                case 5 -> {
                    System.out.println("Application is closing.");
                    repeat = false;
                }
            }
        } while (repeat);
    }
}

