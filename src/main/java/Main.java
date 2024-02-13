// Aviral Mishra
// TTT with 2D arrays
// Period 5
// 02/13/2024

/*
This project must play Tic-Tac-Toe.


For the first in-class demonstration, you must have the following:
1) a static constand 2-D Array the represnets the board and holds the STATE data for the game.
2) You must correctly resolve:
  horizontal, 
  diagonal, 
  vertical winner conditions
  And a draw
3) You must have 1 player.

For the future and more points above an A-...
0) You must correctly resolve all win and draw states
1) You should have a seond player
2) You should be able to play on a 4 x 4 board
3) You should correctly resolve turns
4) The player and the game should be in seperate classes from your static Main


For more in the future and more awesomer...
1) You can have a text file documenting player win-loss records and another stat of your choice
2) You can have a 3rd or 4th player
3) You can have a 3rd dimension to the game
4) You can make a new class for a game session as well as a single game
5) You can make a new class for a turn, or a piece, or a screen painter
*/

/*

2-D Array sneak attack!

Can you write a method that will look at STATE
and return true if the '2' team would win 
at tic-tac-toe?

*/

import java.util.Scanner;

class Main {

  public static final String[][] STATE = {
    {" ", " ", " "},
    {" ", " ", " "},
    {" ", " ", " "}
  };

  public static String[][] boardState = STATE;

  public static void main(String[] args) {
    play();
  }

  public static void play() {
    Scanner console = new Scanner(System.in);
    boolean X = true;
    int turn = 0;
    while((turn < boardState.length * 2 - 1 || playerWon(boardState).equals("false")) && turn < boardState.length * boardState.length){
      draw2DArray(boardState);
      takeTurn(boardState, (X)? "X" : "O", console);
      turn++;
      X = !X;
    }
    draw2DArray(boardState);
    if (playerWon(boardState).equals("false"))
      System.out.println("It was a tie...");
    else
      System.out.println("Player " + playerWon(boardState) + " won!");
  }

  public static void takeTurn(String[][] board, String player, Scanner console){
    boolean firstInput = true;
    boolean squareTaken = false;
    int row = -1;
    int column = -1;
    while(firstInput || squareTaken){
      squareTaken = false;
      System.out.print("Which row would player '" + 
                        player + "' like to go? (1, 2, 3) ");
      row = console.nextInt() - 1;
      System.out.print("Which column would player '" + 
                        player + "' like to go? (1, 2, 3) ");
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

  public static String playerWon(String[][] board){
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

  public static void draw2DArray(String[][] Array){
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