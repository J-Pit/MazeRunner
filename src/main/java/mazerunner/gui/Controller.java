package mazerunner.gui;

import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import mazerunner.engine.GameEngine;

import java.util.HashMap;

public class Controller {
    @FXML
    private Button up;
    @FXML
    private Button down;
    @FXML
    private Button left;
    @FXML
    private Button right;
    @FXML
    private GridPane grid;

    @FXML
    private TextField difficulty;
    GameEngine g = new GameEngine(10);

    @FXML
    private Cell[][] cell =  new Cell[g.getSize()][g.getSize()];
        // Pane to hold cell

    HashMap<String,String> cellImages = new HashMap<String,String>();
    @FXML
    public void initialize(){
        System.out.println(grid.getRowCount());
        cellImages.put("c", "file:resources/coin.bmp");
        cellImages.put("t", "file:resources/trap.bmp");
        cellImages.put("a", "file:resources/apple.bmp");
        cellImages.put("e", "file:resources/exit.bmp");
        cellImages.put("_", "file:resources/exit.bmp");
        cellImages.put(">", "file:resources/exit.bmp");

        g.createInitialMap();
        for (int i = 0; i < g.getSize()-1; i++){
            for (int j = 0; j < g.getSize()-1; j++){
                Image image = new Image(cellImages.get(g.getCell(i,j)));
                ImageView iv1 = new ImageView();
                iv1.setImage(image);
                grid.add(iv1,i,j,1,1);
            }

        }


        System.out.println("test");


        System.out.println(grid.getRowCount());
    }

    public void updateGui(){

    }

}
