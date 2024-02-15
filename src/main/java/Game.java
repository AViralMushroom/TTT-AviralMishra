// Aviral Mishra
// TTT with 2D arrays
// Period 5
// 02/16/2024

/**
* This is the Game class, where the gameplay instructions are
* A lot of code is spent iterating through the 2d array (the tictactoe board)
* This class is dependent on the player class because you need players to play a game
**/
import java.util.Scanner;

public class Game{
  /////////////////////////////////
  // PROPERTIES/FIELDS
  /////////////////////////////////
  
  private Scanner console;
  private Player[] playerXO = new Player[2];
  
  public final String[][] STATE = {
    {" ", " ", " "},
    {" ", " ", " "},
    {" ", " ", " "}
  };

  public String[][] boardState = STATE;

  /////////////////////////////////
  // CONSTRUCTOR
  /////////////////////////////////
  
  public Game(Scanner console, Player playerX, Player playerO){
    this.console = console;
    this.playerXO[0] = playerX;
    this.playerXO[1] = playerO;
    
    System.out.println(playerX.getName() + " will play with 'X' and " + playerO.getName() + " with 'O'");
  }

  /////////////////////////////////
  // METHODS
  /////////////////////////////////

  // all method calls and infrastructure to play tic tac toe
  public void play() {
    boolean X = true;
    int turn = 0;
    while((turn < boardState.length * 2 - 1 || playerWon(boardState).equals("false")) && turn < boardState.length * boardState.length){
      draw2DArray(boardState);
      takeTurn(boardState, (X)? "X" : "O", console);
      turn++;
      X = !X;
    }
    draw2DArray(boardState);    
    if (playerWon(boardState).equals("false")){
      System.out.println("It was a tie...");
      playerXO[0].addDraw();
      playerXO[1].addDraw();
    } else {
      int winnerNumber = playerWon(boardState).equals("X")? 0 : 1;
      System.out.println("Player " + playerXO[winnerNumber].getName() + " won!");
      playerXO[winnerNumber].addWin();
      playerXO[(winnerNumber * -1) + 1].addLoss(); // math to always get other number
    }
  }

  // add an X or O to the board
  public void takeTurn(String[][] board, String player, Scanner console){
    String currentPlayerName = playerXO[(player.equals("X")? 0 : 1)].getName();
    boolean firstInput = true;
    boolean squareTaken = false;
    int row = -1;
    int column = -1;
    while(firstInput || squareTaken){
      squareTaken = false;
      System.out.print("Which row would player '" + 
                        currentPlayerName + "' like to go? (1, 2, 3) ");
      row = console.nextInt() - 1;
      System.out.print("Which column would player '" + 
                        currentPlayerName + "' like to go? (1, 2, 3) ");
      column = console.nextInt() - 1;
      if (!board[row][column].equals(" ")){
        squareTaken = true;
        System.out.println("Square taken");
      }
      if (firstInput)
        firstInput = !firstInput;
    }
    board[row][column] = player;
  }

  // check which player won (or if one even did)
  public String playerWon(String[][] board){
    boolean[] winnerFromLine = {true, true, true, true};
    for (int i = 0; i < board.length; i++){
      winnerFromLine[0] = true;
      winnerFromLine[1] = true;
      for (int j = 0; j < board.length - 1; j++){
        if(board[i][j].equals(" ") || !board[i][j].equals(board[i][j + 1]))
          winnerFromLine[0] = false;
        if(board[j][i].equals(" ") || !board[j][i].equals(board[j + 1][i]))
          winnerFromLine[1] = false;
        if(!winnerFromLine[0] && !winnerFromLine[1])
          break;
      }
      if (winnerFromLine[0])
        return board[i][0];
      if (winnerFromLine[1])
        return board[0][i];
      if (i < board.length - 1){
        if(board[i][i].equals(" ") || !board[i][i].equals(board[i + 1][i + 1]))
          winnerFromLine[2] = false;
        if(board[i][board.length - 1 - i].equals(" ") || !board[i][board.length - 1 - i].equals(board[i + 1][board.length - 2 - i]))
          winnerFromLine[3] = false;
      }
    }
    if (winnerFromLine[2])
      return board[0][0];
    if (winnerFromLine[3])
      return board[0][board.length - 1];
    return "false";
  }

  // draw the current state of the baord
  public void draw2DArray(String[][] Array){
    System.out.println("  1  2  3 ");
    System.out.println(" ---------");
    for (int i = 0; i < Array.length; i++){
      System.out.print(i + 1);
      for (String cell : Array[i]){
        System.out.print("|" + cell + "|");
      }
      System.out.println();
      System.out.println(" ---------");
    }
  }
}