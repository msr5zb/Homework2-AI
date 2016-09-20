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
public class AlgorithmDFGS {
  
    
    public StateSpace doStuff(StateSpace currentStateSpace){
       
       System.out.println("I'm supposed to do stuff.");
       return currentStateSpace;
    }
    
    
    //Up, Left, Clean, Right, Down
    //Returns The Goal State if Found, Null Otherwise
    public StateSpace IterationDFGS(StateSpace workingStateSpace){
        if(workingStateSpace == null){return null;}
        
        workingStateSpace.printCurrentRoomLocation();

        System.out.println("Dirty Room Count is: " + workingStateSpace.getDirtyRoomCount());

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
                StateSpace childStateSpace = IterationDFGS(workingStateSpace.getChildren().get("upChild"));
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
                StateSpace childStateSpace = IterationDFGS(workingStateSpace.getChildren().get("leftChild"));
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
                StateSpace childStateSpace = IterationDFGS(workingStateSpace.getChildren().get("cleanChild"));
                //If The Child Is the Goal State, Return
                if(childStateSpace != null){
                    if(childStateSpace.getDirtyRoomCount() == 0){
                        return childStateSpace;
                    }
                }
            }
             //If Node has a Left Child, Run the Algorithm on our up child.
            if(workingStateSpace.getChildren().get("rightChild") != null ){
                //Return What the Child Node Gives
                StateSpace childStateSpace = IterationDFGS(workingStateSpace.getChildren().get("rightChild"));
                //If The Child Is the Goal State, Return
                if(childStateSpace != null){
                    if(childStateSpace.getDirtyRoomCount() == 0){
                        return childStateSpace;
                    }
                }
            }
             //If Node has a Left Child, Run the Algorithm on our up child.
            if(workingStateSpace.getChildren().get("downChild") != null ){
                //Return What the Child Node Gives
                StateSpace childStateSpace = IterationDFGS(workingStateSpace.getChildren().get("downChild"));
                //If The Child Is the Goal State, Return
                if(childStateSpace != null){
                    if(childStateSpace.getDirtyRoomCount() == 0){
                        return childStateSpace;
                    }
                }
            }        
            
            
                System.out.println("ALL NODES DISCOVERED, Backing Up~");
                return null;
            
            
        

        
    }
    
    
    
    
    
}
