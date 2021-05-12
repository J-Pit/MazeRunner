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

            System.out.println("Stamina:" + p.getStamina());
            System.out.println("coins:" + p.getCoins());
            Scanner myObj = new Scanner(System.in);
            String userName = myObj.nextLine();
            p.move(userName);
            engine.drawPlayer(p.getPlayerX(), p.getPlayerY());
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
