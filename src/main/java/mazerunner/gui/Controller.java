package mazerunner.gui;

import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import mazerunner.engine.GameEngine;

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
    private Object Rectangle;

    @FXML
    public void initialize(){
        GameEngine g = new GameEngine(10);
        System.out.println("test");


        System.out.println(grid.getRowCount());
    }

}
