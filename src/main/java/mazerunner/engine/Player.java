package mazerunner.engine;

public class Player {
    private int Stamina = 12;
    private int Score;
    private int coins;
    private int PlayerX = 9;
    private int PlayerY =0;

    public int getPlayerY() {
        return PlayerY;
    }

    public void setPlayerY(int playerY) {
        PlayerY = playerY;
    }

    public int getPlayerX() {
        return PlayerX;
    }

    public void setPlayerX(int playerX) {
        PlayerX = playerX;
    }

    public int getStamina() {
        return Stamina;
    }

    public void setStamina(int stamina) {
        Stamina = stamina;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public void move(String direction){
        switch (direction){
            case "left": PlayerY -= 1;
            break;
            case "up": PlayerX += 1;
            break;
            case "right": PlayerY += 1;
            break;
            case "down": PlayerX -= 1;
            break;
        }

    }



}
