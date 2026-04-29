package Building;

import java.util.ArrayList;
import java.util.List;

import elevator.Elevator;
import enums.Direction;
import floor.Floor;
import request.ExternalRequest;
import request.InternalRequest;

public class Building {
    private List<Floor> floor;
    private List<Elevator> elevator;

    public Building(int noOfFloors, int noOfElevators ){
        floor= new ArrayList<>();
        elevator= new ArrayList<>();

        for(int i=0;i<noOfFloors;i++){
            floor.add(new Floor(i));
        }
        for(int i=0;i<noOfElevators;i++){
            elevator.add(new Elevator());
            
        }
        
    }

    public void handleExternalRequest(int elevatorNumber,int currentFloor, Direction direction){
                Elevator requestedElevator=elevator.get(elevatorNumber);
                requestedElevator.addExternalRequest(new ExternalRequest(currentFloor, direction));
               
    }

    public void handleInternalRequest(int elevatorNumber,int requestedFloor){
                Elevator requestedElevator=elevator.get(elevatorNumber);
                requestedElevator.addInternalRequest(new InternalRequest(requestedFloor));
                
    }
}
