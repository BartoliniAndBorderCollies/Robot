import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Robot robocop = new Robot();

        Scanner scan = new Scanner(System.in);
        int response;
        String command = "";
        do{

            robocop.showMenu();


            response = scan.nextInt();

            switch (response) {
                case 1 -> robocop.robotOn();
                case 2 -> robocop.robotOff();
                case 3 -> robocop.chargeRobot();
                case 4 -> {


                    do {
                        robocop.moveRobot(command);

                        command = scan.next(); //TODO: dałem next bo mi przelatywał znów do kolejnej linii

                        if (command.equalsIgnoreCase("Left feet")) {
                            robocop.moveRobot("Left feet");
                        } else if (command.equalsIgnoreCase("Right feet")) {
                            robocop.moveRobot("Right feet");
                        } else if (command.equalsIgnoreCase("Left hand")) {
                            robocop.moveRobot("Left hand");
                        } else if (command.equalsIgnoreCase("Right hand")) {
                            robocop.moveRobot("Right hand");
                        } else if (command.equalsIgnoreCase("Jump")) {
                            robocop.moveRobot("Jump");
                        } else {
                            System.out.println("Unknown command.");
                        }
                    } while (true);
                }


                case 5 -> System.exit(0);

            }
        }while(true);





    }
}