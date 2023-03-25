public class Robot {

    private int energyLevel = 100;
    private String robotName;
    private boolean isOn;
    private String command;

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
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

        if(isOn) {
            switch(command){
                case "Left feet": energyLevel = getEnergyLevel() - RobotMovement.STEP_LEFT.getStepLeftConsumption();
                break;
                case "Right feet": energyLevel = getEnergyLevel() - RobotMovement.STEP_RIGHT.getStepRightConsumption();
                break;
                case "Left hand": energyLevel = getEnergyLevel() - RobotMovement.LEFT_HANDE_MOVE.getLeftHandConsumption();
                break;
                case "Right hand": energyLevel = getEnergyLevel() - RobotMovement.RIGHT_HAND_MOVE.getRightHandConsumption();
                break;
                case "Jump": energyLevel = getEnergyLevel() - RobotMovement.JUMP.getJumpConsumption();
                default:
            }
        }else {
            System.out.println("Turn robot on first.");
            System.out.println("");
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
