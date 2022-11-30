package com.example;


import java.util.Scanner;

public class XO {

    static final String EMPTY = " ";
    static final String X = "X";
    static final String O = "O";

    public static void main(String[] args) {
        boolean boo;
        Scanner scanner = new Scanner(System.in);
        do {
            String[][] desk = new String[3][3];
            initDesktopEmpty(desk);
            System.out.print("Dear player enter your name,play with '" + X + "': ");
            String playerX = scanner.nextLine();
            System.out.print("Dear player enter your name,play with '" + O + "': ");
            String playerO = scanner.nextLine();
            drawDesk(desk);
            do {
                if (playerTurn1(playerX, " (X): ", scanner, desk, X, "Winner  ")) break;
                if (!hasAnySpace(desk)) {
                    System.out.println("Draw");
                    break;
                }
                if (playerTurn1(playerO, " (O): ", scanner, desk, O, "Winner   ")) break;
            } while (hasAnySpace(desk));
            boo = yesOrNo(scanner);
        } while (!boo);

    }

    private static boolean playerTurn1(String playerX, String player, Scanner scanner, String[][] desk, String x, String x1) {
        playerTurn(playerX, player, scanner, desk, x);
        drawDesk(desk);
        if (isWinner(desk, x)) {
            System.out.println(x1 + playerX);
            return true;
        }
        return false;
    }

    private static void initDesktopEmpty(String[][] desk) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                desk[i][j] = EMPTY;
            }
        }
    }

    private static boolean yesOrNo(Scanner scanner) {
        boolean retVal = false;
        System.out.println("Do you want play again? ");
        for (; ; ) {
            System.out.println("1.Yes\n2.No ");
            String yesOrNo = scanner.nextLine();
            if (yesOrNo.equals("1")) {
                System.out.println("Welcome back");
                break;
            } else if (yesOrNo.equals("2")) {
                System.out.println("Goodbye");
                retVal = true;
                break;
            } else
                System.out.println("Enter correct variant");
        }
        return retVal;
    }

    private static void playerTurn(String name, String player, Scanner scanner, String[][] desk, String XO) {
        for (; ; ) {
            boolean foundCell = false;
            System.out.print(name + player);
            String coordinates = scanner.nextLine();
            switch (coordinates.toUpperCase()) {
                case "A1":
                    if (EMPTY.equals(desk[0][0])) {
                        desk[0][0] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "B1":
                    if (EMPTY.equals(desk[0][1])) {
                        desk[0][1] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "C1":
                    if (EMPTY.equals(desk[0][2])) {
                        desk[0][2] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "A2":
                    if (EMPTY.equals(desk[1][0])) {
                        desk[1][0] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "B2":
                    if (EMPTY.equals(desk[1][1])) {
                        desk[1][1] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "C2":
                    if (EMPTY.equals(desk[1][2])) {
                        desk[1][2] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "A3":
                    if (EMPTY.equals(desk[2][0])) {
                        desk[2][0] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "B3":
                    if (EMPTY.equals(desk[2][1])) {
                        desk[2][1] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                case "C3":
                    if (EMPTY.equals(desk[2][2])) {
                        desk[2][2] = XO;
                        foundCell = true;
                    } else {
                        System.out.println("Enter correct coordinates ");
                    }
                    break;
                default:
                    System.out.println("Enter correct coordinates ");
            }
            if (foundCell) break;
        }
    }

    private static boolean hasAnySpace(String[][] desk) {
        return EMPTY.equals(desk[0][0]) || EMPTY.equals(desk[0][1]) || EMPTY.equals(desk[0][2]) ||
                EMPTY.equals(desk[1][0]) || EMPTY.equals(desk[1][1]) || EMPTY.equals(desk[1][2]) ||
                EMPTY.equals(desk[2][0]) || EMPTY.equals(desk[2][1]) || EMPTY.equals(desk[2][2]);
    }

    private static void drawDesk(String[][] desk) {
        System.out.println("$ | A | B | C |");
        System.out.println("---------------");
        System.out.println("1" + " | " + desk[0][0] + " | " + desk[0][1] + " | " + desk[0][2] + " |");
        System.out.println("---------------");
        System.out.println("2" + " | " + desk[1][0] + " | " + desk[1][1] + " | " + desk[1][2] + " |");
        System.out.println("---------------");
        System.out.println("3" + " | " + desk[2][0] + " | " + desk[2][1] + " | " + desk[2][2] + " |");
        System.out.println("---------------");
    }


    private static boolean isWinner(String[][] desk, String player) {
        return desk[0][0].equals(desk[0][1]) && desk[0][0].equals(desk[0][2]) && desk[0][0].equals(player) ||
                desk[1][0].equals(desk[1][1]) && desk[1][0].equals(desk[1][2]) && desk[1][0].equals(player) ||
                desk[2][0].equals(desk[2][1]) && desk[2][0].equals(desk[2][2]) && desk[2][0].equals(player) ||
                desk[0][0].equals(desk[1][0]) && desk[0][0].equals(desk[2][0]) && desk[0][0].equals(player) ||
                desk[0][1].equals(desk[1][1]) && desk[0][1].equals(desk[2][1]) && desk[0][1].equals(player) ||
                desk[0][2].equals(desk[1][2]) && desk[0][2].equals(desk[2][2]) && desk[0][2].equals(player) ||
                desk[0][0].equals(desk[1][1]) && desk[0][0].equals(desk[2][2]) && desk[0][0].equals(player) ||
                desk[0][2].equals(desk[1][1]) && desk[0][2].equals(desk[2][0]) && desk[0][2].equals(player);
    }

}
