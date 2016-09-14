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
    
    @Override
    public void start(Stage primaryStage) {
     
        //For the 4x4 Rooms (First Scenario)
        int rows = 4;
        int cols = 4;
       
        //Initialize Rooms Array
        Room[][] rooms = new Room[rows][cols];
        
        
        //Create Rooms for First Scenario
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                rooms[i][j] = new Room(i,j);
            }
        }
      
        //Place Initial Dirt
        rooms[0][1].makeDirty();
        rooms[0][3].makeDirty();
        rooms[1][1].makeDirty();
        rooms[1][2].makeDirty();
        rooms[2][0].makeDirty();
        rooms[3][1].makeDirty();
        rooms[3][3].makeDirty();
        
        //Place Initial Vacuum
        rooms[2][1].placeVacuum();
        
        //Display Array of Objects to Screen
        
        //Our Window
        Stage window = primaryStage;
        
        //Set Window's Title
        window.setTitle("Vacuum Cleaning Application!");
        
        //Our Layout
        GridPane grid = new GridPane();
        //Set Padding for Grid Cells
        grid.setPadding(new Insets(20,20,20,20));
                
        //Update State Display
        StateSpace currentStateSpace = new StateSpace(rooms);
        
        //Display
        currentStateSpace.printStateSpace(grid);
        
        
        Scene scene = new Scene(grid, 500,300);
         
        //Display Window
        window.setScene(scene);
        window.show();
        
        
        
        
        
        
        
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
