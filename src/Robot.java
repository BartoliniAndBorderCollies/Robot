public class Robot {

    private int energyLevel = 100;
    private String robotName;
    private boolean isOn = true;
    private boolean isChargerCreate;

    public void setChargerCreate(boolean chargerCreate) {
        isChargerCreate = chargerCreate;
    }

    public Robot(String robotName) {
        this.robotName = robotName;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void energyCheck() {
        System.out.println("Current energy level is: " + energyLevel + "%.");

        if (energyLevel > 100) {
            throw new RuntimeException("Unexpected error, energy level cannot be over 100%.");
        } else if (energyLevel > 30) {
            System.out.println();
        } else if (energyLevel > 5 && energyLevel < 30) {
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
                3. Create a charger to be able to recharge battery.
                4. Plug in the robot and start charging.
                5. Move the robot.
                6. Skip the turn.
                7. Close the application.
                                
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

    public void charger() {
        if (isChargerCreate) {
            System.out.println("Charger already exist.");
        } else {
            System.out.println("Charger has been created.");
            setChargerCreate(true);
        }
    }

    public void chargeRobot() {
        checkIfOn();
        if (isChargerCreate && !checkIfOn()) {
            if (energyLevel < 100) {
                System.out.println("Battery will be charged 10% each turn. ");
                energyLevel += 10;
            }
            if (energyLevel >= 100) {
                energyLevel = 100;
                System.out.println("Battery is fully charged and cannot exceed 100%");
            }
        } else if (!isChargerCreate) {
            System.out.println("You must create a charger first.");
        }
    }

    public boolean checkIfOn() {
        if (isOn) {
            System.out.println("Turn off the robot first.");
            return true;
        }
        return false;
    }

    public void robotOn() {
        if (!checkIfOn()) {
            setOn(true);
            System.out.println("Robot is now on.");
            System.out.println();
        } else {
            System.out.println("You have to unplug the robot from the charger.");
        }
    }

    public void robotOff() {
        setOn(false);
        System.out.println("Robot has been turned off.");
        System.out.println();
    }

    public void skipTheTurn() {
        chargeRobot();
        System.out.println("Next turn is beginning.");
    }
}
