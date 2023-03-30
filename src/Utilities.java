public class Utilities {

    private Charger charger;
    private Robot robot;

    public void setCharger(Charger charger) {
        this.charger = charger;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public void showMenu() {

        System.out.println("""
                                
                Hello, welcome to Robot command center.
                What do you want to do? Type the answer:
                1. Turn on the robot.
                2. Turn off the robot.
                3. Create a charger to be able to recharge battery.
                4. Plug in the robot and start charging.
                5. Unplug the robot from the charger.
                6. Move the robot.
                7. Skip the turn.
                8. Close the application.
                                
                """);
    }

    public void skipTheTurn(Robot robot) {
        charger.chargeRobot(robot);
        System.out.println("Next turn is beginning.");
    }
}
