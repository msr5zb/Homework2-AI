/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mike
 */
public class AlgorithmIDS {
    
    
    public AlgorithmIDS(){
        
    }
    
    
    
    public StateSpace IterateIDS(StateSpace workingStateSpace){
        
        List<StateSpace> fringe = new ArrayList<StateSpace>();
        
        fringe.add(workingStateSpace);
        
        while(workingStateSpace.getDirtyRoomCount() != 0){
            workingStateSpace = fringe.get(0);
            fringe.remove(0);
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
        
        
        
        
        
        //Check if Null Node
        if(workingStateSpace == null){return null;}
        
        //Print to Console Information
        workingStateSpace.printCurrentRoomLocation();
        System.out.println("Dirty Room Count is: " + workingStateSpace.getDirtyRoomCount());

        while(workingStateSpace.getDirtyRoomCount() !=0){
            
            
            
            
            
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //Base Case
        if(workingStateSpace.getDirtyRoomCount() == 0){
            System.out.println("You did ITTTTTTTTTTTTTTTTTTT");
            return workingStateSpace;    
        }
      
        //If Node Does Not have Children, Generate Them.
        if(workingStateSpace.getChildren() == null || workingStateSpace.getChildren().isEmpty()){
            System.out.println("No Children Found, Making Babies...");
            workingStateSpace.generateChildren();
        }

        //If Node has an Up Child, Run the Algorithm on our up child.
        if(workingStateSpace.getChildren().get("upChild") != null ){

            //Return What the Child Node Gives
            StateSpace childStateSpace = IterateIDS(workingStateSpace.getChildren().get("upChild"));
            //If The Child Is the Goal State, Return
            if(childStateSpace != null){
                if(childStateSpace.getDirtyRoomCount() == 0){
                    return childStateSpace;
                }
            }
        }

        //If Node has a Left Child, Run the Algorithm on our up child.
        if(workingStateSpace.getChildren().get("leftChild") != null ){
            //Return What the Child Node Gives
            StateSpace childStateSpace = IterateIDS(workingStateSpace.getChildren().get("leftChild"));
            //If The Child Is the Goal State, Return
            if(childStateSpace != null){
                if(childStateSpace.getDirtyRoomCount() == 0){
                    return childStateSpace;
                }
            }
        }
         //If Node has a Left Child, Run the Algorithm on our up child.
        if(workingStateSpace.getChildren().get("cleanChild") != null ){
            //Return What the Child Node Gives
            StateSpace childStateSpace = IterateIDS(workingStateSpace.getChildren().get("cleanChild"));
            //If The Child Is the Goal State, Return
            if(childStateSpace != null){
                if(childStateSpace.getDirtyRoomCount() == 0){
                    return childStateSpace;
                }
            }
        }
         //If Node has a Right Child, Run the Algorithm on our up child.
        if(workingStateSpace.getChildren().get("rightChild") != null ){
            //Return What the Child Node Gives
            StateSpace childStateSpace = IterateIDS(workingStateSpace.getChildren().get("rightChild"));
            //If The Child Is the Goal State, Return
            if(childStateSpace != null){
                if(childStateSpace.getDirtyRoomCount() == 0){
                    return childStateSpace;
                }
            }
        }
         //If Node has a Down Child, Run the Algorithm on our up child.
        if(workingStateSpace.getChildren().get("downChild") != null ){
            //Return What the Child Node Gives
            StateSpace childStateSpace = IterateIDS(workingStateSpace.getChildren().get("downChild"));
            //If The Child Is the Goal State, Return
            if(childStateSpace != null){
                if(childStateSpace.getDirtyRoomCount() == 0){
                    return childStateSpace;
                }
            }
        }        

        //All Nodes Discovered/Null, Return.
        System.out.println("ALL NODES DISCOVERED, Backing Up~");
        return null;
        
        
        
        
    }
    
    


}
