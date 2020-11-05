public class TicTacToeGame {
    //UC1 initialize empty board when game is started
    public static char[] startNewGame(){
        char[] board = new char[10];
        for(int index=1;index<board.length;index++) {
            board[index] = ' ';
        }
        return board;
    }

    public static void main(String[] args){
        char[] board = startNewGame();
    }
}
