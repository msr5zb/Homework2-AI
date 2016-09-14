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

    public boolean cleanCurrentRoom(){
        if(this.currentRoom.isDirty()){
            this.currentRoom.cleanRoom();
            actionList.add("Vacuumed");
            return true;
        }
        else{
            return false;
        }
    }
    
    //Returns True on Successful Move. False otherwise. Cannot move to already visited rooms.
    public boolean move(String direction){
        
        switch(direction){
            case "left": if(this.currentRoom.getRow() != 0 && rooms[this.currentRoom.getRow()-1][this.currentRoom.getColumn()].isVisited() == false){
                            //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()-1][this.currentRoom.getColumn()];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            this.actionList.add("left");
                            //Update Action List
                            return true;
                         } else{return false;}
            
            case "right": if(this.currentRoom.getRow() != rooms.length && rooms[this.currentRoom.getRow()+1][this.currentRoom.getColumn()].isVisited() == false){
                            //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()+1][this.currentRoom.getColumn()];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            //Update Action List
                            this.actionList.add("right");
                            return true;
                         } else{return false;}
            
            case "up": if(this.currentRoom.getColumn() != 0 && rooms[this.currentRoom.getRow()-1][this.currentRoom.getColumn()-1].isVisited() == false){
                            //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()-1][this.currentRoom.getColumn()-1];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            //Update Action List
                            this.actionList.add("up");
                            return true;
                         } else{return false;}
            
            case "down": if(this.currentRoom.getColumn() != rooms[0].length && rooms[this.currentRoom.getRow()][this.currentRoom.getColumn()+1].isVisited() == false){ //Check if it'll be in bounds
                             //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()][this.currentRoom.getColumn()+1];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            //Update Action List
                            this.actionList.add("down");
                            return true;
                         } else{return false;}
            default: return false;           
        }
    }
    
    //Returns True on Successful Move. False otherwise. Can move to already visited rooms.
    public boolean moveUnlimited(String direction){
        
        switch(direction){
            case "left": if(this.currentRoom.getRow() != 0){
                            //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()-1][this.currentRoom.getColumn()];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            this.actionList.add("left");
                            //Update Action List
                            return true;
                         } else{return false;}
            
            case "right": if(this.currentRoom.getRow() != rooms.length){
                            //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()+1][this.currentRoom.getColumn()];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            //Update Action List
                            this.actionList.add("right");
                            return true;
                         } else{return false;}
            
            case "up": if(this.currentRoom.getColumn() != 0){
                            //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()-1][this.currentRoom.getColumn()-1];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            //Update Action List
                            this.actionList.add("up");
                            return true;
                         } else{return false;}
            
            case "down": if(this.currentRoom.getColumn() != rooms[0].length){ //Check if it'll be in bounds
                             //If Can Move, Remove Vacuum from the Room
                            this.currentRoom.removeVacuum();
                            //Adjust The Current Room
                            this.currentRoom = rooms[this.currentRoom.getRow()][this.currentRoom.getColumn()+1];
                            //Set Room to Being Visited
                            this.currentRoom.setVisited();
                            //Set Vacuum in Room
                            this.currentRoom.setVacuum();
                            //Update Action List
                            this.actionList.add("down");
                            return true;
                         } else{return false;}
            default: return false;           
        }
    }
    
  
    
    public StateSpace(Room[][] rooms){
        this.rooms = rooms;
        setCurrentRoom();
        
    }
 
    private int getDirtyRoomCount(){
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
    

  
}
