import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Robot robot2 = new Robot("R2D2");

        Scanner scan = new Scanner(System.in);
        int response;
        do{
            System.out.println("""
    Hello, welcome to Robot command center.
    What do you want to do? Type the answer:
    1. Turn on the robot.
    2. Turn off the robot.
    3. Charge the robot.
    4. Move the robot.
    5. Close the application.
    """);
            scan.nextLine();
            response = scan.nextInt();

            switch(response) {
                case 1: robot2.robotOn();
                case 2: robot2.robotOff();
                case 3: robot2.chargeRobot();
                case 4: robot2.moveRobot();
                case 5: break;
            }
        }while(true);





    }
}