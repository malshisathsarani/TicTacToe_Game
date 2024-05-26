import java.util.Random; import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);


    char[][] board = {{' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}};

    printBoard(board);
    while (true) { playTurn(board, scanner); if (isGameFinished(board)){ break; } printBoard(board); computerTurn(board); if (isGameFinished(board)){ break; } printBoard(board); } //printBoard(board);

    //scanner.close();
}

    private static boolean isGameFinished(char[][] board) {

        if (hasConstantWon(board, 'X')) {
            printBoard(board);
            System.out.println("    You wins !!!!        ");
            return true;
        }

        if (hasConstantWon(board, 'O')) {
            printBoard(board);
            System.out.println("    Computer wins !!!!        ");
            return true;
        }


        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++){
                if (board[i][j] == ' '){
                    return  false;
                }
            }
        }
        printBoard(board);
        System.out.println("The game ended in a  tie !!!  ");
        return true;
    }

    private static boolean hasConstantWon(char[][] board,  char symbol) {
        if (    board[0][1] == symbol && board[0][2] == symbol && board[0][0] == symbol ||
                board[1][1] == symbol && board[1][2] == symbol && board[1][0] == symbol ||
                board[2][1] == symbol && board[2][2] == symbol && board[2][0] == symbol ||

                board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
                board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||
                board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||

                board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
                board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol ){

            return true;
        }
        return false;
    }

    private static void computerTurn(char[][] board) {
        Random rand = new Random();
        int computerMove;
        while(true) {
            computerMove = rand.nextInt(9) + 1;
            if(isValidMove(board, computerMove)){
                break;
            }
        }

        System.out.println("computer chose" + computerMove);

        placeMove(board, Integer.toString(computerMove), 'O' );
    }

    private static boolean isValidMove(char[][] board, int position){
        switch (position){

            case 1:
                return(board[0][0] == ' ');
            case 2:
                return(board[0][1] == ' ');
            case 3:
                return(board[0][2] == ' ');

            case 4:
                return(board[1][0] == ' ');

            case 5:
                return(board[1][1] == ' ');

            case 6:
                return( board[1][2] == ' ');

            case 7:
                return (board[2][0] == ' ');

            case 8:
                return (board[2][1] == ' ');

            case 9:
                return( board[2][2] == ' ');

            default:
                return false;
        }
    }
    private static void playTurn(char[][] board, Scanner scanner) {
        String userInput;
        while(true){
            System.out.println("Enter your position (1 - 9)");
            userInput = scanner.next();
            System.out.println(userInput);
            if(isValidMove(board, Integer.parseInt(userInput))){
                break;
            }else{
                System.out.println(userInput + "  ---  It is not a valid move !!");
            }
        }
        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char Symbol) {
        switch (position){

            case "1":
                board[0][0] = Symbol;
                break;

            case "2":
                board[0][1] =Symbol;
                break;

            case "3":
                board[0][2] = Symbol;
                break;

            case "4":
                board[1][0] =Symbol;
                break;

            case "5":
                board[1][1] = Symbol;
                break;

            case "6":
                board[1][2] = Symbol;
                break;

            case "7":
                board[2][0] = Symbol;
                break;

            case "8":
                board[2][1] = Symbol;
                break;

            case "9":
                board[2][2] = Symbol;
                break;

            default:
                System.out.println(":(");
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + " |"  + board[0][1] + " |" +  board[0][2] + " |");
        System.out.println("--+--+--+");
        System.out.println(board[1][0] + " |"  + board[1][1] + " |"  + board[1][2] + " |");
        System.out.println("--+--+--+");
        System.out.println(board[2][0] + " |"  + board[2][1] + " |"  + board[2][2] + " |");
    }
}