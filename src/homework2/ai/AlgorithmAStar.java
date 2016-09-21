/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mike
 */
public class AlgorithmAStar {
    
    
    
    
    public StateSpace doStuff(StateSpace currentStateSpace){
       
       System.out.println("I'm supposed to do stuff.");
       return currentStateSpace;
    }
    
    
    public StateSpace IterationAStar(StateSpace workingStateSpace){
     
        List<StateSpace> fringe = new ArrayList<StateSpace>();
        fringe.add(workingStateSpace);
        
        while(workingStateSpace.getDirtyRoomCount() != 0){
            workingStateSpace = getLowestCost(fringe);
            workingStateSpace.printCurrentRoomLocation();
            
            
            
            //up left clean right down
            workingStateSpace.generateChildren();
            if(workingStateSpace.getChildren().get("upChild") != null){
                fringe.add(workingStateSpace.getChildren().get("upChild"));
            }
            if(workingStateSpace.getChildren().get("leftChild") != null){
                fringe.add(workingStateSpace.getChildren().get("leftChild"));
            }
            if(workingStateSpace.getChildren().get("cleanChild") != null){
                fringe.add(workingStateSpace.getChildren().get("cleanChild"));
            }
            if(workingStateSpace.getChildren().get("rightChild") != null){
                fringe.add(workingStateSpace.getChildren().get("rightChild"));
            }
            if(workingStateSpace.getChildren().get("downChild") != null){
                fringe.add(workingStateSpace.getChildren().get("downChild"));
            }
 
        }
  
        return workingStateSpace;
        
        
        
        
    }
    
    
    
    public StateSpace getLowestCost(List<StateSpace> fringe){
        
        //Score of Path + # of Dirty Rooms
        
        
        StateSpace lowestCostStateSpace;
        lowestCostStateSpace = fringe.get(0);
        int lowestCostIndex = 0;
        
        for(int i = 0; i < fringe.size(); i++) {
            
            //if(lowestCostStateSpace.getScore() > fringe.get(i).getScore()){
            if((lowestCostStateSpace.getScore() +  lowestCostStateSpace.getDirtyRoomCount()) > (fringe.get(i).getScore() + fringe.get(i).getDirtyRoomCount())){
                lowestCostStateSpace = fringe.get(i);
                lowestCostIndex = i;
            }
        } 
        
        fringe.remove(lowestCostIndex);
        return lowestCostStateSpace;
    }
    


}
