import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        Scanner sc = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;

        //initial board setup
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = ' ';
            }
        }

        while(!gameOver){
            printBoard(board);
            System.out.println("Enter the row for " + player + " : ");
            int row = sc.nextInt();
            System.out.println("Enter the column for " + player + " : ");
            int col = sc.nextInt();

            if(board[row][col] == ' '){
                board[row][col] = player;
                if(checkWon(board, player)){
                    System.out.println("Player " + player + " won!");
                    gameOver = true;
                }else{
                    player = (player == 'X')? 'O' : 'X';
                }
            }else{
                System.out.println("Invalid move!");
            }
        }

    }

    public static boolean checkWon(char[][] board, char player){

        //check for rows and columns
        for(int i = 0; i < 3; i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player ){
                return true;
            }

            if(board[0][i] == player && board[1][i] == player && board[2][i] == player ){
                return true;
            }
        }

        //check diagonals
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }

        if(board[0][2] == player && board[1][1] == player && board[2][0] == player ){
            return true;
        }

        return false;
    }

    public static void printBoard(char[][] board){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(" | " + board[i][j]);
            }
            System.out.print(" |");
            System.out.println();
        }
    }

}
