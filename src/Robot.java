public class Robot {

    private int energyLevel = 100;

    private int currentEnergyLevel;

    private String robotName;
    private boolean isOn;
    private String command;

    public Robot(String robotName) {
        this.robotName = robotName;
    }

    Robot robot = new Robot("Primary Robot");

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }



    public void setOn(boolean on) {
        isOn = on;
    }



    public void moveRobot() {

        if(robot.isOn) {
            switch(command){
                case "Move left feet": currentEnergyLevel = robot.getEnergyLevel() - RobotMovement.STEP_LEFT.getStepLeftConsumption();
                case "Move right feet": currentEnergyLevel = robot.getEnergyLevel() - RobotMovement.STEP_RIGHT.getStepRightConsumption();
                case "Move left hand": currentEnergyLevel = robot.getEnergyLevel() - RobotMovement.LEFT_HANDE_MOVE.getLeftHandConsumption();
                case "Move right hand": currentEnergyLevel = robot.getEnergyLevel() - RobotMovement.RIGHT_HAND_MOVE.getRightHandConsumption();
                case "Jump": currentEnergyLevel = robot.getEnergyLevel() - RobotMovement.JUMP.getJumpConsumption();
                default:
            }
        }else {
            System.out.println("Turn on robot first.");
        }

    }

    public void chargeRobot() {
        if(!robot.isOn) {
            robot.setEnergyLevel(100);
            System.out.println("Robot has been fully charged.");
        } else {
            System.out.println("Turn off the robot first.");
        }

    }

    public void robotOn(){
        robot.setOn(true);
        System.out.println("Robot is now on.");

    }

    public void robotOff(){
        robot.setOn(false);
        System.out.println("Robot has been turned off.");

    }

}
