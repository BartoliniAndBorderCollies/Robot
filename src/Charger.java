

public class Charger {
    private Robot robot;
    private boolean chargerExist;

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void chargeRobot(Robot robot) {
        if (robot.checkIfOn()) {
            System.out.println("Robot must be turned off.");
            return;
        }
        if (chargerExist) {
            try {
                robot.setEnergyLevel(robot.getEnergyLevel() + 10);
                System.out.println("Robot is being charged.");
            } catch (Exception e) {
                System.out.println("");
            }
        }else {
            System.out.println("Create charger first.");
        }
    }
    
    public void createCharger() {
        if (chargerExist) {
            System.out.println("Charger already exist.");
        } else {
            System.out.println("Charger has been created.");
            chargerExist=true;
        }
    }
}
