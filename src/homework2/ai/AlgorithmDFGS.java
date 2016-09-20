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
    public StateSpace IterationDFGS(StateSpace parentStateSpace){
       if(parentStateSpace == null){return null;}
        
        if(parentStateSpace != null){parentStateSpace.printCurrentRoomLocation();}
        else{System.out.println("WHOAH NULLY");}

        System.out.println("Dirty Room Count is: " + parentStateSpace.getDirtyRoomCount());

        if(parentStateSpace.getDirtyRoomCount() == 0){
            return parentStateSpace;    
        }
        
        else{
            //Returned a Parent
         
            if(parentStateSpace.getChildren() == null){parentStateSpace.generateChildren();}
            
            
            
            if(parentStateSpace.getChildren().get("upChild") != null ){
                //If Our Child is the Desired StateSpace, return it
                if(parentStateSpace.getChildren().get("upChild").getDirtyRoomCount() == 0){
                    return parentStateSpace.getChildren().get("upChild");
                }
                //Else, Run the Algorithm of the Child
                else{
                    IterationDFGS(parentStateSpace.getChildren().get("upChild"));
                }   
            }
            
            
            
            if(parentStateSpace.getChildren().get("leftChild") != null){
                return IterationDFGS(parentStateSpace.getChildren().get("leftChild"));
            }
            if(parentStateSpace.getChildren().get("cleanChild") != null){
                return IterationDFGS(parentStateSpace.getChildren().get("cleanChild"));
            }
            if(parentStateSpace.getChildren().get("rightChild") != null){
                return IterationDFGS(parentStateSpace.getChildren().get("rightChild"));
            }
            if(parentStateSpace.getChildren().get("downChild") != null){
                return IterationDFGS(parentStateSpace.getChildren().get("downChild"));
            } 
            else{
                System.out.println("ALL NODES DISCOVERED, Backing Up~");
                return IterationDFGS(null);
            }
            
        }

        
    }
    
    
    
    
    
}
