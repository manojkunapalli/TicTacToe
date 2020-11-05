import java.util.*;
public class TicTacToeGame {
    //UC1 initialize empty board when game is started
    public static char[] createBoard(){
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

    //UC3 show the current board
    public static void showCurrentBoard(char[] board){
        System.out.println("***Current Board***");
        int row =3;
        int column = 0;
        for (int index=1;index<board.length;index++) {
            System.out.print(board[index]+ ",");
            column++;
            if(column == row){
                column=0;
                System.out.println();
            }
        }
    }

    public static void main(String[] args){
        char[] board = createBoard();
        String userLetter = chooseUserLetter();
        String computerLetter = (userLetter.equals("O")) ? "X" : "O";
        showCurrentBoard(board);
    }
}
