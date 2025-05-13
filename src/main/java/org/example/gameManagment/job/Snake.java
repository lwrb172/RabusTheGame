package org.example.gameManagment.job;

import java.util.ArrayList;
import java.util.Random;

public class Snake {
    static String direction = "RIGHT"; // UP DOWN LEFT RIGHT
    private int rows = 15;
    private int cols = 50;
    private String tableData [][] = new String[rows][cols];
    private int fruit [] = new int[2];

    private ArrayList<int[]> playerData = new ArrayList<int[]>();

    private Double tableUpdateTime = (double)(1000/30);
    private int gameSpeed = 1;

    static native void controls();

    public static void controlUp() {
        direction = "UP";
    }

    public static void controlDown() {
        direction = "DOWN";
    }

    public static void controlLeft() {
        direction = "LEFT";
    }

    public static void controlRight() {
        direction = "RIGHT";
    }

    public static void controlExit() { //*
        System.exit(0);
    }

    public void start() {
        resetGame();
        printTable();
    }

    private void printTable() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(tableData[i][j]);
            }
            System.out.println();
        }
    }

    private void resetGame() {
        direction = "RIGHT";
        playerData = new ArrayList<int[]>();

        int midCols = (int) (cols/2);
        int midRows = (int) (rows/2);

        playerData.add( new int[]{midRows, midCols});
        playerData.add( new int[]{midRows, midCols - 1});
        playerData.add( new int[]{midRows, midCols - 2});
        playerData.add( new int[]{midRows, midCols - 3});

        createRandomFruit();

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols - 1; j++) {
                tableData[i][j] = " ";
            }
        }

        for (int i = 0; i < cols; i++) {
            tableData[0][i] = "|";
            tableData[rows - 1][i] = "|";
        }

        for (int i = 0; i < rows; i++) {
            tableData[i][0] = "||";
            tableData[i][cols - 1] = "||";
        }

        insertPlayer();
        insertFruit();
    }

    private void insertFruit() {
        tableData[fruit[0]][fruit[1]] = "Q";
    }

    private void insertPlayer() {
        try {
            for (int [] pos : playerData) {
                tableData[pos[0]][pos[1]] = "#";
            }
            int [] head = playerData.getFirst();
            tableData[head[0]][head[1]] = "@";
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            resetGame();
        }
    }

    private void createRandomFruit() {
        Random random = new Random();

        int y = random.nextInt(1, rows - 1);
        int x = random.nextInt(1, cols - 1);

        for (int [] body : playerData) {
            if (body[0] == y && body[1] == x) {
                createRandomFruit();
                return;
            }
        }

        fruit[0] = y;
        fruit[1] = x;
    }
}
