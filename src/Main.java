import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Robot robocop = new Robot();

        Scanner scan = new Scanner(System.in);
        int response;
        String userCommand = "";

        do{

            robocop.showMenu();


            response = scan.nextInt();

            switch (response) {
                case 1 -> robocop.robotOn();
                case 2 -> robocop.robotOff();
                case 3 -> robocop.chargeRobot();
                case 4 -> {


                    do {

                        robocop.moveRobot(userCommand);

                        System.out.println("""
                        To move the robot you must type the following commands:
                        LeftFoot,
                        RightFoot,
                        LeftHand,
                        RightHand,
                        Jump,
                        EnergyStatus,
                        Exit
                        """);

                        userCommand = scan.next(); //TODO: dałem next bo mi przelatywał znów do kolejnej linii

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
                        }else if(userCommand.equalsIgnoreCase("EnergyStatus")) {
                            robocop.getEnergyLevel();
                        } else if(userCommand.equalsIgnoreCase("Exit")){
                            System.exit(0);
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