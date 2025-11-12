public class Robot {
    private int[] hallway;
    private int position;
    private boolean isFacingRight;

    public Robot(int[] hallwayToClean, int startingPosition) {
        if (hallwayToClean == null || hallwayToClean.length == 0) {
            this.hallway = new int[1];
            this.position = 0;
        } else {
            this.hallway = new int[hallwayToClean.length];
            for (int i = 0; i < hallwayToClean.length; i++) {
                this.hallway[i] = hallwayToClean[i] < 0 ? 0 : hallwayToClean[i];
            }

            if (startingPosition < 0) {
                this.position = 0;
            } else if (startingPosition >= this.hallway.length) {
                this.position = this.hallway.length - 1;
            } else {
                this.position = startingPosition;
            }
        }

        this.isFacingRight = true;
    }

    public int[] getHallway() {
        return hallway;
    }

    public int getPosition() {
        return position;
    }

    public boolean isFacingRight() {
        return isFacingRight;
    }

    public void setHallway(int[] hallway) {
        if (hallway != null && hallway.length > 0) {
            this.hallway = new int[hallway.length];
            for (int i = 0; i < hallway.length; i++) {
                this.hallway[i] = hallway[i] < 0 ? 0 : hallway[i];
            }
        }
    }

    public void setPosition(int position) {
        if (position >= 0 && position < hallway.length) {
            this.position = position;
        }
    }

    public void setFacingRight(boolean isFacingRight) {
        this.isFacingRight = isFacingRight;
    }

    public void displayState() {
        for (int i = 0; i < hallway.length; i++) {
            System.out.print(hallway[i]);
            if (i < hallway.length - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        for (int i = 0; i < position; i++) {
            System.out.print("  ");
        }
        System.out.println(isFacingRight ? ">" : "<");
    }

    public boolean isRobotBlockedByWall() {
        return (isFacingRight && position == hallway.length - 1)
                || (!isFacingRight && position == 0);
    }

    public void move() {
        if (hallway[position] > 0) {
            hallway[position]--;
            if (hallway[position] > 0) {
                return;
            }
        }

        if (isRobotBlockedByWall()) {
            turnAround();
        } else {
            moveForward();
        }
    }

    private void turnAround() {
        isFacingRight = !isFacingRight;
    }

    private void moveForward() {
        if (isFacingRight) {
            position++;
        } else {
            position--;
        }
    }

    public boolean hallIsClear() {
        for (int i = 0; i < hallway.length; i++) {
            if (hallway[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int clearHall() {
        int count = 0;

        displayState();

        while (!hallIsClear()) {
            move();
            count++;
            displayState();
        }

        return count;
    }
}
