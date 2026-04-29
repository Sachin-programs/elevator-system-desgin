package floor;

public class Floor {
    private int floorNumber;
    private boolean upButtonPressed;
    private boolean downButtonPressed;
    public Floor(int floorNumber) {
        this.floorNumber = floorNumber;
        this.upButtonPressed = false;
        this.downButtonPressed = false;
    }
    public int getFloorNumber() {
        return floorNumber;
    }
    public boolean isUpButtonPressed() {
        return upButtonPressed;
    }
    public boolean isDownButtonPressed() {
        return downButtonPressed;
    }
    public void pressUpButton() {
        upButtonPressed = true;
    }
    public void pressDownButton() {
        downButtonPressed = true;
    }
    public void resetButtons() {
        upButtonPressed = false;
        downButtonPressed = false;
    }
    
}
