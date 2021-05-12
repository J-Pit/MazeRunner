package mazerunner.engine;

import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private boolean end = false;

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean win) {
        this.end = win;
    }

    private int Difficulty = 5;

    public int getDifficulty() {
        return Difficulty;
    }

    public void setDifficulty(int difficulty) {
        Difficulty = difficulty;
    }

    /**
     * An example board to store the current game state.
     * <p>
     * Note: depending on your game, you might want to change this from 'int' to String or something?
     */
    private String[][] map;

    /**
     * Creates a square game board.
     *
     * @param size the width and height.
     */
    public GameEngine(int size) {
        map = new String[size][size];
    }

    /**
     * The size of the current game.
     *
     * @return this is both the width and the height.
     */
    public int getSize() {
        return map.length;
    }

    /**
     * Plays a text-based game
     */

    public void createInitialMap() {
        int traps = getDifficulty();
        int coins = 5;
        int apples = 10 - getDifficulty();
        int exitCell = 1;


        for (int row = 0; row < 10; row++) {

            for (int cell = 0; cell < 10; cell++) {
                switch ((int) (Math.random() * (10 - 0 + 1) + 0)) {
                    case 0:
                        map[row][cell] = "*";
                        break;

                    case 1:
                        if (coins > 0) {
                            map[row][cell] = "c";
                            coins -= 1;
                        } else {
                            map[row][cell] = "*";
                        }
                        break;

                    case 2:
                        if (exitCell > 0) {
                            map[row][cell] = "e";
                            exitCell -= 1;
                        } else {
                            map[row][cell] = "*";
                        }
                        break;

                    case 3:
                        if (apples > 0) {
                            map[row][cell] = "a";
                            apples -= 1;
                        } else {
                            map[row][cell] = "*";
                        }
                        break;

                    case 4:
                        if (traps > 0) {
                            map[row][cell] = "t";
                            traps -= 1;
                        } else {
                            map[row][cell] = "*";
                        }
                        break;
                    default:
                        map[row][cell] = "*";


                }
            }

        }
        map[9][0] = ">";
    }

    public void printMap() {
        for (String[] row : map) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();

        }
        System.out.println();
    }


    public void drawPlayer(int x, int y) {
        String under = map[x][y];
        map[x][y] = "P";
        printMap();
        map[x][y] = under;



    }
    public String returnUnder(int x, int y){
        return map[x][y];
    }
    public void setUnder(int x, int y, String s){
        map[x][y] = s;
    }
}






