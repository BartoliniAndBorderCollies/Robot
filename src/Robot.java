public class Robot {

    private int energyLevel = 100;
    private String robotName;
    private boolean isOn;

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void energyCheck() {
        if(energyLevel<=100 && energyLevel>=30){
            System.out.println("Current energy level is: " + energyLevel + "%.");;
        }else if(energyLevel<30 && energyLevel>5) {
            System.out.println("""
                    Battery level is less than 30%, charge your robot.
                    Current energy level is: """ + energyLevel + "%.");
        } else if(energyLevel<=5) {
            System.out.println("Battery level is critical. Robot is turning off.");
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

            if (isOn) {

                switch (command.toLowerCase()) {
                    case "leftfoot" -> {
                        energyLevel = getEnergyLevel() - RobotMovement.STEP_LEFT.getStepLeftConsumption();
                        System.out.println("Robot moved his left foot.");
                    }
                    case "rightfoot" -> {
                        energyLevel = getEnergyLevel() - RobotMovement.STEP_RIGHT.getStepRightConsumption();
                        System.out.println("Robot moved his right foot.");
                    }
                    case "lefthand" -> {
                        energyLevel = getEnergyLevel() - RobotMovement.LEFT_HANDE_MOVE.getLeftHandConsumption();
                        System.out.println("Robot moved his left hand.");
                    }
                    case "righthand" -> {
                        energyLevel = getEnergyLevel() - RobotMovement.RIGHT_HAND_MOVE.getRightHandConsumption();
                        System.out.println("Robot moved his right hand.");
                    }
                    case "jump" -> {
                        energyLevel = getEnergyLevel() - RobotMovement.JUMP.getJumpConsumption();
                        System.out.println("Robot jumped.");
                    }
                    default -> System.out.println("Unknown command.");
                }
            } else {
                System.out.println("The robot must be on. Turn the robot on first.");
            }
        }

    public void chargeRobot() {
        if(!isOn) {
            setEnergyLevel(100);
            System.out.println("Robot has been fully charged.");
            System.out.println("");
        } else {
            System.out.println("Turn off the robot first.");
            System.out.println(" ");
        }
    }

    public void robotOn(){
        setOn(true);
        System.out.println("Robot is now on.");
        System.out.println("");
    }

    public void robotOff(){
        setOn(false);
        System.out.println("Robot has been turned off.");
        System.out.println("");
    }
}
