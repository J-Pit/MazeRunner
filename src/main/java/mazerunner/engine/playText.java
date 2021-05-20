package mazerunner.engine;

import java.util.Scanner;

public class playText {

    public void playGame() {
        GameEngine engine = new GameEngine(10);
        System.out.printf("The size of map is %d * %d\n", engine.getSize(), engine.getSize());
        engine.createInitialMap();
        Player p = new Player();
        engine.drawPlayer(p.getPlayerX(), p.getPlayerY());
        while (!engine.isEnd()) {

            System.out.printf("Stamina: %d\n",p.getStamina());
            System.out.printf("Coins: %d\n",p.getCoins());
            Scanner myObj = new Scanner(System.in);
            String userName = myObj.nextLine();
            p.move(userName);
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

    public static void main(String[] args) {
        playText p = new playText();
        p.playGame();
    }
}
