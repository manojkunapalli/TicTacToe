import java.util.*;
public class TicTacToeGame {
    //UC1 initialize empty board when game is started
    public static char[] startNewGame(){
        char[] board = new char[10];
        for(int index=1;index<board.length;index++) {
            board[index] = ' ';
        }
        return board;
    }

    //UC2 Ability to choose user X or O
    public static String chooseUserLetter(){
        Scanner input = new Scanner(System.in);
        String userLetter;
        do {
            System.out.println("please Choose Letter X or O");
            userLetter = input.nextLine();
        }while (!userLetter.equalsIgnoreCase("X") && !userLetter.equalsIgnoreCase("O"));
        return userLetter.toUpperCase();
    }

    //UC2 set the Computer letter
    public static String setComputerLetter(String userLetter){
        return (userLetter.equals("O")) ? "X" : "O";
    }

    //UC3 show the board
    public static void showBoard(char[] board){
        for (char c : board) {
            System.out.print(c + ",");
        }
    }

    public static void main(String[] args){
        char[] board = startNewGame();
        String userLetter = chooseUserLetter();
        String computerLetter = setComputerLetter(userLetter);
        showBoard(board);
    }
}
