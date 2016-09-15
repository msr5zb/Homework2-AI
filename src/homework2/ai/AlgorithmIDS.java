/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import java.util.List;

/**
 *
 * @author Mike
 */
public class AlgorithmIDS {
    
    
    
    public StateSpace doStuff(StateSpace rootSpaceState){
        
//        List<StateSpace> children = rootSpaceState.getChildren();
//            for (int i = 0; i < children.size(); i++) {
//                System.out.println("Looking at Child: " + children.get(i).getCurrentRoom().getRow() + "," + children.get(i).getCurrentRoom().getColumn());
//                System.out.println("Looking at Child Depth: " + children.get(i).getDepth());
//            }
        
        
       System.out.println("Starting Inner Alg");
       StateSpace found = null;
       int depth = 0;
       int limit = 3;
       found = DLS(rootSpaceState, depth, limit);
       if(found !=null){
           System.out.println("you did it lol");
       }     
       
            
       return found;
    }
    
    private StateSpace DLS(StateSpace node, int depth, int limit){
        System.out.println("Iteration");

        if(node.getDirtyRoomCount()==0){
            return node;
        }
        else if(node.getDepth() >= limit){
            return null;
        }
        
        
        
        else{
            //foreach child of node (Clean, Left, Right Up, Down
            List<StateSpace> children = node.getChildren();
            System.out.println("CHILDREN MADE");
            if(children.size()==0 || children == null){
                System.out.println("Gotcha");
                return null;
            }
            for (int i = 0; i < children.size(); i++) {
                System.out.println("Looking at Child: " + children.get(i).getCurrentRoom().getRow() + "," + children.get(i).getCurrentRoom().getColumn());
                System.out.println("Looking at Child Depth: " + children.get(i).getDepth());

                StateSpace foundStateSpace = DLS(children.get(i), children.get(i).getDepth(), limit);
                if(foundStateSpace.getDirtyRoomCount() == 0){
                    System.out.println("!!!!!");
                    return foundStateSpace;
                }
                
            }
            return null;
        }

        
        
    }
    
    
    
    
    

}
