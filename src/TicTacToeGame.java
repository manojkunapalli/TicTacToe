import java.util.*;
public class TicTacToeGame {
    static Scanner input = new Scanner(System.in);
    static String userLetter;
    static String computerLetter;
    static Map<Integer,Boolean> visited = new HashMap<>();
    static int count;
    static int turn;

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

    //UC4 Ability of user to play game
    public static void userTurnToPlaceElement(char[] board){
        int index = 0;
        do{
            System.out.println("Specify the index to place element");
            index = input.nextInt();
        }while(visited.get(index) && count <= 9);

        board[index] = userLetter.charAt(0);
        visited.put(index,true);
        showCurrentBoard(board);
        count++;
        if(count < 9 && turn == 1) {
            computerTurnToPlaceElement(board);
        }
    }

    //UC5 Computer Ability of computer to play Game
    public static void computerTurnToPlaceElement(char[] board){
        for(int index=1;index<10;index++){
            if(!visited.get(index)){
                board[index] = computerLetter.charAt(0);
                visited.put(index,true);
                break;
            }
        }
        count++;
        showCurrentBoard(board);
        if(count < 9 && turn == 2) {
            userTurnToPlaceElement(board);
        }
    }

    //UC7- choose the turn
    public static int chooseTheTurn(){
        int turn;
        do{
            System.out.println("Please choose the turn \n1.User\n2.Computer");
            turn = input.nextInt();
        }while (turn != 1 && turn != 2);
        return turn;
    }

    //UC7 - choose the turn - start the game
    public static void startGame(int turn,char[] board){
        if(turn == 1){
            while(count < 9){
                System.out.println("count = "+count);
                userTurnToPlaceElement(board);
            }
        }else{
            while(count < 9){
                System.out.println("count = "+count);
                computerTurnToPlaceElement(board);
            }
        }

    }
    public static void main(String[] args){
        char[] board = createBoard();
        turn = chooseTheTurn();
        userLetter = chooseUserLetter();
        computerLetter = generateComputerLetter(userLetter);
        showCurrentBoard(board);
        startGame(turn,board);
    }
}
