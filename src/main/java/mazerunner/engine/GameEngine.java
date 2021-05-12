package mazerunner.engine;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GameEngine {
    private int numOfCoins;
    private int numOfTraps;
    private int numOfApples;
    private int numOfExits;

    public int getNumOfCoins() {
        return numOfCoins;
    }

    public int getNumOfTraps() {
        return numOfTraps;
    }

    public int getNumOfApples() {
        return numOfApples;
    }

    public int getNumOfExits() {
        return numOfExits;
    }

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
        for(String[] i:map){
            Arrays.fill(i,"_");
        }
        int traps = getDifficulty();
        int coins = 5;
        int apples = 10 - getDifficulty();
        int exitCell = 1;
        int[] numCells = new int[]{traps, coins, apples, exitCell};
        String[] cells = new String[]{"t","c","a","e"};
        for(int i = 0;i < cells.length;i++){
            while(numCells[i] > 0){
                map[(int) (Math.random() * (9 - 0 + 1) + 0)][(int) (Math.random() * (9 - 0 + 1) + 0)] = cells[i];
                numCells[i] -=1;
            }
        }




        //map[9][0] = ">";
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

    public static void main(String[] args) {
        GameEngine e = new GameEngine(10);
        e.createInitialMap();
        e.printMap();
    }
}






