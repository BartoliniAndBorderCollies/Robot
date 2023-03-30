

public class Charger {
    private Robot robot;
    private boolean chargerExist;

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void chargeRobot(Robot robot) {
        if (robot.checkIfOn()) {
            return;
        }try {
            robot.setEnergyLevel(robot.getEnergyLevel() + 10);
        } catch(Exception e) {
            System.out.println("");
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
