/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Mike
 */
public class StateSpace {
    
    private Room[][] rooms;
    private Room currentRoom;
    List<String> actionList = new ArrayList<String>();
    private int score;
    StateSpace parentStateSpace;
    private int depth = 0;
    List<StateSpace> children = new ArrayList<StateSpace>();
    
    public StateSpace(){
        
    }
    public void createChild(StateSpace childStateSpace){
        
        childStateSpace.rooms = this.rooms;
        childStateSpace.currentRoom = this.currentRoom;
        childStateSpace.actionList = this.actionList;
        childStateSpace.score = this.score;
        childStateSpace.parentStateSpace = this;
        childStateSpace.depth = this.depth;
       

    }
    
    public List<StateSpace> getChildren(){
        this.children.clear();
        if(this.canClean() == true){
            //If Dirty, Make a New Child State with Cleaned Room
            StateSpace childNode1 = this.cleanCurrentRoom();
            this.children.add(childNode1);

        }
        if(this.canMoveLeft() == true){
            System.out.println("Attempting to move left");
            //If Can move Left, Make a New Child State That has Moved Left
            StateSpace childNode2 = this.move("left");
            this.children.add(childNode2);

        }  
        if(this.canMoveRight() == true){
            //If Can move Left, Make a New Child State That has Moved Left
            StateSpace childNode3 = this.move("right");
            this.children.add(childNode3);

        }  
        if(this.canMoveUp() == true){
            //If Can move Left, Make a New Child State That has Moved Left
            StateSpace childNode4 = this.move("up");
            this.children.add(childNode4);

        } 
        if(this.canMoveDown() == true){
            //If Can move Left, Make a New Child State That has Moved Left
            StateSpace childNode5 = this.move("down");
            this.children.add(childNode5);

        }      

        return this.children;
    }
    
    public int getDepth(){
        return depth;
    }

    public void printActionList(){
        int i = 0;
        while (i< this.actionList.size()) {
            System.out.println(this.actionList.get(i));
            i++;
        }
    }
    
    public Room getCurrentRoom(){
        return this.currentRoom;
    }
    
    //Calculates and Returns the Score
    private int getScore(){
        this.score = 0;
        for (int i = 0; i < this.actionList.size(); i++) {
            switch(this.actionList.get(i)){
                case "suck" : this.score+=0;break;
                case "up" : this.score+=1.3;break;
                case "down" : this.score+=1.3;break;
                case "left" : this.score+=1;break;
                case "right" : this.score+=1;break;
            }
                    
        }
        return this.score;
    }
    

    
    public boolean canClean(){
        if(this.currentRoom.isDirty()){
            return true;
        }
        else{
            return false;
        }
    }
 
    public StateSpace cleanCurrentRoom(){
        StateSpace newStateSpace = new StateSpace();
        this.createChild(newStateSpace);
        
        newStateSpace.depth += 1;
        if(this.canClean()){
            System.out.println("Cleaned Room");
            newStateSpace.currentRoom.cleanRoom();
            newStateSpace.actionList.add("Vacuumed");
            return newStateSpace;
        }
        else{
            newStateSpace = null;
            return newStateSpace;
        }
    }
    
    public boolean canMoveLeft(){
        System.out.println("Checking if can move left");
        if(this.currentRoom.getColumn() != 0){
            if(rooms[this.currentRoom.getRow()][(this.currentRoom.getColumn()-1)].isVisited() == false){
                return true;
            }
            else{
                System.out.println("Room was Already Visited");
                return false;
            }
            
        }
        else{
            System.out.println("Hit a Wall!");
            return false;
        }
    }
    
