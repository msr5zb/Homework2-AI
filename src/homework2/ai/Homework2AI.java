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
    int rows = 0;
    int columns = 0;
        
    @Override
    public void start(Stage primaryStage) {
        //Our Window
        Stage window = primaryStage;
        
        //Set Window's Title
        window.setTitle("Vacuum Cleaning Application!");

        //Default Room
        setRows(4);
        setColumns(4);
        
        //Initialize Rooms Array
        Room[][] rooms = new Room[getRows()][getColumns()];
               
        RoomGenerator roomFourByFourGenerator = new RoomGenerator();
        roomFourByFourGenerator.createRooms(rooms);
 
        
        
        //Our Layout
        GridPane grid = new GridPane();
        //Set Padding for Grid Cells
        grid.setPadding(new Insets(20,20,20,20)); 

        //Update State Display
        StateSpace workingStateSpace = new StateSpace(rooms, getRows(), getColumns());
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
        Button buttonToggleRooms = new Button("ToggleRooms");

        GridPane.setConstraints(currentRoomLabel,getRows()+1 , 0);
        GridPane.setConstraints(dirtyRoomCountLabel, getRows()+1, 1);
        GridPane.setConstraints(scoreLabel, getRows()+1, 2);
        GridPane.setConstraints(depthLabel, getRows()+1, 3);
        GridPane.setConstraints(actionListScrollPane, getRows()+1, 4, 2, 1);
        
        GridPane.setConstraints(upButton, getColumns()+5, 0);
        GridPane.setConstraints(cleanButton, getColumns()+5, 1);
        GridPane.setConstraints(downButton, getColumns()+5, 2);
        GridPane.setConstraints(leftButton, getColumns()+4, 1);
        GridPane.setConstraints(rightButton, getColumns()+6, 1);
        
        GridPane.setConstraints(buttonIDS,getColumns()+2 , 0);
        GridPane.setConstraints(buttonDFGS,getColumns()+2 , 1);
        GridPane.setConstraints(buttonAStar,getColumns()+2 , 2);
        GridPane.setConstraints(buttonRestart,getColumns()+2 , 3);
        GridPane.setConstraints(buttonToggleRooms,getColumns()+3 , 0);
        
        grid.getChildren().addAll(currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListScrollPane, cleanButton, leftButton, rightButton, upButton, downButton, buttonIDS, buttonDFGS, buttonAStar, buttonRestart, buttonToggleRooms);            
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
                AlgorithmIDS startIDS = new AlgorithmIDS();
                long startTime = System.nanoTime();
                StateSpace updatedState = startIDS.IterateIDS(getCurrentState());
                long endTime = System.nanoTime();
                long duration = (endTime - startTime); 
                System.out.println("*******************************************************************************************");
                System.out.println("Ran in: " + duration/1000000);
                if(updatedState!=null){                   
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Lol gg");}
            }  
        });

         buttonDFGS.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
               
                AlgorithmDFGS startDFGS = new AlgorithmDFGS();
                long startTime = System.nanoTime();
                StateSpace updatedState = startDFGS.IterationDFGS(getCurrentState());
                long endTime = System.nanoTime();
                long duration = (endTime - startTime); 
                System.out.println("*******************************************************************************************");
                System.out.println("Ran in: " + duration/1000000);
                if(updatedState!=null){                   
                    updatedState.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    
                    setCurrentState(updatedState);       
                }
                else{System.out.println("Lol gg");}
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
                
                Room[][] rooms = new Room[getRows()][getColumns()];

                RoomGenerator roomGenerator = new RoomGenerator();
                roomGenerator.createRooms(rooms);
        
                //Update State Display
                StateSpace workingStateSpace = new StateSpace(rooms, getRows(), getColumns());
                setCurrentState(workingStateSpace);
                
                               
                if(workingStateSpace!=null){
                    workingStateSpace.generateChildren();
                    workingStateSpace.updateStateSpaceDisplay(grid, currentRoomLabel, dirtyRoomCountLabel, scoreLabel, depthLabel, actionListTextArea);
                    setCurrentState(workingStateSpace);       
                }
                else{System.out.println("Cannot Move This Direction.");}
            }  
        }); 
         
         buttonToggleRooms.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(getRows() == 4){
                    setRows(5);
                    setColumns(6);  
                }
                else{
                    setRows(4);
                    setColumns(4);  
                }
                
                
                Room[][] rooms = new Room[getRows()][getColumns()];

                RoomGenerator roomGenerator = new RoomGenerator();
                roomGenerator.createRooms(rooms);
        
                //Update State Display
                StateSpace workingStateSpace = new StateSpace(rooms, getRows(), getColumns());
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
    
    public int getRows(){
     return this.rows;   
    }
    public void setRows(int value){
        this.rows = value;
    }
    public int getColumns(){
     return this.columns;   
    }
    public void setColumns(int value){
        this.columns = value;
    }
    
    public StateSpace getCurrentState(){return this.currentStateSpace;}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
