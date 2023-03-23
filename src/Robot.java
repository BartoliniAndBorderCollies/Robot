public class Robot {

    private int energyLevel = 100;
    private String robotName;
    private boolean isOn;

    Robot robot = new Robot();


    public void setOn(boolean on) {
        isOn = on;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public void moveRobot() {
        if(robot.isOn) {
            RobotMovement.STEP_LEFT = energyLevel -
        }

    }

    public void chargeRobot() {
        if(!robot.isOn) {
            robot.setEnergyLevel(100);
            System.out.println("Robot has been fully charged.");
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
