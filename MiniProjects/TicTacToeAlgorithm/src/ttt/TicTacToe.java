package ttt;

import java.util.*;

public class TicTacToe {

    private boolean first = false;
    private String[] board = new String[9];
    private int pcflag = 0;
    private int flag = 0;
    private int playerTurn = 1;
    private int COH = 1;
    private int mode, y, x;
    private int r = 0;
    Random random = new Random();

    // int x, y, flag;
    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.intro();

    }

    public void intro() {

        String goFirst = new String(" ");

        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe");

        System.out.println("Press 1 for playerVsPC & 2 for PlayerVsPlayer");
        COH = console.nextInt();

        if (COH == 1) {
            System.out.println("Press y for going first and n for not playing first");
            goFirst = console.nextLine();
            goFirst = console.nextLine();
            if (goFirst.substring(0, 1).equalsIgnoreCase("y")) {
                first = true;
            }
            System.out.println("Choose 1 for Easy");
            System.out.println("Choose 2 for medium");
            System.out.println("Choose 3 for Hard");
            mode = console.nextInt();

            while (mode != 1 && mode != 2 && mode != 3) {
                System.out.println("You entered an invalid mode number try again :)");
                mode = console.nextInt();
            }
            initializeBoard();
            getBoard();
            startGame(console);
        } else {
            initializeBoard();
            getBoard();
            startPVP(console);
        }
    }

    public void startPVP(Scanner console) {

        if (playerTurn == 1) {
            System.out.println("X TURN");
            r = console.nextInt();

            if (board[r] == " ") {
                board[r] = "X";
                getBoard();
                playerTurn = 2;
                checkWinner(console);

            } else if (board[r] == "X" || board[r] == "O") {
                System.out.println("Try again in an empty place :)");
                startPVP(console);
            }
        } else {
            System.out.println("O TURN");
            int r = console.nextInt() - 1;
            int c = console.nextInt() - 1;

            if (board[r] == " ") {
                board[r] = "O";
                getBoard();
                playerTurn = 1;
                checkWinner(console);

            } else if (board[r] == "X" || board[r] == "O") {
                System.out.println("Try again in an empty place :)");
                startPVP(console);
            }
        }

    }

    public void startGame(Scanner console) {

        if (first == true) {
            userTurn(console);
        } else {
            switch (mode) {
                case 3:
                    compTurn(console);
                    break;
                case 2:
                    compTurnmed(console);
                    break;
                case 1:
                    compTurneasy(console);
                    break;
                default:
                    break;
            }
        }

    }

    //Players Turn broo
    public void userTurn(Scanner console) {
        System.out.println("Your Turn :)");
        r = console.nextInt() ;
        if (board[r] == " ") {
            board[r] = "X";
            getBoard();
            checkScoreUser(console);

        } else if (board[r] == "X" || board[r] == "O") {
            first = true;
            System.out.println("Try again in an empty place :)");
            startGame(console);
        }

    }

    //Computers Turn brooo
    public void compTurn(Scanner console) {

        System.out.println("Now it's my turn");
        System.out.println("");

        if (board[0] == "O" && board[1] == "O" && board[2] != "X") {
            board[2] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);

        } else if (board[3] == "O" && board[4] == "O" && board[5] != "X") {
            board[5] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);

        } else if (board[6] == "O" && board[7] == "O" && board[8] != "X") {
            board[8] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);

        } else if (board[0] == "O" && board[3] == "O" && board[6] != "X") {
            board[6] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);

        } else if (board[1] == "O" && board[4] == "O" && board[7] != "X") {
            board[7] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "O" && board[5] == "O" && board[8] != "X") {
            board[8] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "O" && board[1] == "O" && board[0] != "X") {
            board[0] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[5] == "O" && board[4] == "O" && board[3] != "X") {
            board[3] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "O" && board[7] == "O" && board[6] != "X") {
            board[6] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "O" && board[3] == "O" && board[0] != "X") {
            board[0] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[7] == "O" && board[4] == "O" && board[1] != "X") {
            board[1] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "O" && board[5] == "O" && board[2] != "X") {
            board[2] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "O" && board[2] == "O" && board[1] != "X") {
            board[1] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[3] == "O" && board[5] == "O" && board[4] != "X") {
            board[4] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "O" && board[8] == "O" && board[7] != "X") {
            board[7] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "O" && board[6] == "O" && board[3] != "X") {
            board[3] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[1] == "O" && board[7] == "O" && board[4] != "X") {
            board[4] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "O" && board[8] == "O" && board[5] != "X") {
            board[5] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "O" && board[4] == "O" && board[8] != "X") {
            board[8] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "O" && board[4] == "O" && board[6] != "X") {
            board[6] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "O" && board[4] == "O" && board[2] != "X") {
            board[2] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "O" && board[4] == "O" && board[0] != "X") {
            board[0] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "O" && board[8] == "O" && board[4] != "X") {
            board[4] = "O";
            pcflag = 1;

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "O" && board[6] == "O" && board[4] != "X") {
            board[4] = "O";
            pcflag = 1;
            getBoard();
            checkScoreComp(console);

        } //////////////////////////BLOCKING STATES///////////////////////////////////
        else if (board[0] == "X" && board[1] == "X" && board[2] != "O") {
            board[2] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[3] == "X" && board[4] == "X" && board[5] != "O") {
            board[5] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[6] == "X" && board[7] == "X" && board[8] != "O") {
            board[8] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[0] == "X" && board[3] == "X" && board[6] != "O") {
            board[6] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[1] == "X" && board[4] == "X" && board[7] != "O") {
            board[7] = "O";
            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[5] == "X" && board[8] != "O") {
            board[8] = "O";
            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[1] == "X" && board[0] != "O") {
            board[0] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[5] == "X" && board[4] == "X" && board[3] != "O") {
            board[3] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "X" && board[7] == "X" && board[6] != "O") {
            board[6] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "X" && board[3] == "X" && board[0] != "O") {
            board[0] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[7] == "X" && board[4] == "X" && board[1] != "O") {
            board[1] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "X" && board[5] == "X" && board[2] != "O") {
            board[2] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[2] == "X" && board[1] != "O") {
            board[1] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[3] == "X" && board[5] == "X" && board[4] != "O") {
            board[4] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "X" && board[8] == "X" && board[7] != "O") {
            board[7] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[6] == "X" && board[3] != "O") {
            board[3] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[1] == "X" && board[7] == "X" && board[4] != "O") {
            board[4] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[8] == "X" && board[5] != "O") {
            board[5] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[4] == "X" && board[8] != "O") {
            board[8] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[4] == "X" && board[6] != "O") {
            board[6] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "X" && board[4] == "X" && board[2] != "O") {
            board[2] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "X" && board[4] == "X" && board[0] != "O") {
            board[0] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[8] == "X" && board[4] != "O") {
            board[4] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[6] == "X" && board[4] != "O") {
            board[4] = "O";
            getBoard();
            checkScoreComp(console);

        } //////////////////////////ELSE//////////////////////////////////////   
        else {
            x = random.nextInt(8);
            
            flag = 0;

            while (flag == 0) {

                if (board[x] == " ") {
                    board[x] = "O";
                    flag = 1;
                    getBoard();
                    checkScoreComp(console);
                } else {
                    x = random.nextInt(8);
                    
                    flag = 0;
                }
            }

            /*for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[x][y] == " ") {
                        board[x][y] = "O";
                        getBoard();
                        checkScoreComp(console);
                    }
                }
            }
        }*/
        }
    }

    public void compTurnmed(Scanner console) {

        System.out.println("Now it's my turn");
        System.out.println("");

        //////////////////////////BLOCKING STATES///////////////////////////////////
         if (board[0] == "X" && board[1] == "X" && board[2] != "O") {
            board[2] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[3] == "X" && board[4] == "X" && board[5] != "O") {
            board[5] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[6] == "X" && board[7] == "X" && board[8] != "O") {
            board[8] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[0] == "X" && board[3] == "X" && board[6] != "O") {
            board[6] = "O";
            getBoard();
            checkScoreComp(console);

        } else if (board[1] == "X" && board[4] == "X" && board[7] != "O") {
            board[7] = "O";
            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[5] == "X" && board[8] != "O") {
            board[8] = "O";
            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[1] == "X" && board[0] != "O") {
            board[0] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[5] == "X" && board[4] == "X" && board[3] != "O") {
            board[3] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "X" && board[7] == "X" && board[6] != "O") {
            board[6] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "X" && board[3] == "X" && board[0] != "O") {
            board[0] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[7] == "X" && board[4] == "X" && board[1] != "O") {
            board[1] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "X" && board[5] == "X" && board[2] != "O") {
            board[2] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[2] == "X" && board[1] != "O") {
            board[1] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[3] == "X" && board[5] == "X" && board[4] != "O") {
            board[4] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "X" && board[8] == "X" && board[7] != "O") {
            board[7] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[6] == "X" && board[3] != "O") {
            board[3] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[1] == "X" && board[7] == "X" && board[4] != "O") {
            board[4] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[8] == "X" && board[5] != "O") {
            board[5] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[4] == "X" && board[8] != "O") {
            board[8] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[4] == "X" && board[6] != "O") {
            board[6] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[6] == "X" && board[4] == "X" && board[2] != "O") {
            board[2] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[8] == "X" && board[4] == "X" && board[0] != "O") {
            board[0] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[0] == "X" && board[8] == "X" && board[4] != "O") {
            board[4] = "O";

            getBoard();
            checkScoreComp(console);
        } else if (board[2] == "X" && board[6] == "X" && board[4] != "O") {
            board[4] = "O";
            getBoard();
            checkScoreComp(console);

        } //////////////////////////ELSE//////////////////////////////////////   
        else {
            x = random.nextInt(8);
            flag = 0;

            while (flag == 0) {

                if (board[x] == " ") {
                    board[x] = "O";
                    flag = 1;
                    getBoard();
                    checkScoreComp(console);
                } else {
                    x = random.nextInt(8);
                    
                    flag = 0;
                }
            }

            /* for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    if (board[x][y] == " ") {
                        board[x][y] = "O";
                        getBoard();
                        checkScoreComp(console);
                    }
                }
            }*/
        }

    }

    public void compTurneasy(Scanner console) {

        x = random.nextInt(8);
        flag = 0;

        while (flag == 0) {

            if (board[x] == " ") {
                board[x] = "O";
                flag = 1;
                getBoard();
                checkScoreComp(console);
            } else {
                x = random.nextInt(8);
                
                flag = 0;
            }
        }
        //userTurn(console);

        /*for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (board[x][y] == " ") {
                    board[x][y] = "O";

                    getBoard();
                    //userTurn(console);
                    checkScoreComp(console);

                }
            }

        }*/
    }

    //score checkers
    public void checkWinner(Scanner console) {
        if ((board[0] == "X" && board[1] == "X" && board[2] == "X")
                || (board[3] == "X" && board[4] == "X" && board[5] == "X")
                || (board[6] == "X" && board[7] == "X" && board[8] == "X")
                || (board[0] == "X" && board[3] == "X" && board[6] == "X")
                || (board[1] == "X" && board[4] == "X" && board[7] == "X")
                || (board[2] == "X" && board[5] == "X" && board[8] == "X")
                || (board[0] == "X" && board[4] == "X" && board[8] == "X")
                || (board[2] == "X" && board[4] == "X" && board[6] == "X")) {
            System.out.println("X WINS!");
            intro();
        } else if ((board[0] == "O" && board[1] == "O" && board[2] == "O")
                || (board[3] == "O" && board[4] == "O" && board[5] == "O")
                || (board[6] == "O" && board[7] == "O" && board[8] == "O")
                || (board[0] == "O" && board[3] == "O" && board[6] == "O")
                || (board[1] == "O" && board[4] == "O" && board[7] == "O")
                || (board[2] == "O" && board[5] == "O" && board[8] == "O")
                || (board[0] == "O" && board[4] == "O" && board[8] == "O")
                || (board[2] == "O" && board[4] == "O" && board[6] == "O")) {
            System.out.println("O WINS!");
            intro();
        }else if (board[0] != " " && board[1] != " " && board[2] != " "
                && board[3] != " " && board[4] != " " && board[5] != " "
                && board[6] != " " && board[7] != " " && board[8] != " ") {
            System.out.println("TIE");
            intro();

        } else {
            startPVP(console);
        }
    }

    public void checkScoreUser(Scanner console) {
        if ((board[0] == "X" && board[1] == "X" && board[2] == "X")
                || (board[3] == "X" && board[4] == "X" && board[5] == "X")
                || (board[6] == "X" && board[7] == "X" && board[8] == "X")
                || (board[0] == "X" && board[3] == "X" && board[6] == "X")
                || (board[1] == "X" && board[4] == "X" && board[7] == "X")
                || (board[2] == "X" && board[5] == "X" && board[8] == "X")
                || (board[0] == "X" && board[4] == "X" && board[8] == "X")
                || (board[2] == "X" && board[4] == "X" && board[6] == "X")) {
            System.out.println("X WINS!");
            intro();
        } else if (board[0] != " " && board[1] != " " && board[2] != " "
                && board[3] != " " && board[4] != " " && board[5] != " "
                && board[6] != " " && board[7] != " " && board[8] != " ") {
            System.out.println("TIE");
            intro();

        } else {
            switch (mode) {
                case 3:
                    compTurn(console);
                    break;
                case 2:
                    compTurnmed(console);
                    break;
                case 1:
                    compTurneasy(console);
                    break;
                default:
                    break;
            }
        }
    }

    public void checkScoreComp(Scanner console) {
         if ((board[0] == "O" && board[1] == "O" && board[2] == "O")
                || (board[3] == "O" && board[4] == "O" && board[5] == "O")
                || (board[6] == "O" && board[7] == "O" && board[8] == "O")
                || (board[0] == "O" && board[3] == "O" && board[6] == "O")
                || (board[1] == "O" && board[4] == "O" && board[7] == "O")
                || (board[2] == "O" && board[5] == "O" && board[8] == "O")
                || (board[0] == "O" && board[4] == "O" && board[8] == "O")
                || (board[2] == "O" && board[4] == "O" && board[6] == "O")) {
            System.out.println("O WINS!");
            intro();
        }else if (board[0] != " " && board[1] != " " && board[2] != " "
                && board[3] != " " && board[4] != " " && board[5] != " "
                && board[6] != " " && board[7] != " " && board[8] != " ") {
            System.out.println("TIE");
            intro();

        }  else {
            userTurn(console);
        }

    }

    //board stuff
    //initializes board and fills it with black spaces
    public void initializeBoard() {

        for (int r = 0; r < 9; r++) {
            
                board[r] = " ";
            
        }

    }

    //prints the actual board out
    public void getBoard() {

        String bar = "  =============";
      //  System.out.println("          ");
        System.out.println(bar);
        System.out.println("   " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println(bar);
        System.out.println("   " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println(bar);
        System.out.println("   " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println(bar);
        System.out.println("");

    }

}
