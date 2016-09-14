/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Mike
 */
public class StateSpace {
    
    private Room[][] rooms;
    private int numberOfCleanedrooms;
    private Room currentRoom;
    

    public StateSpace(Room[][] rooms){
        this.rooms = rooms;
        setCurrentRoom();
    }
    
    private void setCurrentRoom(){
         for(int i = 0; i < this.rooms.length; i++){
            for(int j = 0; j < this.rooms[0].length; j++){
                if(this.rooms[i][j].getVacuum()){
                    this.currentRoom = this.rooms[i][j];
                }
            }
        }       
    }
    
    public void printStateSpace(GridPane grid){
        for(int i = 0; i < this.rooms.length; i++){
            for(int j = 0; j < this.rooms[0].length; j++){
                Button workingRoom = new Button("Room: (" 
                        + rooms[i][j].getRow() + "," 
                        + rooms[i][j].getColumn() + ")\n"
                        + "Cleaned: " + rooms[i][j].getCleaned() + "\n"
                        + "Vacuum: " + rooms[i][j].getVacuum());
                         
                //Add in the current working Room, note parameters are (object, col, row);
                GridPane.setConstraints(workingRoom, j, i);
                grid.getChildren().add(workingRoom);
            }
        } 
        
        Label vacuumDetails = new Label("Vacuum is in: (" + this.currentRoom.getRow()+ "," + this.currentRoom.getColumn() + ")");
        GridPane.setConstraints(vacuumDetails, this.rooms.length, 0);
        grid.getChildren().add(vacuumDetails);
    }
    

  
}
