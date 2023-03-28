public enum RobotMovement {
    STEP_LEFT, STEP_RIGHT, LEFT_HANDE_MOVE, RIGHT_HAND_MOVE, JUMP;


    private final int stepLeftConsumption = 20;
    private final int stepRightConsumption = 20;
    private final int leftHandConsumption = 10;
    private final int rightHandConsumption = 10;
    private final int jumpConsumption = 35;

    public int getStepLeftConsumption() {
        return stepLeftConsumption;
    }

    public int getStepRightConsumption() {
        return stepRightConsumption;
    }

    public int getLeftHandConsumption() {
        return leftHandConsumption;
    }

    public int getRightHandConsumption() {
        return rightHandConsumption;
    }

    public int getJumpConsumption() {
        return jumpConsumption;
    }
}
