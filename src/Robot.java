public class Robot {

    private int energyLevel = 100;
    private String robotName;
    private boolean isOn;

    public Robot(String robotName) {
        this.robotName = robotName;
    }

    public void setOn(boolean on) {
        isOn = on;
    }


    public void energyCheck() {
        System.out.println("Current energy level is: " + energyLevel + "%.");


        if(energyLevel>100) {
            throw new RuntimeException ("Unexpected error, energy level cannot be over 100%.");

        } else if (energyLevel > 5) {
            System.out.println("Battery level is less than 30%, charge your robot.");

        } else {
            System.out.println("Battery level is critical.");
            robotOff();
        }
    }

    public void showMenu() {

        System.out.println("""
                Hello, welcome to Robot command center.
                What do you want to do? Type the answer:
                1. Turn on the robot.
                2. Turn off the robot.
                3. Charge the robot.
                4. Move the robot.
                5. Close the application.
                """);

    }

    public void moveRobot(String command) {

        if (!isOn) {
            System.out.println("The robot must be on. Turn the robot on first.");
            return;
        }

        switch (command.toLowerCase()) {
            case "left foot" -> {
                energyLevel -= RobotMovement.STEP_LEFT.getStepLeftConsumption();
                System.out.println("Robot moved his left foot.\n");
            }
            case "right foot" -> {
                energyLevel -= RobotMovement.STEP_RIGHT.getStepRightConsumption();
                System.out.println("Robot moved his right foot.\n");
            }
            case "left hand" -> {
                energyLevel -= RobotMovement.LEFT_HANDE_MOVE.getLeftHandConsumption();
                System.out.println("Robot moved his left hand.\n");
            }
            case "right hand" -> {
                energyLevel -= RobotMovement.RIGHT_HAND_MOVE.getRightHandConsumption();
                System.out.println("Robot moved his right hand.\n");
            }
            case "jump" -> {
                energyLevel -= RobotMovement.JUMP.getJumpConsumption();
                System.out.println("Robot jumped.\n");
            }
            default -> System.out.println("Unknown command.");
        }
    }

    public void chargeRobot() {
        if (isOn) {
            System.out.println("Turn off the robot first.\n");
            return;
        }
        energyLevel = 100;
        System.out.println("Robot has been fully charged.\n");
        }


    public void robotOn() {
        setOn(true);
        System.out.println("Robot is now on.");
        System.out.println();
    }

    public void robotOff() {
        setOn(false);
        System.out.println("Robot has been turned off.");
        System.out.println();
    }
}
