package mazerunner.engine;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;
public class GameEngine {
    private boolean end = false;

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean win) {
        this.end = win;
    }

    private int difficulty = 5;

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Iterates through the map and counts for a specific cell.
     */
    public int getCellCount(String c){
        int count = 0;
        for(String[] i :map){
            for(String n : i){
                if (n.equals(c)){
                    count +=1;
                }
            }
        }
        return count;
    }
    /**
     * sets a cell on the map.
     */
    public void setCell(int x, int y, String c){
        map[x][y] = c;
    }
    /**
     * Returns the cell based off co-ords
     */
    public String getCell(int x,int y){
        return map[x][y];
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
     *
     */
    public void createInitialMap() {
        int traps = difficulty;
        int coins = 5;
        int apples = 10 - difficulty;
        int exitCell = 1;
        for(String[] i:map){
            Arrays.fill(i,"_");
        }

        int[] numCells = new int[]{traps, coins, apples, exitCell};
        String[] cells = new String[]{"t","c","a","e"};
        for(int i = 0;i < cells.length;i++){
            while(numCells[i] > 0){
                int x = (int) (Math.random() * (8 + 1));
                int y = (int) (Math.random() * (9 + 1));
                if(map[x][y].equals("_")){
                    map[x][y] = cells[i];
                    numCells[i] -=1;
                }
                else{
                    continue;
                }


            }
        }

        map[9][0] = ">";
    }

    /**
     * prints map to screen with player
     */
    public void drawPlayer(int x, int y) {
        String under = map[x][y];
        map[x][y] = "P";
        for (String[] row : map) {
            for (String cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println();
        map[x][y] = under;
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
    /**
     * loads the map and player stats from a .txt file
     */
        public void load(Player p) throws IOException {
            Scanner input = new Scanner(new File("save.txt"));
            inputMap(input);
            p.setPlayerX(Integer.parseInt(Files.readAllLines(Path.of("save.txt")).get(10)));
            p.setPlayerY(Integer.parseInt(Files.readAllLines(Path.of("save.txt")).get(11)));
            p.setStamina(Integer.parseInt(Files.readAllLines(Path.of("save.txt")).get(12)));
            p.setCoins(Integer.parseInt(Files.readAllLines(Path.of("save.txt")).get(13)));

        }
    /**
     * loads the map and player stats to a .txt file
     */
        public void save(Player p) throws FileNotFoundException {
            PrintWriter output = new PrintWriter("save.txt");
            outputMap(output);
            int[] values = {p.getPlayerX(), p.getPlayerY(), p.getStamina(), p.getCoins()};
            for(int i :values){
                output.println(i);
            }
            output.close();
        }

    /**
     * function for interacting with items on the map
     */
        public void onEnter(Player p) {
            switch (getCell(p.getPlayerX(),p.getPlayerY())){
                case "c":
                    p.setCoins(p.getCoins() + 1);
                    setCell(p.getPlayerX(), p.getPlayerY(), "_");
                    break;
                case "t":
                    p.setCoins(p.getCoins() - 1);
                    setCell(p.getPlayerX(), p.getPlayerY(), "t");
                    break;
                case "a":
                    p.setStamina(p.getStamina() + 3);
                    setCell(p.getPlayerX(), p.getPlayerY(), "_");
                    break;
                case "e":
                    setEnd(true);
                    System.out.println("You win!");
                    p.setScore(p.getCoins());
                    break;
            }
            if (p.getStamina() < 1 || p.getCoins() < 0) {
                setEnd(true);
                System.out.println("Game Over!");
                p.setScore(-1);
            }
        }

        /**
         * plays the game in text based version
         */
        public void playGame() throws IOException {
            System.out.printf("The size of map is %d * %d\n", getSize(), getSize());
            createInitialMap();
            Player p = new Player();
            drawPlayer(p.getPlayerX(), p.getPlayerY());
            while (!isEnd()) {
                System.out.printf("Stamina: %d\n",p.getStamina());
                System.out.printf("Coins: %d\n",p.getCoins());
                Scanner S = new Scanner(System.in);
                String s = S.nextLine();
                p.move(s);
                if (s.equals("save")){
                    save(p);
                }
                else if (s.equals("load")){
                    load(p);
                }
               drawPlayer(p.getPlayerX(), p.getPlayerY());
                onEnter(p);
            }
        }

        public static void main(String[] args) throws IOException {
            GameEngine e = new GameEngine(10);
            e.playGame();
        }
    }







