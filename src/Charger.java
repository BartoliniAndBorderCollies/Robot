

public class Charger {
    private Robot robot;
    public Robot unplugRobot() {
        Robot robotToReturn = robot; //TODO: tego nie kumam co to za cuda?
        robot = null;
        System.out.println("Robot has been unplugged.");
        return robotToReturn;
    }
    public void plugInRobot(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void chargeRobot(Robot robot) {
        if (robot.checkIfOn()) {
            System.out.println("Robot must be turned off.");
            return;
        }

            try {
                robot.setEnergyLevel(robot.getEnergyLevel() + 10);
                System.out.println("Robot is being charged.");
            } catch (Exception e) {
                System.out.println("Energy level cannot exceed 100%. ");
            }
    }

}
