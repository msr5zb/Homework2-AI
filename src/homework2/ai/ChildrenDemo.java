/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import java.util.HashMap;

/**
 *
 * @author Mike
 */
public class ChildrenDemo {
    
    public ChildrenDemo(StateSpace currentStateSpace){
        System.out.println("Showing Children of Current State: ");
        currentStateSpace.generateChildren();
        HashMap<String, StateSpace> children = currentStateSpace.getChildren();
        
        
        
        if(children.get("cleanChild") != null){System.out.println("Clean Child: " + children.get("cleanChild").getCurrentRoom().getRow() +","+ children.get("cleanChild").getCurrentRoom().getColumn());}
        else{System.out.println("Clean Child: Null");}
        if(children.get("leftChild") != null){System.out.println("Left Child: " + children.get("leftChild").getCurrentRoom().getRow() +","+ children.get("leftChild").getCurrentRoom().getColumn());}
        else{System.out.println("Left Child: Null");} 
        if(children.get("rightChild") != null){System.out.println("Right Child: " + children.get("rightChild").getCurrentRoom().getRow() +","+ children.get("rightChild").getCurrentRoom().getColumn());}
        else{System.out.println("Right Child: Null");}
        if(children.get("upChild") != null){System.out.println("Up Child: " + children.get("upChild").getCurrentRoom().getRow() +","+ children.get("upChild").getCurrentRoom().getColumn());}
        else{System.out.println("Up Child: Null");}
        if(children.get("downChild") != null){System.out.println("Down Child: " + children.get("downChild").getCurrentRoom().getRow() +","+ children.get("downChild").getCurrentRoom().getColumn());}
        else{System.out.println("Down Child: Null");}
        
        //System.out.println("Left Child: " + children.get("leftChild").getCurrentRoom().getRow() +","+ children.get("leftChild").getCurrentRoom().getColumn());
        //System.out.println("Right Child: " + children.get("rightChild").getCurrentRoom().getRow() +","+ children.get("rightChild").getCurrentRoom().getColumn());
        //System.out.println("Up Child: " + children.get("upChild").getCurrentRoom().getRow() +","+ children.get("upChild").getCurrentRoom().getColumn());
        //System.out.println("Down Child: " + children.get("downChild").getCurrentRoom().getRow() +","+ children.get("downChild").getCurrentRoom().getColumn());
    }
    
}
