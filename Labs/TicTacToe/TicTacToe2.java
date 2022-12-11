import java.util.LinkedList;
import java.util.Scanner;

public class TicTacToeV3 {

    public static void main(String[] Args) throws IllegalAccessException {
        Board game = new Board();
         do{
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter i:");
            int i = scanner.nextInt();
            System.out.print("Enter j:");
            int j = scanner.nextInt();
            game.putMark(i, j);
            System.out.println("User's move:");
            game.printBoard();

            game.calculateComputerMove();
            
            double bestScore = Double.NEGATIVE_INFINITY;
            Board bestMove = null;
            for (Board child : game.children) {
            double currentScore = fitness(child);
                if(child.winner()== Board.O){
                    bestMove = child;
                    break;
                }
                
                if(currentScore>bestScore){
                    bestScore = currentScore;
                    bestMove = child;
                }
            }
            if(bestMove != null){
                game = bestMove;
                System.out.println("Computer's move:");
                game.printBoard();
            }

        }while(game.winner() == 0 && game.children.size()>0);
    }

    public static double fitness(Board board){
        if(board.countO == 0 && board.countX == 0)
            return 0;
        return (double) board.countO / (board.countO + board.countX);
    }
}

class Board {
    public static final int X = 1, O = -1, EMPTY = 0;
    private int[][] boardArray = new int[3][3];
    private int player;

    public LinkedList<Board> children;
    public Board parent;
    public int countX = 0, countO = 0;

    Board() {
        children = new LinkedList<>();
        clearBoard();
    }

    public void clearBoard() {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                boardArray[i][j] = EMPTY;
            }
        }
        player = X;
    }

    public void printBoard() {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                if (boardArray[i][j] == 1)
                    System.out.print("X  ");
                else if (boardArray[i][j] == -1)
                    System.out.print("O  ");
                else
                    System.out.print("-  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isWin(int a) {
        if (boardArray[0][0] + boardArray[0][1] + boardArray[0][2] == 3 * a) {
            return true;
        } else if (boardArray[1][0] + boardArray[1][1] + boardArray[1][2] == 3 * a) {
            return true;
        } else if (boardArray[2][0] + boardArray[2][1] + boardArray[2][2] == 3 * a) {
            return true;
        } else if (boardArray[0][0] + boardArray[1][0] + boardArray[2][0] == 3 * a) {
            return true;
        } else if (boardArray[0][1] + boardArray[1][1] + boardArray[2][1] == 3 * a) {
            return true;
        } else if (boardArray[0][2] + boardArray[1][2] + boardArray[2][2] == 3 * a) {
            return true;
        } else if (boardArray[0][0] + boardArray[1][1] + boardArray[2][2] == 3 * a) {
            return true;
        } else if (boardArray[2][0] + boardArray[1][1] + boardArray[0][2] == 3 * a) {
            return true;
        } else
            return false;
    }

    public void putMark(int i, int j) throws IllegalArgumentException {
        if (i < 0 || i > 2 || j < 0 || j > 2)
            throw new IllegalArgumentException("Invalid board position");
        if (boardArray[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied");
        boardArray[i][j] = player;
        player = -player;
    }

    public void printTree() {
        System.out.println(
        "Possible moves:" + children.size() +
        ", X win:" + countX +
        ", O win:" + countO);
        
        this.printBoard();
        for (Board child: children) {
            child.printTree();
        }
    }

    public void calculateComputerMove() throws IllegalArgumentException {
        this.children.clear();
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[0].length; j++) {
                if (boardArray[i][j] == EMPTY) {
                    Board tic = this.cloneBoard();
                    tic.parent = this;
                    tic.putMark(i, j);
                    this.children.add(tic);

                    int winner = tic.winner();
                    if (winner == EMPTY) {
                        tic.calculateComputerMove();
                    } else {
                        Board temp = tic;
                        while(temp.parent != null){
                           temp = temp.parent;
                           if(winner == X){
                            temp.countX++;
                           }     
                           else if(winner == O){
                            temp.countO++;
                           }
                        }


                    }
                }
            }
        }
    }

    public int winner() {
        if (isWin(X))
            return (X);
        else if (isWin(O))
            return (O);
        else
            return (0);
    }

    public Board cloneBoard() {
        Board newBoard = new Board();
        for (int i = 0; i < this.boardArray.length; i++) {
            for (int j = 0; j < this.boardArray[0].length; j++) {
                newBoard.boardArray[i][j] = this.boardArray[i][j];
            }
        }
        newBoard.player = this.player;
        return newBoard;
    }
}
