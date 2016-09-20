/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2.ai;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Mike
 */
public class Homework2AI extends Application {
    
    StateSpace currentStateSpace;
    
    @Override
    public void start(Stage primaryStage) {
        //Our Window
        Stage window = primaryStage;
        
        //Set Window's Title
        window.setTitle("Vacuum Cleaning Application!");

        
        //Initialize Rooms Array
        Room[][] rooms = new Room[4][4];
               
        RoomGenerator roomFourByFourGenerator = new RoomGenerator();
        roomFourByFourGenerator.createRooms(rooms);
 
        int rows = rooms.length;
        int cols = rooms[0].length;
        
        //Our Layout
        GridPane grid = new GridPane();
        //Set Padding for Grid Cells
        grid.setPadding(new Insets(20,20,20,20)); 

        //Update State Display
        StateSpace workingStateSpace = new StateSpace(rooms, rows, cols);
        setCurrentState(workingStateSpace);
        
        //Labels n Stuffs
        Label currentRoomLabel = new Label("Vacuum Location: ");
        Label dirtyRoomCountLabel = new Label("Dirty Rooms: ");
        Label scoreLabel = new Label("Score: ");
        Label depthLabel = new Label("Depth: ");
        TextArea actionListTextArea = new TextArea("");
        ScrollPane actionListScrollPane = new ScrollPane();
        actionListScrollPane.setContent(actionListTextArea); 
        
        Button cleanButton = new Button("Clean");
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");
        Button upButton = new Button("Up");
        Button downButton = new Button("Down");
        
        Button buttonIDS = new Button("IDS");
        Button buttonDFGS = new Button("DFGS");
        Button buttonAStar = new Button("A*");
        Button buttonRestart = new Button("Restart");

        GridPane.setConstraints(currentRoomLabel,rows+1 , 0);
        GridPane.setConstraints(dirtyRoomCountLabel, rows+1, 1);
        GridPane.setConstraints(scoreLabel, rows+1, 2);
        GridPane.setConstraints(depthLabel, rows+1, 3);
        GridPane.setConstraints(actionListScrollPane, rows+1, 4, 2, 1);
        
        GridPane.setConstraints(upButton, cols+5, 0);
        GridPane.setConstraints(cleanButton, cols+5, 1);
        GridPane.setConstraints(downButton, cols+5, 2);
        GridPane.setConstraints(leftButton, cols+4, 1);
        GridPane.setConstraints(rightButton, cols+6, 1);
        
        GridPane.setConstraints(buttonIDS,cols+2 , 0);
        GridPane.setConstraints(buttonDFGS,cols+2 , 1);
        GridPane.setConstraints(buttonAStar,cols+2 , 2);
        GridPane.setConstraints(buttonRestart,cols+2 , 3);
        
        grid.getChildren().addAll(currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListScrollPane, cleanButton, leftButton, rightButton, upButton, downButton, buttonIDS, buttonDFGS, buttonAStar, buttonRestart);            
        getCurrentState().updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
        getCurrentState().generateChildren();

        
        cleanButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                StateSpace updatedState = getCurrentState().getChildren().get("cleanChild");
                
                if(updatedState!=null){
                    updatedState.generateChildren();
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Cannot Move This Direction.");}
            }  
        });        
         leftButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                StateSpace updatedState = getCurrentState().getChildren().get("leftChild");
                
                if(updatedState!=null){
                    updatedState.generateChildren();
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Cannot Move This Direction.");}
            }  
        });    

         rightButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                 StateSpace updatedState = getCurrentState().getChildren().get("rightChild");
                
                if(updatedState!=null){
                    updatedState.generateChildren();
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Cannot Move This Direction.");}       
            }  
        });
        
         upButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                StateSpace updatedState = getCurrentState().getChildren().get("upChild");
                
                if(updatedState!=null){
                    updatedState.generateChildren();
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Cannot Move This Direction.");}
            }  
        });
         downButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                StateSpace updatedState = getCurrentState().getChildren().get("downChild");
                
                if(updatedState!=null){
                    updatedState.generateChildren();
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Cannot Move This Direction.");}
            }  
        });

         buttonIDS.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
