package mazerunner.engine;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class playText {

    public void playGame() throws IOException {
        GameEngine engine = new GameEngine(10);
        System.out.printf("The size of map is %d * %d\n", engine.getSize(), engine.getSize());
        engine.createInitialMap();
        Player p = new Player();
        engine.drawPlayer(p.getPlayerX(), p.getPlayerY());
        while (!engine.isEnd()) {

            System.out.printf("Stamina: %d\n",p.getStamina());
            System.out.printf("Coins: %d\n",p.getCoins());
            Scanner S = new Scanner(System.in);
            String s = S.nextLine();
            p.move(s);
            if (s.equals("save")){
                PrintWriter output = new PrintWriter("save.txt");
                engine.outputMap(output);
                output.println(p.getPlayerX());
                output.println(p.getPlayerY());
                output.println(p.getStamina());
                output.println(p.getCoins());
                output.close();
            }
            else if (s.equals("load")){
                Scanner input = new Scanner(new File("save.txt"));
                engine.inputMap(input);
                String temp = Files.readAllLines(Path.of("save.txt")).get(10);
                p.setPlayerX(Integer.parseInt(temp));
                temp = Files.readAllLines(Path.of("save.txt")).get(11);
                p.setPlayerY(Integer.parseInt(temp));
                engine.drawPlayer(p.getPlayerX(), p.getPlayerY());
            }
            engine.drawPlayer(p.getPlayerX(), p.getPlayerY());
            System.out.println(p.getPlayerX());
            System.out.println(p.getPlayerY());
            switch (engine.returnUnder(p.getPlayerX(), p.getPlayerY())) {
                case "c":
                    p.setCoins(p.getCoins() + 1);
                    engine.setUnder(p.getPlayerX(), p.getPlayerY(), "_");
                    break;
                case "t":
                    p.setCoins(p.getCoins() - 1);
                    engine.setUnder(p.getPlayerX(), p.getPlayerY(), "t");
                    break;
                case "a":
                    p.setStamina(p.getStamina() + 3);
                    engine.setUnder(p.getPlayerX(), p.getPlayerY(), "_");
                    break;
                case "e":
                    engine.setEnd(true);
                    System.out.println("You win!");
                    break;
            }
            if (p.getStamina() < 1 || p.getCoins() < 0) {
                engine.setEnd(true);
                System.out.println("You Died!");
            }

        }
    }

    public static void main(String[] args) throws IOException {
        playText p = new playText();
        p.playGame();
    }
}
