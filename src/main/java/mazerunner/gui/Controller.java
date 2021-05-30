package mazerunner.gui;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import mazerunner.engine.GameEngine;
import mazerunner.engine.Player;

import java.io.FileNotFoundException;
import java.io.IOException;
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
    private TextField stamina;
    @FXML
    private TextField coins;
    @FXML
    private Button newGame;
    @FXML
    private Button load;
    @FXML
    private Button save;
    @FXML
    private TextField difficulty;
    GameEngine g = new GameEngine(10);
    Player p = new Player();

    @FXML
    private Cell[][] cell =  new Cell[g.getSize()][g.getSize()];

    @FXML
    public void initialize(){
        newGame.setOnAction(e -> {
            g.setDifficulty(Integer.parseInt(difficulty.getText()));
            g.createInitialMap();
            updateGui();
        });
        save.setOnAction(e -> {
            try {
                g.save(p);
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        load.setOnAction(e -> {
            try {
                g.createInitialMap();
                g.load(p);

            } catch (IOException ioException) {
                System.out.println("No save file found");
            }
            updateGui();
        });
        up.setOnAction(e -> {
           p.move("up");
            updateGui();
        });
        down.setOnAction(e -> {
            p.move("down");
            updateGui();
        });
        left.setOnAction(e -> {
            p.move("left");
            updateGui();
        });
        right.setOnAction(e -> {
            p.move("right");
            updateGui();
        });

    }

    public void updateGui() {
        g.drawPlayer(p.getPlayerX(), p.getPlayerY());
        g.onEnter(p);
        if(g.isEnd()){
            Platform.exit();
        }
        stamina.setText("Stamina: "+p.getStamina());
        coins.setText("Coins: "+ p.getCoins());
        grid.getChildren().clear();
        for(int row = 0;row < 10;row++){
            for(int col = 0;col<10;col++){
                cell[row][col] = new Cell(g.getCell(row,col));
                cell[row][col].setImage();
                grid.add(cell[row][col],col,row);
            }
        }
        Cell P = new Cell("p");
        P.setImage();
        grid.add(P,p.getPlayerY(),p.getPlayerX());
    }

    public class Cell extends Pane{
        private String token;
        public Cell(String token){
            this.token = token;
        }
            public void setImage(){
                HashMap<String,String> cellImages = new HashMap<String,String>();
                cellImages.put("c", "coin.bmp");
                cellImages.put("t", "trap.bmp");
                cellImages.put("a", "apple.bmp");
                cellImages.put("e", "exit.bmp");
                cellImages.put("_", "nothing.bmp");
                cellImages.put(">", "entrance.bmp");
                cellImages.put("p", "player.bmp");
                Image i = new Image(cellImages.get(token));
                ImageView iv = new ImageView(i);
                iv.setFitHeight(50);
                iv.setFitWidth(50);
                getChildren().add(iv);
        }
    }
}
