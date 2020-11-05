import java.util.*;
public class TicTacToeGame {
    static Scanner input = new Scanner(System.in);
    static String userLetter;
    static String computerLetter;
    static Map<Integer,Boolean> visited = new HashMap<>();

    static {
        for(int index=1;index<10;index++){
            visited.put(index,false);
        }
    }

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
        String userLetter;
        do {
            System.out.println("please Choose Letter X or O");
            userLetter = input.nextLine();
        }while (!userLetter.equalsIgnoreCase("X") && !userLetter.equalsIgnoreCase("O"));
        return userLetter.toUpperCase();
    }

    //UC2 set the Computer letter
    public static String generateComputerLetter(String userLetter){
        return (userLetter.equals("O")) ? "X" : "O";
    }

    //UC3 show the current board
    public static void showCurrentBoard(char[] board){
        System.out.println("***Current Board***");
        int row =3;
        int column = 0;
        for (int index=1;index<board.length;index++) {
            System.out.print("["+board[index]+ "]");
            column++;
            if(column == row){
                column=0;
                System.out.println();
            }
        }
    }

    //UC4 Ability to play game
    public static void userTurnToPlaceElement(char[] board){
        System.out.println("Specify the index to place element");
        int index = input.nextInt();
        board[index] = userLetter.charAt(0);
        visited.put(index,true);
        showCurrentBoard(board);
    }

    public static void main(String[] args){
        char[] board = createBoard();
        userLetter = chooseUserLetter();
        computerLetter = generateComputerLetter(userLetter);
        showCurrentBoard(board);
        userTurnToPlaceElement(board);
    }
}
