import java.util.Scanner;

public class TicTacToe {
    public static void main (String[] args) {
        //initializing the gameboard
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', ' ', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', ' ', '+', '-'},
                {' ', '|', ' ', '|', ' '}
        };
        //printing the gameboard which takes in a char array as the parameters
        printGameBoard(gameBoard);
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to be X or O?");
        char user = scan.nextLine().charAt(0);
        System.out.println("Your move! (1-9): ");
        int pos = scan.nextInt();
        //placepiece by taking in the initial char[][], getting the pos from scanner, and getting the user from scanner
        placePiece(gameBoard, pos, user);
        printGameBoard(gameBoard);
    }
    public static void printGameBoard(char[][] gameBoard){
        //for each row in the gameboard
        for(char[] row : gameBoard) {
            //for each character in the row
            for(char c : row) {
                System.out.print(c);
            }
            //printing a line for each row
            System.out.println();
        }
    }
    public static void placePiece(char[][] gameBoard, int pos, char user) {
        //initializing the char
        char symbol = ' ';
        //checking if the person chose x or not
        if(user == 'x') {
            symbol = 'X';
        } else {
            symbol = 'O';
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2: // [0][1] is the space for the line '|'
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}
