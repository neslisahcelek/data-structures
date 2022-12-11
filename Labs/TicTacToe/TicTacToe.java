import java.util.LinkedList;

public class TicTacToe {
    public static void main(String[] args) throws Exception {
        Board game1 = new Board();
        game1.calculateComputerMove();
        game1.printWinners();
    }
}

class Board {
    public static final int X = 1, O = -1, EMPTY = 0;
    private int[][] boardArray = new int[3][3];
    private int player;
    private Board parent;
    private java.util.LinkedList<Board> children;
    private int countX = 0, countO = 0;

    Board() {
        clearBoard();
        this.children = new java.util.LinkedList<>();
    }

    public void printWinners() {
        System.out.println("Possible moves: " + children.size() + ", X: " + countX + ", O: " + countO);
        for (Board b : this.children) {
            b.printWinners();
        }
    }

    public void calculateComputerMove() throws IllegalAccessException {
        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                if (boardArray[i][j] == EMPTY) {
                    Board clone = cloneBoard();
                    clone.parent = this;
                    clone.putMark(i, j);
                    this.children.addLast(clone);
                    int winnerPlayer = winner();

                    if (winnerPlayer == 0)
                        clone.calculateComputerMove();
                    else if (winnerPlayer == X)
                        ++countX;
                    else
                        ++countO;
                }
            }
        }
    }

    public void printChildren() {
        this.printBoard();
        for (Board b : this.children) {
            b.printChildren();
        }
    }

    public Board cloneBoard() {
        Board returnable = new Board();
        returnable.player = this.player;
        for (int i = 0; i < this.boardArray.length; i++) {
            for (int j = 0; j < this.boardArray[i].length; j++) {
                returnable.boardArray[i][j] = this.boardArray[i][j];
            }
        }
        return returnable;
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

    public void putMark(int i, int j) throws IllegalAccessException {
        if (i < 0 || i > 2 || j < 0 || j > 2)
            throw new IllegalArgumentException("Invalid board position!");
        if (boardArray[i][j] != EMPTY)
            throw new IllegalArgumentException("Board position occupied!");
        boardArray[i][j] = player;
        player = -player;
    }

    public int winner() {
        if (isWin(X))
            return (X);
        else if (isWin(O))
            return (O);
        else
            return (0);
    }
}
