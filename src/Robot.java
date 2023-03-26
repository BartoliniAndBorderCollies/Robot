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

    public int energyCheck() {
        if(energyLevel<=100){
            System.out.println("Current energy level is: " + energyLevel);;
        }else if(energyLevel<30) {
            System.out.println("Battery level is less than 30%, charge your robot.");
        } else if(energyLevel<=5) {
            System.out.println("Battery level is critical. Robot is turning off.");
            robotOff();
        }return energyLevel;
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
                energycheck();

                switch (command) {
                    case "Left foot":
                        energyLevel = getEnergyLevel() - RobotMovement.STEP_LEFT.getStepLeftConsumption();
                        System.out.println("Robot moved his left foot.");
                        break;
                    case "Right foot":
                        energyLevel = getEnergyLevel() - RobotMovement.STEP_RIGHT.getStepRightConsumption();
                        System.out.println("Robot moved his right foot.");
                        break;
                    case "Left hand":
                        energyLevel = getEnergyLevel() - RobotMovement.LEFT_HANDE_MOVE.getLeftHandConsumption();
                        System.out.println("Robot moved his left hand.");
                        break;
                    case "Right hand":
                        energyLevel = getEnergyLevel() - RobotMovement.RIGHT_HAND_MOVE.getRightHandConsumption();
                        System.out.println("Robot moved his right hand.");
                        break;
                    case "Jump":
                        energyLevel = getEnergyLevel() - RobotMovement.JUMP.getJumpConsumption();
                        System.out.println("Robot jumped.");
                    default: energyLevel = getEnergyLevel();
                        System.out.println("Current energy level is: " + energyLevel);

                }
            } else {
                System.out.println("The robot is turning on.");
                robotOn();
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
