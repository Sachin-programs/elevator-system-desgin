package elevator;

import java.util.PriorityQueue;

import enums.Direction;
import enums.ElevatorState;
import request.ExternalRequest;
import request.InternalRequest;

public class Elevator {
    private int currentFloor;
    private ElevatorState state;
    private PriorityQueue<Integer> upRequests;
    private PriorityQueue<Integer> downRequests;

    public Elevator() {
        this.currentFloor = 0;
        this.state = ElevatorState.IDLE;
        this.upRequests = new PriorityQueue<>();
        this.downRequests = new PriorityQueue<>((a, b) -> b - a); // Max-heap for down requests
    }
    public void addExternalRequest(ExternalRequest request) {
        if (request.getDirection() == enums.Direction.UP) {
            upRequests.offer(request.getFloor());
        } else {
            downRequests.offer(request.getFloor());
        }
        move();
    }

    public void addInternalRequest(InternalRequest request){

        if(request.getFloor() == currentFloor){
            System.out.println("Press a valid floor");
        } else if (request.getFloor() > currentFloor) {  // ← else if
            upRequests.offer(request.getFloor());
        } else {
            downRequests.offer(request.getFloor());
        }
            move();
    }


   public void move() {
    if (state == ElevatorState.MOVING_UP) {
        if(!upRequests.isEmpty()){
            state=ElevatorState.MOVING_UP;
            int nextFloor= upRequests.poll();
            currentFloor=nextFloor;
            openDoors();
            
        }
    } else if (state == ElevatorState.MOVING_DOWN) {
        if(!downRequests.isEmpty()){
            state=ElevatorState.MOVING_DOWN;
            int nextFloor= downRequests.poll();
            currentFloor=nextFloor;
            openDoors();
        }
    } else if (state == ElevatorState.IDLE) {
        int upNearest=Integer.MAX_VALUE;
        int downNearest=Integer.MAX_VALUE;

        if(upRequests.isEmpty() && downRequests.isEmpty()){
               state= ElevatorState.IDLE;
                return;
            }

        if(!upRequests.isEmpty()){
        upNearest= Math.abs(currentFloor- upRequests.peek());
        }
        if(!downRequests.isEmpty()){
        downNearest=Math.abs(currentFloor-downRequests.peek());
        }

        if(upNearest<=downNearest){
            state=ElevatorState.MOVING_UP;
        }else{
            state=ElevatorState.MOVING_DOWN;
        }
        move();
    }
}


    public void openDoors() {
            state = ElevatorState.DOORS_OPEN;
            System.out.println("Current floor: "+currentFloor+" -> OPENING DOOR...");
            try{
            Thread.sleep(6000);
            }catch (Exception ex){
                System.out.print("Error ");
            }
            System.out.println("Current floor: "+currentFloor+" -> CLOSING DOOR...");
            state = ElevatorState.IDLE;
            move();
    }
}

    
    

