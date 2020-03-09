import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();
    public static void main (String[] args) {
        //initializing the gameboard
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
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
        char cpu = ' ';
        if (user == 'x') {
            cpu = 'o';
        } else {
            cpu = 'x';
        }
        // while (true) loops code indefinitely
        while (true) {
            scan = new Scanner(System.in);

            System.out.println("Your move! (1-9): ");
            int pos = scan.nextInt();
            //checking if the pos you entered is already in the array list or
            // if you are trying to take a position taken by the computer already
            while(playerPositions.contains(pos) || cpuPositions.contains(pos)) {
                System.out.println("Position is already taken... Enter another position: ");
                pos = scan.nextInt();
            }
            //placepiece by taking in the initial char[][], getting the int pos from scanner, and getting the char user from scanner
            placePiece(gameBoard, pos, "user", user);
            //checking the result after you place a piece
            String result = winnerWinnerChickenDinner();
            //checking if there even is a result after every time you place a piece
            if (result.length()>0) {
                System.out.println(result);
                playAgain(user, gameBoard);
            }


            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;

            //checking if the number the computer generated is already taken by you or if the computer already generated that position
            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            //cpu places the piece after the while loop check
            placePiece(gameBoard, cpuPos, "cpu", cpu);

            printGameBoard(gameBoard);
            //checking result after cpu places a piece
            result = winnerWinnerChickenDinner();
            //checking if there is a result or just an empty string
            if (result.length()>0) {
                System.out.println(result);
                playAgain(user, gameBoard);
            }

        }
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
    public static void placePiece(char[][] gameBoard, int pos, String user, char playerSymbol) {
        //initializing the char
        char symbol = Character.toUpperCase(playerSymbol);
        //checking if the person chose x or not
        if(user.equals("user")) {
            playerPositions.add(pos);
        } else {
            cpuPositions.add(pos);
        }
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
                // [0][1] is the space for the line '|'
            case 2:
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
    public static String winnerWinnerChickenDinner(){
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        //list goes from left to right so have to make them top to bottom
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        //same for diagonals
        List leftRightDia = Arrays.asList(1, 5, 9);
        List rightLeftDia = Arrays.asList(3, 5, 7);
        //List of a list... adding lists above to wincon list
        List<List> winCon = new ArrayList<List>();
        winCon.add(topRow);
        winCon.add(midRow);
        winCon.add(botRow);
        winCon.add(leftCol);
        winCon.add(midCol);
        winCon.add(rightCol);
        winCon.add(leftRightDia);
        winCon.add(rightLeftDia);
        for (List l : winCon) {
            if (playerPositions.containsAll(l)) {
                return "You won!";

            } else if (cpuPositions.containsAll(l)) {
                return "A computer that randomly generates numbers won...";
            }
        }
        //took this out of the for loop
        if (playerPositions.size() + cpuPositions.size() == 9){
            return "Tie";
        }
        return "";
    }
    public static void playAgain(char user, char [][] gameBoard) {
        System.out.println("Would you like to play again? (Y/N): ");
        Scanner play = new Scanner(System.in);
        char yOrN = play.nextLine().charAt(0);
        if (yOrN == 'y') {
            playerPositions.clear();
            cpuPositions.clear();
            gameBoard[0][0] = ' ';
            gameBoard[0][2] = ' ';
            gameBoard[0][4] = ' ';
            gameBoard[2][0] = ' ';
            gameBoard[2][2] = ' ';
            gameBoard[2][4] = ' ';
            gameBoard[4][0] = ' ';
            gameBoard[4][2] = ' ';
            gameBoard[4][4] = ' ';
            user = ' ';

        } else {
            return;
        }
    }
}
