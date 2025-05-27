package org.example.gameManagement.job.tictactoe;

public enum GameScore {
    Player(0),
    Computer(0),
    Draw(0);

    private int score;

    GameScore(int score) {
        this.score = score;
    }

    public void addScore() { this.score++; }

    public int getScore() { return this.score; }
}
