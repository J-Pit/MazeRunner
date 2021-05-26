package mazerunner.engine;

import java.io.PrintWriter;
import java.util.Arrays;
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
    private int traps = Difficulty;
    private int coins = 5;
    private int apples = 10 - Difficulty;
    private int exitCell = 1;

    public int getTraps() {
        return traps;
    }

    public int getCoins() {
        return coins;
    }

    public int getApples() {
        return apples;
    }

    public int getExitCell() {
        return exitCell;
    }

    /**
     * Iterates through the map and counts for a specific cell for testing purposes
     */
    public int getCell(String c){
        int count = 0;
        for(String[] i :map){
            for(String n : i){
                if (n == c){
                    count +=1;
                }
            }
        }
        return count;
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
     * adds traps, coins, apples and an exit to map
     * @// TODO: 25/5/21 fix cells being overwritten
     */
    public void createInitialMap() {
        for(String[] i:map){
            Arrays.fill(i,"_");
        }

        int[] numCells = new int[]{traps, coins, apples, exitCell};
        String[] cells = new String[]{"t","c","a","e"};
        for(int i = 0;i < cells.length;i++){
            while(numCells[i] > 0){
                map[(int) (Math.random() * (8 + 1))][(int) (Math.random() * (9 + 1))] = cells[i];
                numCells[i] -=1;
            }
        }

        map[9][0] = ">";
    }

    /**
     * prints map to screen without player
     */
    public void printMap() {
        for (String[] row : map) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();

        }
        System.out.println();
    }

    /**
     * prints map to screen with player
     */
    public void drawPlayer(int x, int y) {
        String under = map[x][y];
        map[x][y] = "P";
        printMap();
        map[x][y] = under;



    }
    /**
     * Returns the cell where the player is
     */
    public String returnUnder(int x, int y){
        return map[x][y];
    }
    public void setUnder(int x, int y, String s){
        map[x][y] = s;
    }
    /**
     * outputs the map to .txt files
     */
    public void outputMap(PrintWriter o){
        for(String[] i : map){
            for(String n:i){
                o.print(n);
            }
            o.print("\n");
        }
    }
    /**
     * loads the map from a .txt file
     */
    public void inputMap(Scanner s){
        for(int i = 0; i<9;i++){
            map[i] = s.nextLine().split("");
        }

    }
}






