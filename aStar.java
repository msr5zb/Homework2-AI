/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

/**
 *
 * @author sugarhryszko
 */
public class aStar {
    
    private int row;
    private int column;
    
    public aStar(int row, int column){
        this.row = row;
        this.column = column;
        
    }
    
    //corresponds to index val of array of dirty rooms
    public void setHeuristicVal (Room r, int stepsTaken) {
        int widthNum = 0; 
        int heightNum = 0;
        
        for(int i = 0; i < numDirtyRooms; i++) {
            if (dirtyRooms[i].getRow <= r.getRow){
                widthnum = r.getRow - dirtyRooms[i].getRow;
            } else {
                widthnum = dirtyRooms[i].getRow - r.getRow;
            }
            
            if (dirtyRooms[i].getColumn <= r.getColumn){
                widthnum = r.getColumn - dirtyRooms[i].getColumn;
            } else {
                widthnum = dirtyRooms[i].getColumn - r.getColumn;
            }
            
            heurvals[i] = widthNum + heightNum;
        }
        
        
        //distance from dirty array
    }
    
    public int makeDecision(Rooms room, int row, int col, int stepsTaken, int currentSmallest) {

        if (current.isDirty) {
            //clean
            isClean = true;
            visited = true;
            return 0;
        } 
        
        
        
        
        if (current.canMove(left)){
            int leftHVal = findSmallestHeurVal(rooms[row-1][col]) + stepsTaken;
        } 
        if (current.canMove(right)){
            int rightHVal = findSmallestHeurVal(rooms[row+1][col]) + stepsTaken;
            
        } 
        if (current.canMove(down)){
            int downHval = findSmallestHeurVal(rooms[row][col+1]) + stepsTaken;
        } 
        if (current.canMove(up)){
            int upHVal = findSmallestHeurVal(rooms[row][col+1]) + stepsTaken;
        }
        
        if (leftHVal < currentSmallest)
        
        
    }
    
    bool canMove(direction) {
        if (left) {
            if (column == 1) {
                return false;
            }
            return true;
        }
        else if (right) {
            if (column == numCols) {
                return false;
            }
            return true;
        }
        else if (down) {
            if (row == numRows) {
                return false;
            }
            return true;
        }
        else if (up) {
            if (column == 1) {
                return false;
            }
            return true;
        }
        
        return false;
    }
    
    void setUpAstar(Room room) {
       
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                room[i][j].heurVals[i][j] = setHeuristicVal();
            }
        }
   
    }
    
    int findSmallestHeurVal(Room room) {
        //index of smallest heuristic value
        int smallest;
        smallest = room.heurval[0];
        for(int i = 1; i < numDirtyRooms; i++) {
            if (room.heurval[i] < smallest) {
                smallest = room.heurval[i];
            }
        }
    }
    
    void runAstar (Room room) {
        int x = 0;
        while (dirtyRooms != 0 && x >= 0) {
            
            int x =  makeDecision();
            
            if(x < 0) {
                steps ++;
            }
            else {
                if (x == 1) {
                    //change location;
                } else if (x == 2) {
                    //change location;
                } else if (x == 3) {
                    //change location;
                } else if (x == 4) {
                    //change location;
                }
                steps++;
            }
        }
   }
    
    
}
//makeDecision
//check if dirty (statespace of current room)
//if