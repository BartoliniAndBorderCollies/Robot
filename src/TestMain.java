public class TestMain {

    public static void main(String[] args) {
        Robot robot = new Robot("Gabrysia");
        Charger charger = new Charger();

        charger.setRobot(robot);

        charger.setRobot(null);



    }
}
