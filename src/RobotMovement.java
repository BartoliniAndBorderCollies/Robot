public enum RobotMovement {
    STEP_LEFT(20),
    STEP_RIGHT(20),
    LEFT_HANDE_MOVE(10),
    RIGHT_HAND_MOVE(10),
    JUMP(35);

    private final int moveCost;
//    private final String name;

    RobotMovement(int moveCost) {
        this.moveCost = moveCost;
    }

    public int getMoveCost() {
        return moveCost;
    }
}