//                StateSpace updatedState = getCurrentState().getChildren().get("downChild");
//                
//                if(updatedState!=null){
//                    updatedState.generateChildren();
//                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
//                    setCurrentState(updatedState);       
//                }
//                else{System.out.println("Cannot Move This Direction.");}
            }  
        });

         buttonDFGS.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
//                StateSpace updatedState = getCurrentState().getChildren().get("downChild");
//                
//                if(updatedState!=null){
//                    updatedState.generateChildren();
//                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
//                    setCurrentState(updatedState);       
//                }
//                else{System.out.println("Cannot Move This Direction.");}
            }  
        });
         
         buttonAStar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
//                StateSpace updatedState = getCurrentState().getChildren().get("downChild");
//                
//                if(updatedState!=null){
//                    updatedState.generateChildren();
//                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
//                    setCurrentState(updatedState);       
//                }
//                else{System.out.println("Cannot Move This Direction.");}
            }  
        });
         buttonRestart.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                //Initialize Rooms Array
                Room[][] rooms = new Room[4][4];

                RoomGenerator roomFourByFourGenerator = new RoomGenerator();
                roomFourByFourGenerator.createRooms(rooms);
        
                //Update State Display
                StateSpace workingStateSpace = new StateSpace(rooms, rooms.length, rooms[0].length);
                setCurrentState(workingStateSpace);
                
                               
                if(workingStateSpace!=null){
                    workingStateSpace.generateChildren();
                    workingStateSpace.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(workingStateSpace);       
                }
                else{System.out.println("Cannot Move This Direction.");}
            }  
        });      

        
        Scene scene = new Scene(grid, 1000,600);
         
        //Display Window
        window.setScene(scene);
        window.show();
        
        
        
        
        
        
        
      
    }

    
    public void setCurrentState(StateSpace workingStateSpace){
        if(workingStateSpace.getDirtyRoomCount()==0){System.out.println("YOU WIN!");}
        this.currentStateSpace = workingStateSpace;
    }
    public StateSpace getCurrentState(){return this.currentStateSpace;}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}


//        //The DFGS Stuffs
//        Button DFGSButton = new Button("DFGS");
//        DFGSButton.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Running the DFGS Algorithm");
//                AlgorithmDFGS searchDFGS = new AlgorithmDFGS();
//                StateSpace newStateSpace = searchDFGS.doStuff(currentStateSpace);
//                newStateSpace.updateStateSpaceDisplay(grid);
//            }  
//        });
//        GridPane.setConstraints(DFGSButton, rows+2, 2);
//        grid.getChildren().add(DFGSButton);        
//        
//        //The A* Stuffs
//        Button aStarButton = new Button("A*");
//          aStarButton.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Running the A* Algorithm");
//                AlgorithmAStar searchAStar = new AlgorithmAStar();
//                StateSpace newStateSpace = searchAStar.doStuff(currentStateSpace);
//                newStateSpace.updateStateSpaceDisplay(grid);
//            }  
//        });
//        GridPane.setConstraints(aStarButton, rows+3, 2);
//        grid.getChildren().add(aStarButton);    
//        
//         //The A* Stuffs
//        Button showChildren = new Button("Children");
//          showChildren.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Children Demo");
//                ChildrenDemo childrenDemo = new ChildrenDemo(currentStateSpace);
//                currentStateSpace.updateStateSpaceDisplay(grid);
//            }  
//        });
//        GridPane.setConstraints(showChildren, rows, 3);
//        grid.getChildren().add(showChildren);
//
//
//        //The IDS Stuffs
//        Button IDSButton = new Button("IDS");
//        IDSButton.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Running the IDS Algorithm");
//                AlgorithmIDS searchIDS = new AlgorithmIDS();
//                StateSpace newStateSpace = searchIDS.doStuff(currentStateSpace);
//                if(newStateSpace != null)
//                newStateSpace.updateStateSpaceDisplay(grid);
//            }  
//        });
//        GridPane.setConstraints(IDSButton, rows+1, 2);
//        grid.getChildren().add(IDSButton);
//        