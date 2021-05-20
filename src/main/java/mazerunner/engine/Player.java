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

    public int getPlayerX() {
        return PlayerX;
    }

    public void setPlayerX(int playerX) {
        PlayerX = playerX;
    }

    public void setPlayerY(int playerY) {
        PlayerY = playerY;
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

    public int canMove(int coordinate){
        if(coordinate >9){

            return 9;
        }
        else if(coordinate<0){


            return 0;
        }
        else return coordinate;
    }

    public void move(String direction){
        setStamina(getStamina() -1);

        switch (direction){
            case "left": PlayerY -= 1;
            break;
            case "up": PlayerX -= 1;
            break;
            case "right": PlayerY += 1;
            break;
            case "down": PlayerX += 1;
            break;
        }
        if(PlayerX >9){

            PlayerX = 9;
        }
        else if(PlayerX<0){
            PlayerX = 0;
        }
        if(PlayerY >9){

            PlayerY = 9;
        }
        else if(PlayerY<0){
            PlayerY = 0;
        }
    }

    }




