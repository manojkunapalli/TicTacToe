public class TicTacToeGame {

    public static void startNewGame(){
        char[] board = new char[10];

        for(int i=1; i<board.length;i++) {
            board[i] = ' ';
        }
    }

    public static void main(String[] args){
        startNewGame();
    }
}
