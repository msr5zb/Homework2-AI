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
    private boolean dirty = false;
    private boolean visited = false;
   
    //Constructor, Creates Room Object placing it's Coords
    public Room(int row, int column){
        this.positionRow = row;
        this.positionColumn = column;
    } 
    
    //Returns whether the Room was already Visited or not.
    public boolean isVisited(){
        return visited;
    }
    
    //Sets the Room to being Visited
    public void setVisited(){
        this.visited = true;
    }

    //Returns whether the Room is Cleaned or not.
    public boolean isDirty(){
        return dirty;
    }
    
    //Returns whether the Room contains the Vacuum or not.
    public boolean containsVacuum(){
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
    //Places the Vacuum Into Room
    public void setVacuum(){
        this.hasVacuum = true;
    }
    
    //Removes Vacuum from the Room
    public void removeVacuum(){
        this.hasVacuum = false;
    }
    
    //Makes the Room Dirty.
    public void makeDirty(){
        this.dirty = true;
    }
    
    //Makes the Room Clean.
    public void cleanRoom(){
        this.dirty = false;
    }
    
    
    
}