    public boolean canMoveRight(){
        System.out.println("Checking if can move right");
        //System.out.println("Real Room Column: " +this.currentRoom.getColumn()+","+rooms[0].length);
        if(this.currentRoom.getColumn()+1 < rooms[0].length){
            //System.out.println("Checking if can move right: " +this.currentRoom.getRow()+","+(this.currentRoom.getColumn()+1));
            if(rooms[this.currentRoom.getRow()][(this.currentRoom.getColumn()+1)].isVisited() == false){
                return true;
            }
            else{
                System.out.println("Room was Already Visited");
                return false;
            }
        }
        else{
            System.out.println("Hit a Wall!");
            return false;
        }
    }
    public boolean canMoveUp(){
        System.out.println("Checking if can move up");
        if(this.currentRoom.getRow() != 0){
            if(rooms[(this.currentRoom.getRow()-1)][this.currentRoom.getColumn()].isVisited() == false){
                return true;
            }
            else{
                System.out.println("Room was Already Visited");
                return false;
            }
        }
        else{
            System.out.println("Hit a Wall!");
            return false;
        }
    }
    public boolean canMoveDown(){
        System.out.println("Checking if can move down");
        if(this.currentRoom.getRow()+1 < rooms.length){
            if(rooms[(this.currentRoom.getRow()+1)][this.currentRoom.getColumn()].isVisited() == false){
                return true;
            }
            else{
                System.out.println("Room was Already Visited");
                return false;
            }
        }
        else{
            System.out.println("Hit a Wall!");
            return false;
        }
    }
    
    
    //Returns True on Successful Move. False otherwise. Cannot move to already visited rooms.
    public StateSpace move(String direction){
        StateSpace newStateSpace = new StateSpace();
        this.createChild(newStateSpace);
        newStateSpace.depth += 1;
        System.out.println("Room Before Move: " + this.currentRoom.getRow() + "," + this.currentRoom.getColumn());
        
        switch(direction){
            case "left": if(this.canMoveLeft()){
                            
                            System.out.println("Moving Left!");
                            //If Can Move, Remove Vacuum from the Room
                            newStateSpace.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            newStateSpace.currentRoom = rooms[newStateSpace.currentRoom.getRow()][(newStateSpace.currentRoom.getColumn()-1)];
                            //Set Room to Being Visited
                            newStateSpace.currentRoom.setVisited();
                            //Set Vacuum in Room
                            newStateSpace.currentRoom.setVacuum();
                            //Update Action List
                            newStateSpace.actionList.add("left");
                            newStateSpace.currentRoom.setVisited();
                            
                            return newStateSpace;
                         } else{newStateSpace = null; return null; }
            
            case "right": if(this.canMoveRight()){
                            System.out.println("Moving Right!");
                            //If Can Move, Remove Vacuum from the Room
                            newStateSpace.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            newStateSpace.currentRoom = rooms[newStateSpace.currentRoom.getRow()][(newStateSpace.currentRoom.getColumn()+1)];
                            //Set Room to Being Visited
                            newStateSpace.currentRoom.setVisited();
                            //Set Vacuum in Room
                            newStateSpace.currentRoom.setVacuum();
                            //Update Action List
                            newStateSpace.actionList.add("right");
                            newStateSpace.currentRoom.setVisited();
                            return newStateSpace;
                         } else{newStateSpace = null; return null; }
            
            case "up": if(this.canMoveUp()){
                            System.out.println("Moving Up!");
                            //If Can Move, Remove Vacuum from the Room
                            newStateSpace.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            newStateSpace.currentRoom = rooms[(newStateSpace.currentRoom.getRow()-1)][newStateSpace.currentRoom.getColumn()];
                            //Set Room to Being Visited
                            newStateSpace.currentRoom.setVisited();
                            //Set Vacuum in Room
                            newStateSpace.currentRoom.setVacuum();
                            //Update Action List
                            newStateSpace.actionList.add("up");
                            newStateSpace.currentRoom.setVisited();
                            return newStateSpace;
                         } else{newStateSpace = null; return null; }
            
            case "down": if(this.canMoveDown()){ //Check if it'll be in bounds
                            System.out.println("Moving Down!");
                            //If Can Move, Remove Vacuum from the Room
                            newStateSpace.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            newStateSpace.currentRoom = rooms[(newStateSpace.currentRoom.getRow()+1)][newStateSpace.currentRoom.getColumn()];
                            //Set Room to Being Visited
                            newStateSpace.currentRoom.setVisited();
                            //Set Vacuum in Room
                            newStateSpace.currentRoom.setVacuum();
                            //Update Action List
                            newStateSpace.actionList.add("down");
                            newStateSpace.currentRoom.setVisited();
                            return newStateSpace;
                         } else{newStateSpace = null; return newStateSpace;}
            default: newStateSpace = null; return null;           
        }
    }
    
    
    
  
    
    public StateSpace(Room[][] rooms){
        this.rooms = rooms;
        setCurrentRoom();
        this.currentRoom.setVisited();
        
    }
 
    public int getDirtyRoomCount(){
        int numberOfDirtyRooms = 0;
        for(int i = 0; i < this.rooms.length; i++){
            for(int j = 0; j < this.rooms[0].length; j++){
                if(this.rooms[i][j].isDirty()){
                    numberOfDirtyRooms++;
                }
            }
        }    
        return numberOfDirtyRooms;
    }
    
    private void setCurrentRoom(){
         for(int i = 0; i < this.rooms.length; i++){
            for(int j = 0; j < this.rooms[0].length; j++){
                if(this.rooms[i][j].containsVacuum()){
                    this.currentRoom = this.rooms[i][j];
                }
            }
        }       
    }
    
    public void updateStateSpaceDisplay(GridPane grid){
        for(int i = 0; i < this.rooms.length; i++){
            for(int j = 0; j < this.rooms[0].length; j++){
                Button workingRoom = new Button("Room: (" 
                        + rooms[i][j].getRow() + "," 
                        + rooms[i][j].getColumn() + ")\n"
                        + "Dirty: " + rooms[i][j].isDirty() + "\n"
                        + "Vacuum: " + rooms[i][j].containsVacuum());
                         
                //Add in the current working Room, note parameters are (object, col, row);
                GridPane.setConstraints(workingRoom, j, i);
                grid.getChildren().add(workingRoom);
            }
        } 
        
        Label vacuumDetails = new Label("Vacuum is in: (" + this.currentRoom.getRow()+ "," + this.currentRoom.getColumn() + ")");
        GridPane.setConstraints(vacuumDetails, this.rooms.length, 0);
        grid.getChildren().add(vacuumDetails);
        
        Label dirtyRoomCount = new Label("Number of Dirty Rooms is: " + getDirtyRoomCount());
        GridPane.setConstraints(dirtyRoomCount, this.rooms.length, 1);
        grid.getChildren().add(dirtyRoomCount);
    }
    
    //Sets Parent StateSpace of Current State Space
    public void setParentStateSpace(StateSpace parent){
        this.parentStateSpace = parent;
    }
    
    //Returns StateSpace's Parent
    public StateSpace getParentStateSpace(){
        return this.parentStateSpace;
    }
  
}
