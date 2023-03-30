public class Robot {

    private int energyLevel = 100;
    private String robotName;
    private boolean isOn = true;
    private boolean isPlugged;

    public void setEnergyLevel(int energyLevel) throws Exception {
        if (energyLevel > 100) {
            throw new Exception("Maximum energy cannot be higher than 100%");
        }
        this.energyLevel = energyLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public Robot(String robotName) {
        this.robotName = robotName;
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

    public void moveRobot(String command) {

        if (!isOn) {
            System.out.println("The robot must be on. Turn the robot on first.");
            return;
        }

        switch (command.toLowerCase()) {
            case "left foot" -> {
                energyLevel -= RobotMovement.STEP_LEFT.getMoveCost();
                System.out.println("Robot moved his left foot.\n");
            }
            case "right foot" -> {
                energyLevel -= RobotMovement.STEP_RIGHT.getMoveCost();
                System.out.println("Robot moved his right foot.\n");
            }
            case "left hand" -> {
                energyLevel -= RobotMovement.LEFT_HANDE_MOVE.getMoveCost();
                System.out.println("Robot moved his left hand.\n");
            }
            case "right hand" -> {
                energyLevel -= RobotMovement.RIGHT_HAND_MOVE.getMoveCost();
                System.out.println("Robot moved his right hand.\n");
            }
            case "jump" -> {
                energyLevel -= RobotMovement.JUMP.getMoveCost();
                System.out.println("Robot jumped.\n");
            }
            default -> System.out.println("Unknown command.");
        }
    }

    public void unplugRobot() {
        isPlugged = false;
        System.out.println("Robot has been unplugged from the charger.");
    }

    public boolean checkIfOn() {
        return isOn;
    }

    public boolean checkIfBeingCharged() {
        if (isPlugged) {
            System.out.println("Robot is plugged and it cannot be turned on. Unplug the robot first. ");
            return true;
        }
        return false;
    }

    public void robotOn() {
        if (!checkIfOn() && !checkIfBeingCharged()) {
            isOn = true;
            System.out.println("Robot is now on.\n");
        }
    }

    public void robotOff() {
        isOn = false;
        System.out.println("Robot has been turned off.\n");
    }
}
