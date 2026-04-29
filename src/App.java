import Building.Building;
import enums.Direction;

public class App {
    public static void main(String[] args) throws Exception {
       Building building = new Building(10, 1);
       building.handleExternalRequest(0, 5, Direction.UP);
        building.handleExternalRequest(0, 2, Direction.UP);
        building.handleInternalRequest(0, 8);
    }
}
