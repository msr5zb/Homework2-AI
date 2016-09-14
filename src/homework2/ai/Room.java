/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

/**
 *
 * @author Mike
 */
public class Room {
    
    private int positionRow;
    private int positionColumn;
    private boolean hasVacuum = false;
    private boolean isCleaned = true;
    
    
    //Coordinates of the Room to the Up Direction
    
    //Constructor, Creates Room Object placing it's Coords
    public Room(int row, int column){
        this.positionRow = row;
        this.positionColumn = column;
    } 
    
    //Returns if Room is Cleaned or not.
    public boolean getCleaned(){
        return isCleaned;
    }
    
    //Returns if Room has Vacuum or not.
    public boolean getVacuum(){
        return hasVacuum;
    }
    
    //Returns Room's Row
    public int getRow(){
        return this.positionRow;
    }
    
    //Returns Room's Column
    public int getColumn(){
        return this.positionColumn;
    }
    //Place the Vacuum Into Room
    public void placeVacuum(){
        this.hasVacuum = true;
    }
    
    //Makes the Room Dirty.
    public void makeDirty(){
        this.isCleaned = false;
    }
    
    //Makes the Room Clean.
    public void cleanRoom(){
        this.isCleaned = true;
    }
    
    
    
}
