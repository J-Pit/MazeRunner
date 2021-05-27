package mazerunner.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


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

    @FXML
    public void initialize(){
        System.out.println(grid.getRowCount());


        g.createInitialMap();
        g.printMap();
        updateGui();





        System.out.println("test");


        System.out.println(grid.getRowCount());
    }

    public void updateGui() {
        for(int row = 0;row < 10;row++){
            for(int col = 0;col<10;col++){
                Cell c = new Cell(g.getCell(row,col));
                c.setImage();
                grid.add(c,col,row);
            }
        }
    }

    public class Cell extends Pane{
        String token;
        HashMap<String,String> cellImages = new HashMap<String,String>();

        public Cell(String token){
            this.token = token;

        }




            public void setImage(){
                cellImages.put("c", "coin.bmp");
                cellImages.put("t", "trap.bmp");
                cellImages.put("a", "apple.jpg");
                cellImages.put("e", "Exit.bmp");
                cellImages.put("_", "nothing.bmp");
                cellImages.put(">", "entrance.bmp");
                Image i = new Image(cellImages.get(token));
                ImageView iv = new ImageView(i);
                iv.setFitHeight(50);
                iv.setFitWidth(50);
                getChildren().add(iv);
            }



    }

}
